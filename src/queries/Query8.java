package queries;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
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
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Choice;

public class Query8 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query8 window = new Query8();
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
	public Query8() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,240,1024,528);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(77, 0, 823, 490);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 2;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 0;
		panelParent.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridheight = 12;
		gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_1.gridx = 1;
		gbc_rigidArea_1.gridy = 0;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel infoLabel = new JLabel("Update a patient's health record:");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.gridwidth = 3;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 2;
		gbc_infoLabel.gridy = 1;
		panelParent.add(infoLabel, gbc_infoLabel);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridwidth = 2;
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 2;
		gbc_rigidArea_3.gridy = 2;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		JLabel label1 = new JLabel("Patient ID:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 2;
		gbc_label1.gridy = 3;
		panelParent.add(label1, gbc_label1);
		GridBagConstraints gbc_pid = new GridBagConstraints();
		gbc_pid.fill = GridBagConstraints.HORIZONTAL;
		gbc_pid.insets = new Insets(0, 0, 5, 5);
		gbc_pid.gridx = 3;
		gbc_pid.gridy = 3;
		
		Choice choice = new Choice();
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 3;
		gbc_choice.gridy = 3;
		choice.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panelParent.add(choice, gbc_choice);
		selectAllPatient(choice);
		JLabel label2 = new JLabel("Cost:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 2;
		gbc_label2.gridy = 4;
		panelParent.add(label2, gbc_label2);
		JTextField cost = new JTextField();
		cost.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_cost = new GridBagConstraints();
		gbc_cost.fill = GridBagConstraints.HORIZONTAL;
		gbc_cost.insets = new Insets(0, 0, 5, 5);
		gbc_cost.gridx = 3;
		gbc_cost.gridy = 4;
		panelParent.add(cost, gbc_cost);
		
		JLabel lblExample = new JLabel("Example: 12.95");
		lblExample.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GridBagConstraints gbc_lblExample = new GridBagConstraints();
		gbc_lblExample.insets = new Insets(0, 0, 5, 5);
		gbc_lblExample.gridx = 4;
		gbc_lblExample.gridy = 4;
		panelParent.add(lblExample, gbc_lblExample);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_5.gridx = 0;
		gbc_rigidArea_5.gridy = 5;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		JLabel label3 = new JLabel("Disease:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 2;
		gbc_label3.gridy = 5;
		panelParent.add(label3, gbc_label3);
		JTextField disease = new JTextField();
		disease.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_disease = new GridBagConstraints();
		gbc_disease.fill = GridBagConstraints.HORIZONTAL;
		gbc_disease.insets = new Insets(0, 0, 5, 5);
		gbc_disease.gridx = 3;
		gbc_disease.gridy = 5;
		panelParent.add(disease, gbc_disease);
		JLabel label4 = new JLabel("Notes:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.anchor = GridBagConstraints.EAST;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 2;
		gbc_label4.gridy = 6;
		panelParent.add(label4, gbc_label4);
		JTextField notes = new JTextField();
		notes.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_notes = new GridBagConstraints();
		gbc_notes.fill = GridBagConstraints.HORIZONTAL;
		gbc_notes.insets = new Insets(0, 0, 5, 5);
		gbc_notes.gridx = 3;
		gbc_notes.gridy = 6;
		panelParent.add(notes, gbc_notes);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.gridwidth = 2;
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 2;
		gbc_rigidArea_4.gridy = 7;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		
		JButton insert = new JButton("Update");
		insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_insert = new GridBagConstraints();
		gbc_insert.anchor = GridBagConstraints.WEST;
		gbc_insert.insets = new Insets(0, 0, 5, 5);
		gbc_insert.gridx = 3;
		gbc_insert.gridy = 8;
		panelParent.add(insert, gbc_insert);
		insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Hack alert: Assumes choice names do not contain colons
				String pidOnly = choice.getSelectedItem().split(":")[0];
				updatePatientRecord(pidOnly, cost.getText(), disease.getText(), notes.getText());
			}
		});	
		frame.setTitle("Query8: Update Patient Record");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public int updatePatientRecord(String pid, String cost, String disease, String notes) {
		
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2. Check fields
			if(cost.trim().equals("")&&disease.trim().equals("")&&notes.trim().equals("")){
				JOptionPane.showMessageDialog(null,
						"Please enter at least one field to update.");
				return -1;
			}
			
			
			// 3. Check cost format
			if (cost.isEmpty() == false) {
				try{
					
					Pattern rg = Pattern.compile("^[0-9]*\\.[0-9]{2}$");
					Matcher m = rg.matcher(cost);
					if (!m.find()) {
						Exception e = new Exception();
						throw e;
					}

				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Cost must be 2 decimal places, e.g. 12.34");
					return -1;
				}
			}	
			
			// 4.query code
			SqlHelper sh = new SqlHelper();
			HashMap<String, String> pkMap = new HashMap<String, String>();
			pkMap.put("pid", pid);
			HashMap<String, String> valMap = new HashMap<String, String>();
			
			if(!cost.trim().equals("")){
				valMap.put("cost", cost);
			}
			if(!disease.trim().equals("")){
				valMap.put("disease", "'" + disease + "'");
			}
			if(!notes.trim().equals("")){
				valMap.put("notes", "'" + notes + "'");
			}
			String res = sh.sqlUpdate(con, "patientrecord", pkMap, valMap);
			JOptionPane.showMessageDialog(null, String.format("Patient %s record successfully updated", pid));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not update Patientrecord\n%s", e.getMessage()));
			return -1;
		}
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
