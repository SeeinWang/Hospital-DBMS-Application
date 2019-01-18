package queries;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

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

public class Query9 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query9 window = new Query9();
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
	public Query9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,240,964,509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(0, 0, 919, 417);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{39, 0, 416, 155, 34, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 0;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel infoLabel = new JLabel("Write a prescription for a patient according to their test:");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.gridwidth = 3;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 1;
		gbc_infoLabel.gridy = 1;
		panelParent.add(infoLabel, gbc_infoLabel);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.gridheight = 8;
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 0;
		gbc_rigidArea_2.gridy = 1;
		panelParent.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_5.gridx = 2;
		gbc_rigidArea_5.gridy = 2;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		JLabel label1 = new JLabel("Patient:");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 3;
		panelParent.add(label1, gbc_label1);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice0 = new Choice();
		choice0.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllPatient(choice0);
		GridBagConstraints gbc_choice0 = new GridBagConstraints();
		gbc_choice0.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice0.insets = new Insets(0, 0, 5, 5);
		gbc_choice0.gridx = 2;
		gbc_choice0.gridy = 3;
		panelParent.add(choice0, gbc_choice0);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea.gridx = 4;
		gbc_rigidArea.gridy = 3;
		panelParent.add(rigidArea, gbc_rigidArea);
		JLabel label3 = new JLabel("Completed Test:");
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 1;
		gbc_label3.gridy = 4;
		panelParent.add(label3, gbc_label3);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice1 = new Choice();
		choice1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllTname(choice1);
		GridBagConstraints gbc_choice1 = new GridBagConstraints();
		gbc_choice1.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice1.insets = new Insets(0, 0, 5, 5);
		gbc_choice1.gridx = 2;
		gbc_choice1.gridy = 4;
		panelParent.add(choice1, gbc_choice1);
		JLabel label2 = new JLabel("Medicine:");
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 1;
		gbc_label2.gridy = 5;
		panelParent.add(label2, gbc_label2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice2 = new Choice();
		selectAllMname(choice2);
		choice2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_choice2 = new GridBagConstraints();
		gbc_choice2.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice2.insets = new Insets(0, 0, 5, 5);
		gbc_choice2.gridx = 2;
		gbc_choice2.gridy = 5;
		panelParent.add(choice2, gbc_choice2);
		JLabel label4 = new JLabel("Doctor:");
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.anchor = GridBagConstraints.EAST;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 1;
		gbc_label4.gridy = 6;
		panelParent.add(label4, gbc_label4);
		label4.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice3 = new Choice();
		selectAllDoctor(choice3);
		choice3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_choice3 = new GridBagConstraints();
		gbc_choice3.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice3.insets = new Insets(0, 0, 5, 5);
		gbc_choice3.gridx = 2;
		gbc_choice3.gridy = 6;
		panelParent.add(choice3, gbc_choice3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 2;
		gbc_rigidArea_4.gridy = 7;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		
		
		JButton insert = new JButton("Insert");
		GridBagConstraints gbc_insert = new GridBagConstraints();
		gbc_insert.anchor = GridBagConstraints.WEST;
		gbc_insert.insets = new Insets(0, 0, 5, 5);
		gbc_insert.gridx = 2;
		gbc_insert.gridy = 8;
		panelParent.add(insert, gbc_insert);
		insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridwidth = 4;
		gbc_rigidArea_3.gridx = 0;
		gbc_rigidArea_3.gridy = 9;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Hack alert: Assumes choice names do not contain colons
				String pidOnly = choice0.getSelectedItem().split(":")[0];
				String idOnly = choice3.getSelectedItem().split(":")[0];
				
				insertRecommends(idOnly, pidOnly, "'" + choice1.getSelectedItem().trim() + "'", "'" + choice2.getSelectedItem().trim() + "'");
			}
		});	
		frame.setTitle("Query9: Recommend Medicine for Patient");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public int insertRecommends(String id, String pid, String tname, String mname) {
		
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2. Verify patient took that test
			SqlHelper sh = new SqlHelper();
			HashMap<String, String> vm1 = new HashMap<String, String>();
			vm1.put("pid", pid);
			vm1.put("tname", tname);
			if (sh.checkIfExists(con, "takes", vm1) < 0) {
				JOptionPane.showMessageDialog(null, "Error: That patient did not take the test for " + tname);
				return -1;
			}
			
			// 3.query code
			HashMap<String, String> valMap = new HashMap<String, String>();
			valMap.put("id", id);
			valMap.put("pid", pid);
			valMap.put("tname", tname);
			valMap.put("mname", mname);
			String res = sh.sqlInsert(con, "recommends", valMap);
			JOptionPane.showMessageDialog(null, String.format("Patient %s successfully recommended %s for %s by Doctor %s", pid, mname, tname, id));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not create recommendation.\n%s", e.getMessage()));
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
	
	
	public int selectAllMname(Choice choice) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select mname from medicine";
	        
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
	
	
	public int selectAllDoctor(Choice choice) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select id, name from doctor";
	        
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
