/* Lab 6: AQueue
 *
 * Date: October 9, 2013
 * Authors: Tyler Mau and Jeffrey Tang
 *
 */

public class AQueue<T>
{
   private T[] arr;
   private int front;
   private int end;
   private int count;

   public AQueue(int size)
   {
      arr = (T[]) new Object[size];
      front = 0;
      end = -1;
      count = 0;
   }

   public boolean isEmpty()
   {
      if(count == 0)
      {
         return true;
      }
      return false;
   }

   public void enqueue(T item)
   {
      if((front-1 == end && !isEmpty()) || (front == 0 && end == arr.length-1))
      {
         T[] temp = (T[]) new Object[arr.length * 2];
         int j = 0;

         if(end >= front)
         {
            for(int i=front; i<=end; i++)
            {
               temp[j] = arr[i];
               j++;
            }
         }
         else
         {
            for(int i=front; i<arr.length; i++)
            {
               temp[j] = arr[i];
               j++;
            }
            for(int i=0; i<end+1; i++)
            {
               temp[j] = arr[i];
               j++;
            }
         }
         arr = temp;
         front = 0;
         end = count-1;
      }
      count++;
      if(end < arr.length-1)
      {
         end++;
      }
      else
      {
         end = 0;
      }
      arr[end] = item;
   }

   public T dequeue()
   {
      if(isEmpty())
      {
         throw new MyException();
      }

      T item = arr[front];
      arr[front] = null;
      if(front < arr.length-1)
      {
         front++;
      }
      else
      {
         front = 0;
      }
      count--;

      return item;
   }

   public void printArray()
   {
      for(int i=0; i<arr.length; i++)
      {
         System.out.print(arr[i] + " ");
      }
   }

   public static class MyException extends RuntimeException
   {
      public MyException()
      {
         super();
      }
      public MyException(String message)
      {
         super(message);
      }
   }
}
