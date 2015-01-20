/* Lab 11: MySortedList
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: November 1, 2013
 *
 */

public class MySortedList
{
   private class Node
   {
      public int elem;
      Node next;
   }

   private Node head;

   public MySortedList()
   {
      head = null;
   }

   public void add(int item)
   {
      if(isEmpty())
      {
         head = new Node();
         head.elem = item;
      }
      else if(item < head.elem)
      {
         Node temp = new Node();
         temp.elem = item;
         temp.next = head;
         head = temp;
      }
      else
      {
         Node current = head;
         while(current.next != null && current.next.elem < item)
         {
            current = current.next;
         }

         Node temp = new Node();
         temp.elem = item;

         if(current.next != null)
         {
            temp.next = current.next;
         }
         current.next = temp;
      }
   }

   public void delete(int item)
   {
      if(!isEmpty())
      {
         if(head.elem == item)
         {
            head = head.next;
         }
         else
         {
            Node current = head;
            while(current.next != null && current.next.elem < item)
            {
               current = current.next;
            }

            if(current.next != null)
            {
               if(current.next.elem == item)
               {
                  if(current.next.next != null)
                  {
                     current.next = current.next.next;
                  }
                  else
                  {
                     current.next = null;
                  }
               }
            }
         }
      }
   }

   public int max()
   {
      Node current = head;

      while(current.next != null)
      {
         current = current.next;
      }
      return current.elem;
   }

   public int min()
   {
      return head.elem;
   }

   public void print()
   {
      Node current = head;

      while(current != null)
      {
         System.out.print(current.elem + " ");
         current = current.next;
      }
   }

   public boolean isEmpty()
   {
      if(head == null)
      {
         return true;
      }
      return false;
   }
}
