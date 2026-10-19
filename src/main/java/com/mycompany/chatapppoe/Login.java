package com.mycompany.chatapppoe;

public class Login {
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username){
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password){
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        return password.length() >= 8 && hasUpper && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cell){
        return cell.startsWith("+27") && cell.length() == 12;
    }

    public String registerUser(String username, String password, String cell, String firstName, String lastName){
        if(!checkUserName(username)) return "Username is incorrectly formatted.";
        if(!checkPasswordComplexity(password)) return "Password does not meet complexity requirements.";
        if(!checkCellPhoneNumber(cell)) return "Cell phone number is incorrectly formatted.";
        
        this.username = username;
        this.password = password;
        this.cellNumber = cell;
        this.firstName = firstName;
        this.lastName = lastName;
        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password){
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(String username, String password){
        if(loginUser(username, password)){
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
 