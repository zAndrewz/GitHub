/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Scanner;

/**
 *
 * @author lean
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {7, 9, 2, 6, 0, 5, 3, 1};
 //       Scanner enter = new Scanner(System.in);
     //   int arr[] = {7, 9, 2, 6, 0, 5, 3, 1};
/* BUBBLE        
        int buf = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
            }
        }
BUBBLE */
        
        // СЛИЯНИЕМ
        int[] a1 = new int[] {21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
    int[] a2 = new int[] {10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
    int[] a3 = new int[a1.length + a2.length];

    int i=0, j=0;
    for (int k=0; k<a3.length; k++) {

        if (i > a1.length-1) {
            int a = a2[j];
            a3[k] = a;
            j++;
        }
        else if (j > a2.length-1) {
            int a = a1[i];
            a3[k] = a;
            i++;
        }
        else if (a1[i] < a2[j]) {
            int a = a1[i]; 
            a3[k] = a;
            i++;
        }
        else {
            int b = a2[j];
            a3[k] = b;
            j++;
        }
    }
        for (int u : a3)
        System.out.println(u);
        }
    
}