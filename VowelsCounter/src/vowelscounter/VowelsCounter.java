/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vowelscounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lean
 */
public class VowelsCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inline = br.readLine();
        
        // sdfjidsfasajsjanzitqpwquorpsupsdtujspaisadjistdqpkf //13
        
        Pattern p = Pattern.compile("[aeiouyAEIOUY]"); 
        Matcher m;
        
        
        int counter  = 0;
        String what = new String();
        
        for (int i = 0; i <inline.length(); i++) {
            what = inline.charAt(i) + "";
        m = p.matcher(what);
        if(m.matches())
          counter ++;
        }   
        System.out.println("Amount of vowels in this line is: " + counter);
    
    }
}
