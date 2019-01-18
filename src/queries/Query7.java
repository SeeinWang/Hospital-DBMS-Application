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

import javax.swing.JFrame;
import javax.swing.JButton;
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


public class Query7 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query7 window = new Query7();
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
	public Query7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,240,751,423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBounds(26, 0, 671, 324);
		frame.getContentPane().add(panelParent);
		GridBagLayout gbl_panelParent = new GridBagLayout();
		gbl_panelParent.columnWidths = new int[]{0, 147, 389, 56, 0};
		gbl_panelParent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 31, 0};
		gbl_panelParent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelParent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelParent.setLayout(gbl_panelParent);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 4;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		panelParent.add(rigidArea, gbc_rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridheight = 6;
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 1;
		panelParent.add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel infoLabel = new JLabel("Assign a nurse to a room:");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.gridwidth = 3;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 1;
		gbc_infoLabel.gridy = 1;
		panelParent.add(infoLabel, gbc_infoLabel);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 2;
		gbc_rigidArea_2.gridy = 2;
		panelParent.add(rigidArea_2, gbc_rigidArea_2);
		JLabel label1 = new JLabel("Nurse:");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 3;
		panelParent.add(label1, gbc_label1);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice = new Choice();
		choice.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllNurse(choice);
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 2;
		gbc_choice.gridy = 3;
		panelParent.add(choice, gbc_choice);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.gridheight = 6;
		gbc_rigidArea_5.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_5.gridx = 3;
		gbc_rigidArea_5.gridy = 2;
		panelParent.add(rigidArea_5, gbc_rigidArea_5);
		JLabel label2 = new JLabel("Room:");
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 1;
		gbc_label2.gridy = 4;
		panelParent.add(label2, gbc_label2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Choice choice2 = new Choice();
		choice2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		selectAllRoom(choice2);
		GridBagConstraints gbc_choice2 = new GridBagConstraints();
		gbc_choice2.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice2.insets = new Insets(0, 0, 5, 5);
		gbc_choice2.gridx = 2;
		gbc_choice2.gridy = 4;
		panelParent.add(choice2, gbc_choice2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 2;
		gbc_rigidArea_3.gridy = 5;
		panelParent.add(rigidArea_3, gbc_rigidArea_3);
		
		
		JButton insert = new JButton("Insert");
		GridBagConstraints gbc_insert = new GridBagConstraints();
		gbc_insert.anchor = GridBagConstraints.WEST;
		gbc_insert.insets = new Insets(0, 0, 5, 5);
		gbc_insert.gridx = 2;
		gbc_insert.gridy = 6;
		panelParent.add(insert, gbc_insert);
		insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.gridwidth = 3;
		gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_4.gridx = 0;
		gbc_rigidArea_4.gridy = 7;
		panelParent.add(rigidArea_4, gbc_rigidArea_4);
		insert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Hack alert: Assumes choice names do not contain colons
				String idOnly = choice.getSelectedItem().split(":")[0];
				String roomnoOnly = choice2.getSelectedItem().split(":")[0];
				
				insertAssigned(idOnly, roomnoOnly);
			}
		});	
		frame.setTitle("Query7: Assign Nurse to Room");
		frame.setVisible(true);
	}
	
	
	public int insertAssigned(String id, String roomno) {
		
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
			valMap.put("id", id);
			valMap.put("roomno", roomno);
			String res = sh.sqlInsert(con, "assigned", valMap);
			JOptionPane.showMessageDialog(null, String.format("Nurse %s successfully assigned to room %s", id, roomno));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not assign Nurse to room.\n%s", e.getMessage()));
			return -1;
		}
	}
	
	
	public int selectAllNurse(Choice choice) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select id, nname from nurse";
	        
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
	
	
	public int selectAllRoom(Choice choice) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select roomno, type from room";
	        
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
