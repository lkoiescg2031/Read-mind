package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private static DB instance =null;
	private Connection conn;
	private Statement stmt;	
	
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private String USERNAME = "root";
	private String PASSWORD = "root";
	private String DB_URL = "jdbc:mysql://25.9.254.154:3306/game";
	
	private boolean isconnected;
	private boolean islogined;
	
	public static DB getinstance (){
		if(instance == null)
			instance = new DB();
		return instance;
	}
	public void setDBURL(String IPaddress){
		DB_URL = "jdbc:mysql://"+IPaddress+":3306/game";
	}
	public void connectionDB(){
		isconnected =true;
		try {					
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("DB connection is ok");
			stmt = conn.createStatement();
			System.out.println("Statement is generated");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			isconnected =false;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			isconnected =false;
		}
	}
	public void CloseDB(){
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean login(String id, String pw){
		
		islogined = false;
		
		try{
			if(isconnected){
				String query = new String("SELECT pw FROM member where id='"+id+"'");
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					String password = rs.getString("pw");
					if(pw.equals(password))
						islogined = true;
				}
			}
		}catch(SQLException e){
			System.err.println("로그인 에러");
			e.getStackTrace();
		}
		
		return islogined;
	}	
	public boolean CreateMember(String name, String id, String pw, String age, String sex){
		boolean result = false;
		try{
			String query = new String("SELECT * FROM member where id='"+id+"'");
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) System.out.println("이미 존재하는 ID");
			else{
				String Name = name;			String Id = id;
				String Pw = pw;				String Age = age;
				String Sex = sex;
				query = "INSERT INTO member (name, id, pw, age, sex) values('" +
						Name + "', '" + Id + "', '" + Pw + "', '" + Age + "', '" + Sex + "');";
				stmt.executeUpdate(query);
				result = true;
			}
		}catch(SQLException e){
			e.getStackTrace();
		}
		return result;
	}
	public boolean islogined(){
		return islogined;
	}
	private DB(){
		connectionDB();
	}
	private DB(String IP){
		setDBURL(IP);
		connectionDB();
	}
}
