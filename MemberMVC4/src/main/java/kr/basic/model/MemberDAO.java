package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private MemberDAO() {}
	
	static private MemberDAO instance;
	static public MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	private Connection conn; // db 객체
	private PreparedStatement ps; // 쿼리문 객체 
	private ResultSet rs; // 뷰테이블 객체 
	
    // 데이터베이스 연동하기 => connection 객체 생성 
   private void getConnect() {
       String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
       String user ="root";
       String password="1234";
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(url, user, password);
//           System.out.println(conn);
       }catch(SQLException e){
           e.printStackTrace();
           System.out.println("연동실패");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           System.out.println("driver 클래스 찾지 못함 ");
       }
   }
    
    
	
	public ArrayList<Member> getMemberList(){
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from member";
		try {
			getConnect();
			ps = conn.prepareStatement(sql); // string 값을 sql 명령문으로 만드는 객체
			rs = ps.executeQuery(); // 명령문을 실행 후 뷰테이블을 담은 객체
			
			// rs.next() 테이블에 레코드(row) 가 있다면 true : 한줄씩 체크한다 
			// 몇줄 있는지 모르니깐 while 담기 
			while(rs.next()) {
				int num =rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				Member m = new Member(num,id,pass,name,age,email,phone);
				list.add(m);
//				System.out.println(m);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("에러 ");
		}finally {
			dbClose();
		}
		
		return list;
	}
	
	
	public int checkLogin(String id , String pass) {
		String sql = "select * from member where id =? and pass= ?";
		int num = 0;
		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				num =  rs.getInt("num");
			}
			
			return num;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return 0;
		
	}
	
	public Member getMemberByNum(int num ) {
		ArrayList<Member> list = getMemberList();
		for(Member m : list) {
			if(m.getNum() == num) {
				return m;
			}
		}
		return null;
	}
	

	public int addOneMember(Member member) {
		String sql = "insert into member values(null,?,?,?,?,?,?)";
		int row = 0;
		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPass());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getEmail());
			ps.setString(6, member.getPhone());
			row=ps.executeUpdate(); // 삽입한 row 갯수를 리턴 
			System.out.println(" 회원 추가 완료 = " + row);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("회원 추가 실패");
		}finally{
			dbClose();
		}
		return row;
	}
	
	public int deleteOneMember(int num ) {
	  String sql="delete from member where num = ?";
	  int cnt =0;
	  try {
		  getConnect();
		  ps = conn.prepareStatement(sql);
		  ps.setInt(1, num);
		  cnt = ps.executeUpdate();
		  
		  if(cnt >0) {
			  System.out.println("회원 삭제 성공");
		  }else {
			  System.out.println("회원 삭제 실패");
		  }
		  
	  }catch(SQLException e) {
			
		}finally{
			dbClose();
		}
	  return cnt;
	}
	
    public int updateOneMember(int num, int age, String email, String phone) {
    	  String sql = "update member set age=? , email=?, phone=? where num = ?";
    	  int cnt = 0;
    	  try {
    		  getConnect();
    		  ps = conn.prepareStatement(sql);
    		  ps.setInt(1, age);
    		  ps.setString(2,email);
    		  ps.setString(3,phone);
    		  ps.setInt(4, num);
    		  cnt = ps.executeUpdate();
    		  
    		  if(cnt >0) {
    			  System.out.println("회원 수정 성공");
    		  }else {
    			  System.out.println("회원 수정 실패");
    		  }
    		  
    	  }catch(SQLException e) {
    			
    		}finally{
    			dbClose();
    		}
    	return cnt;
    }
	
	// 데이터베이스 연결 끊기
	private void dbClose() {
		  try { 
		   if(rs!=null) rs.close();
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
	}   
	
	
}
