import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
//scanner package

class Project {
	private static int id;
	Scanner scanner = new Scanner(System.in);
	String firstname;
	String lastname;
	int age;
	String mobileno;
	String Email;

	public void Project(String firstname, String lastname, int age, String mobileno, String Email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.mobileno = mobileno;
		this.Email = Email;
	}

	public void customerInfo() throws Exception {
		// Customer method for input
		
		System.out.println("Enter user firstname: ");
		String firstname = scanner.next();

		System.out.println("Enter user lastname: ");
		String lastname = scanner.next();

		System.out.println("Enter user age: ");
		int age = scanner.nextInt();

		System.out.println("Enter user mobile number: ");
		String mobileno = scanner.next();
		if (mobileno.length() < 10) {
			System.out.println("Should be 10 digit");
		} else {

			System.out.println("Enter user Email: ");
			String Email = scanner.next();
			scanner.nextLine();

			System.out.println("Enter user Resident: ");
			String Resident = scanner.next();
			//

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

			String s = "insert into customer_info(firstname,lastname,age,mobile_no,email,resident) values	('"
					+ firstname + "','" + lastname + "','" + age + "','" + mobileno + "','" + Email + "','" + Resident
					+ "')";

			PreparedStatement psmt = conn.prepareStatement(s);

			int row = psmt.executeUpdate();

			if (row > 0) {
				System.out.println("Data inserted Sucessfully");
			} else {
				System.out.println("Error...");
			}
		}
	}
	

	public void custupdate() throws SQLException {
		// customer update
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter First name you want to update");
		String fn = scanner.next();

		System.out.println("Enter Last name you want to update");
		String ln = scanner.next();

		System.out.println("Enter ID");
		int ID21 = scanner.nextInt();

		String Sqlupdate = "UPDATE customer_info set firstname='" + fn + "',lastname='" + ln + "' where ID='" + ID21
				+ "'";
		PreparedStatement psmt = conn.prepareStatement(Sqlupdate);

		int row = psmt.executeUpdate();

		if (row > 0) {
			System.out.println("updated...");
		}
	}

	public void custdel() throws Exception {
		// customer delete
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter customer ID");
		int ID = scanner.nextInt();

		String Sqldelete = ("Delete from customer_info where ID='" + ID + "'");
		PreparedStatement psmt = conn.prepareStatement(Sqldelete);

		int row = psmt.executeUpdate();
		if (row > 0) {
			System.out.println("Deleted...from Database");
		}

	}

	public void custsearch() throws SQLException {
		// customer search
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter customer ID");
		int ID = scanner.nextInt();

		String Sqlsearch = ("select * from customer_info where ID='" + ID + "'");
		PreparedStatement psmt = conn.prepareStatement(Sqlsearch);

		ResultSet row = psmt.executeQuery();
		while (row.next()) {
			System.out.println("Name: " + row.getString("firstname"));
			System.out.println("Surname: " + row.getString("lastname"));
			System.out.println("Mobile number: " + row.getString("mobile_no"));
			System.out.println("Email ID: " + row.getString("Email"));
			System.out.println("Resident: " + row.getString("resident"));

		}

	}

	public void EmpInfo() throws Exception {
		// Employee method for input
		System.out.println("Enter Employee ID: ");
		int eid = scanner.nextInt();

		System.out.println("Enter Employee firstname: ");
		String firstname = scanner.next();

		System.out.println("Enter Employee lastname: ");
		String lastname = scanner.next();

		System.out.println("Enter Employee mobile number: ");
		String mobileno = scanner.next();

		System.out.println("Enter Employee dutytime: ");
		String Email = scanner.next();

		System.out.println("Enter Employee alloted work");
		String work = scanner.next();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		String s = "insert into emp_info(firstname,lastname,mobileno,email,work) values('" + firstname + "','"
				+ lastname + "','" + mobileno + "','" + Email + "','" + work + "')";

		PreparedStatement psmt = conn.prepareStatement(s);

		int row = psmt.executeUpdate();

		if (row > 0) {
			System.out.println("Data inserted Sucessfully");
		} else {
			System.out.println("Error...");
		}
	}

