/* Program 2: List Printer
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 14, 2013
 *
 * Description: Outputs a sorted list of student records using data from file
 */

//Imports
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class ListPrinter
{
   //Main Method
   public static void main(String[] args)
   {
      //Scanner for User Input
      Scanner scanner = new Scanner(System.in);
      //Create Heap
      BinHeap<Student> heap = new BinHeap<Student>();
      //Create String for File Name
      String filename;

      //Prompt User for File Name
      System.out.println("Enter name of file:");
      filename = scanner.next();

      try
      {
         //Create File Input Stream
         FileInputStream file = new FileInputStream(filename);
         //Scanner to Read File
         Scanner scan = new Scanner(file);
         //Student Variable
         Student student;
         //Id Variable
         long id;
         //Name Variable
         String name;
         //Scanner to Read Each Line In File
         Scanner line;

         //Read Until End of File
         while(scan.hasNextLine())
         {
            //Create Scanner to Read Next Line
            line = new Scanner(scan.nextLine());

            //If Student Information on Line Is Not Valid, Go To Next Line
            try
            {
               id = line.nextLong();
               name = line.next();

               if(!line.hasNext() && id > 0)
               {
                  student = new Student(id,name);
                  heap.insert(student);
               }
            }
            catch(NoSuchElementException e)
            {
               //Go To Next Line
            }
         }

         //Print Out Student List
         System.out.println("Student List:");

         int size = heap.size();
         for(int i=0; i<size; i++)
         {
            student = heap.deleteMin();
            System.out.println((i+1) + ". " + student.toString());
         }
      }
      catch(FileNotFoundException e)
      {
         //Print Error If File Not Found
         System.out.println("Error: File Not Found");
      }
   }
}
