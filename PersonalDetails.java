/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaldetails;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PersonalDetails {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare variables and constants
        char answer = 0,c;
        String month = "",fullNames,userID="",userInitials="",digitsFromID,initialsFromID,verUserID;   
        int initialsCounter = 1;
        boolean validDigit = false;
         
        fullNames = getNames();
        
        //Capitalize each letter combine with numbers and create user id
        userID = JOptionPane.showInputDialog(null, "Create your user id", "MHM123456",JOptionPane.QUESTION_MESSAGE);  
 
        //Getting the initials from full names
        userInitials += Character.toUpperCase(fullNames.charAt(0)); 
        for(int i = 1; i < fullNames.length(); i++){
            if(fullNames.charAt(i) == ' '){
                i++; 
                c = fullNames.charAt(i); 
                c = Character.toUpperCase(c); 
                userInitials += c; 
                initialsCounter =initialsCounter + 1 ;
            }
        }
        initialsFromID = userID.substring(0,initialsCounter); 
        digitsFromID = userID.substring(initialsCounter,userID.length());

        //Determining if the remaning characters are digits
        for(int j=0; j < digitsFromID.length();j++){
            if(Character.isDigit(digitsFromID.charAt(j))){
                validDigit = true; 
            }else{
                validDigit = false;
                j = digitsFromID.length();  
            }
        }
        if(userID.length() == 9)
            if(initialsFromID.equals(userInitials))
                if(validDigit == true)
                    JOptionPane.showMessageDialog(null,fullNames + "\n" +
                                                       getAge() + " YEARS OLD." + "\n" +
                                                       getGender() + "\n" +
                                                       getStatus() + "\n" +
                                                 "UserID = "+userID,"Is Valid",JOptionPane.INFORMATION_MESSAGE); 
                     
                else
                    JOptionPane.showMessageDialog(null, "The userID digits are not valid "+userID,"Digits InValid",JOptionPane.INFORMATION_MESSAGE); 
            else
                JOptionPane.showMessageDialog(null, "The initials do not match!","Invalid Initials",JOptionPane.WARNING_MESSAGE); 
        else
            JOptionPane.showMessageDialog(null, "The length of the userID is not correct!","Invalid Length",JOptionPane.WARNING_MESSAGE); 
             
    }
    public static String getNames(){
        //Get name of the user
        String name = "";
        name =JOptionPane.showInputDialog(null,"Fullnames and Surname","Manqobi Happy Mabena",JOptionPane.PLAIN_MESSAGE);
                
        return name.toUpperCase();
    }
    public static int getAge(){
        //Get age of the user 
        int age;
        String strAge= JOptionPane.showInputDialog(null,"Age");
        age = Integer.parseInt(strAge);
        
        return age;
    }
    public static char getGender(){
        //Get gender of the user
           char gender;
         gender = JOptionPane.showInputDialog(null,"Male (M) or Female (F)").toUpperCase().charAt(0);
        
        return gender;
    }
    public static String getStatus(){
        //Get marital status of the user
        String status = " ";
        char symbol;
        
        symbol = JOptionPane.showInputDialog(null,"Enter your Marital Status (S/s, M/m, D/d): ").charAt(0);
        switch(symbol){
            case 'S':
            case 's':
                status = "Single";
                break;
            case 'M':
            case 'm':
                status = "Married";
                break;
            case 'D':
            case 'd':
                status = "Divorced";
                break;
            default:
                status = "Unknown";
             
        }
        return status.toUpperCase();
    }
 
}
