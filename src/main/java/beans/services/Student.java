package beans.services;

import beans.Check;
import beans.menu.DisplayMenu;
import beans.menu.MenuManagement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Student {
    private int choice;
    private boolean check;
    private String tempChoice;
    private char[] cChoice;
    Check checkClass = new Check();
    DisplayMenu displayMenu = new DisplayMenu();
    Scanner sc = new Scanner(System.in);
    ResultSet res;
    Faculty faculty = new Faculty();
    DisplayStudent displayStudent = new DisplayStudent();
    public void changeInfo(Statement stmt){
        try{
            do {
                do {
                    displayMenu.changeInfo();
                    tempChoice = sc.nextLine();
                    cChoice = tempChoice.toCharArray();
                    check = checkClass.cInt(cChoice);
                }while (!check);
                choice = Integer.parseInt(tempChoice);
                res = stmt.executeQuery("SELECT s.id, s.lastname, s.firstname " +
                        "FROM student s;");
                while (res.next()){
                    System.out.print("ID: " + res.getInt("id"));
                    System.out.print(", Nom: " + res.getString("lastname"));
                    System.out.println(", Prénom: " + res.getString("firstname"));
                }
                switchChangeInfo(stmt, choice);
            }while (choice < 0 || choice > 4);
        }catch (Exception e){System.out.println("Beug ChangeInfo");}
    }

    public void switchChangeInfo(Statement stmt, int choice){
        int id;
        String tempId, lastname, firstname;
        char[] cId;
        try {
            do {
                System.out.println("Entrer l'id de l'étudiant à modifier.");
                tempId = sc.nextLine();
                cId = tempId.toCharArray();
                check = checkClass.cInt(cId);
            }while (!check);
            id = Integer.parseInt(tempId);
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Entrer le nouveau nom");
                        lastname = sc.nextLine();
                        check = checkClass.cString(lastname);
                    }while (!check);
                    res = stmt.executeQuery("UPDATE student " +
                            "SET lastname = '" + lastname + "' " +
                            "WHERE id = " + id + ";");
                    break;
                case 2:
                    do {
                        System.out.println("Entrer le nouveau prénom");
                        firstname = sc.nextLine();
                        check = checkClass.cString(firstname);
                    }while (!check);
                    res = stmt.executeQuery("UPDATE student " +
                            "SET firstname = '" + firstname + "' " +
                            "WHERE id = " + id + ";");
                    break;
                case 3:
                    do {
                        System.out.println("Entrer le nouveau nom");
                        lastname = sc.nextLine();
                        check = checkClass.cString(lastname);
                    }while (!check);
                    do {
                        System.out.println("Entrer le nouveau prénom");
                        firstname = sc.nextLine();
                        check = checkClass.cString(firstname);
                    }while (!check);
                    res = stmt.executeQuery("UPDATE student " +
                            "SET lastname = '" + lastname + "', firstname = '" + firstname + "' " +
                            "WHERE id = " + id + ";");
                    break;
                default:
                    System.out.println("Veuillez choisir l'un des chiffres proposer.");
            }
        }catch (Exception e){System.out.println("Beug change info MenuManagement");}
    }

    public void add(Statement stmt){
        Random random = new Random();
        boolean flag = false;
        int id, nbFaculty;
        String lastname, firstname;
        try {
            do {
                id = 99999 + random.nextInt(1000000 - 99999);
                res = stmt.executeQuery("SELECT s.id " +
                        "FROM student s");
                while (res.next()){
                    if (res.getInt("id")==id){
                        flag = true;
                    }
                }
                check = !flag;
            } while (!check);
            do {
                System.out.println("Entrer son nom: ");
                lastname = sc.nextLine();
                check = checkClass.cString(lastname);
            }while (!check);
            do {
                System.out.println("Entrer son prénom: ");
                firstname = sc.nextLine();
                check = checkClass.cString(firstname);
            }while (!check);
            nbFaculty = faculty.facultyAssignment(stmt);
            res = stmt.executeQuery("INSERT INTO student VALUES ("+ id +", '" + lastname + "', '" +
                    firstname + "', " + nbFaculty + ");");
        }catch (Exception e){System.out.println("Beug addStuden");}
    }

    public void delete(Statement stmt){
        String tempId;
        char[] cId;
        int id;
        boolean flag = false;

        try{
            do {
                do {
                    displayStudent.all(stmt);
                    System.out.println("Entrer l'id de l'étudiant que vous voulez supprimer.");
                    tempId = sc.nextLine();
                    cId = tempId.toCharArray();
                    check = checkClass.cInt(cId);
                }while (!check);
                id = Integer.parseInt(tempId);
                res = stmt.executeQuery("SELECT s.id " +
                        "FROM student s;");
                while (res.next() && !flag){
                    if (res.getInt("id")==id){
                        flag = true;
                    }
                }
                if (!flag){
                    System.out.println("Cet ID n'existe pas");
                }
            }while (!flag);
            res = stmt.executeQuery("DELETE FROM student " +
                    "WHERE id = " + id + ";");
        }catch (Exception e){System.out.println("Beug delete Student");}
    }
}
