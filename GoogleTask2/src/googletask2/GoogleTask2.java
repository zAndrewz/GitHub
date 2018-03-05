/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googletask2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lean
 */
public class GoogleTask2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String comd = "3[abc]4[ab]c";
        String buf = new String();
        String result = "";
        Pattern p = Pattern.compile("[0-9]");
        Matcher m; 
        ArrayList <Integer> numbers = new ArrayList();
        String [] strings;
        
        
        strings = comd.split("]");
        
        
        // разбиваем на строки, находим номера, убираем квадратные скобки из строк
        for (int j = 0; j < strings.length; j++)
        for (int i = 0; i < strings[j].length(); i++)
        {
        buf = strings[j].substring(i, i+1);
        m = p.matcher(buf);
        if (m.matches())
        {
         numbers.add(Integer.parseInt(buf));
         strings[j] = strings[j].substring(1);
         strings[j] = strings[j].replace("[", "");
        }
        }
        
        for (int a = 0; a < numbers.size(); a++)
            for (int b = 0; b < numbers.get(a); b++)
            {
                result += strings[a];
            }
        
        if (strings.length > numbers.size())
        for (int i = numbers.size(); i < strings.length; i++)
        result += strings[i];
        
         System.out.println(result);
        
//        for (String c : strings)
//            System.out.println(c);
//        
//        System.out.println(numbers);

    }
    
}
