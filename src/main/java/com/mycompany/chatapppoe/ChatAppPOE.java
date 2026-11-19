package com.mycompany.chatapppoe;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ChatAppPOE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // Part 1 - Login
        String reg = login.registerUser("kyl_1", "Ch&&sec@ke99", "Thobile", "Khanyeza");
        System.out.println(reg);
        boolean ok = login.loginUser("kyl_1", "Ch&&sec@ke99");
        System.out.println(login.returnLoginStatus(ok));
        if (!ok) return;

        // Part 3 - Populate arrays with test data
        Message.populateTestData();

        // Part 2 + 3 - Main Menu
        while (true) {
            System.out.println("\n--- QuickChat ---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Stored Messages");
            System.out.println("4. Quit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                JOptionPane.showMessageDialog(null, "Send Messages - use your Part 2 flow here. For POE demo, test data is already populated.");
            } else if (choice.equals("2")) {
                System.out.println(Message.displayReport());
            } else if (choice.equals("3")) {
                System.out.println("a. Sender & Recipient");
                System.out.println("b. Longest Message");
                System.out.println("c. Search by Message ID");
                System.out.println("d. Search by Recipient");
                System.out.println("e. Delete by Hash");
                System.out.println("f. Full Report");
                System.out.print("Choose a-f: ");
                String sub = scanner.nextLine();
                if (sub.equalsIgnoreCase("a")) System.out.println(Message.displaySendersRecipients());
                else if (sub.equalsIgnoreCase("b")) System.out.println("Longest: " + Message.getLongestMessage());
                else if (sub.equalsIgnoreCase("c")) { System.out.print("Enter Message ID: "); System.out.println(Message.searchByID(scanner.nextLine())); }
                else if (sub.equalsIgnoreCase("d")) { System.out.print("Enter Recipient: "); System.out.println(Message.searchByRecipient(scanner.nextLine())); }
                else if (sub.equalsIgnoreCase("e")) { System.out.print("Enter Hash: "); System.out.println(Message.deleteByHash(scanner.nextLine())); }
                else if (sub.equalsIgnoreCase("f")) System.out.println(Message.displayReport());
            } else if (choice.equals("4")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}