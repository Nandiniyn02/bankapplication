package com.RashmiBankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class Model {
	String url ="jdbc:oracle:thin:@//localhost:1521/XE";
	//"jdbc:oracle:thin:@//localhost:1521/XE";
	String un ="system";
	String pw = "system";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String name;
	private String username;
	private String custid;
	private String password;
	private String emailid;
	private String balance;
	private int accno;
	private String amount;
	Model()
	{
		try {
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url,un,pw);
		} catch (Exception e) {
			System.out.println("error in connection");
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCustomerid() {
		return custid;
	}
	public String setCustomerid(String customerid) {
		return this.custid = customerid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
		
	}
	boolean login()
	{
		String query="SELECT * FROM BANK_APP WHERE CUSTID=? AND PASSWORD=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, custid);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				name=rs.getString(1);
				accno=rs.getInt(6);
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("error!!");
		}
		return false;
	}
	
	boolean checkBalance()
	{
     	String query="SELECT * FROM BANK_APP WHERE ACCNO=?";	
     	try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, accno);
			rs=pstmt.executeQuery();
			
			while(rs.next()==true)
			{
				balance=rs.getString(5);
				return true;
			}
			
		} catch (Exception e) {
			
			
		}
     	return false;
	}
	
	boolean changepassword()
	{
		try
		{
		String query="UPDATE BANK_APP SET PASSWORD=? WHERE ACCNO=?";
		pstmt=con.prepareStatement(query);
				pstmt.setString(1,password);
				pstmt.setInt(2,accno);
				int temp=pstmt.executeUpdate();
				if(temp==1)
				{
					return true;
				}
				else
				{
					return false;
				}
		
		}
		catch(Exception e)
		{
			
		}
		return false;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	boolean transfer()
	{
		try 
		{
			String query = "UPDATE BANK_APP SET BALANCE=BALANCE-? WHERE ACCNO=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,amount);
			pstmt.setInt(2,accno);
			int m = pstmt.executeUpdate();
			
			if(m==1)
			{
				String s="INSERT INTO BANKSTATEMENT VALUES(?,?)";
				pstmt=con.prepareStatement(s);
				pstmt.setInt(1, accno);
				pstmt.setString(2,amount);
				pstmt.executeUpdate();
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			
		}
		return false;
	}

	ArrayList getStatement()
	{
		ArrayList al = new ArrayList();
		try 
		{
		String s = "SELECT * FROM BANKSTATEMENT WHERE ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setInt(1, accno);
		rs=pstmt.executeQuery();
		while(rs.next()==true)
		{
		al.add(rs.getInt(2));
		}
		}
		catch(Exception e)
		{
	
		}
		return al;
	}
	
	}

