package beans;


import beans.menu.MenuManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectPostgreSQL {
    MenuManagement menuManagement = new MenuManagement();
    public void connect(){
        try{
            // étape 1: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Student_Management", "postgres", "");

            // étape 2: créer l'objet statement
            Statement stmt = conn.createStatement();



            // étape 3: exécuter la requête

            menuManagement.homeManagement(stmt);

            // étape 4: fermez l'objet de connexion
            conn.close();
        }catch (Exception e){System.out.println("beug Connect");}
    }

}
