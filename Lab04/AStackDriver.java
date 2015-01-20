import java.util.Scanner;

public class AStackDriver
{
   public static void main(String[] args)
   {
      AStack<Integer> stack = new AStack<Integer>(5);
      Scanner scanner = new Scanner(System.in);
      char choice;
      boolean test = true, done = true;
      Integer value;


      System.out.println("Choose one of the following operations:");
      System.out.println("- add/push (enter the letter a)" +
                        "\n- delete/pop (enter the letter d)" +
                        "\n- peek (enter the letter p)" +
                        "\n- check if the list is empty (enter the letter e)" +
                        "\n- quit (enter the letter q) \n");

      while(done)
      {
         System.out.println("Enter menu choice:");
         choice = scanner.nextLine().charAt(0);

         switch(choice)
         {
            case 'a':
               System.out.println("Enter an Integer: ");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  stack.push(value);
                  System.out.println(value + " pushed");
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'd':
               try
               {
                  value = stack.pop();
                  System.out.println(value + " popped");
               }
               catch(AStack.MyException e)
               {
                  System.out.println("Invalid operation: the stack is empty");
               }
               break;
            case 'p':
               try
               {
                  value = stack.peek();
                  System.out.println(value + " is on top");
               }
               catch(AStack.MyException e)
               {
                  System.out.println("Invalid operation: the stack is empty");
               }
               break;
            case 'e':
               if(stack.isEmpty())
                  System.out.println("empty");
               else
                  System.out.println("not empty");
               break;
            case 'q':
               done = false;
               System.out.println("Quitting");
               while(test)
               {
                  try
                  {
                     value = stack.pop();
                     System.out.print(value + " ");
                  }
                  catch(AStack.MyException e)
                  {
                     test = false;
                  }
               }
               System.out.println();
               break;
            default:
               System.out.println("Invalid choice");
               break;
         }
      }
   }
}
