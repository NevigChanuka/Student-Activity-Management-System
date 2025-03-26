import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String stuId;
    private static Scanner input = new Scanner(System.in);
    public static int maxStudent = 100;
    public static String[][] stuDetialsArray = new String[maxStudent][2];
    public static Student[] studentsObjectArray = new Student[maxStudent];
    public static Module[] moduleObjectArray = new Module[maxStudent];


    public static void checkAvailableSeats() { // checks seat availability
        int countSeat = 0;

        for (int row = 0; row < maxStudent; row++) {
            if (stuDetialsArray[row][0] == null) {
                countSeat++;
            }
        }
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("                *** "+ countSeat +" Seats Available! ***       ");
        System.out.println("+-------------------------------------------------------------+");

    }

    public static void addToArray( String stuName, String stuId ) { // add student name and id to "stuDetialsArray" array

        for (int index = 0; index < maxStudent; index++) {

            if (stuDetialsArray[index][0] == null) {
                stuDetialsArray[index][0] = stuName;
                stuDetialsArray[index][1] = stuId;
                break;
            }
        }
    }

    public static void registerStudent() { // Register student name and ID

        System.out.println("+-----------------------Register student----------------------+");

        System.out.print("Enter Student Name: ");
        String stuName = input.next(); // get student name

        System.out.print("Enter Student ID: ");
        stuId = input.next(); // get student id

        System.out.println("+-------------------------------------------------------------+");

        Main.addToArray(stuName,stuId);

    }

    public static void deleteStudent() { // Delete student records

        System.out.println("+----------------------Delete student-------------------------+");
        System.out.print("Enter Student ID: ");
        stuId = input.next(); // get student id
        System.out.println("+-------------------------------------------------------------+");

        for (int index = 0; index < maxStudent; index++ ) {

            if ((stuDetialsArray[index][1] != null) && (stuDetialsArray[index][1].equals(stuId))) { // Delete from "stuDetialsArray"
                stuDetialsArray[index][0] = null;
                stuDetialsArray[index][1] = null;
            }

            if ((studentsObjectArray[index] != null) && (studentsObjectArray[index].stuId.equals(stuId))) { // Delete from "studentsObjectArray","moduleObjectArray"
                studentsObjectArray[index] = null;
                moduleObjectArray[index] = null;
            }

        }

    }

    public static void findStudent() { // find students using ID

        boolean isRegistered = true;
        System.out.println("+------------------------Find student-------------------------+");
        System.out.print("Enter Student ID: ");
        stuId = input.next(); // get student id

        for (int index = 0; index < maxStudent; index++ ) {


            if (stuId.equals(stuDetialsArray[index][1])) { // find user entered value
                System.out.println(" ");
                System.out.println("Student Name: " + stuDetialsArray[index][0]);
                System.out.println("Student ID  : " + stuDetialsArray[index][1]);
                System.out.println(" ");
                System.out.println("                 *** Student is Registered! ***                ");
                isRegistered = false;
                break;
            }
        }

        if (isRegistered) {
            System.out.println(" ");
            System.out.println("               *** Student is not Registered! ***              ");
        }
        System.out.println("+-------------------------------------------------------------+");
        System.out.println();
    }

    public static void storeStudentDetails() { //store students details in to text file

        try {
            FileWriter file = new FileWriter("StudentDetails.txt");

            for (int row = 0; row < maxStudent; row++) {

                if (stuDetialsArray[row][0] == null) {
                    continue;
                } else {
                    String detail = stuDetialsArray[row][0] + ":" + stuDetialsArray[row][1] + "\n";
                    file.write(detail); // write data to file
                }
            }
            file.close();
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|        *** Student details saved successfully! ***          |");
            System.out.println("+-------------------------------------------------------------+");

        } catch (IOException e) {
            System.out.println(" ");
        }

    }

    public static void loadStudentDetails() { // load students details from the text file and save it to array
        try {
            FileReader file = new FileReader("StudentDetails.txt");
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()){
                String text = fileReader.nextLine(); // read text from file
                String[] splitedData = text.split(":"); //split data

                Main.addToArray(splitedData[0],splitedData[1]); // save to array

            }
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|        *** Student details loaded successfully! ***         |");
            System.out.println("+-------------------------------------------------------------+");

        } catch (IOException e) {
            System.out.println("File Not Found!");

        }
    }

    public static void viewListOfStudents() {  // View the list of students based on their names

        int maxLegnth = 0;

        for (int i = 0; i < maxStudent; i++) {
            if (stuDetialsArray[i][0] != null) {
                maxLegnth++;
            }
        }

        String[] stuList = new String[maxLegnth]; // create new array for sorting

        for (int i = 0; i < maxLegnth; i++) {
            stuList[i] = stuDetialsArray[i][0]; // assign array elements values
        }

        Arrays.sort(stuList);

        System.out.println("|----------------Registered Students List----------------|");
        for (int i = 0; i < maxLegnth; i++) {
            System.out.println(i+1 + ". " + stuList[i]);
        }
        System.out.println("|--------------------------------------------------------|");
    }

    public static void additionalOption() { // sub menu for additional option

        while (true) {
            System.out.println("+----------------------Additional option----------------------+");
            System.out.println("|  1. Add student name and module marks                       |");
            System.out.println("|  2. Create summary report                                   |");
            System.out.println("|  3. Create complete report                                  |");
            System.out.println("|  4. Exit to main menu                                       |");
            System.out.println("+-------------------------------------------------------------+");

            System.out.print("Enter Choice: ");
            String choice = input.next();
            System.out.println(" ");

            if (choice.equals("1")) {
                for (int index = 0; index < maxStudent; index++) {

                    if (studentsObjectArray[index] == null) {
                        studentsObjectArray[index] = new Student(); // create an object on array
                        studentsObjectArray[index].getStuDetails();

                        moduleObjectArray[index] = new Module(); // create an object on array
                        moduleObjectArray[index].moduleMethod();
                        break;
                    }
                }

            } else if (choice.equals("2")) {
                Module.summaryReport();
            } else if (choice.equals("3")) {
                Module.completeReport();
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Invalid Choice");
                System.out.println(" ");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("+--------------------------Main menu--------------------------+");
            System.out.println("|  1. Check available seats                                   |");
            System.out.println("|  2. Register student                                        |");
            System.out.println("|  3. Delete student                                          |");
            System.out.println("|  4. Find student                                            |");
            System.out.println("|  5. Store student details into a file                       |");
            System.out.println("|  6. Load student details from the file to the system        |");
            System.out.println("|  7. View the list of students                               |");
            System.out.println("|  8. Additional option                                       |");
            System.out.println("|  9. Exit                                                    |");
            System.out.println("+-------------------------------------------------------------+");

            System.out.print("Enter Choice: "); // get users choice
            String choice = input.next();
            System.out.println(" ");

            if (choice.equals("1")) {
                Main.checkAvailableSeats();
            } else if (choice.equals("2")) {
                Main.registerStudent();
            } else if (choice.equals("3")) {
                Main.deleteStudent();
            } else if (choice.equals("4")) {
                Main.findStudent();
            } else if (choice.equals("5")) {
                Main.storeStudentDetails();
            } else if (choice.equals("6")) {
                Main.loadStudentDetails();
            } else if (choice.equals("7")) {
                Main.viewListOfStudents();
            } else if (choice.equals("8")) {
                Main.additionalOption();
            } else if (choice.equals("9")) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }
}