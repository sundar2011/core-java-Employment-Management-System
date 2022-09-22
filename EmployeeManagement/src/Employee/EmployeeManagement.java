package Employee;
import Employee.*;

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement implements Serializable{
	
	
	static void display(ArrayList<Employee> al) {
		 
	System.out.println("\n------Employee List------\n");	
	System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","salary","contact-no","Email-Id"));
	
	for(Employee e:al) {
		System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.id,e.name,e.salary,e.contact_no,e.email_id));
	}
		
	}
	

	public static void main(String[] args) {
		
		int id;
		String name;
		Float salary;
		Long contact_no;
		String email_id;
		
		Scanner sc=new Scanner(System.in);	
		ArrayList<Employee> al=new ArrayList<Employee>();
		
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		FileOutputStream fos = null;
		ObjectOutputStream oos =null;
		
		try {
			
			File myFile = new File("test.txt");
	        System.out.println("Attempting to read from file in: "+myFile.getCanonicalPath());
			 
//			File homedir = new File(System.getProperty("user.home"));
			f=new File("/home/sundharam/git/core-java/EmployeeManagement/test.txt");
			if(f.exists())
			{
			fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				al = (ArrayList<Employee>)ois.readObject();
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
				
  
	System.out.println("----------Employee Management Systems---------");
	System.out.println("1.Adding the Employee");
	System.out.println("2.searching the Employee");
	System.out.println("3.Editing the Employees");
	System.out.println("4.Deleting the Employees");
	System.out.println("5.Displaying the Employees");
	do
	{
	System.out.println("Enter your Choice");
	int ch=sc.nextInt();
		
	switch(ch){
		
	case 1:
		System.out.println("Add the Employee details");
		System.out.println("Enter the Employee Id");
		id=sc.nextInt();
		System.out.println("Enter the Employee Name");
		name=sc.next();
		System.out.println("Enter the Employee Salary");
		salary=sc.nextFloat();
		System.out.println("Enter the Contact No");
		contact_no=sc.nextLong();
		System.out.println("Enter the Email Id");
		email_id=sc.next();
		al.add(new Employee(id,name,salary,contact_no,email_id));
		display(al);	
		break;
	case 2:
		System.out.println("Search Employee details");		
		 id=sc.nextInt();
		 int i=0;
		 for(Employee e:al) {
			
			 if(id==e.id) {
//				 System.out.println(e);
				 System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.id,e.name,e.salary,e.contact_no,e.email_id));
				 i++;
			 }			 
		 }
		 if(i==0) {
			 System.out.println("Search Employee id is not avaiable");
		 }
		 break;
	case 3:
		System.out.println("Edit Employee details");
		System.out.println("Enter the employee edited id");
		id=sc.nextInt();
		int j=0;
		for(Employee e:al) {
			if(id==e.id) {
				
				j++;
				do {
					int c=0;
				System.out.println("Enter the edited employees details");
				System.out.println("1.Edit the employee name");
				System.out.println("2.Edit the employee salary");
				System.out.println("3.Edit the employee contact No");
				System.out.println("4.Edit the employee Email id");
				System.out.println("5.Go back");
				
				System.out.println("Enter your choice : ");
				c = sc.nextInt();
			   switch(c) {
			   
			   case 1:
				  e.name=sc.next();
				  System.out.println(e);
				  break;
			   
			   case 2:
					  e.salary=sc.nextFloat();
					  System.out.println(e);
					  break;
				   
			   case 3:
					  e.contact_no=sc.nextLong();
					  System.out.println(e);
					  break;
				   
			   case 4:
					  e.email_id=sc.next();
					  System.out.println(e);
					  break;
					  
			   case 5:
				     j++;
					  break;
				
			   default:
				   System.out.println("Enter the options are not avaiable");
				   break;
			   }
			   }while(j==1);
				
			
			
		}

			if(j==0) {
				System.out.println("Enter the id is not avaiable");
			}
		}
		break;
		
	case 4:
		System.out.println("Enter the id to Delete the Employee");
		id=sc.nextInt();
		int k=0;
		try {
			for(Employee e:al) {
				if(id==e.id) {
					
					al.remove(e);
					display(al);
					k++;
				}
			}
			if(k==0) {
				System.out.println("Enter the Employee id is not avaiable");
			}
		}
		catch(Exception e) {
			System.out.println(e);			
		}
		
		break;
		
	case 5:
		try {
			al = (ArrayList<Employee>)ois.readObject();
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);			
		}
        catch(Exception e){
        	System.out.println(e);				
		}
		display(al);
		break;
	case 6: try {
		fos = new FileOutputStream(f);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(al);
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	catch(Exception e2){
		e2.printStackTrace();
	}
	finally{
		try {
			fis.close();
			ois.close();
			fos.close();
			oos.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
			}
		System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
		sc.close();
		System.exit(0);
		break;
    
    
	default:
		System.out.println("u not selected the give list options");
		break;
	
	}
	}while(true);
	
	
	   
	    
	    
	}

}
