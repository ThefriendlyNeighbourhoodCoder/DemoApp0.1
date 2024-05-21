package com.userDetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.bean.User;
import com.userDetails.dao.userDao;

public class userDao {
	private Connection con;
	
	public userDao(Connection con) {
		super();
		this.con=con;
	}
	
	public static int save(User u) {
		
		int status = 0;
		
		try {
			
			Connection con = DbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into userDetails(id,uname,upwd,uemail,umobile,role) values(?,?,?,?,?,?)");
			
			ps.setString(1, u.getId());
			ps.setString(2, u.getUname());
			ps.setString(3, u.getUpwd());
			ps.setString(4, u.getUemail());
			ps.setString(5, u.getUmobile());
			ps.setString(6, u.getRole());

			
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
		
		
	}
	
	public static List<User> getAllUser(){
		
		List<User> list = new ArrayList<User>();
		
		try {
			Connection con = DbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from userDetails");
			ResultSet rs = ps.executeQuery();
			User u = null;
			while (rs.next()) {
				 u = new User();
				 u.setId(rs.getString(1));
				 u.setUname(rs.getString(2));
				 u.setUpwd(rs.getString(3));
				 u.setUemail(rs.getString(4));
				 u.setUmobile(rs.getString(5));
				 u.setRole(rs.getString(6));
				 list.add(u);
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	
	
public static User getUserById(int id) {
		
		User u = new User();
		
		try {
			Connection con = DbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from userDetails where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				 u = new User();
				 u.setId(rs.getString(1));
				 u.setUname(rs.getString(2));
				 u.setUpwd(rs.getString(3));
				 u.setUemail(rs.getString(4));
				 u.setUmobile(rs.getString(5));
				 u.setRole(rs.getString(6));
				 
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return u;
		
		
	}


public static int update(User u) {
	
int status = 0;
	
	try {
		Connection con = DbConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("update userDetails set uname=?, uemail=?, umobile=?, role=? where id=?");
		ps.setString(1, u.getUname());
		ps.setString(2, u.getUemail());
		ps.setString(3, u.getUmobile());
		ps.setString(4, u.getRole());
		ps.setString(5, u.getId());
		
		status = ps.executeUpdate();
	
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return status;
	
	
}

public static int delete(int id){
	
int status = 0;
	
	try {
		Connection con = DbConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from userDetails where id=?");
		ps.setInt(1, id);
		
		status = ps.executeUpdate();
	
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return status;
	
	
}
}
