package com.syne.assign;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable
{


	private static final long serialVersionUID = 1L;

	private long empCode;
	
	private String name;
	
	private String deptartmentCode;

	public long getEmpCode() {
		return empCode;
	}

	public void setEmpCode(long empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptartmentCode() {
		return deptartmentCode;
	}

	public void setDeptartmentCode(String deptartmentCode) {
		this.deptartmentCode = deptartmentCode;
	}

	public Employee(long empCode, String name, String deptartmentCode) {
		super();
		this.empCode = empCode;
		this.name = name;
		this.deptartmentCode = deptartmentCode;
	}

}




public class SerializerDeserializer {

	public static void main(String[] args) {

		Employee e1 =new Employee(1,"Kris" ,"IT");
		
		
		// Serialization
		FileOutputStream fo;
		try {
		fo = new FileOutputStream(new File("Emp.txt"));
		ObjectOutputStream ob =new ObjectOutputStream(fo);
		ob.writeObject(e1);

		} catch (IOException e) {
					e.printStackTrace();
		}
				
		
		
		 Employee empObject = null; 
		  
	        // Deserialization 
	        try
	        {    
	            FileInputStream file = new FileInputStream("Emp.txt"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            empObject = (Employee)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	            System.out.println("Emp ID = " + empObject.getName()); 
	            System.out.println("Emp Name = " + empObject.getName()); 
	            System.out.println("Emp Department = " + empObject.getDeptartmentCode()); 
	        } 
	          
	        catch(IOException ex) 
	        { 
	            ex.printStackTrace();
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	        	 ex.printStackTrace();
	        } 
	  
		
		
		
		
		
	}






}
