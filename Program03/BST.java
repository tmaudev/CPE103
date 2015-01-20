/* Program 3: Binary Search Tree
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: October 28, 2013
 *
 * Description: Generic Binary Search Tree ADT
 *              Items to the left of a node are < than the parent node.
 *              Items to the right of a node are >= the parent node.
 */

import java.util.*;

//Binary Search Tree Class (Comparable)
public class BST<T extends Comparable<? super T>>
{
   //Private Node Class
   private class BSTNode
   {
      //Holds Generic Element
      T elem;
      //Points to 2 Nodes (Left and Right)
      BSTNode left, right;
   }

   //Private Instance Variable to Represent Root of Tree
   private BSTNode root;

   //Pre-Order Traversal Iterator
   private class PreIter implements Iterator<T>
   {
      //Stack for Storing Nodes (Used for Traversing)
      public MyStack<BSTNode> stack;

      //Pre-Order Iterator Constructor
      public PreIter()
      {
         //Initializes Stack
         stack = new MyStack<BSTNode>();

         //If Stack is Not Empty, Push Root to Stack
         if(!isEmpty())
         {
            stack.push(root);
         }
      }

      //Determines If A Next Value Exists
      public boolean hasNext()
      {
         //Returns False If Stack is Empty
         if(stack.isEmpty())
         {
            return false;
         }
         return true;
      }

      //Returns the Next Element in Pre-Order Traversal
      public T next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }

         BSTNode node = stack.pop();

         if(node.right != null)
         {
            stack.push(node.right);
         }

         if(node.left != null)
         {
            stack.push(node.left);
         }

