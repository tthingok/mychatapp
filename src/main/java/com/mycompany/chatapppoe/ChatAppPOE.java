package com.mycompany.chatapppoe;

import javax.swing.JOptionPane;

public class ChatAppPOE {
    public static void main(String[] args) {
        Login login = new Login();
        
        // Part 1 - Auto register Thobile for proof
        login.registerUser("Thob_", "Ch@2024!", "+27721234567", "Thobile", "Khanyeza");
        String loginResult = login.returnLoginStatus("Thob_", "Ch@2024!");
        System.out.println(loginResult);
        if(!login.loginUser("Thob_", "Ch@2024!")) return;

        // Part 2 - Message system
        int totalMessages = 0;
        String allMessages = "";
        String longestMessage = "";
        
        String numStr = JOptionPane.showInputDialog("How many messages do you want to send?");
        if(numStr == null) return;
        int numMessages = Integer.parseInt(numStr);

        for(int i=1; i<=numMessages; i++){
            String recipient = JOptionPane.showInputDialog("Enter recipient (+27...):");
            String text = JOptionPane.showInputDialog("Enter message (max 250 chars):");
            
            if(text.length() > 250){
                JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters");
                i--; continue;
            }
            
            Message msg = new Message(recipient, text, i);
            
            if(msg.checkRecipientCell() == 0){
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code.");
                i--; continue;
            }
            
            int choice = JOptionPane.showConfirmDialog(null, 
                "Message ID: " + msg.getMessageID() + "\nHash: " + msg.getHash() + "\n\nSend message?");
            
            if(choice == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Message successfully sent.");
                allMessages += "\n" + msg.getHash() + " - " + msg.getRecipient() + ": " + msg.getMessage();
                totalMessages++;
                if(text.length() > longestMessage.length()) longestMessage = text;
            } else if(choice == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Press 0 to delete message.");
            } else {
                JOptionPane.showMessageDialog(null, "Message stored to send later.");
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessages + "\nAll messages:\n" + allMessages);
    }
}
