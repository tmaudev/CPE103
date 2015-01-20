/* Lab 5: StringChecker
 *
 * Date: October 7, 2013
 * Authors: Tyler Mau and Jeffrey Tang
 *
 */

import java.util.Scanner;

public class StringChecker
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      while(true)
      {
         System.out.println("Enter String to be Checked:");
         if(scanner.hasNextLine())
         {
            if(isBalanced(scanner.nextLine()))
            {
               System.out.println("String is Balanced!");
            }
            else
            {
               System.out.println("String is not Balanced.");
            }
            System.out.println();
         }
         else
         {
            break;
         }
      }
   }

   public static boolean isBalanced(String str)
   {
      AStack<Character> stack = new AStack<Character>(10);
      int i;
      char symbol;

      for(i=0; i<str.length(); i++)
      {
         symbol = str.charAt(i);
         if(symbol == '(' || symbol == '[' || symbol == '{')
         {
            stack.push(symbol);
         }
         else if(symbol == ')' || symbol == ']' || symbol == '}')
         {
            if(stack.isEmpty())
            {
               return false;
            }
            else if(symbol == ')')
            {
               if(stack.pop() != '(')
               {
                  return false;
               }
            }
            else if(symbol == ']')
            {
               if(stack.pop() != '[')
               {
                  return false;
               }
            }
            else if(symbol == '}')
            {
               if(stack.pop() != '{')
               {
                  return false;
               }
            }
         }
      }
      if(!stack.isEmpty())
      {
         return false;
      }
      return true;
   }
}
