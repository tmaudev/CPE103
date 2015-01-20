import java.util.Scanner;
import java.io.*;

public class AStackClient
{
   public static void main(String[] args) throws IOException
   {

      AStack<Integer> intStack = new AStack<Integer>(5);
      AStack<Float> floatStack = new AStack<Float>(5);
      AStack<String> strStack = new AStack<String>(5);
      String fileName;
      Scanner scan = new Scanner(System.in);
      System.out.print("Input File Name: ");
      fileName = scan.next();
      FileInputStream file = new FileInputStream(fileName);

      Scanner scanner = new Scanner(file);

      while(scanner.hasNext())
      {
         if(scanner.hasNextInt())
         {
            intStack.push(scanner.nextInt());
         }
         else if(scanner.hasNextFloat())
         {
            floatStack.push(scanner.nextFloat());
         }
         else
         {
            strStack.push(scanner.next());
         }
      }
      System.out.print("Strings: ");
      while(!strStack.isEmpty())
      {
         System.out.print(strStack.pop() + " ");
      }
      System.out.println();

      System.out.print("Floats: ");
      while(!floatStack.isEmpty())
      {
         System.out.print(floatStack.pop() + " ");
      }
      System.out.println();

      System.out.print("Integers: ");
      while(!intStack.isEmpty())
      {
         System.out.print(intStack.pop() + " ");
      }
      System.out.println();

   }
}
