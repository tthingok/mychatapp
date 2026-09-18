public class Login {
    private String username;
    private String password;
    private final String firstName;
    private final String lastName;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Check username contains underscore and <=5 chars
    public boolean checkUserName(String username) {
        this.username = username;
        return username.contains("_") && username.length() <= 5;
    }

    // Check password: 8+ chars, capital, number, special char
    public boolean checkPasswordComplexity(String password) {
        this.password = password;
        return password.length() >= 8 &&
               password.matches(".[A-Z].") &&
               password.matches(".[0-9].") &&
               password.matches(".[!@#$%^&()_+\\-={}\\[\\]|;:'\",.<>/?].*");
    }

    // Check cell: international code, e.g. +27838968976
    // Reference: https://www.regular-expressions.info/
    public boolean checkCellPhoneNumber(String cellNumber) {
        String regex = "^\\+27\\d{9}$"; // SA format +27 + 9 digits
        return cellNumber.matches(regex);
    }

    public String registerUser(String username, String password, String cell) {
        boolean u = checkUserName(username);
        boolean p = checkPasswordComplexity(password);
        boolean c = checkCellPhoneNumber(cell);

        if (!u) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!p) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!c) {
            return "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + "," + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}