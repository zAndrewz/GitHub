/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thrd;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Egg extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 5; i++) {
            try {
                // Приостанавливаем поток
                sleep(ChickenEgg.getTimeSleep());
                System.out.println("Яйцо");
            }catch(InterruptedException e){}
        }
    }
}

class CounterNumbers extends Thread {
    
   public void run() {
       for (int i = 0; i < 25; i++)
       {
       System.out.println(i);
           try {
               sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(CounterNumbers.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
   
}

public class ChickenEgg
{
    public static int getTimeSleep()
    {
        final Random random = new Random();
        int tm = random.nextInt(1000);
        if (tm < 10)
            tm *= 100;
        else if (tm < 100)
            tm *= 10;
        return tm;
    }
    
    public static void main(String[] args)
    {
        Egg egg = new Egg (); // Создание потока
        CounterNumbers c = new CounterNumbers();
        System.out.println("Начинаем спор : кто появился первым ?");

        c.start();
        
        egg.start(); // Запуск потока
        for(int i = 0; i < 5; i++) {
            try {
                // Приостанавливаем поток
                Thread.sleep(ChickenEgg.getTimeSleep());
                System.out.println("Курица");	
            }catch(InterruptedException e){}
        }
        if(egg.isAlive() && c.isAlive()) { // Cказало ли яйцо последнее слово?
            try{
                c.join();
                egg.join(); // Ждем, пока яйцо закончит высказываться
            }catch(InterruptedException e){}

            System.out.println("Первым появилось яйцо !!!");
        } else {
            //если оппонент уже закончил высказываться
            System.out.println("Первой появилась курица !!!");
        }
        System.out.println("Спор закончен");
    }
}
