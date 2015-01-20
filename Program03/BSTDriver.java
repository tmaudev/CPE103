/* Program 3: BSTDriver
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: October 28, 2013
 *
 * Description: Test Driver for Binary Search Tree
 *              Displays Menu and Prompts User for Choice
 */

import java.util.*;

//Binary Search Tree Test Driver Class
public class BSTDriver
{
   //Main
   public static void main(String[] args)
   {
      //Create Integer Binary Search Tree
      BST<Integer> bst = new BST<Integer>();
      //Create Pre-Order, In-Order, and Level-Order Iterators
      Iterator<Integer> preItr;
      Iterator<Integer> inItr;
      Iterator<Integer> lvlItr;

      //Test Variable for Loop
      boolean done = true;

      //Value to Hold Integer Tree Values
      int value;

      //Scanner for User Input
      Scanner scanner = new Scanner(System.in);

      //Variable for User's Menu Choices
      char choice;

      //Menu
      System.out.println("Choose one of the following operations:");
      System.out.println("a - add the element" +
                        "\nd - delete the element" +
                        "\nf - find the element" +
                        "\ne - check if the tree is empty" +
                        "\nk - make the tree empty" +
                        "\nm - find the minimal element" +
                        "\nx - find the maximal element" +
                        "\np - print the tree in preorder using iterator" +
                        "\ni - print the tree in inorder using iterator" +
                        "\nl - print the tree in levelorder using iterator" +
                        "\nt - print the tree using printTree" +
                        "\no - output the tree using toString" +
                        "\nq - Quit the program");

      //Continue Program Until User Quits
      while(done)
      {
         //Prompts User for Menu Choice
         System.out.println("\nEnter menu choice:");
         choice = scanner.nextLine().charAt(0);

         //Switch Statement
         switch(choice)
         {
            //Add Element to Tree
            case 'a':
               System.out.println("Enter an Integer:");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  bst.insert(value);
                  System.out.println(value + " Inserted.");
               }
               else
               {
                  System.out.println("Invalid Value");
                  scanner.nextLine();
               }
               break;
            //Delete Element from Tree
            case 'd':
               System.out.println("Enter an Integer:");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();

                  if(!bst.isEmpty())
                  {
                     bst.delete(value);
                     System.out.println(value + " Deleted.");
                  }
                  else
                  {
                     System.out.println("Tree is Already Empty.");
                  }
               }
               else
               {
                  System.out.println("Invalid Value");
                  scanner.nextLine();
               }
               break;
            //Find Specified Element
            case 'f':
               System.out.println("Enter an Integer:");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  if(bst.find(value))
                  {
                     System.out.println(value + " Was Found.");
                  }
                  else
                  {
                     System.out.println(value + " Was Not Found.");
                  }
               }
               else
               {
                  System.out.println("Invalid Value.");
                  scanner.nextLine();
               }
               break;
            //Check If Tree is Empty
            case 'e':
               if(bst.isEmpty())
               {
                  System.out.println("Tree is Empty.");
               }
               else
               {
                  System.out.println("Tree is Not Empty");
               }
               break;
            //Empty the Tree
            case 'k':
               bst.makeEmpty();
               System.out.println("Tree is Now Empty.");
               break;
            //Count Number of Nodes (Size of Tree)
            case 'n':
               System.out.println("Size of Tree: " + bst.size());
               break;
            //Find Minimum Element in Tree
            case 'm':
               try
               {
                  System.out.println("Smallest Element: " + bst.findMinimum());
               }
               catch(BST.MyException e)
               {
                  System.out.println("Tree is Empty.");
               }
               break;
            //Find Maximum Element in Tree
            case 'x':
               try
               {
                  System.out.println("Largest Element: " + bst.findMaximum());
               }
               catch(BST.MyException e)
               {
                  System.out.println("Tree is Empty.");
               }
               break;
            //Print Elements of Tree Using Pre-Order Traversal
            case 'p':
               preItr = bst.iteratorPre();
               while(preItr.hasNext())
               {
                  System.out.print(preItr.next() + " ");
               }
               System.out.println();
               break;
            //Print Elements of Tree Using In-Order Traversal
            case 'i':
               inItr = bst.iteratorIn();
               while(inItr.hasNext())
               {
                  System.out.print(inItr.next() + " ");
               }
               System.out.println();
               break;
            //Print Elements of Tree Using Level-Order Traversal
            case 'l':
               lvlItr = bst.iteratorLevel();
               while(lvlItr.hasNext())
               {
                  System.out.print(lvlItr.next() + " ");
               }
               System.out.println();
               break;
            //Print Tree With Visual Indentations
            case 't':
               bst.printTree();
               System.out.println();
               break;
            //Print Tree On One Line Separated By Spaces
            case 'o':
               System.out.println(bst.toString());
               break;
            //Quit the Program
            case 'q':
               done = false;
               System.out.println("Quitting...");
               System.out.println();
               break;
            //Alert User for Invalid Menu Choices
            default:
               System.out.println("Invalid choice.");
               break;
         }
      }
   }
}
