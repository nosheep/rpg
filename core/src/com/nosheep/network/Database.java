package com.nosheep.network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.badlogic.gdx.graphics.Color;
import com.nosheep.main.rpgGame;
import com.nosheep.mainMenu.Menu;
import com.nosheep.player.Data;

public class Database {

	private boolean DEVELOPER = false;
	
	@SuppressWarnings("unused")
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://reallypoorgraphics.dlinkddns.com/tenta";
	private final String DEV_URL = "jdbc:mysql://localhost/tenta";
	private final String u = "user";
	private final String p = "44ebb406a54781cad26c76d361cd4f3a5516a5205e640f08c23474a4996535c5";
	
	@SuppressWarnings("unused")
	private Menu menu;
	
	// ACCOUNT //
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> username = new ArrayList<String>();
		ArrayList<String> password = new ArrayList<String>();
	// ACCOUNT END //
	
	public Database(){
		
	}
		
	public Database(Menu menu, String em, String pw){
		this.menu = menu;
		System.out.println(DB_URL);
		
		Connection conn = null;
		   Statement stmt = null;
		   try{
			  rpgGame.font.setColor(Color.CYAN);
			  rpgGame.font.draw(rpgGame.getBatch(), "Connecting...", 500, 300);
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      if(DEVELOPER)
		    	  conn = DriverManager.getConnection(DEV_URL, u, p);
		      else
		    	  conn = DriverManager.getConnection(DB_URL,u,p);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      String sql;
		      sql = "SELECT email, username, password FROM accounts";
		      ResultSet rs = stmt.executeQuery(sql);
	
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         email.add(rs.getString("email"));
		         username.add(rs.getString("username"));
		         password.add(rs.getString("password"));
		         
		         for(int i=0; i<email.size(); i++){
					   if(email.get(i).equals(em) &&
							password.get(i).equals(pw)){
						   	menu.setPlayer(Data.load(username.get(i)));
				   			rpgGame.mainMenu = false;
					   }
				 }
		      }
		    //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }
		   catch(SQLException se){
		      se.printStackTrace();
		      JOptionPane.showMessageDialog(null, "Server offline. Please try again later.", "", 1);
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	public boolean register(String email, char[] password, String username){
		String pw = "";
		for(char c : password)
			pw += c;
		
		System.out.println(pw);
		
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			if(DEVELOPER)
		    	  conn = DriverManager.getConnection(DEV_URL, u, p);
		      else
		    	  conn = DriverManager.getConnection(DB_URL,u,p);
		
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO `accounts`(email,password,username) VALUE ('"+email+"','"+pw+"','"+username+"')";
		      stmt.executeUpdate(sql);
		      
		      conn.close();
		      return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
