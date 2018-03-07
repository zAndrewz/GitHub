/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googletask3;

import java.util.Arrays;
import java.util.Random;
import sun.rmi.runtime.Log;

/**
 *
 * @author lean
 */
public class GoogleTask3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int candies [] = {1,1,2,2,3,3};
        Solution sol = new Solution();
        System.out.println(sol.distributeCandies(candies));
    }
}
