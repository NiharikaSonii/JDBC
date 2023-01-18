package com.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class AccountDAL {
	private static final int AccId = 0;

	public static boolean insertAccountToDB(Account ac) throws SQLException  {
		boolean f=false;
		try {
			
			Connection con = DBUtil.createConnection();
			String query = "insert into Account(id,name,type,balance) values(?,?,?,?)";
			
			//prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//set the value of parameters
			pstmt.setInt(1, ac.getId());
			pstmt.setString(2, ac.getName());
			pstmt.setString(3, ac.getType());
			pstmt.setDouble(4, ac.getBalance());
			
			//execute
			pstmt.executeUpdate();
			f=true;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteAccount(int accId) throws SQLException {
		
		boolean f=false;
		try {
			
			Connection con = DBUtil.createConnection();
			String query = "delete from Account where id=?";
			
			//prepared Statement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//set the value of parameters
			pstmt.setInt(1,accId);
			
			//execute
			pstmt.executeUpdate();
			f=true;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return f;
	}

	public static void showAccountDetails() throws SQLException {
		
		try {
			
			Connection con = DBUtil.createConnection();
			String query = "select * from Account";
			
			Statement stmt=con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String type=set.getString(3);
				double balance=set.getDouble(4);
				
				System.out.println("ID:"+id);
				System.out.println("Name:"+name);
				System.out.println("Type:"+type);
				System.out.println("Balance:"+balance);
				System.out.println("--------------------");
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
