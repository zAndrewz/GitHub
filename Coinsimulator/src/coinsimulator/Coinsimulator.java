/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinsimulator;

import java.util.Random;
import java.util.Scanner;

/**Напишите программу, которая симулирует подбрасывание одной монеты столько раз,
   сколько захочет пользователь. Программа должна записывать результаты и подсчитывать
   сколько раз выпали орел и решка.
 * @author lean
 */
public class Coinsimulator {

            /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int am = 0;
        Random random = new Random();
        Scanner amount = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("How many times you want to drop a coin? ");
        am = amount.nextInt();
        
        int result [] = new int [am];
        for (int i = 0; i < am; i++)
        result[i] = random.nextInt(2)+1;
        
        int even = 0, odd = 0;
        
        for (int i = 0; i < am; i++)
            if (result[i]%2 == 0)
                even++;
        else
                odd++;
        
        System.out.println("------------------");
        System.out.println("Let's take a look what we got!");
        System.out.println(even + " eagles " + odd + " tails");
    }
    
}
