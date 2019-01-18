package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class ConnectAndQuery {
	public static void main(String args[]) {
		try {
			// 1.connect database
			Class.forName(DBConnectionUtil.DBDRIVER).newInstance();
			Connection con = DBConnectionUtil.getConnection();
			if(con!=null){
				System.out.println("Connect database successfully!");
			}
			// 2.query code
			PreparedStatement ps = con
					.prepareStatement("select * from DOCTOR where name='Christina Chan'");
			//ps.setString(1, "Christina Chan");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				System.out.println("ID: "+rs.getInt(1)+" SPECIALTY: "+rs.getString(2)+" ADDRESS: "+rs.getString(3)+" NAME: "+rs.getString(4));
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
