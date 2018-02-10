/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mess;

import java.util.Scanner;


/**
 *
 * @author lean
 */
public class Mess {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number of your credit card to validate ");
        String x = s.nextLine();
        System.out.println(func(x));
            
    }
    // 4561261212345464
    /*
    */
    static boolean func (String card){
        int number[] = new int[card.length()];
        int sum = 0;
        for (int x = 0; x<= card.length()-1; x++)
        {
            char a = card.charAt(x);
            number [x] = Integer.parseInt(a + "");
        }
        for (int i = 0; i <= number.length-1;  i++)
        {
            if ( i%2 == 0 || i == 0 ){
            number[i] = number[i]*2;
            //System.out.println("divide " + number[i]);
            if (number[i]> 9)
              number[i] = number[i]-9;
            //System.out.println("minus " + number[i]);
            }
            sum += number[i];
            // System.out.println("sum " + sum);
            }
        if(sum%10 == 0)
                return true;
            else
                return false;
}
}