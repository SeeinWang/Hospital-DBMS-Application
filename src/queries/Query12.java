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

import connect.DBConnectionUtil;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Query12 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query12 window = new Query12();
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
	public Query12() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,240,676,268);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 659, 226);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 0;
		panel.add(rigidArea, gbc_rigidArea);
		
		JLabel infoLabel = new JLabel("Find patients who were recommended");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 1;
		gbc_infoLabel.gridy = 1;
		panel.add(infoLabel, gbc_infoLabel);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 2;
		panel.add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel lblEveryMedicine = new JLabel("every medicine:");
		GridBagConstraints gbc_lblEveryMedicine = new GridBagConstraints();
		gbc_lblEveryMedicine.insets = new Insets(0, 0, 5, 5);
		gbc_lblEveryMedicine.gridx = 1;
		gbc_lblEveryMedicine.gridy = 2;
		panel.add(lblEveryMedicine, gbc_lblEveryMedicine);
		lblEveryMedicine.setFont(new Font("Tahoma", Font.PLAIN, 36));
				
				Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
				gbc_rigidArea_3.insets = new Insets(0, 0, 5, 0);
				gbc_rigidArea_3.gridx = 2;
				gbc_rigidArea_3.gridy = 2;
				panel.add(rigidArea_3, gbc_rigidArea_3);
				
				Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
				gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
				gbc_rigidArea_2.gridx = 1;
				gbc_rigidArea_2.gridy = 3;
				panel.add(rigidArea_2, gbc_rigidArea_2);
		
				JButton insert = new JButton("Search");
				GridBagConstraints gbc_insert = new GridBagConstraints();
				gbc_insert.insets = new Insets(0, 0, 5, 5);
				gbc_insert.gridx = 1;
				gbc_insert.gridy = 4;
				panel.add(insert, gbc_insert);
				insert.setFont(new Font("Tahoma", Font.PLAIN, 36));
				
				Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
				gbc_rigidArea_4.insets = new Insets(0, 0, 0, 5);
				gbc_rigidArea_4.gridx = 1;
				gbc_rigidArea_4.gridy = 5;
				panel.add(rigidArea_4, gbc_rigidArea_4);
				insert.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						selectPatientAllMedicine();
					}
				});	
		frame.setTitle("Query12: Patients who were recommended every medicine");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public static int selectPatientAllMedicine() {
		
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select P.pname from patient P where not exists "
					+ "((select mname from Medicine) minus (select mname from recommends R where R.pid = P.pid))";
			String res = "";
			
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				
				res = rs.getString(1);
				
//				// ResultSet counts start at 1
//				for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
//					res = res.concat(rsmd.getColumnLabel(i) + "=" + rs.getString(i).trim() + ", ");
//				}
//				res = res.substring(0, res.length() - 2);	// remove last comma
			}
			ps.close();	
			JOptionPane.showMessageDialog(null, String.format("Patients who were recommended every medicine:\n%s", res));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not complete search.\n%s", e.getMessage()));
			return -1;
		}
	}
}
