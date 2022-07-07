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
            faculty.facultyChoice(stmt);
        }catch (Exception e){System.out.println("Beug byFaculty");}
    }

    public void all(Statement stmt){
        try{
            res = stmt.executeQuery("SELECT * FROM student ORDER BY id;");
            while (res.next()){
                System.out.print("ID: " + res.getInt("id"));
                System.out.print(", Nom: " + res.getString("lastname"));
                System.out.print(", Prénom: " + res.getString("firstname"));
                System.out.println(", Filière: " + res.getString("faculty"));
            }
        }catch (Exception e){System.out.println("Beug Faculty all");}
    }
}
