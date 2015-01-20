/* Lab 13: MyHashTable
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: November 6, 2013
 */

import java.util.*;
public class MyHashTable<T>
{
   private LinkedList<T>[] table;
   public MyHashTable (int tablesize)
   {
      table = (LinkedList<T>[]) new LinkedList[tablesize];
      for(int i =0; i<table.length; i++)
      {
         table[i] = new LinkedList<T>();
      }
   }

   private int hash(T item)
   {
      return Math.abs (item.hashCode()) % table.length;
   }

   public void insert(T item)
   {
      table[hash(item)].addFirst(item);
   }

   public void delete(T item)
   {
      table[hash(item)].remove(item);
   }

   public boolean find(T item)
   {
      return table[hash(item)].contains(item);
   }

   public boolean isEmpty()
   {
      for(int i = 0; i<table.length; i++)
      {
         if(table[i].size() != 0)
            return false;
      }
      return true;
   }

   public void print()
   {
      for(int i = 0; i<table.length; i++)
      {
         System.out.print(i + ": ");
         for(int j = 0; j < table[i].size(); j++)
            System.out.print(table[i].get(j) + " ");
         System.out.println();
      }

   }

   public void makeEmpty()
   {
      for(int i=0; i<table.length; i++)
      {
         if(table[i].size() != 0)
         {
            table[i].clear();
         }
      }
   }

   public int size()
   {
      int size = 0;
      for(int i=0; i<table.length; i++)
      {
         size += table[i].size();
      }
      return size;
   }

   private class Iter implements Iterator<T>
   {
      int i = 0, j = 0;

      public Iter()
      {
         while(i<table.length && table[i].size() == 0)
         {
            i++;
         }
      }

      public boolean hasNext()
      {
         if(i < table.length)
         {
            return true;
         }
         return false;
      }

      public T next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }

         T item = table[i].get(j);

         if(j+1 < table[i].size())
         {
            j = j + 1;
         }
         else
         {
            i++;
            while(i < table.length && table[i].size() == 0)
            {
               i++;
            }

            j = 0;
         }

         return item;
      }

      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   public Iterator<T> iterator()
   {
      return new Iter();
   }
}
