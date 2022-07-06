package beans.services;

import java.sql.ResultSet;
import java.sql.Statement;

public class Faculty {
    ResultSet res;
    public void facultyChoice(Statement stmt, int choice){
        try{
            switch (choice){
                case 1:
                    res = stmt.executeQuery("SELECT s.id, s.lastname, s.firstname " +
                        "FROM student s " +
                        "WHERE s.faculty = 'Electronique';");
                    while (res.next()){
                        System.out.print("ID: " + res.getInt("id"));
                        System.out.print(", Nom: " + res.getString("lastname"));
                        System.out.println(", Prénom: " + res.getString("firstname"));
                    }
                    break;
                case 2:
                    res = stmt.executeQuery("SELECT s.id, s.lastname, s.firstname " +
                            "FROM student s " +
                            "WHERE s.faculty = 'Informatique';");
                    while (res.next()){
                        System.out.print("ID: " + res.getInt("id"));
                        System.out.print(", Nom: " + res.getString("lastname"));
                        System.out.println(", Prénom: " + res.getString("firstname"));
                    }
                    break;
                default:
                    System.out.println("Veuillez sélectionner l'un des chiffre proposer.");
            }

        }catch (Exception e){System.out.println("beug facultyChoice");}
    }
}
