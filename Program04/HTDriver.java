/* Program 4: Hash Table Driver
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: November 14, 2013
 *
 * Description: Test Driver for Hash Table ADT
 */

//Import Scanner Class
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.NoSuchElementException;

public class HTDriver
{
   //Main Method
   public static void main(String[] args)
   {
      //Create Scanner for User Input
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter Name of Input File:");
      String input = scanner.nextLine();

      try
      {
         //Create Variable for Menu Choice
         char choice;
         //Test Variables for Loops
         boolean test = true, done = true;
         //String to Hold Heap Values
         String value, name;
         //Long to Hold ID
         long id;
         //Scanner to Read Each Line In File
         Scanner line;
         //Student Object
         Student student;

         //Creates Files and Scanners for Data Processing
         FileInputStream file = new FileInputStream(input);
         Scanner fscan = new Scanner(file);

         //Variable for Number of Elements In File
         int count = fscan.nextInt();
         //Create Hash Table
         HashTable table = new HashTable(count);

         while(fscan.hasNextLine())
         {
            line = new Scanner(fscan.nextLine());
            //If Student Information on Line Is Not Valid, Go To Next Line
            try
            {
               id = line.nextLong();
               name = line.next();

               if(!line.hasNext() && id > 0)
               {
                  student = new Student(id,name);
                  table.insert(student);
               }
            }
            catch(NoSuchElementException e)
            {
               //Go To Next Line
            }
         }

         //Menu
         System.out.println("Choose one of the following operations:" +
                            "\na - add the element" +
                            "\nd - delete the element" +
                            "\nf - find and retrieve the element" +
                            "\nn - get the number of elements in the collection" +
                            "\ne - check if the collection is empty" +
                            "\nk - make the hash table empty" +
                            "\np - print the content of the hash table" +
                            "\no - output the elements of the collection" +
                            "\nq - Quit the program");

         //Loop Until User Quits
         while(done)
         {
            //Prompts User for Menu Choice
            System.out.println("\nEnter menu choice:");
            //Scan In User Choice
            choice = scanner.nextLine().charAt(0);

            //Switch for Menu Choices
            switch(choice)
            {
               //Add Element To Hash Table
               case 'a':
                  System.out.println("Enter a Student ID and Last Name:");
                  if(scanner.hasNext())
                  {
                     line = new Scanner(scanner.nextLine());
                     try
                     {
                        id = line.nextLong();
                        name = line.next();

                        if(!line.hasNext() && id > 0)
                        {
                           student = new Student(id,name);
                           table.insert(student);
                           System.out.println(student.toString() + " Added.");
                        }
                        else
                        {
                           System.out.println("Error: Incorrect Input.");
                        }
                     }
                     catch(NoSuchElementException e)
                     {
                        System.out.println("Error: Incorrect Input.");
                     }
                  }
                  break;
               //Delete Hash Table Element
               case 'd':
                  System.out.println("Enter a Student ID:");
                  if(scanner.hasNext())
                  {
                     try
                     {
                        id = scanner.nextLong();

                        if(id > 0)
                        {
                           student = new Student(id,"");
                           Student temp = (Student)table.find(student);
                           table.delete(student);

                           if(temp != null)
                           {
                              System.out.println(temp.toString() + " Deleted.");
                           }
                           else
                           {
                              System.out.println("ID Not Found");
                           }
                           scanner.nextLine();
                        }
                        else
                        {
                           System.out.println("Error: Incorrect Input.");
                        }
                     }
                     catch(NoSuchElementException e)
                     {
                        System.out.println("Error: Incorrect Input.");
                     }
                  }
                  break;
               case 'f':
                  System.out.println("Enter a Student ID:");
                  if(scanner.hasNext())
                  {
                     try
                     {
                        id = scanner.nextLong();

                        if(id > 0)
                        {
                           student = new Student(id,"");
                           Student temp = (Student)table.find(student);

                           if(temp != null)
                           {
                              System.out.println(temp.toString() + " Found.");
                           }
                           else
                           {
                              System.out.println("ID Not Found.");
                           }
                           scanner.nextLine();
                        }
                        else
                        {
                           System.out.println("Error: Incorrect Input.");
                        }
                     }
                     catch(NoSuchElementException e)
                     {
                        System.out.println("Error: Incorrect Input.");
                     }
                  }
                  break;
               //Outputs Number of Elements in Collection
               case 'n':
                  System.out.println(table.elementCount() + " Element(s) in Collection.");
                  break;
               //Checks If Hash Table Is Empty
               case 'e':
                  if(table.isEmpty())
                  {
                     System.out.println("Empty.");
                  }
                  else
                  {
                     System.out.println("Not Empty.");
                  }
                  break;
               //Empties Hash Table
               case 'k':
                  table.makeEmpty();
                  System.out.println("Table is Now Empty.");
                  break;
               //Print Hash Table
               case 'p':
                  table.printTable();
                  break;
               //Output Elements of Hash Table
               case 'o':
                  Iterator itr = table.iterator();

                  while(itr.hasNext())
                  {
                     System.out.println(itr.next());
                  }
                  break;
               //Quit the Loop
               case 'q':
                  done = false;
                  System.out.println("Quitting...");
                  System.out.println("");
                  break;
               default:
                  System.out.println("Invalid Choice.");
                  break;
            }
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File Not Found.");
      }
   }
}
