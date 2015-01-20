/* Program 1: StackTest
 *
 * Date: October 2, 2013
 * Authors: Tyler Mau and Jeffrey Tang
 *
 * Description: Test Driver for Stack ADT
 */

import java.util.Scanner;
import java.util.EmptyStackException;

public class StackTest
{
   public static void main(String[] args)
   {
      //Create New Stack
      MyStack<String> myStack = new MyStack<String>();

      //Create Scanner to Read In User Input
      Scanner scanner = new Scanner(System.in);

      //Test Variables for While Loops
      boolean done = true, test = true;

      //Variable for User Input Menu Choice
      char choice;

      //String Variable That Holds Value of a Stack Element
      String value;

      //Output Menu
      System.out.println("Choose one of the following operations:" +
                         "\n- push/add (enter the letter a)" +
                         "\n- pop/delete (enter the letter d)" +
                         "\n- peek (enter the letter p)" +
                         "\n- check if the list is empty (enter the letter e)" +
                         "\n- Quit (enter the letter q)");

      //Continues Asking for User's Menu Choice Until User Quits
      while(done)
      {
         //Prompts User for Menu Choice
         System.out.println("\nEnter a menu choice:");
         //Scans In User's Menu Choice
         choice = scanner.nextLine().charAt(0);

         //Switch to Choose Appropriate Functionality Based On User Choice
         switch(choice)
         {
            //Pushing Element to Stack
            case 'a':
               //Prompt User to Enter Value for Stack
               System.out.println("\nEnter value:");

               //If User Inputs Value, Add To Stack
               if(scanner.hasNext())
               {
                  value = scanner.next();
                  myStack.push(value);
                  System.out.println(value + " pushed in");
                  scanner.nextLine();
               }
               break;
            //Popping Element From Stack
            case 'd':
               //Remove and Return Top Element From Stack (If Not Empty)
               try
               {
                  value = myStack.pop();
                  System.out.println(value + " popped out");
               }
               //Display Error Message If Stack Is Empty
               catch(EmptyStackException e)
               {
                  System.out.println("Invalid operation on an empty stack.");
               }
               break;
            //Return Top Element From Stack
            case 'p':
               //Returns Top Element From Stack (If Not Empty)
               try
               {
                  value = myStack.peek();
                  System.out.println(value + " on the top");
               }
               //Display Error Message If Stack Is Empty
               catch(EmptyStackException e)
               {
                  System.out.println("Invalid operation on an empty stack.");
               }
               break;
            //Check If Stack Is Empty
            case 'e':
               //Displays Message If Stack Is Empty/Not Empty
               if(myStack.isEmpty())
               {
                  System.out.println("empty");
               }
               else
               {
                  System.out.println("not empty");
               }
               break;
            //Quit the Program
            case 'q':
               done = false;
               System.out.println();

               //Outputs Contents Of Stack
               while(test)
               {
                  try
                  {
                     value = myStack.pop();
                     System.out.print(value + " ");
                  }
                  catch(EmptyStackException e)
                  {
                     test = false;
                  }
               }

               System.out.println();
               break;
            //Display Error Message If Invalid Input Is Entered
            default:
               while(test)
               System.out.println("Invalid choice");
               break;
         }
      }
      System.out.println();
   }
}
