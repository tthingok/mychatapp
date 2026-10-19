package com.mycompany.chatapppoe;

import java.util.Random;

public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private String hash;
    private int num;

    public Message(String recipient, String message, int num) {
        this.recipient = recipient;
        this.message = message;
        this.num = num;
        this.messageID = generateID();
        this.hash = createMessageHash();
    }

    private String generateID() {
        Random r = new Random();
        long id = 1000000000L + (long)(r.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public int checkRecipientCell() {
        if(recipient.startsWith("+") && recipient.length() <= 13 && recipient.length() >= 10) return 1;
        return 0;
    }

    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String first = words.length > 0 ? words[0] : "NO";
        String last = words.length > 1 ? words[words.length-1] : first;
        return (messageID.substring(0,2) + ":" + num + ":" + first + last).toUpperCase();
    }

    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public String getHash() { return hash; }
}
