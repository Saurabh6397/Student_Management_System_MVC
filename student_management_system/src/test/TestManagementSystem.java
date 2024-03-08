package test;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Student;
import dbcon.MyConnection;

public class TestManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyConnection connection=new MyConnection();
		Student s=new Student();
		int choice;
		do {
			System.out.println("--------------student Details------------------");
			System.out.println("1: Insert Student data");
			System.out.println("2: show Student data");
			System.out.println("3: Delete student data");
			System.out.println("4: Upadate student data");
			System.out.println("5: exist");
			System.out.println("Enter your Choice:");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: String name,grade;
					System.out.println("Entere Student Name:");
					name=sc.next();
					System.out.println("Enter student grade:");
					grade=sc.next();
					//initilize student bean
					
					s.setName(name);
					s.setGrade(grade);
					//System.out.println("value set");
					connection.saveStudent(s);
					
					System.out.println("Inserted Student data....");
					break;
			case 2: System.out.println("________studet list__________");
					ArrayList<Student>ar=connection.listStudent();
					for(Student s1:ar)
					{
						System.out.println(s1);
					}
					break;
					
			case 3: int id;
					System.out.println("Enter delete id:");
					id=sc.nextInt();
					
					s.setId(id);
					//call business logic
					connection.DeleteStudent(id);
					
					System.out.println("Deleted Student data......");
					break;
			case 4:
					System.out.println("Enter name to update");
					name=sc.next();
					System.out.println("Enter Grade to update");
					grade=sc.next();
					System.out.println("Enter Int to update");
					int id1=sc.nextInt();
					
					s.setName(name);
					s.setGrade(grade);
					s.setId(id1);
					connection.UpdateStudent(s);
					System.out.println("update successfully");
					break;
			default:System.out.println("please Enter Correct choice");
			}
		}
		while(choice!=0);
			}
		}

