package queries;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query11 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query11 window = new Query11();
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
	public Query11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,240,989,387);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(0, 0, 965, 295);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{49, 0, 0, 364, 95, 20, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 39, 0, 0, 0, 46, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 3;
		gbc_rigidArea_3.gridy = 0;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		
		JLabel infoLabel = new JLabel("Deduct from Patient outstanding cost with Coverage:");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.gridwidth = 3;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 2;
		gbc_infoLabel.gridy = 1;
		panelParent.add(infoLabel, gbc_infoLabel);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 3;
		gbc_rigidArea_2.gridy = 2;
		panelParent.add(rigidArea_2, gbc_rigidArea_2);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_6.gridx = 0;
		gbc_rigidArea_6.gridy = 3;
		panelParent.add(rigidArea_6, gbc_rigidArea_6);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 1;
		gbc_rigidArea_4.gridy = 3;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		JLabel label1 = new JLabel("Patient ID:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 2;
		gbc_label1.gridy = 3;
		panelParent.add(label1, gbc_label1);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllPatient(choice);
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 3;
		gbc_choice.gridy = 3;
		panelParent.add(choice, gbc_choice);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_5.gridx = 5;
		gbc_rigidArea_5.gridy = 3;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 3;
		gbc_rigidArea_1.gridy = 4;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		
		JButton insert = new JButton("Deduct");
		insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_insert = new GridBagConstraints();
		gbc_insert.anchor = GridBagConstraints.WEST;
		gbc_insert.insets = new Insets(0, 0, 5, 5);
		gbc_insert.gridx = 3;
		gbc_insert.gridy = 5;
		panelParent.add(insert, gbc_insert);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea.gridx = 3;
		gbc_rigidArea.gridy = 6;
		panelParent.add(rigidArea, gbc_rigidArea);
		insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String pidOnly = choice.getSelectedItem().split(":")[0];
				deductCoverage(pidOnly);
			}
		});	
		frame.setTitle("Query11: Deduct from Patient cost using Coverage");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public int deductCoverage(String pid) {
		
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			HashMap<String, String> valMap = new HashMap<String, String>();
			valMap.put("pid", pid);
			String res = this.deductCoverageFromCost(con, sh, valMap);
			if (res.isEmpty()) {
				return 0;
			}
			JOptionPane.showMessageDialog(null, String.format("Patient %s record successfully updated", pid));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not update Patientrecord.\n%s", e.getMessage()));
			return -1;
		}
	}

	
	/*
	 * Q11: Deducts proportion covered by insuranceaccount from current cost of patientrecord 
	 * Accepts Map/"dictionary" of attr-value pairs (requires only pid)
	 * Returns tuple of updated patientrecord
	 * ASSUMES patient has coverage TODO: check for coverage first
	 */
	public String deductCoverageFromCost(Connection con, SqlHelper sh, HashMap<String, String> valMap) {
		
		String currentCost = this.getCurrentCost(con, valMap);  // e.g. "25.99"
		
		if (currentCost == null || Double.parseDouble(currentCost) == 0) {
			JOptionPane.showMessageDialog(null, "Patient has no medicine charges.");
			return "";
		}
		
		String coverage = this.getCoverageAmount(con, valMap);
		String newCost = String.format("%.2f", Double.parseDouble(currentCost) 
				- (Double.parseDouble(currentCost) * Double.parseDouble(coverage)));

		HashMap<String, String> pkMap = new HashMap<String, String>();
		pkMap.put("pid", valMap.get("pid"));
		HashMap<String, String> updValMap = new HashMap<String, String>();
		updValMap.put("cost", newCost);
		
		String res = sh.sqlUpdate(con, "PatientRecord", pkMap, updValMap);
		return res;
	}
	
	
	/*
	 * Get percentage coverage of insurance account for given patient
	 * Returned as numeric string e.g. "0.75"
	 * ASSUMES valMap contains pid
	 * ASSUMES patient has coverage TODO: check for coverage first
	 */
	public String getCoverageAmount(Connection con, HashMap<String, String> valMap) {
		String select = String.format("select ia.amount from insuranceaccount ia, patientinsurance pi "
				+ "where pi.pid=%s AND ia.id=pi.id", valMap.get("pid"));
		//System.out.println(select);
		String res = "";
		
		try {		
			// Select
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getString(1);
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	/*
	 * Get current cost of patientrecord for given patient
	 * Returned as numeric string e.g. "25.99"
	 * ASSUMES valMap contains pid
	 */
	public String getCurrentCost(Connection con, HashMap<String, String> valMap) {
		String select = String.format("select cost from patientrecord where pid=%s", valMap.get("pid"));
		String res = "";
		
		try {		
			// Select
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getString(1);
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
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
