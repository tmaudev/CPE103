/* Program 2: Heap Test
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 11, 2013
 *
 * Description: Test Driver for Binary Heap ADT
 *              Contains Options to Add, Delete, Check Empty, Check Size, Print, and Quit
 */

//Import Scanner Class
import java.util.Scanner;

public class HeapTest
{
   //Main Method
   public static void main(String[] args)
   {
      //Create Scanner for User Input
      Scanner scanner = new Scanner(System.in);
      //Create Variable for Menu Choice
      char choice;
      //Test Variables for Loops
      boolean test = true, done = true;
      //String to Hold Heap Values
      String value;

      //Prompts User for Initial Size of Heap
      System.out.println("Enter Initial Size of Heap:");
      BinHeap<String> heap = new BinHeap<String>(scanner.nextInt());
      scanner.nextLine();

      //Menu
      System.out.println("\nChoose one of the following operations:" +
                         "\n- add an element (enter the letter a)" +
                         "\n- delete the smallest element (enter the letter d)" +
                         "\n- is the heap empty (enter the letter e)" +
                         "\n- size of the collection (enter the letter s)" +
                         "\n- print the collection (enter the letter p)" +
                         "\n- Quit (enter the letter q)");

      //Loop Until User Quits
      while(done)
      {
         //Prompts User for Menu Choice
         System.out.println("\nEnter menu choice:");
         //Scan In User Choice
         choice = scanner.nextLine().charAt(0);

         //Switch for Menu Choices
         switch(choice)
         {
            //Add Element To Heap
            case 'a':
               System.out.println("Enter a String:");
               if(scanner.hasNext())
               {
                  value = scanner.next();
                  heap.insert(value);
                  System.out.println(value + " inserted");
                  scanner.nextLine();
               }
               break;
            //Delete Smallest Element In Heap
            case 'd':
               try
               {
                  value = heap.deleteMin();
                  System.out.println(value + " deleted");
               }
               catch(BinHeap.MyException e)
               {
                  System.out.println("Invalid operation: the heap is empty");
               }
               break;
            //Checks If Heap Is Empty
            case 'e':
               if(heap.isEmpty())
               {
                  System.out.println("empty");
               }
               else
               {
                  System.out.println("not empty");
               }
               break;
            //Print Heap In Order Stored In Array
            case 'p':
               System.out.println(heap.toString());
               break;
            //Return the Size of Heap
            case 's':
               System.out.println("the size is " + heap.size());
               break;
            //Quit the Loop and Output Heap In Order From Least to Greatest
            case 'q':
               done = false;
               System.out.println("Quitting\n");
               while(test)
               {
                  try
                  {
                     value = heap.deleteMin();
                     System.out.print(value + " ");
                  }
                  catch(BinHeap.MyException e)
                  {
                     test = false;
                  }
               }
               System.out.println("\n");
               break;
            default:
               System.out.println("Invalid choice");
               break;
         }
      }
   }
}
