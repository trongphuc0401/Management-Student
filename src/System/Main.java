package System;

import java.util.ArrayList;
import java.util.Scanner;

import static System.ReadAndWrite.read;

public class Main {


    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = read("student.txt");
        Controller controller = new Controller();
        Boolean close = false;
        String choose = "";
        menuConsole();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    controller.add();
                    break;
                case "2":
                    controller.search();
                    break;
                case "3":
                    controller.edit();
                    break;
                case "4":
                    controller.delete();
                    break;
                case "5":
                    controller.displayGradePercentage();
                    break;
                case "6":
                    controller.displayAveragePercentage();
                    break;
                case "7":
                    controller.showStudent();
                    break;
                case "8":
                    close = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }if(close) {
                break;
            }
            menuConsole();
        }
    }
    public static void menuConsole() {
        System.out.print("##------------------ Menu-----------------##\n\n");
        System.out.print("|----------------------------------------|\n");
        System.out.print("| Option 1 - Add student                 |\n");
        System.out.print("| Option 2 - Find student by Id          |\n");
        System.out.print("| Option 3 - Edit student by Id          |\n");
        System.out.print("| Option 4 - Delete student by Id        |\n");
        System.out.print("| Option 5 - Display grade percentage    |\n");
        System.out.print("| Option 6 - Display average percentage  |\n");
        System.out.print("| Option 7 - Show student                |\n");
        System.out.print("| Option 8 - Exit                        |\n");
        System.out.print("|----------------------------------------|\n");
        System.out.print("Choose something: ");
    }
}
