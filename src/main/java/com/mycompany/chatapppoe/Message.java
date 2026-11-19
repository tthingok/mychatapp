package com.mycompany.chatapppoe;

import java.util.ArrayList;
import java.io.FileWriter;

public class Message {
    // PART 3 - 5 Arrays
    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();
    public static ArrayList<String> sentRecipients = new ArrayList<>();
    public static ArrayList<String> storedRecipients = new ArrayList<>();
    public static ArrayList<String> sentHashes = new ArrayList<>();
    public static ArrayList<String> storedHashes = new ArrayList<>();
    public static ArrayList<String> sentIDs = new ArrayList<>();
    public static ArrayList<String> storedIDs = new ArrayList<>();

    // This populates arrays with YOUR POE test data - do NOT hard-code in main
    public static void populateTestData() {
        sentMessages.clear(); disregardedMessages.clear(); storedMessages.clear();
        messageHashes.clear(); messageIDs.clear();
        sentRecipients.clear(); storedRecipients.clear();
        sentHashes.clear(); storedHashes.clear(); sentIDs.clear(); storedIDs.clear();

        // Message 1 - Sent
        sentMessages.add("Did you get the cake?");
        sentRecipients.add("+27834557896");
        sentHashes.add("00:0:DID YOU");
        sentIDs.add("27834557896");

        // Message 4 - Sent
        sentMessages.add("It is dinner time !");
        sentRecipients.add("0838884567");
        sentHashes.add("00:3:IT IS");
        sentIDs.add("0838884567");

        // Message 3 - Disregarded
        disregardedMessages.add("Yohoooo, I am at your gate.");

        // Message 2 - Stored
        storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        storedRecipients.add("+27838884567");
        storedHashes.add("00:1:WHE RE");
        storedIDs.add("27838884567");

        // Message 5 - Stored - same recipient as Message 2
        storedMessages.add("Ok, I am leaving without you.");
        storedRecipients.add("+27838884567");
        storedHashes.add("00:4:OK, I");
        storedIDs.add("27838884567");

        // For report - combine
        messageHashes.addAll(sentHashes); messageHashes.addAll(storedHashes);
        messageIDs.addAll(sentIDs); messageIDs.addAll(storedIDs);
    }

    public static void saveToJSON() {
        try {
            FileWriter w = new FileWriter("storedMessages.json");
            w.write("[\n");
            for (int i = 0; i < storedMessages.size(); i++) {
                w.write("  {\"recipient\":\"" + storedRecipients.get(i) + "\", \"message\":\"" + storedMessages.get(i) + "\", \"hash\":\"" + storedHashes.get(i) + "\", \"id\":\"" + storedIDs.get(i) + "\"}");
                if (i < storedMessages.size() - 1) w.write(",");
                w.write("\n");
            }
            w.write("]");
            w.close();
        } catch (Exception e) { System.out.println("Could not save: " + e.getMessage()); }
    }

    // a. Sender + Recipient of stored
    public static String displaySendersRecipients() {
        String out = "";
        for (int i = 0; i < storedMessages.size(); i++) {
            out += "Recipient: " + storedRecipients.get(i) + " | Message: " + storedMessages.get(i) + "\n";
        }
        return out;
    }

    // b. Longest
    public static String getLongestMessage() {
        String longest = "";
        for (String m : sentMessages) if (m.length() > longest.length()) longest = m;
        for (String m : storedMessages) if (m.length() > longest.length()) longest = m;
        for (String m : disregardedMessages) if (m.length() > longest.length()) longest = m;
        return longest;
    }

    // c. Search by Message ID
    public static String searchByID(String id) {
        for (int i = 0; i < sentIDs.size(); i++) if (sentIDs.get(i).equals(id)) return sentMessages.get(i);
        for (int i = 0; i < storedIDs.size(); i++) if (storedIDs.get(i).equals(id)) return storedMessages.get(i);
        return "Not found";
    }

    // d. Search by Recipient
    public static String searchByRecipient(String recipient) {
        String out = "";
        for (int i = 0; i < storedRecipients.size(); i++) {
            if (storedRecipients.get(i).equals(recipient)) out += storedMessages.get(i) + "\n";
        }
        for (int i = 0; i < sentRecipients.size(); i++) {
            if (sentRecipients.get(i).equals(recipient)) out += sentMessages.get(i) + "\n";
        }
        return out.trim();
    }

    // e. Delete by Hash
    public static String deleteByHash(String hash) {
        for (int i = 0; i < storedHashes.size(); i++) {
            if (storedHashes.get(i).equals(hash)) {
                String deleted = storedMessages.get(i);
                storedMessages.remove(i); storedRecipients.remove(i); storedHashes.remove(i); storedIDs.remove(i);
                saveToJSON();
                return "Message: \"" + deleted + "\" successfully deleted.";
            }
        }
        return "Hash not found.";
    }

    // f. Full Report
    public static String displayReport() {
        String report = "";
        for (int i = 0; i < sentMessages.size(); i++) {
            report += "Message Hash: " + sentHashes.get(i) + "\nRecipient: " + sentRecipients.get(i) + "\nMessage: " + sentMessages.get(i) + "\n---\n";
        }
        for (int i = 0; i < storedMessages.size(); i++) {
            report += "Message Hash: " + storedHashes.get(i) + "\nRecipient: " + storedRecipients.get(i) + "\nMessage: " + storedMessages.get(i) + "\n---\n";
        }
        return report;
    }
}