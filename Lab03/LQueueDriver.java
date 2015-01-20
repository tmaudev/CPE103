import java.util.Scanner;

public class LQueueDriver
{
   public static void main(String[] args)
   {
      LQueue<Integer> queue = new LQueue<Integer>();
      Scanner scanner = new Scanner(System.in);
      char choice;
      boolean test = true, done = true;
      Integer value;
      
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- enqueue/add (enter the letter a)" +
                        "\n- dequeue/delete (enter the letter d)" +
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
               catch(LQueue.MyException e)
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
                  catch(LQueue.MyException e)
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