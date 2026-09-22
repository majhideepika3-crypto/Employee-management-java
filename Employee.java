CREATE DATABASE company_db;
USE company_db;
CREATE TABLE employees (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100),
  department VARCHAR(50),
  salary INT
);
public class Employee {
    int id; String name; String email; String department; int salary;
    public Employee(int id, String name, String email, String dept, int sal){
        this.id=id; this.name=name; this.email=email; 
        this.department=dept; this.salary=sal;
    }
}
import java.sql.*;
public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String pass = "your_mysql_password";
        return DriverManager.getConnection(url, user, pass);
    }
}
import java.sql.*; import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();
        while(true){
            System.out.println("\n1.Add 2.View 3.Delete 4.Exit");
            int ch = sc.nextInt();
            if(ch==1){
                System.out.print("Name: "); String n=sc.next();
                System.out.print("Email: "); String e=sc.next();
                System.out.print("Dept: "); String d=sc.next();
                System.out.print("Salary: "); int s=sc.nextInt();
                String q="INSERT INTO employees(name,email,department,salary) VALUES(?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(q);
                ps.setString(1,n); ps.setString(2,e); ps.setString(3,d); ps.setInt(4,s);
                ps.executeUpdate(); System.out.println("Added!");
            }
            if(ch==2){
                ResultSet rs=con.createStatement().executeQuery("SELECT * FROM employees");
                while(rs.next()){
                    System.out.println(rs.getInt("id")+" | "+rs.getString("name")+" | "+rs.getString("department")+" | "+rs.getInt("salary"));
                }
            }
            if(ch==3){
                System.out.print("ID to delete: "); int id=sc.nextInt();
                con.createStatement().executeUpdate("DELETE FROM employees WHERE id="+id);
                System.out.println("Deleted!");
            }
            if(ch==4) break;
        }
    }
}
