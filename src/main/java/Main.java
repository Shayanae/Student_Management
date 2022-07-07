import beans.ConnectPostgreSQL;

public class Main {
    public static void main(String[] args) {
        ConnectPostgreSQL connectPostgreSQL = new ConnectPostgreSQL();
        connectPostgreSQL.connect();
    }
}
