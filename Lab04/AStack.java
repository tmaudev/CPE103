public class AStack<T>
{
   private T[] arr;
   private int top;

   public AStack(int size)
   {
      arr = (T[]) new Object[size];
      top = -1;
   }

   public void push(T item)
   {
      if(top >= arr.length-1)
      {
         T[] temp = (T[]) new Object[arr.length*2];
         for(int i = 0; i<arr.length; i++)
         {
            temp[i] = arr[i];
         }
         arr = temp;
      }
      top++;
      arr[top] = item;
   }

   public T pop()
   {
      if(isEmpty())
      {
         throw new MyException();
      }
      T temp = arr[top];
      arr[top] = null;
      top--;
      return temp;
   }

   public T peek()
   {
      if(isEmpty())
      {
         throw new MyException();
      }
      T temp = arr[top];
      return temp;
   }

   public boolean isEmpty()
   {
      if(top == -1)
         return true;
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
