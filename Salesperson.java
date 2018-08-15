/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesperson;

import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class Salesperson {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        /*
        * User input as well as application output. Also passes user input to 
        * the Money class
        *
        */
        
        Money money = new Money();                                                              
        
        System.out.print("Enter Sales Amount: $"); 
        Scanner input = new Scanner(System.in);                                                 
        double sales = input.nextDouble();                                                      
        System.out.println("Your annual compensation is: $" + money.calculateCommission(sales));
        
        money.commissionTable(sales);
    }
    
}
