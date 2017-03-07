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
		
		if(file_recognition==10){                  // FILE RECOGNITION이 10일때 회사정보 INSERT AND UPDATE
			String manu_name_kr = args[1][0];      // 한글회사명
			String manu_name_eng = args[1][1];     // 영문회사명
		    String manu_regist_no = args[1][2];    // 사업자번호
		    String manu_pres_name = args[1][3];    // 대표자 이름
		    String manu_manager = args[1][4];      // 담당자 이름
		    String manu_tel = args[1][5];          // 전화번호
		    String manu_email = args[1][6];        // 이메일주소
		    String manu_homepage = args[1][7];     // 홈페이지 주소
		    String manu_addr_kr = args[1][8];      // 회사 주소(한글)
		    String manu_addr_eng = args[1][9];     // 회사 주소(영문)
		}else if(file_recognition==11){			   // FILE RECOGNITION이 11일때 제품정보 INSERT AND UPDATE
			String manu_name_kr = args[1][0];      // 한글회사명
			String prod_name_kr = args[1][1];      // 상품명(한글)
			String prod_name_eng = args[1][2];     // 상품명(영문)
			String prod_desc_kr = args[1][3];      // 제품명(한글)
			String prod_desc_eng = args[1][4];     // 제품명(영문)
			String supply_price = args[1][5];      // 공급가액
			String retail_price = args[1][6];      // 소매가액
			String entry_date = args[1][7];        // 입력일
			String stock_amt = args[1][8];         // stock 개수
			String manager_name = args[1][9];      // 관리자 아이디
			String order_degree = args[1][10];     // 오더차수			
		}
		
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
	
	
	public static void Db_connection(String args, String[][] arg1){
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
		//stmt.executeUpdate(SQL); update문 잠시 정지
		
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
		Db_connection(sql_done, args);
		
	}
	
}

class Db_sql_operation {
	
	public  CallableStatement db_insert_update(Connection con, String[][] args){          // db 인서트와 업데이트를 하는 구문
	    
		
		int file_recognition = args[1].length;
		CallableStatement cstmt = null;
		
		
		try {			
			if(file_recognition==10){                  // FILE RECOGNITION이 10일때 Company_info INSERT AND UPDATE
				String manu_name_kr = args[1][0];      // 한글회사명
				String manu_name_eng = args[1][1];     // 영문회사명
				String manu_regist_no = args[1][2];    // 사업자번호
				String manu_pres_name = args[1][3];    // 대표자 이름
				String manu_manager = args[1][4];      // 담당자 이름
				String manu_tel = args[1][5];          // 전화번호
				String manu_email = args[1][6];        // 이메일주소
				String manu_homepage = args[1][7];     // 홈페이지 주소
				String manu_addr_kr = args[1][8];      // 회사 주소(한글)
				String manu_addr_eng = args[1][9];     // 회사 주소(영문)
				
				cstmt = con.prepareCall("{Call insert_comp_info_temp(?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString(1,manu_name_kr);
				cstmt.setString(2, manu_name_eng);
				cstmt.setString(3, manu_regist_no);
				cstmt.setString(4, manu_pres_name);
				cstmt.setString(5, manu_manager);
				cstmt.setString(6, manu_tel);
				cstmt.setString(7, manu_email);
				cstmt.setString(8, manu_homepage);
				cstmt.setString(9, manu_addr_kr);
				cstmt.setString(10, manu_addr_eng);		
				
			}else if(file_recognition==11){			   // FILE RECOGNITION이 11일때 제품정보 INSERT AND UPDATE
				String manu_name_kr = args[1][0];      // 한글회사명
				String prod_name_kr = args[1][1];      // 상품명(한글)
				String prod_name_eng = args[1][2];     // 상품명(영문)
				String prod_desc_kr = args[1][3];      // 제품명(한글)
				String prod_desc_eng = args[1][4];     // 제품명(영문)
				double supply_price = Double.parseDouble(args[1][5]);      // 공급가액
				double retail_price = Double.parseDouble(args[1][6]);      // 소매가액
				String entry_date = args[1][7];        // 입력일
				int stock_amt = Integer.parseInt(args[1][8]);         // stock 개수
				String manager_name = args[1][9];      // 관리자 아이디
				int order_degree = Integer.parseInt(args[1][10]);     // 오더차수
				
				cstmt = con.prepareCall("{Call insert_product_info_temp(?,?,?,?,?,?,?,STR_TO_DATE(?,'%m/%d/%Y'),?,?,?)}");
				cstmt.setString(1,manu_name_kr);
				cstmt.setString(2, prod_name_kr);
				cstmt.setString(3, prod_name_eng);
				cstmt.setString(4, prod_desc_kr);
				cstmt.setString(5, prod_desc_eng);
				cstmt.setDouble(6, supply_price);;
				cstmt.setDouble(7, retail_price);
				cstmt.setString(8, entry_date);
				cstmt.setInt(9, stock_amt);
				cstmt.setString(10, manager_name);
				cstmt.setInt(11, order_degree);
			}		
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		return cstmt;
		
	}
}
