import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String fName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lName = sc.nextLine();

        Login login = new Login(fName, lName);

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter SA cell number (+27...): ");
        String cell = sc.nextLine();

        String regResult = login.registerUser(username, password, cell);
        System.out.println(regResult);

        if (regResult.contains("successfully captured")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter username: ");
            String uLogin = sc.nextLine();
            System.out.print("Enter password: ");
            String pLogin = sc.nextLine();
            System.out.println(login.returnLoginStatus(uLogin, pLogin));
        }
    }
}
