/* Lab 1
 *
 * Date: September 23, 2013
 * Authors: Tyler Mau, Jeffrey Tang
 *
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class ListWork
{
   public static void main(String[] args)
   {
      Integer[] array = new Integer[10];
      Scanner scanner = new Scanner(System.in);
      int i, test = 0;

      System.out.println("Input 10 Integers:");
      for(i=0; i<10; i++)
      {
         try
         {
            array[i] = scanner.nextInt();
         }
         catch(InputMismatchException e)
         {
            scanner.next();
            i--;
         }
      }
      scanner.nextLine();

      while(test == 0)
      {
         System.out.print("\nWould you like to search(y or n)? ");
         if(scanner.next().equals("y"))
         {
            test = 0;
         }
         else
         {
            test = 1;
            break;
         }
         scanner.nextLine();
         System.out.print("\nInput Target for Search: ");

         try
         {
            if(search(array, scanner.nextInt()))
            {
               System.out.println("Target Found!");
            }
            else
            {
               System.out.println("Target Not Found.");
            }
         }
         catch(InputMismatchException e)
         {
            scanner.next();
            System.out.println("Input Must Be Integer.");
         }
      }
      print(array);
   }

   public static <T> boolean search(T[] arr, T target)
   {
      int i;
      for(i=0; i<arr.length; i++)
      {
         if(arr[i].equals(target))
         {
            return true;
         }
      }
      return false;
   }

   public static <T> void print(T[] arr)
   {
      int i;
      for(i=0; i<arr.length; i++)
      {
         System.out.println(arr[i]);
      }
   }
}
