/* Program 1: Converter
 *
 * Date: October 2, 2013
 * Authors: Tyler Mau and Jeffrey Tang
 *
 * Description: Contains 2 Processes:
 *              1. Converts Infix Expression To Postfix Expression
 *              2. Calculates Value of Postfix Expression
 */

import java.util.Scanner;

public class Converter
{
   //Converts Infix Expression to a Postfix Expression
   public static String infixToPostfix(String expression)
   {
      //Create Stack For Algorithm
      MyStack<String> stack = new MyStack<String>();

      //Create String Variable to Hold Postfix Expression
      String output = new String("");

      //Create Scanner to Parse and Evaluate Infix Expression
      Scanner scanner = new Scanner(expression);

      //Test Variable for While Loop
      boolean test = true;

      //String Variable to Temporarily Hold Infix Operand/Operator
      String value;

      //Continue Conversion Until End Of Expression
      while(test)
      {
         //If Expression Has Another Operand/Operator, Continue Conversion
         if(scanner.hasNext())
         {
            //Scan In Operand/Operator
            value = scanner.next();

            //If Value Is '(', Push To Stack
            if(value.equals("("))
            {
               stack.push(value);
            }
            //If Value Is ')', Pop Elements From Stack and Add to Expression Until '(' Is Detected
            else if(value.equals(")"))
            {
               while(!stack.peek().equals("("))
               {
                  output += stack.pop();
                  output += " ";
               }
               //Remove '(' From Stack
               stack.pop();
            }
            //If Value is '*' or '/'
            else if(value.equals("*") || value.equals("/"))
            {
               //If Stack Is Empty, Push to Stack
               if(stack.isEmpty())
               {
                  stack.push(value);
               }
               //If Top of Stack Is '(', Push to Stack
               else if(stack.peek().equals("("))
               {
                  stack.push(value);
               }
               //If Top of Stack Is '+' or '-', Push to Stack
               else if(stack.peek().equals("+") || stack.peek().equals("-"))
               {
                  stack.push(value);
               }
               //If Top of Stack Is '*' or '/', Pop From Stack and Add to Expression
               //Then Push to Stack
               else
               {
                  //Continue Popping and Adding Stack Elements to Expression
                  while(stack.peek().equals("*") || stack.peek().equals("/"))
                  {
                     output += stack.pop();
                     output += " ";
                     if(stack.isEmpty())
                     {
                        break;
                     }
                  }
                  stack.push(value);
               }
            }
            //If Value Is '+' or '-'
            else if(value.equals("+") || value.equals("-"))
            {
               //If Stack Is Empty, Push to Stack
               if(stack.isEmpty())
               {
                  stack.push(value);
               }
               //If Top of Stack Is '(', Push to Stack
               else if(stack.peek().equals("("))
               {
                  stack.push(value);
               }
               //If Top of Stack Is '*', '/', '+', or '-', Pop From Stack and Add to Expression
               //Then Push to Stack
               else
               {
                  //Continue Popping and Adding Stack Elements to Expression
                  while(stack.peek().equals("+") || stack.peek().equals("-") ||
                        stack.peek().equals("*") || stack.peek().equals("/"))
                  {
                     output += stack.pop();
                     output += " ";
                     if(stack.isEmpty())
                     {
                        break;
                     }
                  }
                  stack.push(value);
               }
            }
            //If Value Is Operand, Add to Expression
            else
            {
               output += value;
               output += " ";
            }
         }
         //If End of Expression Is Reached, Pop and Add Remaining Stack Elements to Expression
         else
         {
            while(!stack.isEmpty())
            {
               output += stack.pop();
               output += " ";
            }
            //Ends While Loop
            test = false;
         }
      }
      return output;
   }

   //Calculates Value of Postfix Expression
   public static double postfixValue(String expression)
   {
      //Create Stack for Algorithm
      MyStack<Double> stack = new MyStack<Double>();

      //Create Scanner to Parse Expression
      Scanner scanner = new Scanner(expression);

      //Test Variable for While Loop
      boolean test = true;

      //Variable to Temporarily Hold Operators
      String operation;

      while(test)
      {
         //If Next Term in Equation is an Integer, Push to Stack
         if(scanner.hasNextInt())
         {
            stack.push(scanner.nextDouble());
         }
         //If Next Term in Equation is a Float, Push to Stack
         else if(scanner.hasNextFloat())
         {
            stack.push(scanner.nextDouble());
         }
         else
         {
            if(scanner.hasNext())
            {
               operation = scanner.next();

               //If Operator is '+', Add Top 2 Stack Items
               if(operation.equals("+"))
               {
                  stack.push(stack.pop() + stack.pop());
               }
               //If Operator is '-', Subtract the Top Stack Item From Next Item
               else if(operation.equals("-"))
               {
                  stack.push((-1 * stack.pop()) + stack.pop());
               }
               //If Operator is '*', Multiply Top 2 Stack Items
               else if(operation.equals("*"))
               {
                  stack.push(stack.pop() * stack.pop());
               }
               //If Operator is '/', Divide the Top Stack Item From Next Item
               else if(operation.equals("/"))
               {
                  stack.push((1/stack.pop()) * stack.pop());
               }
               else
               {
                  //Ends While Loop If Invalid Operation is Inputted
                  //Not Necessary Due to Precondition
                  test = false;
               }
            }
            else
            {
               //Ends While Loop If Done Reading Expression
               test = false;
            }
         }
      }
      //Return Answer to Equation
      return stack.pop();
   }
}
