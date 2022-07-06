package beans.services;

import beans.Check;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayStudent {
    private ResultSet res;
    private boolean check;
    private String tempChoice;
    private char[] cChoice;
    private int choice;
    Scanner sc = new Scanner(System.in);
    Check checkClass = new Check();
    Faculty faculty = new Faculty();
    public void byFaculty(Statement stmt){
        int count;
        try{
            do {
                do {
                    count = 0;
                    res = stmt.executeQuery("SELECT f.fname FROM faculty f;");
                    while (res.next()) {
                        count++;
                        System.out.println(count + ": " + res.getString("fname"));
                    }
                    System.out.println("Pour quelle filière voulez vous affichez les étudiants?");
                    tempChoice = sc.nextLine();
                    cChoice = tempChoice.toCharArray();
                    check = checkClass.cInt(cChoice);
                } while (!check);
                choice = Integer.parseInt(tempChoice);
                faculty.facultyChoice(stmt, choice);
            }while (choice!=1 && choice!=2);
        }catch (Exception e){System.out.println("Beug byFaculty");}
    }
}
