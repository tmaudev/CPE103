/* Lab 2
 *
 * Date: September 25, 2013
 *
 * Authors: Tyler Mau, Jeffrey Tang
 */

import java.util.Scanner;

public class Separator
{

   private static final int N = 5;
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      boolean test = true;
      Integer[] intArr = new Integer[N];
      Float[] floatArr = new Float[N];
      int i = 0, j = 0, count = 0;

      System.out.println("Enter Integers or Floats:");

      while(test)
      {
         if(scanner.hasNextInt())
         {
            if(i<N)
            {
               intArr[i] = scanner.nextInt();
            }
            else
            {
               test = false;
            }
            i++;
         }
         else if(scanner.hasNextFloat())
         {
            if(j<N)
            {
               floatArr[j] = scanner.nextFloat();
            }
            else
            {
               test = false;
            }
            j++;
         }
         else
         {
            test = false;
            break;
         }

         if(!scanner.hasNext())
         {
            test = false;
         }
         else if(i>N)
         {
            i--;
         }
         else if(j>N)
         {
            j--;
         }
         else
         {
            test = true;
         }

      }

      System.out.print("Integers: ");
      for(count=0; count<i; count++)
      {
         System.out.print(intArr[count] + " ");
      }
      System.out.print("\nFloats: ");
      for(count=0; count<j; count++)
      {
         System.out.print(floatArr[count] + " ");
      }

      System.out.println();

   }

}
