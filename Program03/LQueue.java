/* Program 3: Linked List Queue
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: October 28, 2013
 *
 * Description: Linked List Queue ADT
 */

//Linked List Queue ADT Class
public class LQueue<T>
{
   //Private Nodes For Front and End
   private Node front;
   private Node end;

   //Constructor
   public LQueue()
   {
      //Set Front and End to Null
      front = end = null;
   }

   //Private Node Class
   private class Node
   {
      //Generic Value Variable
      public T value;
      //Points to Next Node
      public Node next;
   }

   //Add Item to End of Queue
   public void enqueue(T item)
   {
      Node temp = new Node();
      temp.value = item;
      if(isEmpty() == false)
         end.next = temp;
      else
         front = temp;
      end = temp;
   }

   //Remove and Return Front Element
   public T dequeue()
   {
      T temp;
      if(isEmpty())
      {
         throw new MyException();
      }
      else
      {
         temp = front.value;
         front = front.next;
      }
      return temp;
   }

   //Check If Queue is Empty (Return True If Empty, False If Not
   public boolean isEmpty()
   {
      if(front == null)
      {
         return true;
      }
      return false;
   }

   //Custom Exception Class
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
