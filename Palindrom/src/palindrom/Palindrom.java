/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lean
 */
public class Palindrom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String reverse = new String();
        
        for (int i = line.length()-1; i != -1; i--)
            reverse += line.charAt(i) + "";
        
        if (line.equals(reverse))
        System.out.println("This is palindrom");
        else
        System.out.println("This is not a palindrom");
        
//        System.out.println("normal line is " + line);
//        System.out.println("reverse line is " + reverse);
        
        
    }
    
}
