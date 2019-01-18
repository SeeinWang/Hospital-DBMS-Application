package tests;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import connect.DBConnectionUtil;
import queries.SqlHelper;
import queries.Query10;
import queries.Query11;
import queries.Query12;
import queries.Query13;
import queries.Query14;
import queries.Query15;
import queries.Query7;
import queries.Query8;
import queries.Query9;


/*
 * TestClass for all query-related functions
 * NOTE: Query-related tests may be delayed. Look out for Swing dialog windows during run.
 */
public class TestClass {
	
	static Connection con;
	
	/*
	 * Call to main to test
	 */
	public static void main(String args[]){
		
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
		testHelper(sh);
		
		Query7 q7 = new Query7();
		testQ7(sh, q7);
		
		Query8 q8 = new Query8();
		testQ8(sh, q8);
		
		Query9 q9 = new Query9();
		testQ9(sh, q9);
		
		Query10 q10 = new Query10();
		testQ10(sh, q10);
		
		Query11 q11 = new Query11();
		testQ11(sh, q11);
		
		Query13 q13 = new Query13();
		testQ13(q13);
		
		Query14 q14 = new Query14();
		testQ14(q14);
		
		Query15 q15 = new Query15();
		testQ15(q15);
		
		Query12 q12 = new Query12();
		testQ12(q12);
	}
	
	
	/*
	 * Test Query12-related functions (patients who were recommended every medicine)
	 */
	private static void testQ12(Query12 q12) {
		System.out.println("\n====== Query 12 ======");
		int res1 = q12.selectPatientAllMedicine();
		if (res1 == 0) System.out.println("q12: OK");
		else System.out.println("q12: ***FAILED***");
	}
	
	
	/*
	 * Test Query15-related functions (average number of tests taken by patients)
	 */
	private static void testQ15(Query15 q15) {
		System.out.println("\n====== Query 15 ======");
		int res1 = q15.selectAverageTestsByPatients();
		if (res1 == 0) System.out.println("q15: OK");
		else System.out.println("q15: ***FAILED***");
	}
	
	
	/*
	 * Test Query14-related functions (return most expensive medicine)
	 */
	private static void testQ14(Query14 q14) {
		System.out.println("\n====== Query 14 ======");
		int res1 = q14.selectLeastExpensiveMedicine();
		if (res1 == 0) System.out.println("q14: OK");
		else System.out.println("q14: ***FAILED***");
	}
	
	
	/*
	 * Test Query13-related functions (return most expensive medicine)
	 */
	private static void testQ13(Query13 q13) {
		System.out.println("\n====== Query 13: ======");
		int res1 = q13.selectMostExpensiveMedicine();
		if (res1 == 0) System.out.println("q13: OK");
		else System.out.println("q13: ***FAILED***");
	}
	
	/*
	 * Test Query11-related functions (deduct covered from patientrecord cost)
	 */
	private static void testQ11(SqlHelper sh, Query11 q11) {	
		System.out.println("\n====== Query 11: ======");
		int res1 = q11.deductCoverage("1");
		if (res1 == 0) System.out.println("q11: OK");
		else System.out.println("q11: ***FAILED***");
		
		// Restore database with SqlHelper
		HashMap<String, String> pkMap9 = new HashMap<String, String>();
		pkMap9.put("pid", "1");
		HashMap<String, String> valMap9 = new HashMap<String, String>();
		valMap9.put("cost", "35.00");
		String res9 = sh.sqlUpdate(con, "patientRecord", pkMap9, valMap9);
	}
	
	
	/*
	 * Test Query10-related functions (buy/charge all patient medicine to record cost)
	 */
	private static void testQ10(SqlHelper sh, Query10 q10) {

		System.out.println("\n====== Query 10: ======");
		int res1 = q10.buyMedicine("1");
		if (res1 == 0) System.out.println("q10: OK");
		else System.out.println("q10: ***FAILED***");
		
		// Restore database with SqlHelper
		HashMap<String, String> pkMap8 = new HashMap<String, String>();
		pkMap8.put("pid", "1");
		HashMap<String, String> valMap8 = new HashMap<String, String>();
		valMap8.put("cost", "35.00");
		String res8 = sh.sqlUpdate(con, "patientRecord", pkMap8, valMap8);
	}
	
	
	
