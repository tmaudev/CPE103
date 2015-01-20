/* Lab 15 Basic AVL Binary Search Tree
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: November 18, 2013
 *
 */

public class BasicAVL
{
   private class AVLNode
   {
      int elem;
      int height;
      AVLNode left, right;
   }

   private AVLNode root;

   public BasicAVL()
   {
      root = null;
   }

   public void insert(int item)
   {
      root = insert(item,root);
   }

   private AVLNode insert(int item, AVLNode node)
   {
      if(node == null)
      {
         node = new AVLNode();
         node.elem = item;
      }
      else
      {
         if(item < node.elem)
         {
            node.left = insert(item, node.left);
            if(node.left.height - height(node.right) == 2)
            {
               if(item < node.left.elem)
               {
                  node = rotateWithLeft(node);
               }
               else
               {
                  node = doubleLeftRight(node);
               }
            }
         }
         else if(item > node.elem)
         {
            node.right = insert(item, node.right);
            if(node.right.height - height(node.left) == 2)
            {
               if(item > node.right.elem)
               {
                  node = rotateWithRight(node);
               }
               else
               {
                  node = doubleRightLeft(node);
               }
            }
         }
      }
      node.height = Math.max(height(node.left),height(node.right)) + 1;
      return node;
   }

   private int height(AVLNode x)
   {
      int answer;
      if(x != null)
      {
         answer = x.height;
      }
      else
      {
         answer = -1;
      }
      return answer;
   }

   private AVLNode rotateWithLeft(AVLNode x)
   {
      AVLNode y = x.left;

      x.left = y.right;
      y.right = x;

      if(height(x.left) < height(x.right))
      {
         x.height = 1 + height(x.right);
      }
      else
      {
         x.height = 1 + height(x.left);
      }

      if(height(y.left) < height(y.right))
      {
         y.height = 1 + height(y.right);
      }
      else
      {
         y.height = 1 + height(y.left);
      }
      return y;
   }

   private AVLNode rotateWithRight(AVLNode x)
   {
      AVLNode y = x.right;

      x.right = y.left;
      y.left = x;

      if(height(x.left) < height(x.right))
      {
         x.height = 1 + height(x.right);
      }
      else
      {
         x.height = 1 + height(x.left);
      }

      if(height(y.left) < height(y.right))
      {
         y.height = 1 + height(y.right);
      }
      else
      {
         y.height = 1 + height(y.left);
      }
      return y;
   }

   private AVLNode doubleLeftRight(AVLNode x)
   {
      x.left = rotateWithRight(x.left);
      return rotateWithLeft(x);
   }

   private AVLNode doubleRightLeft(AVLNode x)
   {
      x.right = rotateWithLeft(x.right);
      return rotateWithRight(x);
   }

   //Prints the Tree With Visual Indentations
   public void print()
   {
      print(root,"");
   }

   //Private Recursive Tree Printing Method
   private void print(AVLNode node, String tabs)
   {
      if(node != null)
      {
         System.out.print("\n" + tabs);
         System.out.print(node.elem);
         tabs = tabs + "   ";
         print(node.left,tabs);
         print(node.right,tabs);
      }
   }
}
