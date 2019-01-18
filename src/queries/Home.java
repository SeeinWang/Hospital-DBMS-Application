package queries;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 50, 1217, 992);
		frame.setTitle("Hospital Data Management system");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1192, 0};
		gridBagLayout.rowHeights = new int[]{752, 52, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panelGrid = new JPanel();
		GridBagConstraints gbc_panelGrid = new GridBagConstraints();
		gbc_panelGrid.insets = new Insets(0, 0, 5, 0);
		gbc_panelGrid.gridx = 0;
		gbc_panelGrid.gridy = 0;
		frame.getContentPane().add(panelGrid, gbc_panelGrid);
		GridBagLayout gbl_panelGrid = new GridBagLayout();
		gbl_panelGrid.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelGrid.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelGrid.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelGrid.setLayout(gbl_panelGrid);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 2;
		gbc_rigidArea_2.gridy = 0;
		panelGrid.add(rigidArea_2, gbc_rigidArea_2);
		
		JLabel infoLabel = new JLabel("Welcome! Please choose from the following:");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.gridwidth = 3;
		gbc_infoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_infoLabel.gridx = 2;
		gbc_infoLabel.gridy = 1;
		panelGrid.add(infoLabel, gbc_infoLabel);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_7 = new GridBagConstraints();
		gbc_rigidArea_7.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_7.gridx = 3;
		gbc_rigidArea_7.gridy = 2;
		panelGrid.add(rigidArea_7, gbc_rigidArea_7);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_3 = new GridBagConstraints();
		gbc_rigidArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_3.gridx = 2;
		gbc_rigidArea_3.gridy = 3;
		panelGrid.add(rigidArea_3, gbc_rigidArea_3);
		
		JLabel labelSubheader1 = new JLabel("Manage Patients\r\n");
		labelSubheader1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_labelSubheader1 = new GridBagConstraints();
		gbc_labelSubheader1.insets = new Insets(0, 0, 5, 5);
		gbc_labelSubheader1.gridx = 2;
		gbc_labelSubheader1.gridy = 4;
		panelGrid.add(labelSubheader1, gbc_labelSubheader1);
		
		JLabel lblHospitalOperation = new JLabel("Hospital Operations");
		lblHospitalOperation.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblHospitalOperation = new GridBagConstraints();
		gbc_lblHospitalOperation.insets = new Insets(0, 0, 5, 5);
		gbc_lblHospitalOperation.gridx = 4;
		gbc_lblHospitalOperation.gridy = 4;
		panelGrid.add(lblHospitalOperation, gbc_lblHospitalOperation);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.gridwidth = 2;
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 5;
		panelGrid.add(rigidArea_1, gbc_rigidArea_1);
		
		Panel panel1 = new Panel();
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.insets = new Insets(0, 0, 5, 5);
		gbc_panel1.gridx = 2;
		gbc_panel1.gridy = 5;
		panelGrid.add(panel1, gbc_panel1);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{0, 429, 0};
		gbl_panel1.rowHeights = new int[]{47, 0, 47, 47, 47, 47, 47, 0};
		gbl_panel1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_panel1);
		JButton but5 = new JButton("New Patient Test result");
		but5.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query5();
			}
		});
		JButton but6 = new JButton("Update Patient Contact Info");
		but6.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query6();
			}
		});
		JButton but1 = new JButton("New Patient");
		but1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query1();
			}
		});
		
		JLabel lblQ = new JLabel("Q1:");
		lblQ.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ = new GridBagConstraints();
		gbc_lblQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ.gridx = 0;
		gbc_lblQ.gridy = 0;
		panel1.add(lblQ, gbc_lblQ);
		GridBagConstraints gbc_but1 = new GridBagConstraints();
		gbc_but1.fill = GridBagConstraints.BOTH;
		gbc_but1.insets = new Insets(0, 0, 5, 0);
		gbc_but1.gridx = 1;
		gbc_but1.gridy = 0;
		panel1.add(but1, gbc_but1);
		
		JButton butViewAll = new JButton("View All Patients");
		butViewAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new QueryAllPatient();
			}
		});
		butViewAll.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_butViewAll = new GridBagConstraints();
		gbc_butViewAll.fill = GridBagConstraints.HORIZONTAL;
		gbc_butViewAll.insets = new Insets(0, 0, 5, 0);
		gbc_butViewAll.gridx = 1;
		gbc_butViewAll.gridy = 1;
		panel1.add(butViewAll, gbc_butViewAll);
		
		JLabel lblQ_1 = new JLabel("Q6:");
		lblQ_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_1 = new GridBagConstraints();
		gbc_lblQ_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_1.gridx = 0;
		gbc_lblQ_1.gridy = 2;
		panel1.add(lblQ_1, gbc_lblQ_1);
		GridBagConstraints gbc_but6 = new GridBagConstraints();
		gbc_but6.fill = GridBagConstraints.BOTH;
		gbc_but6.insets = new Insets(0, 0, 5, 0);
		gbc_but6.gridx = 1;
		gbc_but6.gridy = 2;
		panel1.add(but6, gbc_but6);
		
		JLabel lblQ_2 = new JLabel("Q5:");
		lblQ_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_2 = new GridBagConstraints();
		gbc_lblQ_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_2.gridx = 0;
		gbc_lblQ_2.gridy = 3;
		panel1.add(lblQ_2, gbc_lblQ_2);
		GridBagConstraints gbc_but5 = new GridBagConstraints();
		gbc_but5.fill = GridBagConstraints.BOTH;
		gbc_but5.insets = new Insets(0, 0, 5, 0);
		gbc_but5.gridx = 1;
		gbc_but5.gridy = 3;
		panel1.add(but5, gbc_but5);
		JButton but3 = new JButton("Get Patient Test Result");
		but3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query3();
			}
		});
		
		JLabel lblQ_3 = new JLabel("Q3:");
		lblQ_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_3 = new GridBagConstraints();
		gbc_lblQ_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_3.gridx = 0;
		gbc_lblQ_3.gridy = 4;
		panel1.add(lblQ_3, gbc_lblQ_3);
		GridBagConstraints gbc_but3 = new GridBagConstraints();
		gbc_but3.fill = GridBagConstraints.BOTH;
		gbc_but3.insets = new Insets(0, 0, 5, 0);
		gbc_but3.gridx = 1;
		gbc_but3.gridy = 4;
		panel1.add(but3, gbc_but3);
		JButton but4 = new JButton("Delete Patient");
		but4.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query4();
			}
		});
		JButton but2 = new JButton("Get Patient Medicine");
		but2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query2();
			}
		});
		
		JLabel lblQ_4 = new JLabel("Q2:");
		lblQ_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_4 = new GridBagConstraints();
		gbc_lblQ_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_4.gridx = 0;
		gbc_lblQ_4.gridy = 5;
		panel1.add(lblQ_4, gbc_lblQ_4);
		GridBagConstraints gbc_but2 = new GridBagConstraints();
		gbc_but2.fill = GridBagConstraints.BOTH;
		gbc_but2.insets = new Insets(0, 0, 5, 0);
		gbc_but2.gridx = 1;
		gbc_but2.gridy = 5;
		panel1.add(but2, gbc_but2);
		
		JLabel lblQ_5 = new JLabel("Q4:");
		lblQ_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_5 = new GridBagConstraints();
		gbc_lblQ_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblQ_5.gridx = 0;
		gbc_lblQ_5.gridy = 6;
		panel1.add(lblQ_5, gbc_lblQ_5);
		GridBagConstraints gbc_but4 = new GridBagConstraints();
		gbc_but4.fill = GridBagConstraints.BOTH;
		gbc_but4.gridx = 1;
		gbc_but4.gridy = 6;
		panel1.add(but4, gbc_but4);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_6 = new GridBagConstraints();
		gbc_rigidArea_6.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_6.gridx = 3;
		gbc_rigidArea_6.gridy = 5;
		panelGrid.add(rigidArea_6, gbc_rigidArea_6);
		
		Panel panel2 = new Panel();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.anchor = GridBagConstraints.NORTH;
		gbc_panel2.insets = new Insets(0, 0, 5, 5);
		gbc_panel2.gridx = 4;
		gbc_panel2.gridy = 5;
		panelGrid.add(panel2, gbc_panel2);
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[]{0, 511, 0};
		gbl_panel2.rowHeights = new int[]{47, 47, 47, 47, 47, 0};
		gbl_panel2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel2.setLayout(gbl_panel2);
		
		JLabel lblQ_6 = new JLabel("Q7:");
		lblQ_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_6 = new GridBagConstraints();
		gbc_lblQ_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_6.gridx = 0;
		gbc_lblQ_6.gridy = 0;
		panel2.add(lblQ_6, gbc_lblQ_6);
		
		JButton but7 = new JButton("Assign Nurse to Room");
		but7.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but7 = new GridBagConstraints();
		gbc_but7.fill = GridBagConstraints.BOTH;
		gbc_but7.insets = new Insets(0, 0, 5, 0);
		gbc_but7.gridx = 1;
		gbc_but7.gridy = 0;
		panel2.add(but7, gbc_but7);
		but7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query7();
			}
		});
		
		JLabel lblQ_7 = new JLabel("Q8:");
		lblQ_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_7 = new GridBagConstraints();
		gbc_lblQ_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_7.gridx = 0;
		gbc_lblQ_7.gridy = 1;
		panel2.add(lblQ_7, gbc_lblQ_7);
		
		JButton but8 = new JButton("Update Patient Record");
		but8.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but8 = new GridBagConstraints();
		gbc_but8.fill = GridBagConstraints.BOTH;
		gbc_but8.insets = new Insets(0, 0, 5, 0);
		gbc_but8.gridx = 1;
		gbc_but8.gridy = 1;
		panel2.add(but8, gbc_but8);
		but8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query8();
			}
		});
		
		JLabel lblQ_8 = new JLabel("Q9:");
		lblQ_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_8 = new GridBagConstraints();
		gbc_lblQ_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_8.gridx = 0;
		gbc_lblQ_8.gridy = 2;
		panel2.add(lblQ_8, gbc_lblQ_8);
		
		JButton but9 = new JButton("Prescribe Patient Medicine");
		but9.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but9 = new GridBagConstraints();
		gbc_but9.fill = GridBagConstraints.BOTH;
		gbc_but9.insets = new Insets(0, 0, 5, 0);
		gbc_but9.gridx = 1;
		gbc_but9.gridy = 2;
		panel2.add(but9, gbc_but9);
		but9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query9();
			}
		});
		
		JLabel lblQ_9 = new JLabel("Q10:");
		lblQ_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_9 = new GridBagConstraints();
		gbc_lblQ_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_9.gridx = 0;
		gbc_lblQ_9.gridy = 3;
		panel2.add(lblQ_9, gbc_lblQ_9);
		
		JButton but10 = new JButton("Charge Cost of Medicine");
		but10.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but10 = new GridBagConstraints();
		gbc_but10.fill = GridBagConstraints.BOTH;
		gbc_but10.insets = new Insets(0, 0, 5, 0);
		gbc_but10.gridx = 1;
		gbc_but10.gridy = 3;
		panel2.add(but10, gbc_but10);
		but10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query10();
			}
		});
		
		JLabel lblQ_10 = new JLabel("Q11:");
		lblQ_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_10 = new GridBagConstraints();
		gbc_lblQ_10.insets = new Insets(0, 0, 0, 5);
		gbc_lblQ_10.gridx = 0;
		gbc_lblQ_10.gridy = 4;
		panel2.add(lblQ_10, gbc_lblQ_10);
		
		JButton but11 = new JButton("Deduct Coverage from Patient Bill");
		but11.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but11 = new GridBagConstraints();
		gbc_but11.fill = GridBagConstraints.BOTH;
		gbc_but11.gridx = 1;
		gbc_but11.gridy = 4;
		panel2.add(but11, gbc_but11);
		but11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Query11();
			}
		});
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_4 = new GridBagConstraints();
		gbc_rigidArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_4.gridx = 5;
		gbc_rigidArea_4.gridy = 5;
		panelGrid.add(rigidArea_4, gbc_rigidArea_4);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 6;
		panelGrid.add(rigidArea, gbc_rigidArea);
		
		JLabel lblHospitalAnalytics = new JLabel("Hospital Analytics");
		lblHospitalAnalytics.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblHospitalAnalytics = new GridBagConstraints();
		gbc_lblHospitalAnalytics.gridwidth = 3;
		gbc_lblHospitalAnalytics.insets = new Insets(0, 0, 5, 5);
		gbc_lblHospitalAnalytics.gridx = 2;
		gbc_lblHospitalAnalytics.gridy = 7;
		panelGrid.add(lblHospitalAnalytics, gbc_lblHospitalAnalytics);
		
		Panel panel3 = new Panel();
		GridBagConstraints gbc_panel3 = new GridBagConstraints();
		gbc_panel3.gridwidth = 3;
		gbc_panel3.insets = new Insets(0, 0, 0, 5);
		gbc_panel3.gridx = 2;
		gbc_panel3.gridy = 8;
		panelGrid.add(panel3, gbc_panel3);
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[]{0, 483, 0};
		gbl_panel3.rowHeights = new int[]{47, 47, 47, 47, 0};
		gbl_panel3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel3.setLayout(gbl_panel3);
		
		JLabel lblQ_11 = new JLabel("Q12:");
		lblQ_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_11 = new GridBagConstraints();
		gbc_lblQ_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_11.gridx = 0;
		gbc_lblQ_11.gridy = 0;
		panel3.add(lblQ_11, gbc_lblQ_11);
		
		JButton but12 = new JButton("Patients who Took all Medicines");
		GridBagConstraints gbc_but12 = new GridBagConstraints();
		gbc_but12.fill = GridBagConstraints.BOTH;
		gbc_but12.insets = new Insets(0, 0, 5, 0);
		gbc_but12.gridx = 1;
		gbc_but12.gridy = 0;
		panel3.add(but12, gbc_but12);
		but12.setFont(new Font("Tahoma", Font.PLAIN, 32));
		but12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new Query12();
				Query12.selectPatientAllMedicine();
			}
		});
		
		JLabel lblQ_12 = new JLabel("Q13:");
		lblQ_12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_12 = new GridBagConstraints();
		gbc_lblQ_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_12.gridx = 0;
		gbc_lblQ_12.gridy = 1;
		panel3.add(lblQ_12, gbc_lblQ_12);
		
		JButton but13 = new JButton("Most Expensive Medicine");
		but13.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but13 = new GridBagConstraints();
		gbc_but13.fill = GridBagConstraints.BOTH;
		gbc_but13.insets = new Insets(0, 0, 5, 0);
		gbc_but13.gridx = 1;
		gbc_but13.gridy = 1;
		panel3.add(but13, gbc_but13);
		but13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				new Query13();
				Query13.selectMostExpensiveMedicine();
			}
		});
		
		JLabel lblQ_13 = new JLabel("Q14:");
		lblQ_13.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_13 = new GridBagConstraints();
		gbc_lblQ_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblQ_13.gridx = 0;
		gbc_lblQ_13.gridy = 2;
		panel3.add(lblQ_13, gbc_lblQ_13);
		
		JButton but14 = new JButton("Least Expensive Medicine");
		but14.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but14 = new GridBagConstraints();
		gbc_but14.fill = GridBagConstraints.BOTH;
		gbc_but14.insets = new Insets(0, 0, 5, 0);
		gbc_but14.gridx = 1;
		gbc_but14.gridy = 2;
		panel3.add(but14, gbc_but14);
		but14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				new Query14();
				Query14.selectLeastExpensiveMedicine();
			}
		});
		
		JLabel lblQ_14 = new JLabel("Q15:");
		lblQ_14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblQ_14 = new GridBagConstraints();
		gbc_lblQ_14.insets = new Insets(0, 0, 0, 5);
		gbc_lblQ_14.gridx = 0;
		gbc_lblQ_14.gridy = 3;
		panel3.add(lblQ_14, gbc_lblQ_14);
		
		JButton but15 = new JButton("Average Tests per Patient");
		but15.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_but15 = new GridBagConstraints();
		gbc_but15.fill = GridBagConstraints.BOTH;
		gbc_but15.gridx = 1;
		gbc_but15.gridy = 3;
		panel3.add(but15, gbc_but15);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_5 = new GridBagConstraints();
		gbc_rigidArea_5.gridx = 0;
		gbc_rigidArea_5.gridy = 1;
		frame.getContentPane().add(rigidArea_5, gbc_rigidArea_5);
		but15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				new Query15();
				Query15.selectAverageTestsByPatients();
			}
		});
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
	}
}
