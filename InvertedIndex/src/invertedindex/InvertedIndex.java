/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lean
 */
public class InvertedIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File[] files;
        Scanner sc = new Scanner(System.in);
        ArrayList<File> result = new ArrayList<>();
        String di = "A:\\NetBeans\\NetBeansTestFiles";
        String ext = ".txt";
        String req = sc.nextLine();
        files = findFiles(di, ext);

        result = textLooker(files, di, req);
        for(File f : result)
                System.out.println("Файл: " + f.getName());
    }
    

    
         private static File[] findFiles(String dir, String ext) {
        File file = new File(dir);
        if(!file.exists()) System.out.println(dir + " папка не существует");
        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
        if(listFiles.length == 0){
            System.out.println(dir + " не содержит файлов с расширением " + ext);
        }else{
            return listFiles;
        }
        return null;
    }
 
    // Реализация интерфейса FileNameFilter
    public static class MyFileNameFilter implements FilenameFilter{
         
        private String ext;
         
        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }
 
    public static ArrayList<File> textLooker(File[] listFile, String dir, String request)
    {
        ArrayList<File> find = new ArrayList<>();
 //       boolean stop = false;
        String strLine;
 //       List<String> list = new ArrayList<>();
        BufferedReader br;
        String way = new String();
        try{
        for (File f : listFile) {
          //  System.out.println(f.getName());
          way = dir+ File.separator +f.getName();
   FileInputStream fstream = new FileInputStream(way);
   br = new BufferedReader(new InputStreamReader(fstream));
   do {
    if(br.readLine().contains(request))
        find.add(f);
   } while ((strLine = br.readLine()) != null);
        }
    }catch (IOException e){
   System.out.println("Ошибка");
    }
        return find;
    }
}