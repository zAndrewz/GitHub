/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lean
 */
public class Study {
    
	public static void main(String[] args) {
            System.out.println("Enter a number less than a million: ");
            Scanner number = new Scanner(System.in);
            String num = "";
            while (num != "s")
            {
            num = number.nextLine();
            howmanynumbers (num);
            };
            
	}
        
        static void howmanynumbers(String x)
        {
            int counter = 0;
            for (int z = 0; z <= x.length()-1; z++)
            counter++;
            //System.out.println(counter);
            word(counter, x);
        }
        
        static void word(int numb, String num)
        {
            String answer = "";
           if ( numb == 1)
           answer = numbers(num);
           System.out.println(answer);
           if ( numb == 2){
           answer = wordsbiggerten(num);
           System.out.println(answer);
           }
           if (numb == 3)
           System.out.println(numbers(num.substring(0, 1)) + " hundred " + wordsbiggerten(num.substring(1)));
           if (numb == 4)
           System.out.println(numbers(num.substring(0,1)) + " thousand " + numbers(num.substring(1,2)) + " hundred " + wordsbiggerten(num.substring(2)));
           if (numb == 5){
           answer = wordsbiggerten(num.substring(0,2)) + " thousand " + numbers(num.substring(2,3)) + " hundreds " + wordsbiggerten(num.substring(3));
           System.out.println(answer);
           }
           if (numb == 6)
           {
           answer = numbers(num.substring(0,1)) + " hundred " + wordsbiggerten(num.substring(1,3)) + " thousands " + numbers(num.substring(3,4)) + " hundred " + wordsbiggerten(num.substring(4));
           System.out.println(answer);
           }
           if (numb > 6 || numb < 1)
           System.out.println("Wrong!");
        }
           
        
        static String numbers(String numbers)
        {
            String n = "";
            for(int a = 0; a < numbers.length(); a++)
            n = words(numbers.charAt(a)+"");
            return n;
        }
        
        static String words(String x)
        {
            int caser = Integer.parseInt(x);
            switch(caser)
            {
                case 1: return "one";
                case 2: return "two";
                case 3: return "three";
                case 4: return "four";
                case 5: return "five";
                case 6: return "six";
                case 7: return "seven";
                case 8: return "eight";
                case 9: return "nine";
            }
            return "";
        }
        
        static String wordsbiggerten(String x)
        {
            boolean trigger = true;
            int caser = Integer.parseInt(x);
            if (caser <= 19 && caser >=10){
                caser = Integer.parseInt(x);
            trigger = false;}
            if (caser >= 20 && caser <= 29 && trigger) {
                caser = 20; 
                trigger = false;}
            if (caser >= 30 && caser <= 39 && trigger){
                caser = 30; 
                trigger = false;}
            if (caser >= 40 && caser <= 49 && trigger){
                caser = 40;
                trigger = false;}
            if (caser >= 50 && caser <= 59 && trigger){
                caser = 50;
                trigger = false;}
            if (caser >= 60 && caser <= 69 && trigger){
                caser = 60;
                trigger = false;}
            if (caser >= 70 && caser <= 79 && trigger){
                caser = 70;
                trigger = false;}
            if (caser >= 80 && caser <= 89 && trigger){
                caser = 80;
                trigger = false;}
            if (caser >= 90 && caser <= 99 && trigger)
                caser = 90;
            
            switch(caser)
            {
                case 10: return "ten";
                case 11: return "eleven";
                case 12: return "twelve";
                case 13: return "thirteen";
                case 14: return "fourteen";
                case 15: return "fiveteen";
                case 16: return "sixteen";
                case 17: return "seventeen";
                case 18: return "eighteen";
                case 19: return "nineteen";
                case 20: return "twenty" + words(x.substring(1));
                case 30: return "thirty" + words(x.substring(1));
                case 40: return "fourty" + words(x.substring(1));
                case 50: return "fivety" + words(x.substring(1));
                case 60: return "sixty" + words(x.substring(1));
                case 70: return "seventy" + words(x.substring(1));
                case 80: return "eighty" + words(x.substring(1));
                case 90: return "ninety" + words(x.substring(1));
            }
            return "";
        }
}