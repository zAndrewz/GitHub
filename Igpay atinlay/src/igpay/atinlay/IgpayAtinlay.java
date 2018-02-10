/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igpay.atinlay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lean
 */
public class IgpayAtinlay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String [] lines;
        lines = input.split(" ");
        
        // Eagle West Coast East North South Arab Chinese Russian Belong Approach
            
        
        Pattern p = Pattern.compile("^(?i:[aeiouyAEIOUY]).*"); 
        Pattern no = Pattern.compile("^(?i:[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]).*"); 
        Matcher m;
        String s = new String();
    //    for (String s : lines) {
        for (int i = 0; i < lines.length; i++) {
            s = lines[i];
        m = no.matcher(s); 
 //       System.out.println(m.matches());
        if (m.matches())
           lines[i] = lines[i].substring(1) + lines[i].charAt(0) + "ay";
        }
      
          
        for (String a : lines) {
       System.out.print(a.toLowerCase() + " ");
    }
    
}
}
