package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	Connection conn;
	public CustomerDAO()
	{
		try {
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/EmployeeDB","sa","sa@123");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getCustomer(int cid)
	{
			ResultSet rs = null;
		try
		{
			String str = "select * from Customer where Cust_id = ?";
			PreparedStatement st = conn.prepareStatement(str);
			st.setInt(1, cid);
			rs = st.executeQuery();
			System.out.println("ID Name	  Age");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);	
				int age = rs.getInt(3);
				System.out.println(id+" "+name+" "+age);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	public void insertCustomer(int id, String name, int age)
	{
		try
		{
		String str = "insert into customer values(?,?,?)";
		PreparedStatement st = conn.prepareStatement(str);
		st.setInt(1, id);
		st.setString(2, name);
		st.setInt(3, age);
		st.executeUpdate();
		System.out.println("Insert Success");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void updateCustomer(int id, String name, int age)
	{
		try
		{
		String str = "update customer set cust_name = ?, cust_age = ? where cust_id = ?";
		PreparedStatement st = conn.prepareStatement(str);
		st.setString(1, name);
		st.setInt(2, age);
		st.setInt(3, id);
		
		st.executeUpdate();
		System.out.println("Update Success");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void deleteCustomer(int id)
	{
		try
		{
		String str = "delete from customer where cust_id = ?";
		PreparedStatement st = conn.prepareStatement(str);
		st.setInt(1, id);
		
		st.executeUpdate();
		System.out.println("Delete Success");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
