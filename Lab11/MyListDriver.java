/* Lab 11: MyListDriver
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 30, 2013
 *
 */

import java.util.*;

public class MyListDriver
{
   public static void main(String[] args)
   {
      MySortedList list = new MySortedList();
      boolean done = true;
      int value;
      Scanner scanner = new Scanner(System.in);
      char choice;

      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter the letter a)" +
                        "\n- delete (enter the letter d)" +
                        "\n- max (enter the letter x)" +
                        "\n- min (enter the letter m)" +
                        "\n- print (enter the letter p)" +
                        "\n- isEmpty (enter the letter e)" +
                        "\n- quit (enter the letter q)");

      while(done)
      {
         System.out.println("\nEnter Menu Choice:");
         choice = scanner.nextLine().charAt(0);

         switch(choice)
         {
            case 'a':
               System.out.println("Enter an Integer:");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  list.add(value);
                  System.out.println(value + " added.");
               }
               else
               {
                  System.out.println("Invalid Value.");
                  scanner.nextLine();
               }
               break;
            case 'd':
               System.out.println("Enter an Integer:");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  list.delete(value);
                  System.out.println(value + " deleted.");
               }
               else
               {
                  System.out.println("Invalid Value.");
                  scanner.nextLine();
               }
               break;
            case 'x':
               if(list.isEmpty())
               {
                  System.out.println("List is Empty...");
               }
               else
               {
                  System.out.println("Max Value: " + list.max());
               }
               break;
            case 'm':
               if(list.isEmpty())
               {
                  System.out.println("List is Empty...");
               }
               else
               {
                  System.out.println("Min Value: " + list.min());
               }
               break;
            case 'p':
               list.print();
               System.out.println();
               break;
            case 'e':
               if(list.isEmpty())
               {
                  System.out.println("The List is Empty.");
               }
               else
               {
                  System.out.println("The List is Not Empty.");
               }
               break;
            case 'q':
               done = false;
               System.out.println("Quitting...");
               System.out.println();
               break;
            default:
               System.out.println("Invalid Choice.");
               break;
         }
      }
   }
}
