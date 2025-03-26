import java.util.Scanner;

public class Student {
    private static Scanner input = new Scanner(System.in);

    //int indexNo; // stuDetails array element index number
    String stuId;
    String stuName;


    public void getStuDetails() { // get student ID and Name

        System.out.print("Enter Student Name: ");
        stuName = input.next();  // get student name

        System.out.print("Enter Student ID: ");
        stuId = input.next(); // get student id

        boolean hasElement = false;
        for (int index = 0; index < Main.stuDetialsArray.length; index++) {

            if ((Main.stuDetialsArray[index][1] != null) && (Main.stuDetialsArray[index][1].equals(stuId))) { // checks name and id already added
                hasElement = true;
                break;
            }
        }
        if (!hasElement) {
            Main.addToArray(stuName, stuId); // add name and id to "stuDetialsArray" array
        }
    }

}
