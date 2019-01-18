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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.DBConnectionUtil;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class QueryAllPatient {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryAllPatient window = new QueryAllPatient();
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
	public QueryAllPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300,250,1889,840);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame.getContentPane().setLayout(null);
		
		JTable jtable = new JTable();
		jtable.setFont(new Font("Tahoma", Font.PLAIN, 28));
		jtable.setRowHeight(40);
		JScrollPane pane = new JScrollPane(jtable);
		pane.setBounds(26, 28, 1809, 658);
		frame.getContentPane().add(pane);
		
		selectAllPatient(jtable);
		
		frame.setVisible(true);
		frame.setTitle("View All Patients");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public int selectAllPatient(JTable jtable) {
		
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connection ok... preparing query");
			}
			
			// 2.query code
			SqlHelper sh = new SqlHelper();
			String select = "select p.pid, pname, cost, amount as coverage, disease, notes, address, phone "
					+ "from patient p "
					+ "left outer join patientrecord pr on p.pid=pr.pid "
					+ "inner join patientinsurance pi on p.pid=pi.pid "
					+ "right outer join insuranceaccount i on pi.id=i.id";
			
			DefaultTableModel tablemodel=new DefaultTableModel(); 
	        Object[] columns=new Object[8];   
	        tablemodel.addColumn("ID");
	        tablemodel.addColumn("Name");
	        tablemodel.addColumn("Costs");
	        tablemodel.addColumn("Coverage");
	        tablemodel.addColumn("Disease");
	        tablemodel.addColumn("Notes");
	        tablemodel.addColumn("Address");
	        tablemodel.addColumn("Phone");
	        
	        
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()){
				
	            columns[0]=rs.getString(1);
	            columns[1]=rs.getString(2);
	            if (rs.getString(3) != null && rs.getString(3) != "") {
	            	
	            	columns[2]=String.format("%.2f", Double.parseDouble(rs.getString(3)));
	            }
	            else columns[2]=rs.getString(3);
	            if (rs.getString(4) != null && rs.getString(4) != "") {

	            	columns[3]=String.format("%.2f", Double.parseDouble(rs.getString(4)));
	            }
	            else columns[3]=rs.getString(4);
	            columns[4]=rs.getString(5);
	            columns[5]=rs.getString(6);
	            columns[6]=rs.getString(7);
	            columns[7]=rs.getString(8);
	            tablemodel.addRow(columns);
			}
			ps.close();
			
			jtable.setModel(tablemodel);
			
			jtable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 28));
			
			jtable.getColumnModel().getColumn(0).setMinWidth(45);
			jtable.getColumnModel().getColumn(0).setMaxWidth(45);
			jtable.getColumnModel().getColumn(1).setMinWidth(275);
			jtable.getColumnModel().getColumn(1).setMaxWidth(275);
			jtable.getColumnModel().getColumn(2).setMinWidth(125);
			jtable.getColumnModel().getColumn(2).setMaxWidth(125);
			
			jtable.getColumnModel().getColumn(3).setMinWidth(125);
			jtable.getColumnModel().getColumn(3).setMaxWidth(125);
			jtable.getColumnModel().getColumn(4).setMinWidth(275);
			jtable.getColumnModel().getColumn(4).setMaxWidth(275);
			jtable.getColumnModel().getColumn(5).setMinWidth(350);
			jtable.getColumnModel().getColumn(5).setMaxWidth(350);
			
			
			jtable.getColumnModel().getColumn(6).setMinWidth(375);
			jtable.getColumnModel().getColumn(6).setMaxWidth(375);
			jtable.getColumnModel().getColumn(7).setMinWidth(250);
			jtable.getColumnModel().getColumn(7).setMaxWidth(250);
			
			
			//JOptionPane.showMessageDialog(null, String.format("Average number of tests per patient:\n%s", res));
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, String.format("ERROR: Could not complete search.\n%s", e.getMessage()));
			return -1;
		}
	}
}
