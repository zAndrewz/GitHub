/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss.reader;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple example, used on the jsoup website.
 */
public class RSSReader {
    public static void main(String[] args) throws IOException {
 
        System.out.println(readRSS("https://news.yandex.ru/computers.rss"));
}
    public static String readRSS(String url) throws MalformedURLException, IOException
    {
        try{
            
        URL rssUrl = new URL(url);
        BufferedReader in = new BufferedReader (new InputStreamReader(rssUrl.openStream()));
        String sourceCode = "";
        String line;
        while((line = in.readLine())!= null)
        {
            if ( line.contains("<title>")) {
                int firstPos = line.indexOf("<title>");
                String temp = line.substring(firstPos);
                temp = temp.replace("<title>", "");
                int lastPos = temp.indexOf("</title>");
                temp = temp.substring(0, lastPos);
                sourceCode += temp+"\n";
            }
        }
        
        in.close();
        return sourceCode;
    }
        catch(MalformedURLException ue)
        {
            System.out.println("Malformed URL");
        }
        catch(IOException ioe) {
            System.out.println("Something went wrong");
        }
        return null;
        }
        
}
