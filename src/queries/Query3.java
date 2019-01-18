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
import java.awt.Font;
import java.awt.Choice;

public class Query3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query3 window = new Query3();
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
	public Query3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,240,838,584);
		frame.getContentPane().setLayout(null);
		JLabel label0 = new JLabel("Select patient to retrieve test results:");
		label0.setFont(new Font("Tahoma", Font.PLAIN, 36));
		label0.setBounds(92, 15, 639, 49);
		frame.getContentPane().add(label0);
		JLabel label1 = new JLabel("Patient:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		label1.setBounds(169, 92, 123, 30);
		frame.getContentPane().add(label1);
		
		
		JButton query = new JButton("Select");
		query.setFont(new Font("Tahoma", Font.PLAIN, 36));
		query.setBounds(298, 144, 162, 44);
		frame.getContentPane().add(query);
		frame.setTitle("Query3:Get patient's test");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTable jtable = new JTable();
		jtable.setFont(new Font("Tahoma", Font.PLAIN, 28));
		jtable.setRowHeight(40);
		JScrollPane pane = new JScrollPane(jtable);
		pane.setBounds(26, 215, 755, 244);
		frame.getContentPane().add(pane);
		
		Choice choice = new Choice();
		choice.setBounds(298, 85, 306, 45);
		choice.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllPatient(choice);
		frame.getContentPane().add(choice);
		frame.setVisible(true);
		query.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Hack alert: Assumes choice names do not contain colons
				String pidOnly = choice.getSelectedItem().split(":")[0];
				
				try {
					// 1.connect database
					Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
					Connection con = DBConnectionUtil.getConnection();
					if(con!=null){
						System.out.println("Connect database successfully!");
					}
					// 2.query code
					PreparedStatement ps = con
							.prepareStatement("SELECT  * FROM Patient WHERE pid=?");
					ps.setInt(1, Integer.parseInt(pidOnly));
					ResultSet rset = ps.executeQuery();
					if (!rset.next()) {
						JOptionPane.showMessageDialog(null,
								"Pid does not exist!");
						return;
					}
					 ps = con
							.prepareStatement("SELECT  takes.tname, test.tdate, takes.result FROM Takes takes, Test test WHERE takes.tname=test.tname AND takes.pid = ?");
					ps.setString(1, pidOnly);
					 rset = ps.executeQuery();

			        DefaultTableModel tablemodel=new DefaultTableModel(); 
			        Object[] columns=new Object[3];   
			        tablemodel.addColumn("tname");
			        tablemodel.addColumn("tdate");
			        tablemodel.addColumn("result");
			        while (rset.next())                                
			        {
			            columns[0]=rset.getString(1);
			            columns[1]=rset.getString(2);
			            columns[2]=rset.getString(3);
			            tablemodel.addRow(columns);                    
			        }
			        rset.close();
					ps.close();
					jtable.setModel(tablemodel);
					
					jtable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 28));
					
					jtable.getColumnModel().getColumn(0).setMinWidth(200);
					jtable.getColumnModel().getColumn(0).setMaxWidth(200);
					jtable.getColumnModel().getColumn(1).setMinWidth(300);
					jtable.getColumnModel().getColumn(1).setMaxWidth(300);
					jtable.getColumnModel().getColumn(2).setMinWidth(275);
					jtable.getColumnModel().getColumn(2).setMaxWidth(275);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
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

}
