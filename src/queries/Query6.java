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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query6 window = new Query6();
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
	public Query6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,240,805,619);
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(0, 0, 784, 535);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{0, 174, 383, 23, 39, 0};
		gbl_panelParent.rowHeights = new int[]{48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 4;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		panelParent.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridheight = 11;
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 0;
		gbc_rigidArea_3.gridy = 1;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		JLabel label0 = new JLabel("Update patient contact info:");
		GridBagConstraints gbc_label0 = new GridBagConstraints();
		gbc_label0.gridwidth = 3;
		gbc_label0.insets = new Insets(0, 0, 5, 5);
		gbc_label0.gridx = 1;
		gbc_label0.gridy = 1;
		panelParent.add(label0, gbc_label0);
		label0.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.gridheight = 11;
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_4.gridx = 4;
		gbc_rigidArea_4.gridy = 1;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_5.gridx = 2;
		gbc_rigidArea_5.gridy = 2;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		JLabel label2 = new JLabel("Patient:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 1;
		gbc_label2.gridy = 3;
		panelParent.add(label2, gbc_label2);
		GridBagConstraints gbc_pid = new GridBagConstraints();
		gbc_pid.fill = GridBagConstraints.HORIZONTAL;
		gbc_pid.insets = new Insets(0, 0, 5, 5);
		gbc_pid.gridx = 2;
		gbc_pid.gridy = 3;
		
		Choice choice = new Choice();
		choice.setFont(new Font("Tahoma", Font.PLAIN, 36));
		selectAllPatient(choice);
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 2;
		gbc_choice.gridy = 3;
		panelParent.add(choice, gbc_choice);
		JLabel label1 = new JLabel("Name:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 5;
		panelParent.add(label1, gbc_label1);
		JTextField pname = new JTextField();
		pname.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_pname = new GridBagConstraints();
		gbc_pname.fill = GridBagConstraints.HORIZONTAL;
		gbc_pname.insets = new Insets(0, 0, 5, 5);
		gbc_pname.gridx = 2;
		gbc_pname.gridy = 5;
		panelParent.add(pname, gbc_pname);
		
		JLabel label3 = new JLabel("Address:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 1;
		gbc_label3.gridy = 7;
		panelParent.add(label3, gbc_label3);
		JTextField address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.gridx = 2;
		gbc_address.gridy = 7;
		panelParent.add(address, gbc_address);
		
		JLabel label4 = new JLabel("Phone:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.anchor = GridBagConstraints.EAST;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 1;
		gbc_label4.gridy = 9;
		panelParent.add(label4, gbc_label4);
		JTextField phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_phone = new GridBagConstraints();
		gbc_phone.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone.insets = new Insets(0, 0, 5, 5);
		gbc_phone.gridx = 2;
		gbc_phone.gridy = 9;
		panelParent.add(phone, gbc_phone);
		
		JLabel lblDigits = new JLabel("10 digits");
		lblDigits.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblDigits = new GridBagConstraints();
		gbc_lblDigits.insets = new Insets(0, 0, 5, 5);
		gbc_lblDigits.gridx = 3;
		gbc_lblDigits.gridy = 9;
		panelParent.add(lblDigits, gbc_lblDigits);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.gridwidth = 2;
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 1;
		gbc_rigidArea_2.gridy = 10;
		panelParent.add(rigidArea_2, gbc_rigidArea_2);
		
		JButton query = new JButton("Update");
		query.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_query = new GridBagConstraints();
		gbc_query.anchor = GridBagConstraints.WEST;
		gbc_query.insets = new Insets(0, 0, 5, 5);
		gbc_query.gridx = 2;
		gbc_query.gridy = 11;
		panelParent.add(query, gbc_query);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridwidth = 5;
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 12;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		query.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Hack alert: Assumes choice names do not contain colons
				String pidOnly = choice.getSelectedItem().split(":")[0];
				
				
				try{
					Integer.parseInt(pidOnly);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,
							"Invalid pid!");
					return;
				}
				try {
					// 1.connect database
					Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
					Connection con = DBConnectionUtil.getConnection();
					if(con!=null){
						System.out.println("Connect database successfully!");
					}
					PreparedStatement ps = con
							.prepareStatement("SELECT  * FROM Patient WHERE pid=?");
					ps.setInt(1, Integer.parseInt(pidOnly));
					ResultSet rset = ps.executeQuery();
					if (!rset.next()) {
						JOptionPane.showMessageDialog(null,
								"No patient exists with that ID!");
						return;
					}
					if(pname.getText().trim().equals("")&&address.getText().trim().equals("")&&phone.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null,
								"Please enter at least one field to update.");
						return;
					}
					
					
					// 2. Check phone number format
					if (phone.getText().isEmpty() == false) {
						try{
							Integer.parseInt(phone.getText());

							if (phone.getText().length() != 10) {
								JOptionPane.showMessageDialog(null, "Phone number must be 10 digits, e.g. 6045551234");
								return;
							}

						}catch(Exception e){
							JOptionPane.showMessageDialog(null, "Phone number must be 10 digits, e.g. 6045551234");
							return;
						}
					}	
					
					
					
					// 3.query code
					if(!pname.getText().trim().equals("")){
						ps = con
								.prepareStatement("UPDATE Patient SET pname=? WHERE pid=?");
						ps.setString(1, pname.getText());
						ps.setInt(2, Integer.parseInt(pidOnly));
						ps.executeQuery();
					}
					if(!address.getText().trim().equals("")){
						ps = con
								.prepareStatement("UPDATE Patient SET address=? WHERE pid=?");
						ps.setString(1, address.getText());
						ps.setInt(2, Integer.parseInt(pidOnly));
						ps.executeQuery();
					}
					if(!phone.getText().trim().equals("")){
						ps = con
								.prepareStatement("UPDATE Patient SET phone=? WHERE pid=?");
						ps.setString(1, phone.getText());
						ps.setInt(2, Integer.parseInt(pidOnly));
						ps.executeQuery();
					}
					
					JOptionPane.showMessageDialog(null, "Successfully updated patient contact!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		frame.setTitle("Query6:Update patient contact");
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
