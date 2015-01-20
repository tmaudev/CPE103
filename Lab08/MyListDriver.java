/* Lab 8: MyListDriver
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 16, 2013
 */

import java.util.Scanner;

public class MyListDriver
{
   public static void main(String[] args)
   {
      MyList list = new MyList();
      boolean done = true;
      int value;
      Scanner scanner = new Scanner(System.in);
      char choice;

      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter the letter a)" +
                        "\n- find (enter the letter f)" +
                        "\n- print (enter the letter p)" +
                        "\n- sum (enter the letter s)" +
                        "\n- quit (enter the letter q)");

      while(done)
      {
         System.out.println("\nEnter menu choice:");
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
                  System.out.println(value + " added");
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'f':
               System.out.println("Enter an Integer:");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  if(list.find(value))
                  {
                     System.out.println(value + " found");
                  }
                  else
                  {
                     System.out.println(value + " not found");
                  }
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }

               break;
            case 'p':
               list.print();
               System.out.println();
               break;
            case 's':
               value = list.sum();
               System.out.println("Sum: " + value);
               break;
            case 'q':
               done = false;
               break;
            default:
               System.out.println("Invalid choice.");
               break;
         }
      }
   }
}
