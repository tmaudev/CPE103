/* Lab 10: BSTWork
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 30, 2013
 *
 */

import java.util.*;

public class BSTWork
{
   public static void main(String[] args)
   {
      BasicBST bst = new BasicBST();
      boolean done = true;
      int value;
      Scanner scanner = new Scanner(System.in);
      char choice;

      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter the letter a)" +
                        "\n- odds (enter the letter o)" +
                        "\n- height (enter the letter h)" +
                        "\n- leaves (enter the letter l)" +
                        "\n- one-child nodes (enter the letter c)" +
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
                  bst.insert(value);
                  System.out.println(value + " added");
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'o':
               System.out.println(bst.countOdds() + " odds");
               break;
            case 'h':
               System.out.println("Height: " + bst.height());
               break;
            case 'l':
               System.out.println(bst.countLeaves() + " leaves");
               break;
            case 'c':
               System.out.println(bst.countOneChildParents() + " one-child parents");
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
