package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;

public class TestCustomer {

	//This is a main Function
	public static void main(String[] args) {
		
		try
		{
			CustomerDAO cd = new CustomerDAO();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Customer ID");
			int id = Integer.parseInt(br.readLine());
			//System.out.println("Enter Customer Name");
			//String name = br.readLine();
			//System.out.println("Enter Customer Age");
			//int age = Integer.parseInt(br.readLine());
			
			//cd.updateCustomer(id, name, age);
			//cd.deleteCustomer(id);
			cd.getCustomer(id);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
