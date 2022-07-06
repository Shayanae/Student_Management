package beans;

public class Check {
    static boolean check;
    static int i;
    public  boolean cString(String value){
            i=0;
            check=true;
            while (i<value.length()&&check){
                check= !Character.isDigit(value.charAt(i));
                i++;
            }
            if (!check){
                System.out.println("Veuillez entrer uniquement des lettres");
            }
        return check;
    }

    public  boolean cInt(char[] value){
        if (value.length>9) {
            System.out.println("Veuillez entrer uniquement l'un des chiffres proposer.");
            check=false;
        }else if (value.length==0) {
            System.out.println("Veuillez entrer un chiffre avant d'appuyez sur entrer");
            check = false;
        }else {
            i = 0;
            check = true;
            while (i<value.length&&check) {
                if (!Character.isDigit(value[i])){
                    System.out.println("Veuillez entrer uniquement un ou des nombres");
                    check=false;
                }
                i++;
            }
        }
        return check;
    }

}
