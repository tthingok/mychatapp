package com.mycompany.chatapppoe;
import java.util.Scanner;

public class ChatAppPOE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String fn = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String ln = sc.nextLine();
        Login login = new Login(fn, ln);

        System.out.print("Enter Username (use kyl_1): ");
        String u = sc.nextLine();
        System.out.print("Enter Password (use Ch&&sec@ke99): ");
        String p = sc.nextLine();
        System.out.print("Enter Cell (use +27838968976): ");
        String c = sc.nextLine();

        String res = login.registerUser(u, p, c);
        System.out.println(res);
        if (!res.contains("successfully")) return;

        System.out.print("LOGIN Username: ");
        String lu = sc.nextLine();
        System.out.print("LOGIN Password: ");
        String lp = sc.nextLine();
        System.out.println(login.returnLoginStatus(login.loginUser(lu, lp)));
    }
}  
  