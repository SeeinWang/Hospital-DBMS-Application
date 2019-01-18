package queries;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import connect.DBConnectionUtil;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query5 window = new Query5();
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
	public Query5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,240,896,537);
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(0, 0, 857, 446);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{58, 0, 308, 265, 47, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 57, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 4;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		panelParent.add(rigidArea, gbc_rigidArea);
		JLabel label0 = new JLabel("Enter new patient test result:");
		GridBagConstraints gbc_label0 = new GridBagConstraints();
		gbc_label0.gridwidth = 3;
		gbc_label0.insets = new Insets(0, 0, 5, 5);
		gbc_label0.gridx = 1;
		gbc_label0.gridy = 1;
		panelParent.add(label0, gbc_label0);
		label0.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridheight = 7;
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 2;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 2;
		gbc_rigidArea_4.gridy = 2;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		JLabel label1 = new JLabel("Patient:");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
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
		JLabel label2 = new JLabel("Test Name:");
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 1;
		gbc_label2.gridy = 4;
		panelParent.add(label2, gbc_label2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JTextField tname = new JTextField();
		GridBagConstraints gbc_tname = new GridBagConstraints();
		gbc_tname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tname.insets = new Insets(0, 0, 5, 5);
		gbc_tname.gridx = 2;
		gbc_tname.gridy = 4;
		panelParent.add(tname, gbc_tname);
		tname.setFont(new Font("Tahoma", Font.PLAIN, 32));
		JLabel label3 = new JLabel("Date:");
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 1;
		gbc_label3.gridy = 5;
		panelParent.add(label3, gbc_label3);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JTextField date = new JTextField();
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_date.insets = new Insets(0, 0, 5, 5);
		gbc_date.gridx = 2;
		gbc_date.gridy = 5;
		panelParent.add(date, gbc_date);
		date.setFont(new Font("Tahoma", Font.PLAIN, 32));
		JLabel label33 = new JLabel("yyyy-mm-dd hh:mi");
		GridBagConstraints gbc_label33 = new GridBagConstraints();
		gbc_label33.anchor = GridBagConstraints.WEST;
		gbc_label33.insets = new Insets(0, 0, 5, 5);
		gbc_label33.gridx = 3;
		gbc_label33.gridy = 5;
		panelParent.add(label33, gbc_label33);
		label33.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
				JLabel label4 = new JLabel("Result:");
				GridBagConstraints gbc_label4 = new GridBagConstraints();
				gbc_label4.anchor = GridBagConstraints.EAST;
				gbc_label4.insets = new Insets(0, 0, 5, 5);
				gbc_label4.gridx = 1;
				gbc_label4.gridy = 6;
				panelParent.add(label4, gbc_label4);
				label4.setFont(new Font("Tahoma", Font.PLAIN, 36));
				JTextField result = new JTextField();
				GridBagConstraints gbc_result = new GridBagConstraints();
				gbc_result.fill = GridBagConstraints.HORIZONTAL;
				gbc_result.insets = new Insets(0, 0, 5, 5);
				gbc_result.gridx = 2;
				gbc_result.gridy = 6;
				panelParent.add(result, gbc_result);
				result.setFont(new Font("Tahoma", Font.PLAIN, 32));
						
						Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
						GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
						gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
						gbc_rigidArea_3.gridx = 2;
						gbc_rigidArea_3.gridy = 7;
						panelParent.add(rigidArea_3, gbc_rigidArea_3);
				
						JButton insert = new JButton("Submit");
						GridBagConstraints gbc_insert = new GridBagConstraints();
						gbc_insert.insets = new Insets(0, 0, 5, 5);
						gbc_insert.gridx = 2;
						gbc_insert.gridy = 8;
						panelParent.add(insert, gbc_insert);
						insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
						
						Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
						GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
						gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
						gbc_rigidArea_2.gridwidth = 4;
						gbc_rigidArea_2.gridx = 0;
						gbc_rigidArea_2.gridy = 9;
						panelParent.add(rigidArea_2, gbc_rigidArea_2);
						insert.addActionListener(new ActionListener(){

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
									PreparedStatement ps = con
											.prepareStatement("SELECT  * FROM Patient WHERE pid=?");
									ps.setInt(1, Integer.parseInt(pidOnly));
									ResultSet rset = ps.executeQuery();
									if (!rset.next()) {
										JOptionPane.showMessageDialog(null,
												"Pid does not exsit!");
										return;
									}
//									ps = con.prepareStatement("SELECT  * FROM Test WHERE tname=?");
//									ps.setString(1, tname.getText());
//									rset = ps.executeQuery();
//									if (!rset.next()) {
//										JOptionPane.showMessageDialog(null,
//												"Tname does not exsit!");
//										return;
//									}
									
									// 2. Check for tname
									if (tname.getText().isEmpty() == true) {
										JOptionPane.showMessageDialog(null, "A test name must be entered.");
										return;
									}
									
									// 3. Check date format
									if (date.getText().isEmpty() == false) {
										SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
										try{
											
											f.parse(date.getText());

										}catch(Exception e){
											JOptionPane.showMessageDialog(null, "Date must be as shown, e.g. 2016-06-17 13:45");
											return;
										}
									}
									
									// 3.query code
									ps = con.prepareStatement("INSERT INTO Test (tdate, tname) VALUES (TO_DATE(?, 'yyyy-mm-dd hh24:mi'), ?)");
									ps.setString(1, date.getText());
									ps.setString(2, tname.getText());
									System.out.println(date.getText());
									ps.executeQuery();
									ps.close();

									ps = con.prepareStatement("INSERT INTO Takes (pid, tname, result) VALUES (?,?,?)");
									ps.setString(1, pidOnly);
									ps.setString(2, tname.getText());
									ps.setString(3, result.getText());
									ps.executeQuery();
									ps.close();


									JOptionPane.showMessageDialog(null, "Insert Takes Info Successfully!");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}

						});
		frame.setTitle("Query5: Enter new patient test result");
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
