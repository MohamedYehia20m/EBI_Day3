package EBI;

import java.security.KeyStore.TrustedCertificateEntry;

public class Lab1 {

    public static void main(String[] args) {
        callingMethods x = new Lab1().new callingMethods();
        x.invokeMethods();
    }

    
    public class customException extends Exception {
    	public customException(String message) {
    		super(message);
    	}
    }
    
    public  class methods {
    	//three methods throwing your newly created exception class
    	
    	public static void methods() {}
    	
    	public  void method1 (int age) throws customException
    	{
			if (age < 18)
    			throw new customException("the person is less than 18 years old");
    	}
    	
    	public  void method2 (String gender) throws customException
    	{
    		if (!gender.equals("male"))
    			throw new customException("the person is not male");
    	}
    	
    	public  void method3 (int Fatherage) throws customException
    	{
			if (Fatherage > 60)
    			throw new customException("the person's father is above 60");
    	}
    	
    	
    	
    }
    
    public class callingMethods {
    	//calling the functions in methods with try/catch and finally
    	public void invokeMethods() {
    	methods m = new methods();
    	
    	try {
            m.method1(15);  // This will throw an exception
        } catch (customException e) {
            System.out.println("Caught exception in method1: " + e.getMessage());
        } 

        // Handle exceptions from method2
        try {
            m.method2("female");  // This will throw an exception
        } catch (customException e) {
            System.out.println("Caught exception in method2: " + e.getMessage());
        }

        // Handle exceptions from method3
        try {
            m.method3(65);  // This will throw an exception
        } catch (customException e) {
            System.out.println("Caught exception in method3: " + e.getMessage());
        }
 finally {
            System.out.println("Finally block executed.");
        }
    	
    	}
    } 
    
    
}