import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        String autoFill="1"; 
        String manual="2";

        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.lineSeparator());

        studentManager classRoster=new studentManager();

        while(true){

            printer.welcome(); //displays prompts user if they'd like to manually insert students or use the sample list hard coded in the sampleStudents class

            String inputOption=input.next();  

            if(inputOption.equalsIgnoreCase(autoFill)){     
                new sampleStudents();
                classRoster=sampleStudents.getRoster();     //sets the array of students to the one specified in sampleStudents
                break;
            }
            else if(inputOption.equalsIgnoreCase(manual)){
                while(student.nextStudent){
                    classRoster.addStudent(input);  //continually prompts for new students until nextStudent flag in the student class is set to false by user entering -1 for name
                }
                break;
            }
            else{
                System.out.println("Invalid input"); 
                input.next();  
            }
        }

///////////////////////////////////////////////////////////////

        while(true){ //after data has been submitted, prompts user for a new menu with options on what to do with the data

            printer.menu();
        
        try{

	        int sel=input.nextInt();
        
            if(sel==1){
                classRoster.insert(input); //inserts a student at a given index
            }
            else if(sel==2){ 
                classRoster.fetch(input); //pulls a student based on a name search
            }
            else if(sel==3){
                classRoster.delete(input); //deletes a student based on a name search
            }
            else if(sel==4){
                classRoster.update(input); //locates a student based on name search and allows user to overwrite students old data
            }
            else if(sel==5){
                classRoster.showAll(); //prints all students on roster
            }
            else if(sel==6){
                System.exit(0); //ends program
            }
            else{
                System.out.println("invalid selection"); 
            }
        }
        catch (Exception e){
            System.out.println("Enter an integer 1-6");
            input.next();
            }
        }
        
    }
}
