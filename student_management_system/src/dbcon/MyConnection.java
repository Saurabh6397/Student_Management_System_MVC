package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Student;

public class MyConnection {
	Connection con=null;
	public Connection getcon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/profound22","root","");
		return con;
	}
	public void saveStudent(Student s)
	{
		try {
		con=getcon();
		String sql="insert into Student(name,grade) values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, s.getName());
        ps.setString(2, s.getGrade());
		ps.executeUpdate();
		con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DeleteStudent(int id)
	{
		try {
			con=getcon();
			String sql="Delete from Student where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Student>listStudent()
	{
		ArrayList<Student>ar=new ArrayList<Student>();
		try {
			Student s=null;
			con=getcon();
			String sql="select * from Student";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setGrade(rs.getString(3));
				ar.add(s);
			}
			con.close();
			return ar;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return ar;
		}
	public void UpdateStudent(Student s)
	{
		try
		{
			con=getcon();
			String sql="update Student set name=?,grade=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getGrade());
			ps.setInt(3, s.getId());
			ps.executeUpdate();
			
			con.close();	
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		}
	
	}

