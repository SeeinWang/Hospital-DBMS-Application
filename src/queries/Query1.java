package queries;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;

public class Query1 {

	private JFrame frame;
	private JTextField coverage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query1 window = new Query1();
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
	public Query1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,240,715,607);
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(0, 0, 672, 512);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{0, 49, 177, 92, 121, 43, 0, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 3;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 0;
		panelParent.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.gridheight = 7;
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 1;
		gbc_rigidArea_2.gridy = 1;
		panelParent.add(rigidArea_2, gbc_rigidArea_2);
		JLabel label0 = new JLabel("Enter new patient information:");
		label0.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label0 = new GridBagConstraints();
		gbc_label0.gridwidth = 3;
		gbc_label0.insets = new Insets(0, 0, 5, 5);
		gbc_label0.gridx = 2;
		gbc_label0.gridy = 1;
		panelParent.add(label0, gbc_label0);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridwidth = 2;
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 2;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		JLabel label1 = new JLabel("PID:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 2;
		gbc_label1.gridy = 3;
		panelParent.add(label1, gbc_label1);
		JTextField pid = new JTextField();
		pid.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_pid = new GridBagConstraints();
		gbc_pid.insets = new Insets(0, 0, 5, 5);
		gbc_pid.fill = GridBagConstraints.HORIZONTAL;
		gbc_pid.gridx = 3;
		gbc_pid.gridy = 3;
		panelParent.add(pid, gbc_pid);
		
		pid.setText(autogenPid());
		pid.setEditable(false);
		
		JLabel label2 = new JLabel("Name:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 2;
		gbc_label2.gridy = 4;
		panelParent.add(label2, gbc_label2);
		JTextField pname = new JTextField();
		pname.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_pname = new GridBagConstraints();
		gbc_pname.insets = new Insets(0, 0, 5, 5);
		gbc_pname.fill = GridBagConstraints.HORIZONTAL;
		gbc_pname.gridx = 3;
		gbc_pname.gridy = 4;
		panelParent.add(pname, gbc_pname);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_7.gridx = 0;
		gbc_rigidArea_7.gridy = 5;
		panelParent.add(rigidArea_7, gbc_rigidArea_7);
		
		JLabel label3 = new JLabel("Address:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 2;
		gbc_label3.gridy = 5;
		panelParent.add(label3, gbc_label3);
		JTextField address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.gridx = 3;
		gbc_address.gridy = 5;
		panelParent.add(address, gbc_address);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_4.gridx = 6;
		gbc_rigidArea_4.gridy = 5;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		
		JLabel label4 = new JLabel("Phone:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.anchor = GridBagConstraints.EAST;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 2;
		gbc_label4.gridy = 6;
		panelParent.add(label4, gbc_label4);
		JTextField phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_phone = new GridBagConstraints();
		gbc_phone.fill = GridBagConstraints.HORIZONTAL;
		gbc_phone.insets = new Insets(0, 0, 5, 5);
		gbc_phone.gridx = 3;
		gbc_phone.gridy = 6;
		panelParent.add(phone, gbc_phone);
		
		JLabel lblNewLabel = new JLabel("10 digits");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 6;
		panelParent.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblCoverage = new JLabel("Coverage:");
		lblCoverage.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblCoverage = new GridBagConstraints();
		gbc_lblCoverage.anchor = GridBagConstraints.EAST;
		gbc_lblCoverage.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoverage.gridx = 2;
		gbc_lblCoverage.gridy = 7;
		panelParent.add(lblCoverage, gbc_lblCoverage);
		
		coverage = new JTextField();
		coverage.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_coverage = new GridBagConstraints();
		gbc_coverage.insets = new Insets(0, 0, 5, 5);
		gbc_coverage.fill = GridBagConstraints.HORIZONTAL;
		gbc_coverage.gridx = 3;
		gbc_coverage.gridy = 7;
		panelParent.add(coverage, gbc_coverage);
		
		JLabel lblEg = new JLabel("e.g. 0.75");
		lblEg.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblEg = new GridBagConstraints();
		gbc_lblEg.insets = new Insets(0, 0, 5, 5);
		gbc_lblEg.gridx = 4;
		gbc_lblEg.gridy = 7;
		panelParent.add(lblEg, gbc_lblEg);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_5.gridx = 3;
		gbc_rigidArea_5.gridy = 8;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		
		
		JButton insert = new JButton("Insert");
		insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_insert = new GridBagConstraints();
		gbc_insert.anchor = GridBagConstraints.WEST;
		gbc_insert.insets = new Insets(0, 0, 5, 5);
		gbc_insert.gridx = 3;
		gbc_insert.gridy = 9;
		panelParent.add(insert, gbc_insert);
		insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					try{
						Integer.parseInt(pid.getText());
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Pid is illegal!");
					}
					// 1.connect database
					Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
					Connection con = DBConnectionUtil.getConnection();
					if(con!=null){
						System.out.println("Connect database successfully!");
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
					
					// 3. Check coverage format
					if (coverage.getText().isEmpty() == false) {
						try{
							
							Pattern rg = Pattern.compile("^[0]*\\.[0-9]{2}$");
							Matcher m = rg.matcher(coverage.getText());
							if (!m.find()) {
								Exception e = new Exception();
								throw e;
							}

						}catch(Exception e){
							JOptionPane.showMessageDialog(null, "Coverage must be zero with 2 decimal places, e.g. 0.12");
							return;
						}
					}

					// 3.query code: new patient, patientrecord, patientrecorddate, keeps, insuranceaccount, patientinsurance
					PreparedStatement ps1 = con
							.prepareStatement("INSERT INTO Patient(pid, pname, address, phone) VALUES (?,?,?,?)");
					ps1.setString(1, pid.getText());
					ps1.setString(2, pname.getText());
					ps1.setString(3, address.getText());
					ps1.setString(4, phone.getText());
					ps1.executeQuery();
					ps1.close();
					
					PreparedStatement ps2 = con
							.prepareStatement("INSERT INTO PatientRecord(pid, cost) VALUES (?,?)");
					ps2.setString(1, pid.getText());
					ps2.setString(2, "0.00");
					ps2.executeQuery();
					ps2.close();
					
					
					String temp = "INSERT INTO PatientRecordDate(pid, rdate) VALUES (" + pid.getText() 
					+ ", TO_DATE('2016/06/17 13:00', 'yyyy/mm/dd hh24:mi'))";
					PreparedStatement ps3 = con
							.prepareStatement(temp);
					ps3.executeQuery();
					ps3.close();
					
					PreparedStatement ps4 = con
							.prepareStatement("INSERT INTO Keeps(pid, id) VALUES (?,?)");
					ps4.setString(1, pid.getText());
					ps4.setString(2, "1");
					ps4.executeQuery();
					ps4.close();
					
					PreparedStatement ps5 = con
							.prepareStatement("INSERT INTO InsuranceAccount(id, amount) VALUES (?,?)");
					ps5.setString(1, pid.getText());
					ps5.setString(2, coverage.getText());
					ps5.executeQuery();
					ps5.close();
					
					PreparedStatement ps6 = con
							.prepareStatement("INSERT INTO PatientInsurance(id, pid) VALUES (?,?)");
					ps6.setString(1, pid.getText());
					ps6.setString(2, pid.getText());
					ps6.executeQuery();
					ps6.close();
					
					JOptionPane.showMessageDialog(null, "Insert Patient Info Successfully!");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Pid already exists!");
				}
			}
			
		});
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridwidth = 5;
		gbc_rigidArea_3.gridx = 3;
		gbc_rigidArea_3.gridy = 10;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		
		pname.requestFocus();
		frame.setTitle("Query1:Add Patient");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public String autogenPid() {
		String res = "";
		
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connect database successfully!");
			}
			// 2.query code		
			String select = "select max(pid) + 1 from patient";
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				res = (rs.getString(1));
			}
			ps.close();
			return res;
				
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
