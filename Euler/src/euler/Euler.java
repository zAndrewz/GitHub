/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lean
 */
public class Euler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int amount = Integer.parseInt(line);
        
        long res = Fibbonaci(amount);
        
        System.out.println(res);
//        
//        for (int i = 0; i < 1000; i++){
//        if (i % 3 == 0 || i % 5 ==0)
//            res += i;
//        System.out.println(res);
//    }
//        System.out.println(res);
//    }

}
    
    
    //   0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610
    static long Fibbonaci (int x)
    {
        if (x == 1) return 0;
        if (x == 2) return 1;
        if (x == 3) return 1;
        
        long sum = 0;
        int temp = 0;
        int a = 1;
        int b = 1;
        
        for (int i = 0; temp < 4000000; i++) {
        temp = a + b;
        a = b;
        b = temp;
        if (temp % 2 == 0)
          sum = sum + temp;
        }
        
        
//        if(x == 1) return 1;
//        if(x == 2) return 1;
//        return Fibbonaci(x-1) + Fibbonaci(x-2);
        return sum;
    }
}