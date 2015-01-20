/*
 * 
 */

public class LQueue<T>
{

   private Node front;
   private Node end;
   
   public LQueue()
   {
      front = end = null;
   }
   
   private class Node
   {
      public T value;
      public Node next;
   }
   
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
   
   public boolean isEmpty()
   {
      if(front == null)
      {
         return true;
      }
      return false;
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