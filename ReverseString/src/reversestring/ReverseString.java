/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lean
 */
public class ReverseString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String line = new String();
        String result = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        line = reader.readLine();
        
        System.out.println("You in next line: " + line);
        
        int x = line.length()-1;
        for (; x != -1 ; x--)
            result +=  line.charAt(x);
        
        System.out.println("Reversed line: " + result);
    }
    
}