         return node.elem;
      }

      //Remove Method Not Supported
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   //In-Order Traversal Iterator
   private class InIter implements Iterator<T>
   {
      MyStack<BSTNode> stack;

      //Constructor
      public InIter()
      {
         //Initializes Stack
         stack = new MyStack<BSTNode>();
         if(!isEmpty())
         {
            stack.push(root);
            stackUpLefts(root);
         }
      }

      //Determines If A Next Value Exists
      public boolean hasNext()
      {
         //Returns False If Stack is Empty
         if(stack.isEmpty())
         {
            return false;
         }
         return true;
      }

      //Returns the Next Element in In-Order Traversal
      public T next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }

         BSTNode node = stack.pop();

         if(node.right != null)
         {
            stack.push(node.right);
            stackUpLefts(node.right);
         }
         return node.elem;
      }

      private void stackUpLefts(BSTNode node)
      {
         while(node.left != null)
         {
            stack.push(node.left);
            node = node.left;
         }
      }

      //Remove Method Not Supported
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   //Level-Order Traversal Iterator
   private class LevelIter implements Iterator<T>
   {
      public LQueue<BSTNode> queue;

      //Constructor
      public LevelIter()
      {
         //Initializes Queue
         queue = new LQueue<BSTNode>();
         if(!isEmpty())
         {
            queue.enqueue(root);
         }
      }

      //Determines If A Next Value Exists
      public boolean hasNext()
      {
         if(queue.isEmpty())
         {
            return false;
         }
         return true;
      }

      //Returns the Next Element in Level-Order Traversal
      public T next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }

         BSTNode node = queue.dequeue();

         if(node.left != null)
         {
            queue.enqueue(node.left);
         }

         if(node.right != null)
         {
            queue.enqueue(node.right);
         }

         return node.elem;
      }

      //Remove Method Not Supported
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }

   //Custom Exception
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

   //Binary Search Tree Constructor
   public BST()
   {
      root = null;
   }

   //Insert Item Into Valid Tree Location
   public void insert(T item)
   {
      root = insert(item,root);
   }

   //Private Recursive Insert Method
   private BSTNode insert(T item, BSTNode node)
   {
      if(node == null)
      {
         node = new BSTNode();
         node.elem = item;
      }
      else
      {
         if(item.compareTo(node.elem) < 0)
         {
            node.left = insert(item, node.left);
         }
         else
         {
            node.right = insert(item, node.right);
         }
      }
      return node;
   }

   //Remove Specified Item From Tree and Rebuild Valid Tree
   public void delete(T item)
   {
      root = delete(item,root);
   }

   //Private Recursive Delete Method
   private BSTNode delete(T item, BSTNode node)
   {
      if(node != null)
      {
         if(item.compareTo(node.elem) < 0)
         {
            node.left = delete(item,node.left);
         }
         else if(item.compareTo(node.elem) > 0)
         {
            node.right = delete(item,node.right);
         }
         else
         {
            node = deleteNode(node);
         }
      }
      return node;
   }

   //Private Method for Delete
   //Deletes Node Containing Item and Re-References Nodes
   private BSTNode deleteNode(BSTNode node)
   {
      if(node.left != null && node.right != null)
      {
         T value = successor(node);
         node.elem = value;
         node.right = delete(value,node.right);
         return node;
      }
      else if(node.left != null)
      {
         return node.left;
      }
      else if(node.right != null)
      {
         return node.right;
      }
      else
      {
         return null;
      }
   }

   //Private Method for Delete
   //Finds Smallest Value from Right Branch
   //Used to Replace the Deleted Node If 2 Children Existed
   private T successor(BSTNode node)
   {
      BSTNode temp = node.right;

      while(temp.left != null)
      {
         temp = temp.left;
      }
      return temp.elem;
   }

   //Find Specified Item In Tree (True If Found, False If Not)
   public boolean find(T item)
   {
      return find(item,root);
   }

   //Private Recursive Find Method
   private boolean find(T item, BSTNode node)
   {
      if(node == null)
      {
         return false;
      }

      if(node.elem.equals(item))
      {
         return true;
      }
      else
      {
         if(item.compareTo(node.elem) < 0)
         {
            return find(item,node.left);
         }
         else
         {
            return find(item,node.right);
         }
      }
   }

   //Returns True If Tree Is Empty, False If Not
   public boolean isEmpty()
   {
      if(root == null)
      {
         return true;
      }
      return false;
   }

   //Empties the Tree (References the Root to Null)
   public void makeEmpty()
   {
      root = null;
   }

   //Returns the Number of Nodes in the Tree
   public int size()
   {
      return size(root);
   }

   //Private Recursive Size Method
   private int size(BSTNode treeRoot)
   {
      int size;

      if(treeRoot == null)
      {
         size = 0;
      }
      else
      {
         size = size(treeRoot.left) + 1 + size(treeRoot.right);
      }

      return size;
   }

   //Returns Minimum Value in Tree
   public T findMinimum()
   {
      if(isEmpty())
      {
         throw new MyException();
      }
      return findMinimum(root);
   }

   //Private Recursive Minimum Method
   private T findMinimum(BSTNode node)
   {
      T item;
      if(node.left != null)
      {
         return findMinimum(node.left);
      }
      item = node.elem;
      return item;
   }

   //Returns Maximum Value in Tree
   public T findMaximum()
   {
      if(isEmpty())
      {
         throw new MyException();
      }
      return findMaximum(root);
   }

   //Private Recursive Maximum Method
   private T findMaximum(BSTNode node)
   {
      T item;
      if(node.right != null)
      {
         return findMaximum(node.right);
      }
      item = node.elem;
      return item;
   }

   //Creates Pre-Order Iterator
   public Iterator<T> iteratorPre()
   {
      return new PreIter();
   }

   //Creates In-Order Iterator
   public Iterator<T> iteratorIn()
   {
      return new InIter();
   }

   //Creates Level-Order Iterator
   public Iterator<T> iteratorLevel()
   {
      return new LevelIter();
   }

   //Prints the Tree With Visual Indentations
   public void printTree()
   {
      printTree(root,"");
   }

   //Private Recursive Tree Printing Method
   private void printTree(BSTNode node, String tabs)
   {
      if(node != null)
      {
         System.out.print("\n" + tabs);
         System.out.print(node.elem);
         tabs = tabs + "   ";
         printTree(node.left,tabs);
         printTree(node.right,tabs);
      }
   }

   //Print Tree On One Line Separated By Spaces
   public String toString()
   {
      return toString(root,"");
   }

   //Private Recursive toString Method
   private String toString(BSTNode node, String tree)
   {
      if(node != null)
      {
         tree += node.elem + " ";
         tree = toString(node.left,tree);
         tree = toString(node.right,tree);
      }
      return tree;
   }
}
