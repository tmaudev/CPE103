import java.util.Scanner;

public class AQueueClient
{
   public static void main(String[] args)
   {

      AQueue<Float> floatQueue = new AQueue<Float>(5);
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Values:");

      while(scanner.hasNext())
      {
         if(scanner.hasNextFloat())
         {
            floatQueue.enqueue(scanner.nextFloat());
         }
         else
         {
            scanner.next();
         }
      }
      while(!floatQueue.isEmpty())
      {
         System.out.print(floatQueue.dequeue() + " ");
      }
      System.out.println();
   }
}
