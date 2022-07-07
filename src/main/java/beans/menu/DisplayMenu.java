package beans.menu;

public class DisplayMenu {
    public void home(){
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                                           *");
        System.out.println("*     1. Afficher les étudiants d'une filière.              *");
        System.out.println("*                                                           *");
        System.out.println("*     2. Afficher tous les étudiants.                       *");
        System.out.println("*                                                           *");
        System.out.println("*     3. Modifier le nom et/ou le prénom d'un étudiant.     *");
        System.out.println("*                                                           *");
        System.out.println("*     4. Ajouter un nouvelle étudiant.                      *");
        System.out.println("*                                                           *");
        System.out.println("*     5. Supprimer un étudiant.                             *");
        System.out.println("*                                                           *");
        System.out.println("*     6. Quitter.                                           *");
        System.out.println("*                                                           *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println("Entrez votre choix: ");
    }
    public void changeInfo(){
        System.out.println("Que voulez vous modifiez?");
        System.out.println();
        System.out.println("* * * * * * * * * * * * *");
        System.out.println("*                       *");
        System.out.println("*     1. Le nom.        *");
        System.out.println("*                       *");
        System.out.println("*     2. Le prénom.     *");
        System.out.println("*                       *");
        System.out.println("*     3. Les deux.      *");
        System.out.println("*                       *");
        System.out.println("* * * * * * * * * * * * *");
        System.out.println();
        System.out.println("Entrez votre choix: ");
    }
}
