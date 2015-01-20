/* Lab 8: MyList
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 16, 2013
 */

public class MyList
{
   private Node head;

   private class Node
   {
      private int elem;
      private Node next;
   }

   public MyList()
   {
      head = null;
   }

   public void add(int item)
   {
      Node temp = new Node();
      if(head == null)
      {
         temp.elem = item;
         head = temp;
      }
      else
      {
         temp.elem = item;
         temp.next = head;
         head = temp;
      }
   }

   public boolean find(int item)
   {
      return find(item,head);
   }

   private boolean find(int item, Node temp)
   {
      if(temp == null)
      {
         return false;
      }
      if(temp.elem == item)
      {
         return true;
      }
      return find(item,temp.next);
   }

   public void print()
   {
      print(head);
   }

   private void print(Node temp)
   {
      if(temp != null)
      {
         print(temp.next);
         System.out.print(temp.elem + " ");
      }
   }

   public int sum()
   {
      return sum(head);
   }

   private int sum(Node temp)
   {
      if(temp != null)
      {
         return temp.elem + sum(temp.next);
      }
      return 0;
   }
}
