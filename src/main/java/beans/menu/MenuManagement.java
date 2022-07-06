package beans.menu;

import beans.Check;
import beans.services.DisplayStudent;
import beans.services.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuManagement {
    Scanner sc = new Scanner(System.in);
    Check checkClass = new Check();
    DisplayMenu displayMenu = new DisplayMenu();
    DisplayStudent displayStudent = new DisplayStudent();
    Student student = new Student();
    ResultSet res;
    private boolean check;
    public void homeManagement(Statement stmt){
        int choice;

        String tempChoice;
        char[] cChoice;

        do {
            do {
                displayMenu.home();
                tempChoice = sc.nextLine();
                cChoice = tempChoice.toCharArray();
                check = checkClass.cInt(cChoice);
            }while (!check);
            choice = Integer.parseInt(tempChoice);
            switch (choice){
                case 1:
                    displayStudent.byFaculty(stmt);
                    break;
                case 2:
                    displayStudent.all(stmt);
                    break;
                case 3:
                    student.changeInfo(stmt);
                    break;
                case 4:
                    student.add(stmt);
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Veuillez choisir l'un des chiffres proposer.");
            }
        }while (choice!=6);
    }
}
