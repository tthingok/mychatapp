package com.mycompany.chatapppoe;

public class Login {
    String username, password, firstName, lastName;
    public Login(String fn, String ln){ firstName=fn; lastName=ln; }
    public boolean checkUserName(String u){ return u.contains("_") && u.length()<=5; }
    public boolean checkPasswordComplexity(String p){ return p.length()>=8 && p.matches(".*[A-Z].*") && p.matches(".*[0-9].*") && p.matches(".*[^a-zA-Z0-9].*"); }
    public boolean checkCellPhoneNumber(String c){ return c.matches("^\\+27\\d{9}$"); }
    public String registerUser(String u, String p, String c){
        if(!checkUserName(u)) return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        if(!checkPasswordComplexity(p)) return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        if(!checkCellPhoneNumber(c)) return "Cell phone number is incorrectly formatted or does not contain an international code.";
        username=u; password=p;
        return "User successfully registered.";
    }
    public boolean loginUser(String u, String p){ return u.equals(username) && p.equals(password); }
    public String returnLoginStatus(boolean ok){
        if(ok) return "Welcome "+firstName+" "+lastName+" it is great to see you again.";
        else return "Username or password incorrect, please try again.";
    }
}
 