import java.util.Scanner;

public class HashTest
{
   public static void main(String[] args)
   {
      HashTableSC<Integer> table = new HashTableSC<Integer>(10);
      Scanner scanner = new Scanner(System.in);
      char choice;
      boolean test = true, done = true;
      Integer value;
      
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add/insert (enter the letter a)" +
                        "\n- find (enter the letter f)" +
                        "\n- delete (enter the letter d)" +
                        "\n- empty (enter the letter e)" +
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
                  System.out.println(value + " added");
               }
               else
               {
                  System.out.println("Invalid value");
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
                  System.out.println("Invalid value");
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