/* Program 1: ConTest
 *
 * Date: October 2, 2013
 * Authors: Tyler Mau and Jeffrey Tang
 *
 * Description: 1. Program Utilizes Converter and MyStack Classes.
 *              2. Outputs Menu to Screen and Waits For User Input.
 *              3. Completes Appropriate Methods and Displays Feedback
 *                 Based On User Interaction.
 */

import java.util.Scanner;
import java.util.EmptyStackException;

public class ConTest
{
   //Main Method
   public static void main(String[] args)
   {
      //Creates Scanner for User Input
      Scanner scanner = new Scanner(System.in);

      //Test Variable for While Loop
      boolean done = true;

      //Variable for User Choices
      char choice;

      //Variable to Hold Expression Returned from Methods Called
      String expression;

      //Menu
      System.out.println("\nChoose one of the following operations:" +
                         "\n- Infix to postfix conversion (enter the letter i)" +
                         "\n- Postfix expression evaluation (enter the letter p)" +
                         "\n- Arithmetic expression evaluation (enter the letter a)" +
                         "\n- Quit (enter the letter q)");

      //Continues Asking for Choices Until User Quits
      while(done)
      {
         //Prompts User to Enter Menu Choice
         System.out.println("\nEnter a menu choice:");

         //Scans User's Choice
         choice = scanner.nextLine().charAt(0);

         //Switch Statement Chooses Appropriate Action Based On Menu Choice
         switch(choice)
         {
            case 'i':
               //Prompts User for Infix Expression
               System.out.println("Enter infix expression:");
               expression = scanner.nextLine();
               //Converts Infix Expression to Postfix Expression and Displays Result
               System.out.println(Converter.infixToPostfix(expression));
               break;
            case 'p':
               //Prompts User for Postfix Expression
               System.out.println("Enter postfix expression:");
               expression = scanner.nextLine();
               //Solves Postfix Expression and Displays Solution
               System.out.println(Converter.postfixValue(expression));
               break;
            case 'a':
               //Prompts User for Infix Expression
               System.out.println("Enter infix expression:");
               expression = scanner.nextLine();
               //Converts Infix Expression to Postfix Expression
               //Then Solves Postfix Expression and Displays Solution
               System.out.println(Converter.postfixValue(Converter.infixToPostfix(expression)));
               break;
            case 'q':
               //Ends While Loop
               done = false;
               System.out.println();
               //Displays Message to Indicate Program is Quitting
               System.out.println("Quitting...");
               break;
            default:
               //Prints Error if Invalid Menu Choice is Inputted
               System.out.println("Invalid choice");
               break;
         }
      }
      //Print Line for Stylistic Purposes
      System.out.println();
   }
}
