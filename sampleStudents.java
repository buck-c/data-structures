public class sampleStudents {
    
    static studentManager sampleRoster=new studentManager(11);

    public sampleStudents(){
        sampleRoster.addStudent(0,"Steve",123456,3.5);          //might have been better to put this in main but its ugly
        sampleRoster.addStudent(1,"Mary",789123,2.8);           //creates 11 sample students so program can be tested without manually inputting lots of students
        sampleRoster.addStudent(2,"Andrew",456789,3.3);
        sampleRoster.addStudent(3,"Sam",987654,3.7);
        sampleRoster.addStudent(4,"Tim",321987,2.5);
        sampleRoster.addStudent(5,"Kat",654321,3.9);
        sampleRoster.addStudent(6,"James",137946,3.0);
        sampleRoster.addStudent(7,"Megan",467913,4.0);
        sampleRoster.addStudent(8,"Stacy",654987,3.7);
        sampleRoster.addStudent(9,"Paul",555777,1.8);
        sampleRoster.addStudent(10,"Joe",112233,2.4); 
    }

    static studentManager getRoster(){
        return sampleRoster;
    }

}
