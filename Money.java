/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesperson;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 *
 * @author Kevin
 */
public class Money{        
           
        // Set all global variables the Money class will need                            
        double salary = 50000.00;                       
        double com = 0.05;
        // Variable allows us to reset the com if needed during execution
        double comReset = com; 
        
        double salesTarget = 100000.00;
        double salesThreshold = 0.80;
        double salesIncentive = salesTarget * salesThreshold;
        double accelFactor = 0.015;
        
        // Formating method for the American Dollar
        private String dollarFormat(double format){
            DecimalFormat fmat = new DecimalFormat("#.##"); 
                fmat.setRoundingMode(RoundingMode.FLOOR);   
                String formatTotal = fmat.format(format); 
            
            return formatTotal;
        }
        // Method used to calculate commission
        public String calculateCommission (double input){
            double sales = input; 
            String total;
            
            if (sales <= salesTarget && sales >= salesIncentive){
                double subTotal = sales * com + salary;
                total = dollarFormat(subTotal);
                
            }else if (sales > salesTarget){
                com = com + accelFactor;
                double subTotal = sales * com + salary;
                total = dollarFormat(subTotal);
                
            }else{
                //Returns base salary if commission threshold is not met
                total = dollarFormat(salary); 
            }
            
            return total;
        };  
        //Method used to create the commissions table
        public void commissionTable(double input){                      
            
            double tablePercent = 1.50;
            double tableMax = tablePercent * input;
            double tableValue = input;
            int tableRate = 5000;
           
            
            while (tableValue <= tableMax){               
                tableValue = tableValue + tableRate;
                com = comReset;                
                System.out.println("If you would have sold "+ dollarFormat(tableValue) +" you could have made " + calculateCommission(tableValue));
            };
        };
}

