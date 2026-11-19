package com.mycompany.chatapppoe;

public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && !password.equals(password.toLowerCase())
            && password.matches(".*\\d.*")
            && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    public boolean checkCellPhoneNumber(String cell) {
        return cell.startsWith("+") && cell.length() <= 13;
    }

    public String registerUser(String username, String password, String first, String last) {
        if (!checkUserName(username)) return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        if (!checkPasswordComplexity(password)) return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.firstName = first;
        this.lastName = last;
        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        else return "Username or password incorrect, please try again.";
    }
}