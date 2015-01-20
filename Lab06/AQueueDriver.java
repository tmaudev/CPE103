/* Lab 6: AQueueDriver
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 11, 2013
 *
 */

import java.util.Scanner;

public class AQueueDriver
{
   public static void main(String[] args)
   {
      int size = 5;
      AQueue<Integer> queue = new AQueue<Integer>(size);
      Scanner scanner = new Scanner(System.in);
      char choice;
      boolean test = true, done = true;
      Integer value;


      System.out.println("Choose one of the following operations:");
      System.out.println("- enqueue/add (enter the letter a)" +
                        "\n- dequeue/delete (enter the letter d)" +
                        "\n- check if the list is empty (enter the letter e)" +
                        "\n- print array (enter the letter p)" +
                        "\n- quit (enter the letter q) \n");

      while(done)
      {
         System.out.println("\nEnter menu choice:");
         choice = scanner.nextLine().charAt(0);

         switch(choice)
         {
            case 'a':
               System.out.println("Enter an Integer: ");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  queue.enqueue(value);
                  System.out.println(value + " enqueued");
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
                  value = queue.dequeue();
                  System.out.println(value + " dequeued");
               }
               catch(AQueue.MyException e)
               {
                  System.out.println("Invalid operation: the queue is empty");
               }
               break;
            case 'e':
               if(queue.isEmpty())
                  System.out.println("empty");
               else
                  System.out.println("not empty");
               break;
            case 'p':
               queue.printArray();
               System.out.println();
               break;
            case 'q':
               done = false;
               System.out.println("Quitting");
               while(test)
               {
                  try
                  {
                     value = queue.dequeue();
                     System.out.print(value + " ");
                  }
                  catch(AQueue.MyException e)
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
