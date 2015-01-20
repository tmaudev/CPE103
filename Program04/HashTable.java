/* Program 4: HashTable
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: Novmeber 14, 2013
 *
 * Description: Hash Table ADT
 */

import java.util.*;
import java.lang.Math;

//Hash Table ADT Class
public class HashTable
{
   //Private Class Represents Entry in Hash Table
   private class HashEntry
   {
      //Variable Holds Element in Hash Table
      public Object elem;
      //Variable Used to Indicate Deletion
      public boolean active;

      //Private Class Constructor
      public HashEntry(Object x)
      {
         elem = x;
         active = true;
      }
   }

   //Instance Variable Hash Table
   private HashEntry[] table;
   //Number of Occupied Cells
   private int count;

   //Hash Table Constructor
   public HashTable(int size)
   {
      table = new HashEntry[nextPrime(2*size)];
      count = 0;
   }

   //Finds the Next Highest Prime Number Given an Integer
   private int nextPrime(int size)
   {
      int i = size + 1;
      while(!isPrime(i))
      {
         i++;
      }
      return i;
   }

   //Private Method Checks If Number Is Prime
   private boolean isPrime(int n)
   {
      if(n%2 == 0)
      {
         return false;
      }

      for(int i=3; i*i<n; i+=2)
      {
         if(n%i == 0)
         {
            return false;
         }
      }
      return true;
   }

   //Private Hash Method
   private int hash(Object x)
   {
      return Math.abs(x.hashCode()) % table.length;
   }

   //Iterator to Traverse Hash Table
   private class Iter implements Iterator
   {
      public int cursor;

      //Iterator Constructor
      public Iter()
      {
         cursor = 0;
         while(cursor < table.length && (table[cursor] == null || !table[cursor].active))
         {
            cursor++;
         }
      }

      //Checks If Cursor Is In Valid Location
      public boolean hasNext()
      {
         if(cursor < table.length)
         {
            return true;
         }
         return false;
      }

      //Returns the Object at the Current Cursor and Moves Cursor to Next Location
      public Object next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }

         Object item = table[cursor].elem;

         cursor++;
         while(cursor < table.length && (table[cursor] == null || !table[cursor].active))
         {
            cursor++;
         }

         return item;
      }

      //Unsupported Operation
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   //Private Method Finds Position for Next Operation (Add, Delete, Find)
   private int findPosition(Object item)
   {
      int i = 0, hashValue, index;

      hashValue = hash(item);
      index = hashValue;

      while(table[index] != null && !item.equals(table[index].elem))
      {
         i++;
         index = (hashValue + (i * i)) % table.length;
      }

      return index;
   }

   //Inserts an Object at a Location Based On Hash Code
   public void insert(Object item)
   {
      int index = findPosition(item);
      if(table[index] == null)
      {
         table[index] = new HashEntry(item);
         count++;
         if(count >= table.length/2)
         {
            rehash();
         }
      }
      else
      {
         if(!table[index].active)
         {
            table[index].active = true;
         }
      }
   }

   //Resizes Array and Copies Data to New Hash Table (Must Be Prime Number in Size)
   private void rehash()
   {
      HashEntry[] temp = table;

      table = new HashEntry[nextPrime(2*temp.length)];
      count = 0;

      for(int i=0; i<temp.length; i++)
      {
         if(temp[i] != null && temp[i].active)
         {
            int index = findPosition(temp[i].elem);
            table[index] = temp[i];
            count++;
         }
      }
   }

   //Removes a Specified Object from Hash Table
   public void delete(Object item)
   {
      int index = findPosition(item);
      if(table[index] != null && table[index].active == true)
      {
         table[index].active = false;
      }
   }

   //Locates Specified Object
   //If Found, Returns Object
   public Object find(Object item)
   {
      int index = findPosition(item);
      if(table[index] != null && table[index].active == true)
      {
         return table[index].elem;
      }
      return null;
   }

   //Counts the Number of Active Elements
   public int elementCount()
   {
      int num = 0;
      for(int i=0; i<table.length; i++)
      {
         if(table[i] != null && table[i].active)
         {
            num++;
         }
      }
      return num;
   }

   //Checks If Hash Table Is Empty
   public boolean isEmpty()
   {
      if(count == 0)
      {
         return true;
      }
      return false;
   }

   //Creates a New, Empty Hash Table
   public void makeEmpty()
   {
      count = 0;
      table = new HashEntry[table.length];
   }

   //Prints the Hash Table
   public void printTable()
   {
      System.out.println();
      for(int i=0; i<table.length; i++)
      {
         if(table[i] == null)
         {
            System.out.println("[" + i + "]: empty");
         }
         else if(table[i].active == false)
         {
            System.out.println("[" + i + "]: " + table[i].elem + ", inactive");
         }
         else
         {
            System.out.println("[" + i + "]: " + table[i].elem + ", active");
         }
      }
   }

   //Iterator Method Returns Private Iterator
   public Iterator iterator()
   {
      return new Iter();
   }
}