	/*
	 * Test Query9-related functions (Recommend medicine to patient)
	 */
	private static void testQ9(SqlHelper sh, Query9 q9) {	
		System.out.println("\n====== Query 9: ======");
		int res1 = q9.insertRecommends("1", "5", "'ct scan'", "'fluorouracil'");
		if (res1 == 0) System.out.println("q9: OK");
		else System.out.println("q9: ***FAILED***");
		
		// Restore database with SqlHelper
		HashMap<String, String> valMap1 = new HashMap<String, String>();
		valMap1.put("id", "1");
		valMap1.put("pid", "5");
		valMap1.put("tname", "'ct scan'");
		valMap1.put("mname", "'fluorouracil'");
		sh.sqlDelete(con, "recommends", valMap1);
	}
	
	
	/*
	 * Test Query8-related functions (Update patientrecord)
	 */
	private static void testQ8(SqlHelper sh, Query8 q8) {
		
		System.out.println("\n====== Query 8: ======");
		int res1 = q8.updatePatientRecord("1", "99.99", "tuberculosis", "taken to emergency");
		if (res1 == 0) System.out.println("q8: OK");
		else System.out.println("q8: ***FAILED***");
		
		// Restore database with SqlHelper
		HashMap<String, String> pkMap1 = new HashMap<String, String>();
		pkMap1.put("pid", "1");
		HashMap<String, String> valMap1 = new HashMap<String, String>();
		valMap1.put("cost", "35.00");
		valMap1.put("disease", "'giardiasis'");
		valMap1.put("notes", "'Patient complained of 3+ weeks abdominal pains. Completed test in office'");
		sh.sqlUpdate(con, "patientrecord", pkMap1, valMap1);
	}
	
	
	/*
	 * Test Query7-related functions (Assign nurse to room)
	 */
	private static void testQ7(SqlHelper sh, Query7 q7) {
		
		System.out.println("\n====== Query 7: ======");
		int res1 = q7.insertAssigned("1", "307");
		if (res1 == 0) System.out.println("q7: OK");
		else System.out.println("q7: ***FAILED***");
		
		// Restore database with SqlHelper
		HashMap<String, String> valMap1 = new HashMap<String, String>();
		valMap1.put("id", "1");
		valMap1.put("roomno", "307");
		sh.sqlDelete(con, "assigned", valMap1);
	}
	
	
	/*
	 * Test sqlHelper functions
	 */
	private static void testHelper(SqlHelper sh) {
		// Check-If-Exists
		HashMap<String, String> valMap0t = new HashMap<String, String>();
		valMap0t.put("pid", "1");
		int res0t = sh.checkIfExists(con, "patient", valMap0t);
		if (res0t == 0) System.out.println("CheckIfExists True: OK");
		else System.out.println("CheckIfExists True: ***FAILED***");
		
		HashMap<String, String> valMap0f = new HashMap<String, String>();
		valMap0f.put("pid", "9999");
		int res0f = sh.checkIfExists(con, "patient", valMap0f);
		if (res0f < 0) System.out.println("CheckIfExists False: OK");
		else System.out.println("CheckIfExists False: ***FAILED***");
		
		// Insert
		HashMap<String, String> valMap1 = new HashMap<String, String>();
		valMap1.put("pid", "50");
		valMap1.put("pname", "'Johnny Test'");
		valMap1.put("address", "'123 Home St'");
		valMap1.put("phone", "'604-555-5555'");
		String res1 = sh.sqlInsert(con, "patient", valMap1);
		if (res1.toLowerCase().contains("pid=50".toLowerCase())) System.out.println("sqlInsert: OK");
		else System.out.println("sqlInsert: ***FAILED***");
		
		// Update
		HashMap<String, String> pkMap2 = new HashMap<String, String>();
		pkMap2.put("pid", "50");
		HashMap<String, String> valMap2 = new HashMap<String, String>();
		valMap2.put("pname", "'Susie Test'");
		String res2 = sh.sqlUpdate(con, "patient", pkMap2, valMap2);
		if (res2.toLowerCase().contains("pname=Susie Test".toLowerCase())) System.out.println("sqlUpdate: OK");
		else System.out.println("sqlUpdate: ***FAILED***");
		
		// Delete
		HashMap<String, String> valMap3 = new HashMap<String, String>();
		valMap3.put("pid", "50");
		int res3 = sh.sqlDelete(con, "patient", valMap3);
		if (res3 == 0) System.out.println("sqlDelete: OK");
		else System.out.println("sqlDelete: ***FAILED***");
	}
}
