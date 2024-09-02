package EBI;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Lab2 {

    public static void main(String[] args) {
        SimpleClass simp = new SimpleClass("Hello java!");
        
        simp.printMessage();
        
        Class<?> c = simp.getClass();
        
        try {
        	Author MyAuthor1 = c.getAnnotation(Author.class);
            System.out.println("Authors name is : " + MyAuthor1.name());
            System.out.println("Authors salary is: " + MyAuthor1.salary());
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
		try {
			Method m;
			m = c.getMethod("printMessage");
			Author MyAuthor2 = m.getAnnotation(Author.class);
	        System.out.println("Authors name is : " + MyAuthor2.name());
	        System.out.println("Authors salary is: " + MyAuthor2.salary());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Constructor<?> con = simp.getClass().getConstructor(); 
			Author MyAuthor3 = con.getAnnotation(Author.class);
	        System.out.println("Authors name is : " + MyAuthor3.name());
	        System.out.println("Authors salary is: " + MyAuthor3.salary());
		} catch (Exception e) {
			e.printStackTrace();
		}
        finally {
        	
        }
        
        
        
    }
    
    @Retention (RetentionPolicy.RUNTIME)
    @Target ({ElementType.TYPE, ElementType.METHOD ,ElementType.CONSTRUCTOR , ElementType.FIELD  })
    public @interface Author {
    	String name();
    	int salary();
    	
    }
    
    @Author(name = "MohamedYehia" , salary = 10_000)
    public static class SimpleClass {

    	@Author(name = "MohamedYehia" , salary = 12_000) // A field (member variable)
        private String message;

    	@Author(name = "MohamedYehia" , salary = 14_000) // Constructor
        public SimpleClass(String message) {
            this.message = message;
        }

    	@Author(name = "MohamedYehia" , salary = 16_000) // A method
        public void printMessage() {
            System.out.println("Message: " + message);
        }

       
    }
    
    
    
}