import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Module {

    Float mark1;
    Float mark2;
    Float mark3;
    float total;
    float average;
    String grade;
    private static int module02Pass = 0;
    private static int module01Pass = 0;
    private static int module03Pass = 0;
    private static boolean isMarksValid = false;

    private static Scanner input = new Scanner(System.in);

    private static void marksChecker(Float marks, String marksModule) { //check marks are valid
        if ((marks <= 100) && (marks >= 0)) {
            isMarksValid = !isMarksValid;
        }

        if ((marksModule.equals("module01")) && (marks >= 40)) {
            module01Pass++;
        } else if ((marksModule.equals("module02")) && (marks >= 40)) {
            module02Pass++;
        } else if ((marksModule.equals("module03")) && (marks >= 40)) {
            module03Pass++;
        }
    }


    public void moduleMethod() { // get students marks
        isMarksValid = false;

        while (!isMarksValid) {  // get module 01 marks
            System.out.print("Enter Module Mark 1: ");
            mark1 = input.nextFloat();
            marksChecker(mark1, "module01");
        }

        while (isMarksValid) { // get module 02 marks
            System.out.print("Enter Module Mark 2: ");
            mark2 = input.nextFloat();
            marksChecker(mark2, "module02");
        }

        while (!isMarksValid) { // get module 03 marks
            System.out.print("Enter Module Mark 3: ");
            mark3 = input.nextFloat();
            marksChecker(mark3, "module03");
        }

        total = mark1 + mark2 + mark3;  // calculate total of marks
        average = (mark1 + mark2 + mark3)/3; // calculate average of marks

        // gets the grade
        if (average >= 80) {
            grade = "Distinction";
        } else if (average >=  70) {
            grade = "Merit";
        } else if (average >= 40) {
            grade = "Pass";
        } else if (average >= 0) {
            grade = "Fail";
        }
    }

    public static void summaryReport() { // create summary report
        int countSeat = 0;

        for (int row = 0; row < Main.stuDetialsArray.length; row++) // count registered students
            if (Main.stuDetialsArray[row][0] != null){
                countSeat++;
            }
        System.out.println("+--------------------------Summary----------------------------+");
        System.out.println("Total number of student registrations: " + countSeat);
        System.out.println("Module 1 pass total number of students :" + module01Pass);
        System.out.println("Module 2 pass total number of students :" + module02Pass);
        System.out.println("Module 3 pass total number of students :" + module03Pass);
        System.out.println("+-------------------------------------------------------------+");
    }

    public static void completeReport() {  // create complete report
        int countStudent = 0;

        for (int index = 0; index < Main.maxStudent; index++) {
            if (Main.studentsObjectArray[index] != null) {
                countStudent++;
            }

        }
        System.out.println(Arrays.deepToString(Main.moduleObjectArray));

        for (int index = 0; index < Main.maxStudent; index++) {
            if (Main.studentsObjectArray[index] != null) {
                countStudent++;
            }

        }

        // display full report
        System.out.println("+----------------------------------------------------------------------------FULL REPORT----------------------------------------------------------------------------+");
        System.out.printf("%-10s %-20s %10s %20s %20s %20s %20s %20s\n", "Student ID", "Student Name", "Module 1 marks", "Module 2 marks", "Module 3 marks", "Total marks", "Average mark", "Student Grade"); // Report heading
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for(int index = 0; index < countStudent; index++) {
            System.out.printf("%-10s %-20s %10.2f %20.2f %20.2f %20.2f %20.2f %20s\n",
                    Main.studentsObjectArray[index].stuId,
                    Main.studentsObjectArray[index].stuName,
                    Main.moduleObjectArray[index].mark1,
                    Main.moduleObjectArray[index].mark2,
                    Main.moduleObjectArray[index].mark3,
                    Main.moduleObjectArray[index].total,
                    Main.moduleObjectArray[index].average,
                    Main.moduleObjectArray[index].grade
            );
        }
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }
}
