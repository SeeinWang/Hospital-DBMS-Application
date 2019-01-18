package queries;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setLocation(300, 200);
		frame.setSize(new Dimension(592, 346));
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 576, 247);
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 141, 215, 0, 0};
		gbl_panel_1.rowHeights = new int[]{65, 0, 0, 0, 0, 62, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.gridwidth = 5;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		panel_1.add(rigidArea, gbc_rigidArea);
		JLabel userLb = new JLabel("User:");
		GridBagConstraints gbc_userLb = new GridBagConstraints();
		gbc_userLb.anchor = GridBagConstraints.EAST;
		gbc_userLb.insets = new Insets(0, 0, 5, 5);
		gbc_userLb.gridx = 1;
		gbc_userLb.gridy = 1;
		panel_1.add(userLb, gbc_userLb);
		userLb.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JTextField userText = new JTextField();
		GridBagConstraints gbc_userText = new GridBagConstraints();
		gbc_userText.gridwidth = 2;
		gbc_userText.fill = GridBagConstraints.HORIZONTAL;
		gbc_userText.insets = new Insets(0, 0, 5, 5);
		gbc_userText.gridx = 2;
		gbc_userText.gridy = 1;
		panel_1.add(userText, gbc_userText);
		userText.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridheight = 4;
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 1;
		panel_1.add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel pasLb = new JLabel("Password:");
		GridBagConstraints gbc_pasLb = new GridBagConstraints();
		gbc_pasLb.anchor = GridBagConstraints.EAST;
		gbc_pasLb.insets = new Insets(0, 0, 5, 5);
		gbc_pasLb.gridx = 1;
		gbc_pasLb.gridy = 2;
		panel_1.add(pasLb, gbc_pasLb);
		pasLb.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JPasswordField pas = new JPasswordField();
		GridBagConstraints gbc_pas = new GridBagConstraints();
		gbc_pas.gridwidth = 2;
		gbc_pas.insets = new Insets(0, 0, 5, 5);
		gbc_pas.fill = GridBagConstraints.HORIZONTAL;
		gbc_pas.gridx = 2;
		gbc_pas.gridy = 2;
		panel_1.add(pas, gbc_pas);
		pas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.gridheight = 4;
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea_3.gridx = 4;
		gbc_rigidArea_3.gridy = 1;
		panel_1.add(rigidArea_3, gbc_rigidArea_3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.gridwidth = 2;
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 2;
		gbc_rigidArea_4.gridy = 3;
		panel_1.add(rigidArea_4, gbc_rigidArea_4);
		
		JButton reg = new JButton("Login");
		GridBagConstraints gbc_reg = new GridBagConstraints();
		gbc_reg.anchor = GridBagConstraints.WEST;
		gbc_reg.insets = new Insets(0, 0, 5, 5);
		gbc_reg.gridx = 2;
		gbc_reg.gridy = 4;
		panel_1.add(reg, gbc_reg);
		reg.setFont(new Font("Tahoma", Font.PLAIN, 36));
		JButton reset = new JButton("Reset");
		GridBagConstraints gbc_reset = new GridBagConstraints();
		gbc_reset.anchor = GridBagConstraints.WEST;
		gbc_reset.insets = new Insets(0, 0, 5, 5);
		gbc_reset.gridx = 3;
		gbc_reset.gridy = 4;
		panel_1.add(reset, gbc_reset);
		reset.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.gridwidth = 5;
		gbc_rigidArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_rigidArea_2.gridx = 0;
		gbc_rigidArea_2.gridy = 5;
		panel_1.add(rigidArea_2, gbc_rigidArea_2);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userText.setText("");
				pas.setText("");
			}
		});
		reg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(new File("users.txt")));
					String tu = reader.readLine();
					String tp = reader.readLine();
					if(userText.getText().equals(tu)&&pas.getText().equals(tp)){
						frame.dispose();
						new Home();
					}else{
						JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
