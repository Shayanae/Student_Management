package beans.services;

import beans.Check;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Faculty {
    ResultSet res;
    Scanner sc = new Scanner(System.in);
    private int choice = 0;
    public void facultyChoice(Statement stmt){
        try{
            do {
                choice = displayFaculty(stmt);
                switch (choice) {
                    case 1:
                        res = stmt.executeQuery("SELECT s.id, s.lastname, s.firstname, f.fname " +
                                "FROM student s, faculty f " +
                                "WHERE f.fname = 'Electronique' " +
                                "AND s.faculty = f.id " +
                                "ORDER BY s.id;");
                        while (res.next()) {
                            System.out.print("ID: " + res.getInt("id"));
                            System.out.print(", Nom: " + res.getString("lastname"));
                            System.out.println(", Prénom: " + res.getString("firstname"));
                        }
                        break;
                    case 2:
                        res = stmt.executeQuery("SELECT s.id, s.lastname, s.firstname, f.fname " +
                                "FROM student s, faculty f " +
                                "WHERE f.fname = 'Informatique' " +
                                "AND s.faculty = f.id " +
                                "ORDER BY s.id;");
                        while (res.next()) {
                            System.out.print("ID: " + res.getInt("id"));
                            System.out.print(", Nom: " + res.getString("lastname"));
                            System.out.println(", Prénom: " + res.getString("firstname"));
                        }
                        break;
                    default:
                        System.out.println("Veuillez sélectionner l'un des chiffre proposer.");
                }
            }while (choice!=1 && choice!=2);
        }catch (Exception e){System.out.println("beug facultyChoice");}
    }

    public int facultyAssignment(Statement stmt){
        int nbFaculty = 0;
        try {
            do {
                choice = displayFaculty(stmt);
                switch (choice) {
                    case 1:
                        res = stmt.executeQuery("SELECT f.id " +
                                "FROM faculty f " +
                                "WHERE f.fname = 'Electronique';");
                        while (res.next()){
                            nbFaculty = res.getInt("id");
                        }
                        break;
                    case 2:
                        res = stmt.executeQuery("SELECT f.id " +
                                "FROM faculty f " +
                                "WHERE f.fname = 'Informatique';");
                        while (res.next()){
                            nbFaculty = res.getInt("id");
                        }
                        break;
                    default:
                        System.out.println("Veuillez entrer l'un des chiffres proposer.");
                }
            } while (choice != 1 && choice != 2);
        }catch (Exception e){System.out.println("Beug FacultyAssignement");}
        return nbFaculty;
    }

    private int displayFaculty(Statement stmt){
        int count;
        String tempChoice;
        char[] cChoice;
        boolean check;
        Check checkClass = new Check();
        try {
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
        }catch (Exception e){System.out.println("Beug displayFaculty");}
        return choice;
    }


}
