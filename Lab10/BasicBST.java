/* Lab 10 Basic Binary Search Tree
 *
 * Authors: Tyler Mau
 * Date: October 28, 2013
 *
 */

public class BasicBST
{
   private class BSTNode
   {
      int elem;
      BSTNode left, right;
   }

   private BSTNode root;

   public BasicBST()
   {
      root = null;
   }

   public void insert(int item)
   {
      root = insert(item,root);
   }

   private BSTNode insert(int item, BSTNode node)
   {
      if(node == null)
      {
         node = new BSTNode();
         node.elem = item;
      }
      else
      {
         if(item < node.elem)
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

   public int countOdds()
   {
      return countOdds(root);
   }

   private int countOdds(BSTNode node)
   {
      int odds = 0;

      if(node == null)
      {
         return 0;
      }

      if(node.elem % 2 != 0)
      {
         return odds += countOdds(node.left) + countOdds(node.right) + 1;
      }

      return odds += countOdds(node.left) + countOdds(node.right);
   }

   public int height()
   {
      return height(root);
   }

   private int height(BSTNode node)
   {
      if(node != null)
      {
         int h1 = height(node.left);
         int h2 = height(node.right);
         if(h1 < h2)
         {
            return h2 + 1;
         }
         else
         {
            return h1 + 1;
         }
      }
      return -1;
   }

   public int countLeaves()
   {
      return countLeaves(root);
   }

   private int countLeaves(BSTNode node)
   {
      int size;

      if(node == null)
      {
         size = 0;
      }
      else if(node.left == null && node.right == null)
      {
         size = 1;
      }
     /* else if(node.left == null && node.right != null)
      {
         size = countLeaves(node.right);
      }
      else if(node.left != null && node.right == null)
      {
         size = countLeaves(node.left);
      }*/
      else
      {
         size = countLeaves(node.left) + countLeaves(node.right);
      }

      return size;
   }

   public int countOneChildParents()
   {
      return countOneChildParents(root);
   }

   private int countOneChildParents(BSTNode node)
   {
      if(node == null)
      {
         return 0;
      }
      else if(node.left != null && node.right != null)
      {
         return countOneChildParents(node.left) + countOneChildParents(node.right);
      }
      else if(node.left == null && node.right == null)
      {
         return 0;
      }
      else if(node.left != null)
      {
         return 1 + countOneChildParents(node.left);
      }
      else
      {
         return 1 + countOneChildParents(node.right);
      }
   }
}
