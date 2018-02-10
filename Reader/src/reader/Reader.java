/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lean
 */
public class Reader {
// static ArrayList<String> CityHub = new ArrayList<>();
 //static int CityCount =0;
    /**
     * @param args the command line arguments
     */
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        List<String> buffer = new ArrayList<>();
        List<POJO> buf = new ArrayList<>();
        buffer = inLine();
  //      System.out.println(buffer);
        String boa;
        boa = checker(buffer);
        buf = values (boa);
    }
    
    //считываем файл загружаем все в буфер
    static List<String> inLine() throws FileNotFoundException
    {
        boolean stop = false;
        String strLine;
        List<String> list = new ArrayList<>();
        
        do{
        try{
   FileInputStream fstream = new FileInputStream("A:\\NetBeansProject\\txt.txt");
   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
   
   while ((strLine = br.readLine()) != null){
      list.add(strLine);
   }
   if ((strLine = br.readLine()) == null)
   stop = true;
    }catch (IOException e){
   System.out.println("Ошибка");
    }
        }while (!stop);
        return list;
    }
   
    
    static String checker(List<String> buffer) {
        String str = buffer.toString();
        int counter =0;
        
        // считаем линии
        for(int i = 0; i <str.length(); i++)
        if (str.charAt(i) == ' ' || i == 0 || i==str.length()-1) {
            counter ++; }
           int [] newLine = new int[counter]; 
           counter = 0;
           
        for(int i = 0; i <str.length(); i++)
        if (str.charAt(i) == ' ' || i == 0 || i == str.length()-1) {
            newLine[counter] = i;
            counter++;}  // 5
        
        // заполняем массив линиями
        String[] buffy = new String[counter];
        
        for (int j = 0; j < counter-1; j++)
        {
            buffy[j] = str.substring(newLine[j]+1, newLine[j+1]);
            if (j == counter-1)
            buffy[j] = str.substring(newLine[j]+1);
        }
        
        //length = 5

        // считаем знаки ; и их индексы
        int cnuter = 0;
        for(int i = 0; i <str.length(); i++)
        if (str.charAt(i) == ';' || str.charAt(i) == ' ' || str.charAt(i) == ']') {
            cnuter ++; }
           int [] newChar = new int[cnuter]; 
           cnuter = 0;
           
        for(int i = 0; i <str.length(); i++)
        if (str.charAt(i) == ';' || str.charAt(i) == ' ' || str.charAt(i) == ']') {
            newChar[cnuter] = i;
            cnuter++;}
        // 8

        int[][] c = new int [counter][2]; 
        
        // заполняем номерами индексов знаков ;
        int ch = 0;
        for (int q = 0; q <counter-1; q++)
            for (int w = 0; w < 2; w++) {
                c[q][w] = newChar[ch]; ch++;} 
 
        String[][] lines= new String[buffy.length-1][3];
            
        int a = 0;
        int flag = 0;
        
  
        for (int u = 0; u < buffy.length-1; u++)
        for (int i =0; i < 3; i++)
        {
            if (i == 2)
            {
                if (a == newChar.length-1)
            lines[u][i] = str.substring(newChar[a-1]+1, newChar[a]);
                else
            lines[u][i] = str.substring(newChar[a-1]+1,newChar[a]-1);   
            a++;
            }

             if (flag == 1 && i == 0)
            {
            lines[u][i] = str.substring(newChar[a-1]+1, newChar[a]);
            a++;
            }
            if (flag == 0 && i == 0) {
            lines[u][i] = str.substring(1, newChar[a]);
            a++;
            flag++;
            }
            if (i == 1)
            {
            lines[u][i] = str.substring(newChar[a]-1, newChar[a]);
            a++;
            }
        }
        
  
         Pattern letter = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$");
         Pattern numbers = Pattern.compile("^[0-9]+$");
        Matcher letters, number1, number2;
 
        String num1 = "1", num2 = "2";
        String ne = "eqeqe";
        letters = letter.matcher(ne);
        number1 = numbers.matcher(num1);
        number2 = numbers.matcher(num2);
        
        for (int u = 0; u < buffy.length-1; u++)
        for (int i =0; i < 3; i++)
        {
            if (i == 0)
         number1 = numbers.matcher(lines[u][i]);
            if (i == 1)
        number2 = numbers.matcher(lines[u][i]);
            if (i == 2)
        letters = letter.matcher(lines[u][i]); 
            if (!number1.matches() || !number2.matches() || !letters.matches()){
                lines[u][0] = "";
                lines[u][1] = "";
                lines[u][2] = "";
            }
        }
  
              String result = "";
              
               for (int u = 0; u < buffy.length-1; u++)
        for (int i =0; i < 3; i++)
        {
            if (i == 0)
            if (lines[u][i] != "")
            result = result + lines[u][i] + ";";
            if (i == 1)
            if (lines[u][i] != "")
            result = result + lines[u][i] + ";";
            if (i == 2 && u != buffy.length-1)
            if (lines[u][i] != ""){
            result = result + lines[u][i] + ", ";
            }
        }
               String satr = "[" + result.substring(0,result.length()-2) + "]";
               
     //          System.out.println(satr);
              
        return satr;
    }
    
    //разбиваем буфер на линии(объекты класса POJO) 
    // разбиваем на строки, считаем их и создаем объекты класса
    static List<POJO> values(String x)
    {    
        String str = x;
        POJO e = new POJO();
        List<POJO> listP = new ArrayList<>();
        int counter =0;
        
        for(int i = 0; i <str.length(); i++)
        if (str.charAt(i) == '[' || str.charAt(i) == ' ' || str.charAt(i) == ']') {
            counter ++; }
           int [] newLine = new int[counter]; counter = 0;
        
           
        for(int i = 0; i <str.length(); i++)
        if (str.charAt(i) == ' ' || str.charAt(i) == ']') {
            newLine[counter] = i;
            counter++;}
        
        int start = 0;
        int end;
        String buff = new String();
        int i = 0;
        do 
        {  
          end = newLine[i];
          
          buff = str.substring(start, end);
          e = setter(start, end, buff);
          listP.add(i,e);
          i++;
          start = newLine[i-1];       
        }while (i < counter);
        
 
        counter(listP);
        
        return listP;            
    }
    
    static public POJO setter(int start, int end, String str)
    {
        int a[] = divi(str);  // значения всех ;
        POJO e = new POJO();
        int user_id, count;
        String city;
        String str1 = str;
        int divider = str1.indexOf(";") ;
        String buff = str1.substring(divider+1);
        int divider1 = buff.indexOf(";");

        int start1 = 0;
        int end1 = str1.length();
        buff = str.substring(start1+1,divider);
        user_id = Integer.parseInt(buff);
        count = Integer.parseInt(str.substring(divider+1, divider+2));
        city = str.substring(divider+2+divider1, end1);
        
        int sep = city.indexOf(",");
        if (city.contains(","))
            city = city.substring(0,sep);
        city = city.trim();
        
        e.user_id = user_id;
        e.count = count;
        e.country = city;
        return e;
    }
    
    static public int[] divi(String s)
    {
        ArrayList<Integer> ar = new ArrayList<>();
        char ch = ';';
        for(int i = 0; i<s.length(); i++)
        {
        if (ch == s.charAt(i))
            ar.add(i);
        }
        int [] z = new int [ar.size()];
        for (int y = 0; y < z.length; y++)
             z[y] = ar.get(y);
        return z;
    }
    
    static public void counter(List<POJO> obj)
    {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
        List <POJO> newAr = new ArrayList<>();
        List <String> uniqueCountries = new ArrayList<>();
        List <String> buffer = new ArrayList<>();
        List <Integer> lCount = new ArrayList<>();
        List <Integer> lId = new ArrayList<>();
        List <Integer> uniqId = new ArrayList<>();
        for (int b = 0; b < obj.size() ; b ++)
        {
        newAr.add(obj.get(b));
        }
    
        for (int i = 0; i < obj.size(); i++){
            buffer.add(obj.get(i).getCountry());
            lCount.add(obj.get(i).getCount());
            lId.add(obj.get(i).getUser_id());
                    }
        
        Integer item; // counter
        // countries
        for (Iterator<String> it = buffer.iterator(); it.hasNext();) {
            String wrd = it.next();
            item = hm.get(wrd);
            if (item == null) hm.put(wrd, 1); // если нет в списке то добавить со значением 1
            else  hm.put(wrd, item + 1);
        }
        
                for (Map.Entry entry : hm.entrySet()) {
            uniqueCountries.add(entry.getKey().toString());
        }
        
        
        // unique ID 
                Integer Ids; // counter
                
        for (Iterator<Integer> it = lId.iterator(); it.hasNext();) {
            Integer wrd = it.next();
            Ids = hm1.get(wrd);
            if (Ids == null) 
            hm1.put(wrd, 1); // если нет в списке то добавить со значением 1
            else  hm1.put(wrd, Ids + 1);
        }
        
                for (Map.Entry entry : hm1.entrySet()) {
            uniqId.add(Integer.parseInt(entry.getKey().toString()));
        }
                int amount[] = new int[uniqueCountries.size()];
                int x = 0;
                int acounter = 1;
                int fla = 0;
                for (int j = 0; j <uniqueCountries.size(); j++) {
                  for (int i = 0; i <newAr.size(); i++)
         if (uniqueCountries.get(j).contains(newAr.get(i).getCountry()))
         {
             if (uniqId.get(x) == newAr.get(i).getUser_id())
             amount[x] = acounter++;
             if (fla < j)
             {
                 fla++;
                 x++;
                 acounter = 0;
             }
         }  
                }
         
              // уникальные страны к ID   
        
        String [] ido = new String[lId.size()];
        String [] odo = new String[buffer.size()];
                
        for (int xy = 0; xy < lId.size(); xy++)
            ido[xy] = lId.get(xy).toString();
        
        for (int yx = 0; yx < buffer.size(); yx++)
            odo[yx] = buffer.get(yx);
        
        String[][] arr = new String[newAr.size()][newAr.size()];
        
                for (int p = 0; p < 2; p++)
                 for (int k = 0; k < newAr.size(); k++){
                     arr[k][p] = odo[k];
                     if (p == 1)
                     arr[k][p] = ido[k];
                  } 
        Map<String, Set<String>> map = new HashMap<>();
 
        for (String[] strings : arr) {
            String key = strings[0];
            Set<String> set;
            if (map.containsKey(key)) {
                set = map.get(key);
            } else {
                set = new HashSet<>();
                map.put(key, set);
            }
            set.add(strings[1]);
        }
        // уникальные страны
        int Q = newAr.size();
        int abs = 0; 
        int sum[] = new int[uniqueCountries.size()]; 
        do{
        for ( int i = 0; i < newAr.size(); i++ ) {
        if ( uniqueCountries.get(abs).equals(newAr.get(i).getCountry())) 
        sum[abs] = sum[abs] + newAr.get(i).getCount();
        if (Q-1 == i)
        abs++;
        }
        }while (abs!=uniqueCountries.size());
        
         int repeats[] = new int[uniqueCountries.size()];
         for (int q = 0; q <repeats.length; q++)
             repeats[q] = 0;

         int []o = new int[uniqueCountries.size()];
         int i = 0;
         for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            o [i] = entry.getValue().size();
            i++;
        }
         
         
        for(int tw = 0; tw< uniqueCountries.size(); tw++){
            System.out.println("-------------------------");
            System.out.print(uniqueCountries.get(tw) + " ; ");
            System.out.print(sum[tw] + " ; ");
            System.out.println(o[tw]);
        }
     }
    }