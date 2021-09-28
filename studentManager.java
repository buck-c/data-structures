import java.util.Scanner;

public class studentManager{

    private int next;
    private int size;
    private student[] allStudents;

    public studentManager(){ //initializes student array with a default size of 5. all input methods will double size of array if needed before submitting a new entry
        next=0;
        size=5;
        allStudents=new student[size];
    }

    public studentManager(int s){ //option to initialize student array with a particular length
        next=0;
        size=s;
        allStudents=new student[s];
    }

    void addStudent(Scanner input){ //checks to make sure theres enough space, then stores a student at the next index according to user input
       
        if(next>=allStudents.length){
            allStudents=arrExpand(allStudents);
        }
        allStudents[next]=new student();
        allStudents[next].input(input);
        if(student.nextStudent)
            next++;
        
    }

    void addStudent(int index,String name,int id,double gpa){ //adds student at a particular index when called. only used for sample students option, will overwrite anything at specified index
        if(next>=allStudents.length){
            allStudents=arrExpand(allStudents);
        }
        allStudents[index]=new student(name,id,gpa);
        next++;
    }

    student[] arrExpand(student oldArr[]){ //replaces array with a deep copy of old array thats twice the size when called

		student expandArr[] = new student[oldArr.length*2];
        for(int i=0;i<oldArr.length;i++){
			expandArr[i]=oldArr[i].deepCopy();
		}
		return expandArr;
	}

    void showAll(){ //prints every student
	    	for(int i=0;i<next;i++) { 
				System.out.printf("Student "+(i+1)+": ");
	    		System.out.println(allStudents[i].toString());
	    	}
	}

    void insert(Scanner input){

        System.out.println("Index?");

        try{
            int index=input.nextInt();

            if(next>=allStudents.length){ 
                allStudents=arrExpand(allStudents);
            }

            if(index==next){ // if index is at the end of the array, no need to shift rest of values
                allStudents[next]=new student(); 
                allStudents[index].input(input);
                next++;
            }

            else if(index<next){
                allStudents[next]=new student(); //shifts all values up one index from end of array until insert location is hit
                for(int i=next;i>index;i--){
                    allStudents[i]=allStudents[i-1].deepCopy();
                }
                allStudents[index].input(input);
                next++;
            }

            else{
                System.out.println("Maximum valid index is "+next); //ensures no gaps in array if user inputs index within bounds of an oversized array
                return; 
            }
            
        }
        catch (Exception e){
            System.out.println("entry must be a positive integer"); 
            input.next();
        }
    }
    
    void fetch(Scanner input){
        boolean notFound=true;
        System.out.println("Name?");
        String name=input.next();

        for(int i=0;i<next;i++){
            if((allStudents[i].compareTo(name))==0){ //searches array for student, prints user if found
                notFound=false;
                System.out.println(allStudents[i].toString());    
            }
        }  
        if(notFound){
            System.out.println("Student not found");
        }  
    }
    
    void delete(Scanner input){ 
        boolean notFound=true; 
        System.out.println("Name?");
        String name=input.next();

        for(int i=0;i<next;i++){
            if((allStudents[i].compareTo(name))==0){ 
                notFound=false;
                System.out.println("Deleting "+name+" from class roster"); 

                if(i==0){
                    allStudents[i]=allStudents[i+1].deepCopy(); //below for loop doesn't work if user is trying to delete index 0 so this if statement covers that case
                    i++;                                        //j can only increment until next-1 otherwise the shift below tries to pull out of bounds
                }                                               //theres probably a more clever way to fix that but this works

                for(int j=i;j<next-1;j++){
                    allStudents[j]=allStudents[j+1].deepCopy(); //shifts all students down an index overwriting desired student
                }
                next--; // pulls back next position one as not to break input methods
                allStudents[next]=null; //clears last array location that would otherwise be duplicated by above loop
                System.out.println("Student deleted");
            }
        }
        if(notFound){
            System.out.println("Student not found");
        }
    }

    void update(Scanner input){
        boolean notFound=true;
        System.out.println("Name?");
        String name=input.next();

        for(int i=0;i<next;i++){
            if((allStudents[i].compareTo(name))==0){ //searches array for matching name according to user entry, prompts user to reinput student attributes if student located 
                notFound=false;
                System.out.println("Student located. Please re-enter the following information to update entry: "); 
                allStudents[i].input(input);
                System.out.println("Student "+name+" updated: "+allStudents[i].toString());   
            }
        }
        if(notFound){
            System.out.println("Student not found");
        }
    }
}