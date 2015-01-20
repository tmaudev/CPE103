/* Program 3: MyStack
 *
 * Authors: Tyler Mau (tmau)  and Jeffrey Tang (jtang14)
 * Date: October 28, 2013
 *
 * Description: Stack ADT
 */

import java.util.EmptyStackException;

public class MyStack<T>
{
   //Defines Private Node Class (Represents Element In Stack)
   private class Node
   {
      //Variable Contains Element in Stack
      public T element;
      //Next Item In Stack
      public Node next;
   }

   //Top of Stack
   private Node top;

   //Constructor Initializes Empty Stack
   public MyStack()
   {
      top = null;
   }

   //Adds Element to Stack
   public void push(T elem)
   {
      Node temp = new Node();
      temp.element = elem;
      temp.next = top;
      top = temp;
   }

   //Removes and Returns Element From Stack
   public T pop()
   {
      T temp;
      if(isEmpty())
      {
         throw new EmptyStackException();
      }

      temp = top.element;
      top = top.next;
      return temp;
   }

   //Returns the Top Element In Stack
   public T peek()
   {
      if(isEmpty())
      {
         //Throws Exception if Stack is Empty
         throw new EmptyStackException();
      }
      return top.element;
   }

   //Returns True if Empty, False if Not
   public boolean isEmpty()
   {
      if(top == null)
      {
         return true;
      }
      return false;
   }
}
