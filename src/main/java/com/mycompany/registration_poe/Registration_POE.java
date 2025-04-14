/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration_poe;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class Registration_POE {
    
    
    //PUBLIC VARIABLES TO TEMPORARILY HOLD USER INPUT DURING REGISTRATION
    public String username;
    public String password;
    public String cellphone_number;
    
    //PRIVATE VARIABLES TO STORE VALIDATED USER CREDENTIALS AFTER REGISTRATION
    private String storedusername;
    private String storedpassword;
    
    //METHOD TO CHECK USERNAME
    //CONDITIONS : MUST CONTAIN AND UNDERSCORE AND BE AT LEAST 5 CHARACTERS LONG
    public void checkusername() {
        
        if (username.contains("_") && username.length() >=5) {
            //SHOW SUCCESS MESSAGE WHEN VALID
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        } else {
            //SHOW ERROR MESSAGE AND PROMPT AGAIN IF VALID
            JOptionPane.showMessageDialog(null, "Username is incorrectly formatted! Please Ensure username contains an underscore and is at least five characters long");
            username = JOptionPane.showInputDialog("Enter Username");
            checkusername();
        }
    }
    //METHOD TO CHECK PASSWORD
    //CONDITIONS : AT LEAST 8 CHARACTERS, 1 UPPERCASE LETTER, 1 DIGIT, AND 1 SPECIAL CHARACTER.
    public boolean checkpassword() {
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        //LIST OF ALLOWED SPECIAL CHARACTERS
        String SpecialChar = "~!@#$%^&*()_+=<>?/[]{};:',.";
        
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) hasDigit = true;
            if (Character.isUpperCase(ch)) hasUppercase = true;
            if (SpecialChar.contains(String.valueOf(ch))) hasSpecialChar = true;
            
        }
        if (password.length() >=8 && hasUppercase && hasDigit && hasSpecialChar) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password is incorrectly formatted! Please ensure that password contains an Uppercase, a Digit, and a Special character");
            password = JOptionPane.showInputDialog("Please enter password");
            return checkpassword();
        }
        return password.length() >=8 && hasUppercase && hasDigit && hasSpecialChar;
    }
    //METHOD TO CHECK CELLPHONE NUMBER
    //MUST START WITH +27 AND BE FOLLOWED BY EXACTLY 9 DIGITS
    public void checkcellphone_number() {
        String cellphone_number = JOptionPane.showInputDialog("Enter cellphone number");
        
        if (cellphone_number.matches("\\+27\\d{9}")) {
            
            JOptionPane.showMessageDialog(null, "Cellphone number successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Cellphone number is incorrectly formatted! Please ensure that the number starts with +27 and is followed by nine digits");
            checkcellphone_number();
        }
                
    }
    //METHOD TO HANDLE THE REGISTRATION PROCESS
    //PROMPTS THE USER TO ENTER AND CHECK THEIR USERNAME, PASSWORD, AND CELL PHONE NUMBER
    public void RegisterUser() {
        username = JOptionPane.showInputDialog("Please enter username");
        checkusername();
        
        password = JOptionPane.showInputDialog("Please enter user password");
        checkpassword();
        
        checkcellphone_number();
        
        //SAVE VALIDATED USERNAME AND PASSWORD FOR LOGIN VERIFICATION
        storedusername = username;
        storedpassword = password;
    }
    
    //METHOD TO HANDLE USER LOGIN
    //COMPARES ENTERED CREDENTIALS WITH STORED ONES
    public void LoginUser() {
        String enteredusername = JOptionPane.showInputDialog("Enter username to Login");
            JOptionPane.showMessageDialog(null, "Username is successful!");
        String enteredpassword = JOptionPane.showInputDialog("Enter user password to Login");
            JOptionPane.showMessageDialog(null, "Password is successful!");
        
        if (enteredusername.equals(storedusername) && enteredpassword.equals(storedpassword)) {
            JOptionPane.showMessageDialog(null, "Login Sucessful! Welcome, " + enteredusername);
        } else {
            JOptionPane.showMessageDialog(null, "Username or Password is incorrect! Please try again");
            LoginUser();
        }
    }
    //MAIN METHOD TO RUN THE PROGRAM
    public static void main(String[] args) {
     Registration_POE userRegistration_POE = new Registration_POE();
     
     //START THE REGISTRATION AND LOGIN PROCESS
     userRegistration_POE.RegisterUser();     
     userRegistration_POE.LoginUser();
    }
}
