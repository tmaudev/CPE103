import java.util.Scanner;

public class DiGraphDriver
{
   public static void main(String[] args)
   {
      DiGraphAM graph = new DiGraphAM(7);
      Scanner scanner = new Scanner(System.in);
      char choice;
      boolean test = true, done = true;
      Integer start, end;
      
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add edge (enter the letter a)" +
                        "\n- delete edge (enter the letter d)" +
                        "\n- edge count (enter the letter e)" +
                        "\n- vertex count (enter the letter v)" +
                        "\n- print (enter the letter p)" +
                        "\n- topological sort (enter the letter t)" +
                        "\n- quit (enter the letter q) \n");
                        
      while(done)
      {
         System.out.println("Enter menu choice:");
         choice = scanner.nextLine().charAt(0);
         
         switch(choice)
         {
            case 'a':
               System.out.println("Enter a start: ");
               if(scanner.hasNextInt())
               {
                  start = scanner.nextInt();
                  scanner.nextLine();
                  System.out.println("Enter a end: ");
                  end = scanner.nextInt();
                  scanner.nextLine();
                  graph.addEdge(start,end);
                  System.out.println(start + " to " + end + " added");
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'd':
               System.out.println("Enter a start: ");
               if(scanner.hasNextInt())
               {
                  start = scanner.nextInt();
                  scanner.nextLine();
                  System.out.println("Enter a end: ");
                  end = scanner.nextInt();
                  scanner.nextLine();
                  graph.deleteEdge(start,end);
                  System.out.println(start + " to " + end + " deleted");
               }
               else
               {
                  System.out.println("Invalid value");
                  scanner.nextLine();
               }
               break;
            case 'e':
               System.out.println("edge count: " + graph.edgeCount());
               break;
            case 'v':
               System.out.println("vertex count: " + graph.vertexCount());
               break;
            case 'p':
               graph.print();
               break;
            case 't':
               try
               {
                  int[] arr = graph.topSort();
                  for(int i = 0; i < arr.length; i++)
                  {
                     System.out.print(arr[i] + " ");
                  }
                  System.out.println();
               }catch(LQueue.MyException e)
               {
                  System.out.println("Can't do topological sort - the graph is cyclic");
               }
               break;
            case 'q':
               done = false;
               System.out.println("Quitting");
               break;
            default:
               System.out.println("Invalid choice");
               break;
         }
      }
   }
}