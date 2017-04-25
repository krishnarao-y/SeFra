package com.wd.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DDT_DataBase extends DDT_Excel{
	
	DDT_DataBase(WebDriver d) {
		super(d);
	}
	
	public void readDataBase() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String conString = "jdbc:mysql://localhost:3306/mttours";
		String mysqlDriver = "com.mysql.jdbc.Driver";
		
		Class.forName(mysqlDriver).newInstance();
		Connection con = DriverManager.getConnection(conString, "root", "root");
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();
		//stmt.execute("INSERT INTO `mtlogin`(`Username`, `Password`, `Result`) VALUES ('krishna','krishna','')");
		ResultSet records = stmt.executeQuery("SELECT * FROM `mtlogin` WHERE 1");
		while(records.next()){
			String username = records.getString("Username");
			String password = records.getString("Password");
			login(username, password);
			stmt1.execute("UPDATE `mtlogin` SET `Result`= '" + result + "' Where Username= '" + username + "' and Password= '" + password +"'");
			System.out.println(username + " -- " + password + " -->" + result);
		}
		
		stmt.close();
		con.close();
		
	}

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		DDT_DataBase db = new DDT_DataBase(driver);
		db.openApplication("http://newtours.demoaut.com/");
		try {
			db.readDataBase();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}