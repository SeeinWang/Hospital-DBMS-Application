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
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query10 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query10 window = new Query10();
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
	public Query10() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,240,887,378);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 849, 287);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{43, 258, 392, 0, 46, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 41, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 5;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		panel.add(rigidArea, gbc_rigidArea);
		
		JLabel infoLabel = new JLabel("Charge patient for outstanding medicine costs:");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.gridwidth = 3;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 1;
		gbc_infoLabel.gridy = 1;
		panel.add(infoLabel, gbc_infoLabel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 2;
		gbc_rigidArea_1.gridy = 2;
		panel.add(rigidArea_1, gbc_rigidArea_1);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.gridheight = 5;
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 0;
		gbc_rigidArea_4.gridy = 1;
		panel.add(rigidArea_4, gbc_rigidArea_4);
		JLabel label1 = new JLabel("Patient ID:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 3;
		panel.add(label1, gbc_label1);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllPatient(choice);
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 2;
		gbc_choice.gridy = 3;
		panel.add(choice, gbc_choice);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.gridheight = 5;
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_5.gridx = 4;
		gbc_rigidArea_5.gridy = 1;
		panel.add(rigidArea_5, gbc_rigidArea_5);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 2;
		gbc_rigidArea_2.gridy = 4;
		panel.add(rigidArea_2, gbc_rigidArea_2);
		
		JButton insert = new JButton("Charge");
		insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_insert = new GridBagConstraints();
		gbc_insert.anchor = GridBagConstraints.WEST;
		gbc_insert.insets = new Insets(0, 0, 5, 5);
		gbc_insert.gridx = 2;
		gbc_insert.gridy = 5;
		panel.add(insert, gbc_insert);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridwidth = 5;
		gbc_rigidArea_3.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_3.gridx = 0;
		gbc_rigidArea_3.gridy = 6;
		panel.add(rigidArea_3, gbc_rigidArea_3);
		insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String pidOnly = choice.getSelectedItem().split(":")[0];
				buyMedicine(pidOnly);
			}
		});	
		frame.setTitle("Query10: Charge for Patient's Medicine(s)");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public int buyMedicine(String pid) {
		
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
			String res = this.addTotalToCost(con, sh, valMap);
			if (res.isEmpty()) {
				return 0;
			}
			JOptionPane.showMessageDialog(null, String.format("Patient %s record successfully charged", pid));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not update Patientrecord.\n%s", e.getMessage()));
			return -1;
		}
	}

	
	/*
	 * Q10: Adds cost of recommended medicine to patient's recorded cost amount
	 * Accepts Map/"dictionary" of attr-value pairs (requires only pid)
	 * Returns tuple of updated patientrecord
	 */
	public String addTotalToCost(Connection con, SqlHelper sh, HashMap<String, String> valMap) {
		
		String totalMedicine = this.getTotalMedicinePrice(con, valMap);  // e.g. "25.99"
		
		if (totalMedicine == null || Double.parseDouble(totalMedicine) == 0) {
			JOptionPane.showMessageDialog(null, "Patient has no medicine charges.");
			return "";
		}
		
		String currentCost = this.getCurrentCost(con, valMap);
		String newCost = String.format("%.2f", Double.parseDouble(totalMedicine) + Double.parseDouble(currentCost));

		HashMap<String, String> pkMap = new HashMap<String, String>();
		pkMap.put("pid", valMap.get("pid"));
		HashMap<String, String> updValMap = new HashMap<String, String>();
		updValMap.put("cost", newCost);
		
		String res = sh.sqlUpdate(con, "PatientRecord", pkMap, updValMap);
		return res;
	}
	
	
	/*
	 * Get total cost of recommended medicine for given patient
	 * Returned as numeric string e.g. "25.99"
	 * ASSUMES valMap contains pid
	 */
	public String getTotalMedicinePrice(Connection con, HashMap<String, String> valMap) {
		String select = String.format("select sum(M.price) from Medicine M, Recommends R where R.pid=%s "
				+ "AND R.mname=M.mname", valMap.get("pid"));
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
