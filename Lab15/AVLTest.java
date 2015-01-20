/* Lab 15: AVLTest
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: November 18, 2013
 *
 */

import java.util.*;

public class AVLTest
{
   public static void main(String[] args)
   {
      BasicAVL avl = new BasicAVL();
      boolean done = true;
      int value;
      Scanner scanner = new Scanner(System.in);
      char choice;

      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter the letter a)" +
                        "\n- print (enter the letter p)" +
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
                  avl.insert(value);
                  System.out.println(value + " added");
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'p':
               avl.print();
               break;
            case 'q':
               done = false;
               System.out.println("Quitting...");
               break;
            default:
               System.out.println("Invalid choice.");
               break;
         }
      }
   }
}
