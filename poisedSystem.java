

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class poisedSystem extends projectDetails {


	public static void main(String[] args) {
		
		System.out.println("Welcome to the Poised Management System \n");
		
			do {
				//System.in is a standard input stream 
				Scanner in = new Scanner(System.in);
					
				// Try catch block to check if the user inputs an integer
				try {
					System.out.print("\nWould you like to edit details or create a new project, Please select from below:\n"
						+ "\n1 - To create a new project\n"
						+ "2 - To amend project due date\n"
						+ "3 - To amend the amount paid\n"
						+ "4 - To see over due projects\n"
						+ "5 - To Finalise a project\n"
						+ "6 - To find a project\n"
						+ "7 - To view existing projects\n"
						+ "8 - Add Architect information\n"
						+ "0 - To Exit\n"
						+ ": ");
	
					String userChoice = in.nextLine();
		   			
					if (userChoice.equals("1")) {
		   			
						// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
				        // Use username "root", password "password".
				        Connection connection = DriverManager.getConnection(
				                "jdbc:mysql://localhost:3306/poisepms",
				                "root",
				                "password"
				                );
						
				        // Create a direct line to the database for running our queries
				        Statement statement = connection.createStatement();
				        ResultSet results;
				        int rowsAffected;
				        // executeQuery: runs a SELECT statement and returns the results.
				        results = statement.executeQuery("SELECT * FROM projects");
				        
						
						Scanner sc = new Scanner(System.in);
						
						System.out.println("\nPlease enter the project number: ");
						String a1 = sc.nextLine();
						
						System.out.println("Please enter the project name: ");
						String b1 = sc.nextLine();

						System.out.println("Please enter the building type: ");
						String c1 = sc.nextLine();
						
						System.out.println("Please enter the physical address for the project: ");
						String d1 = sc.nextLine();
						
						System.out.println("Please enter the ERF number: ");
						String e1 = sc.nextLine();
					
						System.out.println("Please enter the total fee charged for the project(eg. 50000.0): ");
						String f1 = sc.nextLine();
						
						System.out.println("Please enter the total amount paid to date(eg. 20000.0): ");
						String g1 = sc.nextLine();
						
						System.out.println("Please enter the project deadline (e.g. year, month, day: YY-MM-DD): ");
						String h1 = sc.nextLine();
						
						String i1 = "Not Completed";  
						String j1 = "Not finalised";
							
			    		// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
				        // Use username "root", password "password".
				        Connection connection1 = DriverManager.getConnection(
				                "jdbc:mysql://localhost:3306/poisepms",
				                "root",
				                "password"
				                );
						
				        // Create a direct line to the database for running our queries
				        Statement statement1 = connection1.createStatement();
				        ResultSet results1;
				        int rowsAffected1;
				        // executeQuery: runs a SELECT statement and returns the results.
				        results = statement.executeQuery("SELECT * FROM customers");
					
						Scanner ci = new Scanner(System.in);
						
						System.out.println("\nPlease add Clients's information below:");
						
						System.out.print("\nEnter Name: "); 
						String a2 = ci.nextLine();
						
						
						System.out.print("Enter Surname: "); 
						String b2 = ci.nextLine();
						
						// If statement to catch the Project name being left blank
						if (b1 == "") {
							b1 = c1 + " " + b2;
						}
					
						System.out.print("Enter Phone Number: ");
						String c2 = ci.nextLine();
						
						System.out.print("Email Address: "); 
						String d2 = ci.nextLine();
						
						System.out.print("Physical Address: ");
						String e2 = ci.nextLine();
						
						
						// String variable that holds the SQL command
						// Adds the inputed variables into the customers database
						String insertProjects = "INSERT INTO projects VALUES (" + a1 + ", " + "'" + b1 + "'" +  ", " + "'" + c1 + "'" + ", " + "'" + d1 + "'" + ", " 
						+ "'" + e1 + "'" + ", " + f1 + ", " + g1 + ", " + "'" + h1 + "'" + ", " + "'" + i1 + "'" + ", " + "'" + j1 + "');";
						//Call the SQL command variable to the .executeUpdate method
						statement.executeUpdate(insertProjects);
					
			
						// String variable that holds the SQL command 
						// Adds the inputed variables into the customers database
						String insertCustomers = "INSERT INTO customers VALUES (" + a1 + ", " + "'" + a2 + "'" +  ", " + "'" + b2 + "'" + ", " + "'" + c2 + "'" + ", " 
						+ "'" + d2 + "'" + ", " +  "'" + e2 + "');";
						//Call the SQL command variable to the .executeUpdate method
						statement.executeUpdate(insertCustomers);
						
						System.out.println("\nNew Project and Customer added!");
 
		   				}
		   			
		   			else if (userChoice.equals("2")) {
		   				
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
		   		        // Use username "root", password "password".
		   		        Connection connection = DriverManager.getConnection(
		   		                "jdbc:mysql://localhost:3306/poisepms",
		   		                "root",
		   		                "password"
		   		                );
		   				
		   		        // Create a direct line to the database for running our queries
		   		        Statement statement = connection.createStatement();
		   		        ResultSet results;
		   		        int rowsAffected;
		   		        // executeQuery: runs a SELECT statement and returns the results.
		   		        results = statement.executeQuery("SELECT * FROM projects");
		   		        
		   		        
		   				Scanner sc2 = new Scanner(System.in);
		   				System.out.print("Enter project number you would like to update: ");
		   				String a2 = sc2.nextLine();
		   				
		   				System.out.print("Enter new deadline date (e.g. year, month, day: YY-MM-DD): "); 
		   				String b2 = sc2.nextLine();
		   				
		   				// Change the 'Deadline' in database:
		   				  // String variable that holds the SQL command 
		   			      String updateDeadline = "UPDATE projects SET DEADLINE = "+ "'" +b2+ "'"
		   			    		  +" WHERE PROJ_NUM ="+a2+";";
		   				  statement.executeUpdate(updateDeadline);
		   				
		   			      System.out.println("\nProject Deadline updated!");
		   				 // executeQuery: runs a SELECT statement and returns the results.
		   			     results = statement.executeQuery("SELECT * FROM projects");
		   				
		   			}
		   			
		   			else if (userChoice.equals("3")) {
		   				
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
		   		        // Use username "root", password "password".
		   		        Connection connection = DriverManager.getConnection(
		   		                "jdbc:mysql://localhost:3306/poisepms",
		   		                "root",
		   		                "password"
		   		                );
		   				
		   		        // Create a direct line to the database for running our queries
		   		        Statement statement = connection.createStatement();
		   		        ResultSet results;
		   		        int rowsAffected;
		   		        // executeQuery: runs a SELECT statement and returns the results.
		   		        results = statement.executeQuery("SELECT * FROM projects");
		   		        
		   				Scanner sc2 = new Scanner(System.in);
		   				System.out.print("Enter project number you would like to update: ");
		   				String a2 = sc2.nextLine();
		   				
		   				System.out.print("Enter new total amount paid(eg. 20000.0): "); 
		   				String b2 = sc2.nextLine();
		   				
		   			      // Change the 'Amount_Paid' in database:
		   				  // String variable that holds the SQL command 
		   			      String updateAmount = "UPDATE projects SET AMOUNT_PAID = "+ "'" +b2+ "'"
		   			    		  +" WHERE PROJ_NUM ="+a2+";";
		   				  statement.executeUpdate(updateAmount);
		   				
		   			      System.out.println("\nProject payment updated!");
		   				 // executeQuery: runs a SELECT statement and returns the results.
		   			     results = statement.executeQuery("SELECT * FROM projects");
		   				
		   			}
		   			
		   			else if (userChoice.equals("4")) {
		   				
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
			            // Use username "root", password "password".
			            Connection connection = DriverManager.getConnection(
			                    "jdbc:mysql://localhost:3306/poisepms",
			                    "root",
			                    "password"
			                    );
			    		
			            // Create a direct line to the database for running our queries
			            Statement statement = connection.createStatement();
			            ResultSet results;
			            int rowsAffected;
			            // executeQuery: runs a SELECT statement and returns the results.
			            results = statement.executeQuery("SELECT * FROM projects WHERE DEADLINE < curdate();");
			            while (results.next()) {
			            	System.out.println(
			                        results.getInt("PROJ_NUM") + ", "
			                        + results.getString("PROJ_NAME") + ", "
			                        + results.getString("BUILDING_TYPE") + ", " 
			                        + results.getString("PHYS_ADDRESS") + ", " 
			                        + results.getString("ERF_NUM") + ", " 
			                        + results.getDouble("TOTAL_FEE") + ", " 
			                        + results.getDouble("AMOUNT_PAID") + ", " 
			                        + results.getString("DEADLINE") + ", " 
			                        + results.getString("COMPLETION") + ", "
			                        + results.getString("STATUS") + ", "
			                		);
			            }
		   			}
		   			
		   			else if (userChoice.equals("5")) {
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
		   				// Use username "root", password "password".
		   				Connection connection = DriverManager.getConnection(
		   				        "jdbc:mysql://localhost:3306/poisepms",
		   				        "root",
		   				        "password"
		   				        );
		   			
		   				// Create a direct line to the database for running our queries
		   				Statement statement = connection.createStatement();
		   				ResultSet results;
		   				int rowsAffected;
		   				// executeQuery: runs a SELECT statement and returns the results.
		   				results = statement.executeQuery("SELECT * FROM projects");
		   				// Loop over the results, printing them all.
		   				while (results.next()) {
		   					System.out.println(
		   		                    results.getInt("PROJ_NUM") + ", "
		   		                    + results.getString("PROJ_NAME") + ", "
		   		                    + results.getString("BUILDING_TYPE") + ", " 
		   		                    + results.getString("PHYS_ADDRESS") + ", " 
		   		                    + results.getString("ERF_NUM") + ", " 
		   		                    + results.getDouble("TOTAL_FEE") + ", " 
		   		                    + results.getDouble("AMOUNT_PAID") + ", " 
		   		                    + results.getString("DEADLINE") + ", " 
		   		                    + results.getString("COMPLETION") + ", "
		   		                    + results.getString("STATUS") + ", "
		   		            		);
		   				}
		   					
		   				Scanner ps1 = new Scanner(System.in);
		   				System.out.print("\nEnter projects number you would like to finalise: ");
		   				String x = ps1.nextLine();	
		   				
		   				int totalFee = 0;
		   				int amountPaid = 0;
		   				
		   				// String variable that holds the SQL command and cast to the .executeQuery method
		   				// This allows for the row called from table to be printed
		   				results = statement.executeQuery("SELECT * FROM projects WHERE PROJ_NUM IN ('"+x+"');");
		   			      // Loop over the results, printing them all.
		   			      while (results.next()) {
		   			    	  totalFee = results.getInt("TOTAL_FEE");
		   			    	  amountPaid = results.getInt("AMOUNT_PAID");
		   			    	  System.out.println(results.getInt("PROJ_NUM")+", "+results.getString("PROJ_NAME")+", "+results.getString("BUILDING_TYPE")+", "+results.getString("PHYS_ADDRESS")+", "+results.getString("ERF_NUM")+", "+results.getInt("TOTAL_FEE")+", "+results.getInt("AMOUNT_PAID")+", "+results.getString("DEADLINE")
		   						+", "+results.getString("COMPLETION")+", "+results.getString("STATUS"));
		   			    	  
		   			      }
		   			    int amountOwed = totalFee - amountPaid;
		   		  		String f = "Finalised";
		   		  		
		   				  
		   				 if (totalFee == amountPaid) {
		   					 
		   					 	System.out.println("\n===============================================================");
		   						System.out.println("\nThe project has been paid in full. No invoice generated.");
		   						System.out.println("\n===============================================================");
		   						System.out.print("\nPlease add a completion date for this project (e.g. year, month, day: YY-MM-DD): ");
		   				  		String y = ps1.nextLine();	  		
		   						
		   				  		// String variable that holds the SQL command 
		   				  		// Updates the project with 'Completion' and the 'Status' values in the database based on the input project number 
		   				  		String updateCompletion = "UPDATE projects SET COMPLETION = "+ "'" +y+ "'"
		   				    		  +" WHERE PROJ_NUM ="+x+";";
		   				  		statement.executeUpdate(updateCompletion);
		   				  		
		   				  		String updateStatus = "UPDATE projects SET STATUS = "+ "'" +f+ "'"
		   					    		  +" WHERE PROJ_NUM ="+x+";";
		   					    statement.executeUpdate(updateStatus);
		   				
		   				 }else  {
		   					 
		   					 	System.out.print("\nPlease add a completion date for this project (e.g. year, month, day: YY-MM-DD): ");
		   				  		String y = ps1.nextLine();
		   				  		
		   				  		// String variable that holds the SQL command 
		   				  		// Updates the project with 'Completion' and the 'Status' values in the database based on the input project number
		   				  		String updateCompletion = "UPDATE projects SET COMPLETION = "+ "'" +y+ "'"
		   				    		  +" WHERE PROJ_NUM ="+x+";";
		   				  		statement.executeUpdate(updateCompletion);
		   				  	 
		   				  		String updateStatus = "UPDATE projects SET STATUS = "+ "'" +f+ "'"
		   					    		  +" WHERE PROJ_NUM ="+x+";";
		   					    statement.executeUpdate(updateStatus);
		   					    System.out.println("\nProject Finalised!:");
		   					    
		   				  		
		   				  		
		   					    System.out.println("\nPlease view your invoice details below: ");
		   						System.out.println("\n===============================================================");
		   						System.out.println("\n                          INVOICE                              ");
		   						System.out.println("\n===============================================================");
		   						System.out.println("                  Finalised Project Details:"); 
		   					
		   						System.out.println("\n");
		   						results = statement.executeQuery("SELECT * FROM projects WHERE PROJ_NUM IN ('"+x+"');");
		   						
		   					      // Loop over the results, printing them all.
		   					      while (results.next()) {
		   					    	  System.out.println(results.getInt("PROJ_NUM")+", "+results.getString("PROJ_NAME")+", "+results.getString("BUILDING_TYPE")+", "+results.getString("PHYS_ADDRESS")+", "+results.getString("ERF_NUM")+", "+results.getInt("TOTAL_FEE")+", "+results.getInt("AMOUNT_PAID")+", "+results.getString("DEADLINE")
		   								+", "+results.getString("COMPLETION")+", "+results.getString("STATUS"));
		   					    	  
		   					    
		   				    	  results = statement.executeQuery("SELECT * FROM customers WHERE PROJ_NUM IN ('"+x+"');");
		   				    	  System.out.println("\nCustomers details below:");
		   					      // Loop over the results, printing them all.
		   					      while (results.next()) {
		   					    	  System.out.println(results.getInt("PROJ_NUM")+", "+results.getString("CUSTOMER_NAME")+", "+results.getString("CUSTOMER_SURNAME")+", "+results.getString("PHONE_NUM")+", "+results.getString("EMAIL")+", "+results.getString("PHYSICAL_ADDRESS"));
		   					   
		   					    System.out.println("--------------------------------------------------");
		   					    System.out.println("Amount still owed is R" + amountOwed);
		   					    System.out.println("--------------------------------------------------");
		   					      
		   					      }  
		   					  }
		   				 }
		   			}
		   			
		   			else if (userChoice.equals("6")) {
		   				
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
		   				// Use username "root", password "password".
		   				Connection connection = DriverManager.getConnection(
		   				        "jdbc:mysql://localhost:3306/poisepms",
		   				        "root",
		   				        "password"
		   				        );
		   			
		   				// Create a direct line to the database for running our queries
		   				Statement statement = connection.createStatement();
		   				ResultSet results;
		   				int rowsAffected;
		   				// executeQuery: runs a SELECT statement and returns the results.
		   				results = statement.executeQuery("SELECT * FROM projects");
		   				// Loop over the results, printing them all.
		   				while (results.next()) {
		   					
		   				Scanner ps = new Scanner(System.in);
		   				System.out.print("\nPlease choose project name or number to search:\n"
		   						+ "\n1 - Project number\n"
		   						+ "2 - Project name\n"
		   						+ ": ");

		   				String projectSearch = ps.nextLine();
		   				
		   	   			if (projectSearch.equals("1")) {
		   	   				
		   	   				Scanner ps1 = new Scanner(System.in);
		   	   				System.out.print("Enter projects number you would like to find: ");
		   	   				String x = ps1.nextLine();	
		   	   				
		   	   				// String variable that holds the SQL command and cast to the .executeQuery method
		   	   				// This allows for the row called from table to be printed
		   	   				results = statement.executeQuery("SELECT * FROM projects WHERE PROJ_NUM IN ('"+x+"');");
		   	   			      // Loop over the results, printing them all.
		   	   			      while (results.next()) {
		   	   			    	  System.out.println(results.getInt("PROJ_NUM")+", "+results.getString("PROJ_NAME")+", "+results.getString("BUILDING_TYPE")+", "+results.getString("PHYS_ADDRESS")+", "+results.getString("ERF_NUM")+", "+results.getInt("TOTAL_FEE")+", "+results.getInt("AMOUNT_PAID")+", "+results.getString("DEADLINE")
		   	   						+", "+results.getString("COMPLETION")+", "+results.getString("STATUS"));
		   	   			    	  
		   	   			      }
		   	   			}else {
		   		   				Scanner ps2 = new Scanner(System.in);
		   		   				System.out.print("Enter projects name you would like to find: ");
		   		   				String y = ps2.nextLine();	
		   		   				
		   		   				// String variable that holds the SQL command and cast to the .executeQuery method
		   		   				// This allows for the row called from table to be printed
		   		   				results = statement.executeQuery("SELECT * FROM projects WHERE PROJ_NAME IN ('"+y+"');");
		   		   			      // Loop over the results, printing them all.
		   		   			      while (results.next()) {
		   		   			    	  System.out.println(results.getInt("PROJ_NUM")+", "+results.getString("PROJ_NAME")+", "+results.getString("BUILDING_TYPE")+", "+results.getString("PHYS_ADDRESS")+", "+results.getString("ERF_NUM")+", "+results.getInt("TOTAL_FEE")+", "+results.getInt("AMOUNT_PAID")+", "+results.getString("DEADLINE")
		   		   						+", "+results.getString("COMPLETION")+", "+results.getString("STATUS"));
		   		   			      }
		   	   			}
		   		}
	}
		   			
		   			else if (userChoice.equals("7")) {
		   				
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
		   		        // Use username "root", password "password".
		   		        Connection connection = DriverManager.getConnection(
		   		                "jdbc:mysql://localhost:3306/poisepms",
		   		                "root",
		   		                "password"
		   		                );
		   				
		   		        // Create a direct line to the database for running our queries
		   		        Statement statement = connection.createStatement();
		   		        ResultSet results;
		   		        int rowsAffected;
		   		        // executeQuery: runs a SELECT statement and returns the results.
		   		        results = statement.executeQuery(" SELECT * FROM projects WHERE STATUS IN ('Not finalised');");
		   		     System.out.println("\nCurrent Projects:");
		   		        while (results.next()) {
		   		        	System.out.println(
		   		                    results.getInt("PROJ_NUM") + ", "
		   		                    + results.getString("PROJ_NAME") + ", "
		   		                    + results.getString("BUILDING_TYPE") + ", " 
		   		                    + results.getString("PHYS_ADDRESS") + ", " 
		   		                    + results.getString("ERF_NUM") + ", " 
		   		                    + results.getDouble("TOTAL_FEE") + ", " 
		   		                    + results.getDouble("AMOUNT_PAID") + ", " 
		   		                    + results.getString("DEADLINE") + ", " 
		   		                    + results.getString("COMPLETION") + ", "
		   		                    + results.getString("STATUS") + ", "
		   		            		);
		   		        }
		   			}
		   			
		   			else if (userChoice.equals("8")) {
		   				
		   			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
			            // Use username "root", password "password".
			            Connection connection1 = DriverManager.getConnection(
			                    "jdbc:mysql://localhost:3306/poisepms",
			                    "root",
			                    "password"
			                    );
			    		
			            // Create a direct line to the database for running our queries
			            Statement statement = connection1.createStatement();
			            ResultSet results;
			            int rowsAffected1;
			            // executeQuery: runs a SELECT statement and returns the results.
			            results = statement.executeQuery("SELECT * FROM architects");
			            
			            System.out.println("\nPlease add Architects information below:");
			    	
			    		Scanner ai = new Scanner(System.in);
			    		
			    		System.out.println("\nEnter the project number the Architect will be working on : ");
			    		String a1 = ai.nextLine();
			    		
			    		System.out.print("\nEnter Name: "); 
			    		String a3 = ai.nextLine();
			    		
			    		System.out.print("Enter Surname: "); 
			    		String b3 = ai.nextLine();
			    		
			    		System.out.print("Enter Phone Number: ");
			    		String c3 = ai.nextLine();
			    		
			    		System.out.print("Email Address: "); 
			    		String d3 = ai.nextLine();
			    		
			    		System.out.print("Physical Address: ");
			    		String e3 = ai.nextLine();
			    		
			    		// String variable that holds the SQL command 
			    			String insertArchitects = "INSERT INTO architects VALUES (" + a1 + ", " + "'" + a3 + "'" +  ", " + "'" + b3 + "'" + ", " + "'" + c3 + "'" + ", " 
			    			+ "'" + d3 + "'" + ", " +  "'" + e3 + "');";
			    			//Call the SQL command variable to the .executeUpdate method
			    			statement.executeUpdate(insertArchitects);
			    			
			    			System.out.println("\nNew Architect added!");
			    			
		   			}		
		   			
		   			else if (userChoice.equals("0")) {
		   				
					    System.out.println("You have logged out!");

					}
			
		   		} catch (SQLException e) {
		          e.printStackTrace();
		     }
			}while (true);
	}
}
//https://popsql.com/learn-sql/mysql/how-to-query-date-and-time-in-mysql
       
