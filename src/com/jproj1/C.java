package com.jproj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C {
	static String url="jdbc:mysql://localhost:3306/palletech";
	static String user="root";
	static String password="admin";
	static String ct="create table employee(id int primary key,name varchar(20),course varchar(20))";
	static Connection connection=null;
	static Statement s=null;
	static PreparedStatement ps=null;
	//static String insert1="insert into employee values(3,'tech','java')";
	//static String insert2="insert into employee values(4,'palle','java')";
	static String insert3="insert into employee values(?,?,?)";
	static String update="update employee set id=5, name='sowmi', course='python' where id=4";
	static String update1="update employee set name='lally', course='jdbc' where id=1";
	static String update2="update employee set name='sudha', course='sql' where id=3";
	static String update3="update employee set  course=? where id=?";
	//static String delete="delete from employee where id=2";
	static String delete1="delete from employee where id=?";
	static String select="select * from employee";
	static ResultSet r=null;
	public static void ct() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			s=connection.createStatement();
			s.executeUpdate(ct);
			s.executeUpdate(ct);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally 
		 {
			 try {
				s.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		 }
	}
		public static void insert(int id,String name,String course) 
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url, user, password);
				ps=connection.prepareStatement(insert3);
				//s.executeUpdate(insert1);
				//s.executeUpdate(insert2);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, course);
				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally 
			 {
				 try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
			 }

		}
		public static void update(String course,int id) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url, user, password);
				ps=connection.prepareStatement(update3);
				//s.executeUpdate(update);
				//s.executeUpdate(update1);
				//s.executeUpdate(update2);
				ps.setString(1, course);
				ps.setInt(2, id);
				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally 
			 {
				 try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
			 }

		}
		public static void delete(int id) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url, user, password);
				ps=connection.prepareStatement(delete1);
				//s.executeUpdate(delete);
				ps.setInt(1, id);
				ps.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally 
			 {
				 try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
			 }
		}
		public static void select() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url, user, password);
				s=connection.createStatement();
				r=s.executeQuery(select);
				while(r.next()) {
					int id=r.getInt("id");
					String name=r.getString("name");
					String course=r.getString("course");
					System.out.println(id+" "+name+" "
							+ ""+course);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally 
			 {
				 try {
					s.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
			 }
		}
}