	public void Empupdate() throws Exception {
//		Employee update
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter First name you want to update");
		String fn = scanner.next();

		System.out.println("Enter Last name you want to update");
		String ln = scanner.next();

		System.out.println("Enter ID");
		int ID21 = scanner.nextInt();

		String Sqlupdate = "UPDATE emp_info set firstname='" + fn + "',lastname='" + ln + "' where eid='" + ID21 + "'";
		PreparedStatement psmt = conn.prepareStatement(Sqlupdate);

		int row = psmt.executeUpdate();

		if (row > 0) {
			System.out.println("updated...");
		}
	}

	public void Empsearch() throws Exception {
//		Emp search
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter customer ID");
		int ID = scanner.nextInt();

		String Sqlsearch = ("select * from emp_info where eid='" + ID + "'");
		PreparedStatement psmt = conn.prepareStatement(Sqlsearch);

		ResultSet row = psmt.executeQuery();
		while (row.next()) {
			System.out.println("Name: " + row.getString("firstname"));
			System.out.println("Surname: " + row.getString("lastname"));
			System.out.println("Mobile number: " + row.getString("mobileno"));
			System.out.println("Email ID: " + row.getString("Email"));
			System.out.println("Work: " + row.getString("work"));

		}
	}

	public void Empdel() throws Exception {
//		Employee delete
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter customer ID");
		int ID = scanner.nextInt();

		String Sqldelete = ("Delete from Emp_info where eid='" + ID + "'");
		PreparedStatement psmt = conn.prepareStatement(Sqldelete);

		int row = psmt.executeUpdate();
		if (row > 0) {
			System.out.println("Deleted...from Database");
		}
	}

	public void RoomInfo() throws Exception {
		// Room information for input
		Scanner scanner = new Scanner(System.in);

		System.out.println("your room number: ");
		int roomno = scanner.nextInt();

		System.out.println("number of bed: ");
		int bed = scanner.nextInt();
		scanner.nextLine();

		System.out.println("your category: ");
		String roomcategory = scanner.nextLine();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		String s = "insert into room_info(room_no,Number_of_bed,roomcategory)values('" + roomno + "','" + bed + "','"
				+ roomcategory + "')";

		PreparedStatement psmt = conn.prepareStatement(s);

		int row = psmt.executeUpdate();

		if (row > 0) {
			System.out.println("Data inserted Sucessfully");
		} else {
			System.out.println("Error...");
		}
	}

	public void roomupdate() throws Exception {
//		Room update
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter Room number whichever you want to update");
		int Room = scanner.nextInt();

		System.out.println("Enter ID");
		int ID21 = scanner.nextInt();

		String Sqlupdate = "UPDATE Room_info set room_no='" + Room + "'where rid='" + ID21 + "'";
		PreparedStatement psmt = conn.prepareStatement(Sqlupdate);

		int row = psmt.executeUpdate();

		if (row > 0) {
			System.out.println("updated...");
		}
	}

	public void Roomsearch() throws Exception {
//		Room Search
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		System.out.println("Enter Room ID");
		int ID = scanner.nextInt();

		String Sqlsearch = ("select * from room_info where rid='" + ID + "'");
		PreparedStatement psmt = conn.prepareStatement(Sqlsearch);

		ResultSet row = psmt.executeQuery();
		while (row.next()) {
			System.out.println("Room No: " + row.getString("room_no"));
			System.out.println("Number of bed: " + row.getString("Number_of_bed"));
			System.out.println("Room Category: " + row.getString("roomcategory"));

		}
	}

	public void Booking() throws Exception {
		// booking information for input

		System.out.println("number of person: ");
		int perno = scanner.nextInt();

		System.out.println("check-out: ");
		String checkout = scanner.next();

		System.out.println("Amount of room(Rs): ");
		double deposit = scanner.nextDouble();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");

		String s = "insert into Book_info(perno,checkout,deposit)values('" + perno + "','" + checkout + "','" + deposit
				+ "')";

		PreparedStatement psmt = conn.prepareStatement(s);

		int row = psmt.executeUpdate();
	}

