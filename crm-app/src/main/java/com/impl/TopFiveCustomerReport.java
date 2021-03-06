package com.impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TopFiveCustomerReport {
	public List fetchingData(){
		
		  //Establish connection to MySQL database
		  String connectionURL = "jdbc:mysql://localhost:3306/insurance";
		  Connection connection= null;
		  ResultSet rs;
		  List dataList= new ArrayList(); 
		  try {

			  // Load the database driver

			   Class.forName("com.mysql.jdbc.Driver");

			   // Get a Connection to the database

			   connection = DriverManager.getConnection(connectionURL, "root", "root"); 

			   //Select the data from the database

			   String sql = "SELECT * FROM customer LIMIT 5";

			   Statement s = connection.createStatement();

			   s.executeQuery (sql);

			   rs = s.getResultSet();

			   while (rs.next ()){

			   //Add records into data list

			   dataList.add(rs.getInt("custId"));
			   dataList.add(rs.getString("cust_name"));
			   dataList.add(rs.getString("surname"));
			   dataList.add(rs.getString("id_number"));
			   dataList.add(rs.getString("Email"));
			   dataList.add(rs.getString("Contact_No"));
			   dataList.add(rs.getString("gender"));
			   
			   
		

			   }

			   rs.close ();

			   s.close ();

			   }catch(Exception e){

			   System.out.println("Exception is ;"+e);

			   }
		return dataList;

	}
}
