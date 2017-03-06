import java.sql.*;
import java.util.Properties;

/*
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
*/

public class Db_operation {
	
	private static String driverName = "com.mysql.jdbc.Driver";
	// private static String DBName = "ksohobh_home"; DB네임 -> ksohobh.net	
	private static String DBName = "kbiz";  // DB네임 -> robin_server
	//String dbURL = "jdbc:mysql://209.236.127.154:3306/" + DBName;
	static int lport;
	static String rhost;
	static int rport;
	
	
	
	public static String sqlscript(String[][] args){
		
		int file_recognition = args[1].length;
		
		System.out.println(file_recognition);
		
		if(file_recognition==10){
			
		}else if(file_recognition==16){
			
		}
		/*
		String prod_name_kr = args[1][0];
		String prod_name_eng = args[1][1];
		String prod_desc_kr = args[1][2];
		String prod_desc_eng = args[1][3];
		String manu_name_kr = args[1][4];
		String manu_name_eng = null;
		String manu_addr_kr = args[1][5];
		String manu_tel = args[1][6];
		String manu_manager = args[1][7];
		String manu_email = args[1][8];
		String manu_homepage = args[1][9];
		String supply_price = args[1][10];
		String retail_price = args[1][11];
		String done_date = args[1][12];
		String stock_amt = args[1][13];
		String manager_name = args[1][14];
		String order_degree = args[1][15];
		*/
		
		
		
		/*
		String [] insert_sql = new String[2];
		insert_sql[0] = "INSERT INTO KBIZ_PRODUCT VALUES (" + null + ", " + "'" + args[1][0] + "', "+ args[1][15] + ", "+ "1" + args[1][10];
		insert_sql[1] = ", "+ args[1][11] + ", '"+ args[1][14] + "', CURRENT_DATE(), 'NATASHIA');";
		String sql_done = insert_sql[0] + insert_sql[1];
		*/
		String sql_done = "none";
		return sql_done;		
	}
	
	/* SSH connection Setup 
	
	*/
	/*
	public static void connectSsh(){
		String user = "root";
		String password = "kbiz238";
		String host = "209.236.127.154";				
		
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 2200);
			
			lport = 3306;
			rhost = "209.236.127.154";
			rport = 3306;
			
			session.setPassword(password);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			
			session.setConfig(config);
			System.out.println("Establishing Connection...");
			
			System.out.println("localhost:" +rhost+":"+rport);
			
			session.connect();			
			session.setPortForwardingL(lport, "209.236.127.154", rport);			
								
			boolean k = session.isConnected();
			
			if (k == false){
				System.out.println("커넥트안됨");
				session.disconnect();
							
			} else {
				System.out.println(k);
			}
			
		}catch(Exception e){
			e.printStackTrace();			
		}
	}
	*/
	
	
	public static void Db_connection(String args){
		//String dbUser = "ksohobh_tester";
		//String dbPassword = "kbizlaoffice";
		String dbUser = "ourcentury";
	    String dbPassword = "eogus0417";
		System.out.println("테스트테스트");
		
	try {		
		
		Class.forName("com.mysql.jdbc.Driver");
		// String dbURL = "jdbc:mysql://localhost:3306/" + DBName;  // SSH사용시
		String dbURL = "jdbc:mysql://162.202.97.156:3306/" + DBName + "?useSSL=false";
		Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword);	
		System.out.println("Mysql DB Connection");
		//String SQL = "Select 1 from dual";		 
		String SQL = args;
		Statement stmt = con.createStatement();
		
		//stmt.executeQuery(SQL);
		
		System.out.println(SQL);
		stmt.executeUpdate(SQL);
		
		//ResultSet result = stmt.executeQuery(SQL);
		
		/*
	     while(result.next())
		{ 
			System.out.print(result.getString(1) +"\t");
			System.out.print(result.getString(1) +"\t");
		}
		*/
		
		con.close();
		System.exit(1);
		
	}catch(Exception e){
		e.printStackTrace();	
		}	
	}
	
	public Db_operation(String[][] args){
		// connectSsh(); SSH 사용시
		String sql_done = sqlscript(args);
		Db_connection(sql_done);
		
	}
	
}