	public void Bookshow() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");
		System.out.println("Enter ID: ");
		int ID = scanner.nextInt();
		System.out.println("=========================================================================================");
		String Sqlsearch = ("SELECT firstname, lastname, mobile_no, Email, resident from customer_info where ID=" + ID);
		PreparedStatement psmt = conn.prepareStatement(Sqlsearch);

		ResultSet row = psmt.executeQuery();
		while (row.next()) {
			System.out.println("Name: " + row.getString("firstname"));
			System.out.println("Surname: " + row.getString("lastname"));
			System.out.println("Mobile number: " + row.getString("mobile_no"));
			System.out.println("Email ID: " + row.getString("Email"));
			System.out.println("Resident: " + row.getString("resident"));

		}
		System.out.println("=========================================================================================");
	}

	public void room1() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmgmtdb", "root", "");
		System.out.println("Enter same ID as above: ");
		int ID = scanner.nextInt();
		System.out.println("=========================================================================================");
		String Sqlsearch = ("SELECT room_no, number_of_bed from room_info where rid=" + ID);
		PreparedStatement psmt = conn.prepareStatement(Sqlsearch);

		ResultSet row = psmt.executeQuery();
		while (row.next()) {
			System.out.println("Room No: " + row.getString("room_no"));
			System.out.println("Number of bed: " + row.getString("number_of_bed"));

		}
		System.out.println("=========================================================================================");
	}

}

public class Hotelmgmt {

	// main function
	public static void main(String args[]) throws Exception {
		Project obj = new Project();
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("*********Select suitable option from below*********** ");
		System.out.println("Press 1: Customer Information");
		System.out.println("Press 2: Staff Information");
		System.out.println("Press 3: Room Information");
		System.out.println("Press 4: Booking Information");

		Scanner a = new Scanner(System.in);

		int b = a.nextInt();

		switch (b) {
		case 1:
			Scanner cust = new Scanner(System.in);

			System.out.println("*********Select suitable option from below*********** "); // customer nested
																							// switch-case
			System.out.println("Press 1: Insert Customer Information");
			System.out.println("Press 2: update Customer Information");
			System.out.println("Press 3: Search Customer Information");
			System.out.println("Press 4: Delete Customer Information");
			int cust1 = cust.nextInt();
			switch (cust1) {
			case 1:
				obj.customerInfo();
				break;
			case 2:
				obj.custupdate();
				break;
			case 3:
				obj.custsearch();
				break;
			case 4:
				obj.custdel();
				break;
			default:
				System.out.println("Invalid Input");
			}
			break;
		case 2:
			Scanner Emp = new Scanner(System.in);

			System.out.println("*********Select suitable option from below*********** "); // Employee nested
																							// switch-case
			System.out.println("Press 1: Insert Employee Information");
			System.out.println("Press 2: update Employee Information");
			System.out.println("Press 3: Search Employee Information");
			System.out.println("Press 4: Delete Employee Information");
			int Emp1 = Emp.nextInt();
			switch (Emp1) {
			case 1:
				obj.EmpInfo();
				break;
			case 2:
				obj.Empupdate();
				break;
			case 3:
				obj.Empsearch();
				break;
			case 4:
				obj.Empdel();
				break;
			default:
				System.out.println("Invalid Input");
			}
			break;
		case 3:
			Scanner Room = new Scanner(System.in);

			System.out.println("*********Select suitable option from below*********** "); // customer nested loop
			System.out.println("Press 1: Insert Room Information");
			System.out.println("Press 2: update Room Information");
			System.out.println("Press 3: Search Room Information");
			int Room1 = Room.nextInt();
			switch (Room1) {
			case 1:
				obj.RoomInfo();
				break;
			case 2:
				obj.roomupdate();
				break;
			case 3:
				obj.Roomsearch();
				break;
			default:
				System.out.println("Invalid input");
			}
			break;
		case 4:
			Scanner book = new Scanner(System.in);
			System.out.println("*********Select suitable option from below*********** "); // customer nested
																							// loop
			System.out.println("Press 1: Insert Booking information");
			System.out.println("Press 2: show Booking information");
			int book1 = book.nextInt();
			switch (book1) {
			case 1:
				obj.Booking();
				break;
			case 2:
				obj.Bookshow();
				obj.room1();
				break;
			default:
				System.out.println("Invalid Input");
			}
			break;

		}
	}
}
