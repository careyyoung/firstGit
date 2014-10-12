package jdbcDemo;

import java.sql.*; 

public class JdbcDemo {
	private final static String URL = "jdbc:mysql://localhost:3306/test";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "";
	
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	
	
	public static void delete(){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from person where id = 2";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
			
			state.close();
			conn.close();
			
			System.out.println("delete success~");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public static void insert(){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into person(id,name,age,descript) value(2,'young',25,'young is a man')";
			Statement state = conn.createStatement();
			state.executeUpdate(sql);
			state.close();
			conn.close();
			
			System.out.println("insert success~");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	
	public static void querySql(){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select id,name,age from person";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()){
				int id1 = rs.getInt(1);
				System.out.print(id1 + "  ");
				int id2 = rs.getInt("id");
				System.out.print(id2 + "  ");
				System.out.println("success...");
				
			}
			rs.close();
			state.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		querySql();
		delete();
		//
		querySql();
		//
		insert();
		querySql();
	}

}
