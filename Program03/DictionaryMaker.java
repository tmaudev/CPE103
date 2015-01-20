/* Program 3: DictionaryMaker
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: October 30, 2013
 *
 * Description: Reads a text file and outputs a sorted list to a separate file.
 */

import java.util.*;
import java.io.*;

//Dictionary Class
public class DictionaryMaker
{
   //Main
   public static void main(String[] args)
   {
      //Strings to Hold Input and Output File Names
      String input, output;
      //Scanner for User Input
      Scanner scanner = new Scanner(System.in);

      //Prompts User for Input and Output File Names
      System.out.println("Enter Name of Input File:");
      input = scanner.nextLine();
      System.out.println("Enter Name of Output File:");
      output = scanner.nextLine();

      try
      {
         //Creates Files and Scanners for Data Processing
         FileInputStream file = new FileInputStream(input);
         PrintStream write = new PrintStream(new FileOutputStream(output));
         Scanner fscan = new Scanner(file);

         //Create Binary Search Tree for Strings
         BST<String> dictionary = new BST<String>();
         //String Variable for Dictionary Word
         String word;

         //Read Until End of File
         while(fscan.hasNextLine())
         {
            word = fscan.nextLine();
            //Checks for Duplicate Words
            if(!dictionary.find(word))
            {
               //Insert Word to Dictionary
               dictionary.insert(word);
            }
         }

         //Creates In-Order Iterator to Output Words in Alphabetical Order
         Iterator<String> inItr = dictionary.iteratorIn();

         //Iterate Through Every Node In Tree (In-Order Traversal)
         while(inItr.hasNext())
         {
            //Output Dictionary Word to File
            write.println(inItr.next());
         }
      }
      catch(FileNotFoundException e)
      {
         //Output Error Message If Input File Was Not Found
         System.out.println("File Not Found.");
      }
   }
}
