package queries;

import java.awt.Choice;
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
import javax.swing.JTextField;

import connect.DBConnectionUtil;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query4 window = new Query4();
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
	public Query4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,240,626,347);
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(24, 0, 499, 259);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{0, 0, 291, 0, 9, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 32, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 4;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		panelParent.add(rigidArea, gbc_rigidArea);
		JLabel label0 = new JLabel("Select patient to delete:");
		GridBagConstraints gbc_label0 = new GridBagConstraints();
		gbc_label0.gridwidth = 3;
		gbc_label0.insets = new Insets(0, 0, 5, 5);
		gbc_label0.gridx = 1;
		gbc_label0.gridy = 1;
		panelParent.add(label0, gbc_label0);
		label0.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.gridheight = 5;
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 0;
		gbc_rigidArea_2.gridy = 1;
		panelParent.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.gridheight = 4;
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_5.gridx = 3;
		gbc_rigidArea_5.gridy = 2;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 2;
		gbc_rigidArea_4.gridy = 2;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		JLabel label1 = new JLabel("Patient:");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 3;
		panelParent.add(label1, gbc_label1);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice = new Choice();
		choice.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllPatient(choice);
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 2;
		gbc_choice.gridy = 3;
		panelParent.add(choice, gbc_choice);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 2;
		gbc_rigidArea_3.gridy = 4;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		
		
		JButton delete = new JButton("Delete");
		GridBagConstraints gbc_delete = new GridBagConstraints();
		gbc_delete.anchor = GridBagConstraints.WEST;
		gbc_delete.insets = new Insets(0, 0, 5, 5);
		gbc_delete.gridx = 2;
		gbc_delete.gridy = 5;
		panelParent.add(delete, gbc_delete);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridwidth = 4;
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 6;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		delete.addActionListener(new ActionListener(){

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
					PreparedStatement ps1 = con
							.prepareStatement("SELECT  * FROM Patient WHERE pid=?");
					ps1.setInt(1, Integer.parseInt(pidOnly));
					ResultSet rset = ps1.executeQuery();
					if (!rset.next()) {
						JOptionPane.showMessageDialog(null,
								"Patient with that PID does not exist!");
						return;
					}
					// 2.query code: patient, patientrecord, patientrecorddate, patientinsurance, insuranceaccount, keeps
					ps1 = con
							.prepareStatement("DELETE FROM Patient WHERE pid = ?");
					ps1.setString(1, pidOnly);
					ps1.executeQuery();
					
					ps1 = con
							.prepareStatement("DELETE FROM PatientRecord WHERE pid = ?");
					ps1.setString(1, pidOnly);
					ps1.executeQuery();
					
					ps1 = con
							.prepareStatement("DELETE FROM PatientRecordDate WHERE pid = ?");
					ps1.setString(1, pidOnly);
					ps1.executeQuery();
					
					ps1 = con
							.prepareStatement("DELETE FROM PatientInsurance WHERE pid = ?");
					ps1.setString(1, pidOnly);
					ps1.executeQuery();
					
					ps1 = con
							.prepareStatement("DELETE FROM InsuranceAccount WHERE id = ?");
					ps1.setString(1, pidOnly);
					ps1.executeQuery();
					
					ps1 = con
							.prepareStatement("DELETE FROM Keeps WHERE pid = ?");
					ps1.setString(1, pidOnly);
					ps1.executeQuery();

					JOptionPane.showMessageDialog(null, "Delete Patient Info Successfully!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		frame.setTitle("Query4:Delete patient");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
}
