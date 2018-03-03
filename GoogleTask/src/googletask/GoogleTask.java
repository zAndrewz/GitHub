/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googletask;

/**
 *
 * @author lean
 */
public class GoogleTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
        int check = 1;
        int res = 0;
        int result = 0;
        
        for ( int i = 0; i < arr.length-1; i++)
        {
            //Элемент больше правого
            if (arr[i] > arr[i+1])
                // какая длина "долины" начиная с элемента больше
                for(int a = i; a < arr.length;)
                    // измеряем длину,
                    if (arr[a] > arr[a+check])
                    {
                        res += arr[a] - arr[a+check];
                        if (1+a+check == arr.length)
                        {
                            arr[a] = arr[a]-1;
                            res = 0;
                            check = 0;
                        }
                       check++; 
                    }
                    else
                    {
                        i = a+check-1;
                        a = arr.length;
                        check = 1;
                        result += res;
                        res = 0;
                        
                    }
            System.out.println(result);
        }
    }
    
}