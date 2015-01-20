/* Program 2
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 11, 2013
 *
 * Description: Binary Heap ADT
 */

public class BinHeap<T extends Comparable<? super T>>
{
   //Exception
   public static class MyException extends RuntimeException
   {
      //MyException Constructor Without Message
      public MyException()
      {
         super();
      }

      //MyException Constructor With Message
      public MyException(String message)
      {
         super(message);
      }
   }

   //Private Instance Variable for Array Representation of Heap
   private T[] arr;
   //Private Instance Variable for Size of Heap
   private int size;

   //Heap Constructor
   public BinHeap()
   {
      //Creates Empty Binary Heap With 100 Empty Spots
      arr = (T[]) new Comparable[100];
      //Initializes Size to Zero
      size = 0;
   }

   //Heap Constructor With Size Parameter
   public BinHeap(int arrSize)
   {
      //Creates Empty Binary Heap With Specified Empty Spots
      arr = (T[]) new Comparable[arrSize];
      //Initializes Size to Zero
      size = 0;
   }

   //Insert Method Adds Item to Heap
   //Places in Location Such That Heap is Valid
   public void insert(T item)
   {
      int hole = size;

      //Increase the Size of the Heap
      size++;

      //If Heap Is Full, Double Size of Heap
      if(size > arr.length)
      {
         T[] temp = (T[]) new Comparable[arr.length*2];
         for(int i=0; i<arr.length; i++)
         {
            temp[i] = arr[i];
         }
         arr = temp;
      }

      //Traverse the Heap Backwards Until Item Is Placed In Location Such That Heap Is Valid
      while(hole!= 0 && item.compareTo(arr[(hole-1)/2]) < 0)
      {
         //If Current Hole Location Is Not Valid, Place Parent Into Hole
         //Then Change Hole To Parent Location
         arr[hole] = arr[(hole-1)/2];
         hole = (hole-1)/2;
      }
      arr[hole] = item;
   }

   //Removes and Returns Smallest Value in Heap
   //Valid Heap is Left After Method Is Called
   public T deleteMin()
   {
      //Throw Exception if Heap Is Empty
      if(isEmpty())
      {
         throw new MyException();
      }

      int hole = 0;
      T item = arr[hole];
      T temp = arr[size-1];
      size--;
      int newhole = newHole(hole,temp);

      //Traverses Heap from Top Until Last Value Can Be Placed In Valid Location
      while(newhole != -1)
      {
         arr[hole] = arr[newhole];
         hole = newhole;
         newhole = newHole(hole, temp);
      }

      arr[hole] = temp;
      return item;
   }

   //Checks If Heap Is Empty Based on Size
   //Returns True If Empty, False If Not
   public boolean isEmpty()
   {
      if(size == 0)
      {
         return true;
      }
      return false;
   }

   //Returns the Size of the Heap
   public int size()
   {
      return this.size;
   }

   //Returns the Heap in the Order Stored in the Array
   public String toString()
   {
      String str = "";
      for(int i=0; i<size; i++)
      {
         str = str + arr[i] + " ";
      }
      return str;
   }

   //Private Method Used By DeleteMin Method
   //Sets New Hole to Child If Item is Smaller Than Smallest Child
   private int newHole(int hole, T item)
   {
      int newhole = -1;
      //If Left Child Exists
      if(2*hole+1 < size)
      {
         //If Right Child Does Not Exist
         if(2*hole+2 >= size)
         {
            //If Child Item Is Less Than Last Item In Heap
            if(arr[2*hole+1].compareTo(item) < 0)
            {
               //Set New Hole To Left Child
               newhole = 2*hole + 1;
            }
         }
         else
         {
            //If Left Child Item Is Greater Than Right Child
            if(arr[(2*hole)+1].compareTo(arr[(2*hole)+2]) > 0)
            {
               //If Right Child Is Less Than Last Item In Heap
               if(arr[2*hole+2].compareTo(item) < 0)
               {
                  //Set New Hole to Right Child
                  newhole = 2*hole + 2;
               }
            }
            else
            {
               //If Left Child Is Less Than Last Item In Heap
               if(arr[2*hole+1].compareTo(item) < 0)
               {
                  //Set New Hole to Left Child
                  newhole = 2*hole + 1;
               }
            }
         }
      }
      return newhole;
   }
}
