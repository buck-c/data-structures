import java.util.Scanner;

public class student {

    private String name;
	private int id;
	private double gpa;
    static boolean nextStudent=true;
	
	student() {	
		name="";
		id=0;
		gpa=0;
	}
	
	student(String student, int studentId, double grade) {
		name=student;
		id=studentId;
		gpa=grade;
	}
	
	void input(Scanner input) {
        String exit="-1";
		nextStudent=true;
		
		System.out.println("Student name? (-1 to quit)");
	       
	    String n=input.next(); // sets name  
	    if(exit.equalsIgnoreCase(n)) { //exits if user enters "-1"
	    	nextStudent=false; //flag for loop in studentManager
	    	return;
	    }
	    setName(n); 
          
		while(true) { // tries to set ID
			System.out.println("Student ID?");
				try { 
					setId(input.nextInt());
					break;
				}
				catch (Exception e) {
					System.out.println("Entry must be an integer"); 
					input.next();
				}
			}

		while(true){ // tries to set GPA
			System.out.println("GPA?");
				try { 
					setGpa(input.nextDouble());
					break;  
				}
				catch (Exception e) {
					System.out.println("Entry must be numeric"); 
					input.next();
				}
			}
          
        
	}

    public student deepCopy() {
        student clone = new student(name,id,gpa); 
        return clone;
    }

	public int compareTo(String target){ //returns int 0 if passed a name identitical to student name
		return(name.compareTo(target));
	}

    public String toString() { //combines student information for easy output
		return name+" Student ID: "+id+" GPA: "+gpa;
	}

	void setName(String student) {
		name=student;
	}
	
	void setId(int studentId) {
		id=studentId;
	}

	void setGpa(double grade) {
		gpa=grade;
	}
	
	String getName() {
		return name;
	}
	
	int getId() {
		return id;
	}

	double getGpa() {
		return gpa;
	}

}

