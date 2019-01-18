package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

import connect.DBConnectionUtil;

public class SqlHelper {
	
	/*
	 * Call to main to test
	 */
	public static void main(String args[]){
		
		Connection con = null;
		
		// Instantiation connection for SqlHelper testing
		try {
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connect database successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SqlHelper sh = new SqlHelper();
		
		// Check-If-Exists
		HashMap<String, String> valMap0t = new HashMap<String, String>();
		valMap0t.put("pid", "1");
		int res0t = sh.checkIfExists(con, "patient", valMap0t);
		if (res0t == 0) System.out.println("CheckIfExists True: OK");
		else System.out.println("CheckIfExists True: ***FAILED***");
		
//		HashMap<String, String> valMap0f = new HashMap<String, String>();
//		valMap0f.put("pid", "9999");
//		int res0f = sh.checkIfExists(con, "patient", valMap0f);
//		if (res0f < 0) System.out.println("CheckIfExists False: OK");
//		else System.out.println("CheckIfExists False: ***FAILED***");
//		
//		// Insert
//		HashMap<String, String> valMap1 = new HashMap<String, String>();
//		valMap1.put("pid", "50");
//		valMap1.put("pname", "'Johnny Test'");
//		valMap1.put("address", "'123 Home St'");
//		valMap1.put("phone", "'604-555-5555'");
//		String res1 = sh.sqlInsert(con, "patient", valMap1);
//		if (res1.toLowerCase().contains("pid=50".toLowerCase())) System.out.println("sqlInsert: OK");
//		else System.out.println("sqlInsert: ***FAILED***");
//		
//		// Update
//		HashMap<String, String> pkMap2 = new HashMap<String, String>();
//		pkMap2.put("pid", "50");
//		HashMap<String, String> valMap2 = new HashMap<String, String>();
//		valMap2.put("pname", "'Susie Test'");
//		String res2 = sh.sqlUpdate(con, "patient", pkMap2, valMap2);
//		if (res2.toLowerCase().contains("pname=Susie Test".toLowerCase())) System.out.println("sqlUpdate: OK");
//		else System.out.println("sqlUpdate: ***FAILED***");
//		
//		// Delete
//		HashMap<String, String> valMap3 = new HashMap<String, String>();
//		valMap3.put("pid", "50");
//		int res3 = sh.sqlDelete(con, "patient", valMap3);
//		if (res3 == 0) System.out.println("sqlDelete: OK");
//		else System.out.println("sqlDelete: ***FAILED***");
	}
	
	/*
	 * General function for SELECT. Returns 0 if exists; -1 if does not exist.
	 * Accepts connection, tableName and Map/"dictionary" of attr-value pairs.
	 */
	public int checkIfExists(Connection con, String tableName, HashMap<String, String> valMap) {
		
		String select = "select * from ";
		String selValues = "";
		
		for (HashMap.Entry<String, String> entry : valMap.entrySet()){
			selValues = selValues.concat(" " + entry.getKey() + "=" + entry.getValue() + " AND");
		}
		// Remove last commas/ANDs
		selValues = selValues.substring(0, selValues.length() - 4);
		
		select = select + tableName + " where" + selValues;
		System.out.println(select);
		
		try {		
			// Select
			PreparedStatement ps2 = con.prepareStatement(select);
			ResultSet rs2 = ps2.executeQuery();
			//System.out.println("Just called executeQuery");
			
			if(rs2.next()){
				
//				while(rs2.next()){
//					System.out.println("PID: "+rs2.getInt(1)+" PNAME: "+rs2.getString(2)+" ADDRESS: "+rs2.getString(3)+" PHONE: "+rs2.getString(4));
//				}
				
				ps2.close();
				return 0;
			}
			else {
				
//				System.out.println("rs2.next() was false");
				
				ps2.close();
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	/*
	 * General function for INSERT. Returns newly-created tuple (SELECT).
	 * Accepts tableName and Map/"dictionary" of attr-value pairs.
	 */
	public String sqlInsert(Connection con, String tableName, HashMap<String, String> valMap) {
		
		String insert = "insert into ";
		String columns = " (";
		String select = "select * from ";
		String insValues = "";
		String selValues = "";
		String confirm = "";

		for (HashMap.Entry<String, String> entry : valMap.entrySet()){
			insValues = insValues.concat(entry.getValue() + ", ");
			columns = columns.concat(" " + entry.getKey() + ", ");
			selValues = selValues.concat(" " + entry.getKey() + "=" + entry.getValue() + " AND");
		}
		
		// Remove last commas/ANDs
		insValues = insValues.substring(0, insValues.length() - 2);
		columns = columns.substring(0, columns.length() - 2);
		selValues = selValues.substring(0, selValues.length() - 4);
		
		insert = insert + tableName + columns + ") "+ " values (" + insValues + ")";
		select = select + tableName + " where" + selValues;
		
		System.out.println(insert);
		
		try {
			// Insert
			PreparedStatement ps1 = con.prepareStatement(insert);
			int rs1 = ps1.executeUpdate();
			con.commit();
			
			// Select
			PreparedStatement ps2 = con.prepareStatement(select);
			ResultSet rs2 = ps2.executeQuery();
			ResultSetMetaData rsmd2 = rs2.getMetaData();
			while(rs2.next()){
				
				// ResultSet counts start at 1
				for (int i = 1; i < rsmd2.getColumnCount() + 1; i++) {
					confirm = confirm.concat(rsmd2.getColumnLabel(i) + "=" + rs2.getString(i).trim() + ", ");
				}
				confirm = confirm.substring(0, confirm.length() - 2);	// remove last comma
			}
			ps2.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return confirm;
	}
	
		
	/*
	 * General function for UPDATE. Returns newly-created tuple (SELECT).
	 * Accepts tableName and Map/"dictionary" of attr-value pairs.
	 */
	public String sqlUpdate(Connection con, String tableName, HashMap<String, String> pkMap, HashMap<String, String> valMap) {
		
		String update = "update ";
		String select = "select * from ";
		String conds = "";
		String updValues = "";
		String selValues = "";
		String confirm = "";
		
		for (HashMap.Entry<String, String> entry : pkMap.entrySet()) {
			conds = conds.concat(" " + entry.getKey() + "=" + entry.getValue() + " AND");
		}

		for (HashMap.Entry<String, String> entry : valMap.entrySet()){
			updValues = updValues.concat(" " + entry.getKey() + "=" + entry.getValue() + " ,");
			selValues = selValues.concat(" " + entry.getKey() + "=" + entry.getValue() + " AND");
		}
		
		// Remove last commas/ANDs
		conds = conds.substring(0, conds.length() - 4);
		updValues = updValues.substring(0, updValues.length() - 2);
		selValues = selValues.substring(0, selValues.length() - 4);
		
		update = update + tableName + " set "+ updValues + " where " + conds;
		select = select + tableName + " where" + selValues;
		
		System.out.println(update);
		
		try {
			// Update
			PreparedStatement ps1 = con.prepareStatement(update);
			int rs1 = ps1.executeUpdate();
			con.commit();
			
			// Select
			PreparedStatement ps2 = con.prepareStatement(select);
			ResultSet rs2 = ps2.executeQuery();
			ResultSetMetaData rsmd2 = rs2.getMetaData();
			while(rs2.next()){
				
				// ResultSet counts start at 1
				for (int i = 1; i < rsmd2.getColumnCount() + 1; i++) {
					
					String val = rs2.getString(i);
					if (val != null) {
						val = val.trim();
					}
					confirm = confirm.concat(rsmd2.getColumnLabel(i) + "=" + val + ", ");
				}
				confirm = confirm.substring(0, confirm.length() - 2);	// remove last comma
			}
			ps2.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return confirm;
	}
	
	
	/*
	 * General function for DELETE. Returns 0 if successful, -1 if error.
	 * Accepts tableName and Map/"dictionary" of primary key pairs.
	 */
	public int sqlDelete(Connection con, String tableName, HashMap<String, String> valMap) {
		
		if (valMap.isEmpty()) {
			return -1;
		}
		
		String delete = "delete from " + tableName + " where";
		String conds = "";

		for (HashMap.Entry<String, String> entry : valMap.entrySet()){
			conds = conds.concat(" " + entry.getKey() + "=" + entry.getValue() + " AND");
		}
		
		// Remove last AND
		conds = conds.substring(0, conds.length() - 4);
		delete = delete.concat(conds);
		
		System.out.println(delete);
		
		try {
			PreparedStatement ps = con.prepareStatement(delete);
			int rs = ps.executeUpdate();
			con.commit();
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
