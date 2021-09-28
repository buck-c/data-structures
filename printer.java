public class printer {	//just prints all the menus used in the program to reduce main method clutter
    
    public static void welcome() {
		System.out.println("Welcome To St. Joseph's College");
		System.out.println("Option 1: Sample inputs");
		System.out.println("Option 2: Manual data entry");
	}
	public static void menu(){
		System.out.println("Select an option:");
		System.out.println("1: Insert a student at a specific index");
		System.out.println("2: Fetch a student's information");
		System.out.println("3: Delete a student's information");
		System.out.println("4: Update a student's information");
		System.out.println("5: Output all student information");
		System.out.println("6: Exit program");

	}
}
