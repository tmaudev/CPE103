/* Lab 7: Complete Binary Trees
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 16, 2013
 */

import java.lang.Math;

public class TreeWork<T extends Comparable<? super T>>
{
   public static <T extends Comparable<? super T>> boolean isHeap(T[] arr,int N)
   {
      for(int i = 0; i < (N-1)/2; i++)
      {
         if(i*2+2 < N)
         {
            if(arr[i].compareTo(arr[i*2+1]) > 0)
            {
               return false;
            }
            else if(arr[i].compareTo(arr[i*2+2]) > 0)
            {
               return false;
            }
         }
         else
         {
            if(arr[i].compareTo(arr[i*2+1]) > 0)
            {
               return false;
            }
         }
      }
      return true;
   }

   public static <T> void printTree (T[] arr, int N)
   {
      int i = 0;
      for(int j = 0; j < Math.log(N)/Math.log(2); j ++)
      {
         System.out.println();

         for(i = 0; i < Math.pow(2,j); i++)
         {
            if(i + (int)Math.pow(2,j) < N)
            {
               System.out.print(arr[i+(int)Math.pow(2,j)-1]);
               System.out.print(" ");
            }
            else
            {
               break;
            }
         }
      }
   }
}
