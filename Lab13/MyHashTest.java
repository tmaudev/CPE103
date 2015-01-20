import java.util.Scanner;
import java.util.*;

public class MyHashTest
{
   public static void main(String[] args)
   {
      MyHashTable<Integer> table = new MyHashTable<Integer>(10);
      Scanner scanner = new Scanner(System.in);
      char choice;
      boolean test = true, done = true;
      Integer value;
      Iterator<Integer> itr;

      System.out.println("Choose one of the following operations:");
      System.out.println("- add/insert (enter the letter a)" +
                        "\n- find (enter the letter f)" +
                        "\n- delete (enter the letter d)" +
                        "\n- empty (enter the letter e)" +
                        "\n- make empty (enter the letter k)" +
                        "\n- size (enter the letter s)" +
                        "\n- output (enter the letter o)" +
                        "\n- print (enter the letter p)" +
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
                  table.insert(value);
                  System.out.println(value + " added\n");
               }
               else
               {
                  System.out.println("Invalid value\n");
                  scanner.nextLine();
               }
               break;
            case 'd':
               System.out.println("Enter an Integer to be delete: ");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  table.delete(value);
                  System.out.println(value + " deleted");
                  System.out.println();
               }
               else
               {
                  System.out.println("Invalid value\n");
                  scanner.nextLine();
               }
               break;
            case 'f':
               System.out.println("Enter an Integer to be found: ");
               if(scanner.hasNextInt())
               {
                  value = scanner.nextInt();
                  scanner.nextLine();
                  if(table.find(value))
                     System.out.println(value + " found");
                  else
                     System.out.println(value + " not found");
                  System.out.println();
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'e':
               if(table.isEmpty())
                  System.out.println("empty");
               else
                  System.out.println("not empty");
                  System.out.println();
               break;
            case 'k':
               table.makeEmpty();
               System.out.println("table is now empty");
               System.out.println();
               break;
            case 's':
               System.out.println("Size: " + table.size());
               System.out.println();
               break;
            case 'o':
               itr = table.iterator();

               System.out.println();
               while(itr.hasNext())
               {
                  System.out.print(itr.next() + " ");
               }
               System.out.println("\n");
               break;
            case 'p':
                  table.print();
                  System.out.println();
               break;
            case 'q':
               done = false;
               break;
            default:
               System.out.println("Invalid choice");
               break;
         }
      }
   }
}
