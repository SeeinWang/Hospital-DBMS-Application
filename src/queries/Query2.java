package queries;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connect.DBConnectionUtil;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query2 window = new Query2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Query2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 240, 805, 713);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Query2:Get recommended medicine");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTable jtable = new JTable();
		jtable.setFont(new Font("Tahoma", Font.PLAIN, 28));
		jtable.setRowHeight(40);
		JScrollPane pane = new JScrollPane(jtable);
		pane.setBounds(331, 344, 300, 242);
		frame.getContentPane().add(pane);

		JButton query = new JButton("Search");
		query.setBounds(331, 261, 158, 53);
		frame.getContentPane().add(query);
		query.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JLabel label0 = new JLabel(
				"Select patient and test to get prescription:");
		label0.setBounds(66, 44, 697, 44);
		frame.getContentPane().add(label0);
		label0.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JLabel label1 = new JLabel("Patient:");
		label1.setBounds(189, 116, 128, 44);
		frame.getContentPane().add(label1);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JLabel label2 = new JLabel("Test:");
		label2.setBounds(229, 188, 88, 44);
		frame.getContentPane().add(label2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		JLabel lblPrescription = new JLabel("Prescription:");
		lblPrescription.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblPrescription.setBounds(109, 348, 208, 44);
		frame.getContentPane().add(lblPrescription);
		
		Choice choice1 = new Choice();
		choice1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		choice1.setBounds(331, 116, 300, 45);
		selectAllPatient(choice1);
		frame.getContentPane().add(choice1);
		
		Choice choice2 = new Choice();
		choice2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		choice2.setBounds(331, 187, 300, 45);
		selectAllTname(choice2);
		frame.getContentPane().add(choice2);
		query.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Hack alert: Assumes choice names do not contain colons
				String pidOnly = choice1.getSelectedItem().split(":")[0];
				String tnameOnly = choice2.getSelectedItem().trim();
				
				try {
					// 1.connect database
					Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
					Connection con = DBConnectionUtil.getConnection();
					if (con != null) {
						System.out.println("Connect database successfully!");
					}

					// 2.query code
					// Check that patient exists
					PreparedStatement ps = con
							.prepareStatement("SELECT  * FROM Patient WHERE pid=?");
					ps.setInt(1, Integer.parseInt(pidOnly));
					ResultSet rset = ps.executeQuery();
					if (!rset.next()) {
						JOptionPane.showMessageDialog(null,
								"No patient with that PID exists!");
						return;
					}
					// Check that test result exists
					String sel2 = "SELECT  * FROM Test WHERE tname='" + tnameOnly +"'";
					System.out.println(sel2);
					ps = con.prepareStatement(sel2);			

					rset = ps.executeQuery();
					if (!rset.next()) {
						JOptionPane.showMessageDialog(null,
								"No test with that name exists!");
						return;
					}

					// Now, find
					String sel3 = String.format("SELECT mname FROM Recommends WHERE pid=%s and tname=%s", pidOnly, "'" + tnameOnly +"'");
					System.out.println(sel3);
					ps = con.prepareStatement(sel3);
					rset = ps.executeQuery();

					DefaultTableModel tablemodel = new DefaultTableModel();
					Object[] columns = new Object[1];
					tablemodel.addColumn("Medicine Name");
					
					while (rset.next()) {
						
						System.out.println(rset.getString(1));

						columns[0] = rset.getString(1);
						tablemodel.addRow(columns);
						
						jtable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 28));
					}
					
					if (tablemodel.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "That patient did not take the test for " + tnameOnly 
								+ ", OR a doctor still needs to write a prescription");
					}
					
					rset.close();
					ps.close();
					jtable.setModel(tablemodel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		frame.setVisible(true);
	}
	
	
	
	
	public int selectAllPatient(Choice choice) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select * from patient";
	        
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				String pat = rs.getString(1) + ":" + rs.getString(2);
				choice.add(pat);
			}
			ps.close();
			
			//JOptionPane.showMessageDialog(null, String.format("Average number of tests per patient:\n%s", res));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not complete search.\n%s", e.getMessage()));
			return -1;
		}
	}
	
	public int selectAllTname(Choice choice) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select tname from test";
	        
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				String pat = rs.getString(1);
				choice.add(pat);
			}
			ps.close();
			
			//JOptionPane.showMessageDialog(null, String.format("Average number of tests per patient:\n%s", res));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not complete search.\n%s", e.getMessage()));
			return -1;
		}
	}
	
}
