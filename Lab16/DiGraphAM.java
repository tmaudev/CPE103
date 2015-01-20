public class DiGraphAM
{
   private int[][] adjTable;
   
   public DiGraphAM(int N)
   {
      adjTable = new int[N][N];
   }
   
   public void addEdge(int start, int end)
   {
      adjTable[start][end] = 1;
   }
   
   public void deleteEdge(int start, int end)
   {
      adjTable[start][end] = 0;
   }
   
   public int edgeCount()
   {  
      int count = 0;
      for(int i = 0; i < adjTable.length; i++)
      {
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] == 1)
               count++;
         }
      }
      return count;
   }
   
   public int vertexCount()
   {
      return adjTable.length;
   }
   
   public void print()
   {  
      for(int i = 0; i < adjTable.length; i++)
      {
         System.out.print(i + " is connected to: ");
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] == 1)
               System.out.print(j + ", ");
         }
         System.out.println();
      }
   }
   
   private int[] indegrees()
   {
      int[] answer = new int[adjTable.length];
      for(int i = 0; i < adjTable.length; i++)
      {
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] == 1)
               answer[j]++;
         }
      }
      return answer;
   }
   
   public int[] topSort()
   {
      int[] temp = indegrees();
      int[] answer = new int[adjTable.length];
      LQueue<Integer> queue = new LQueue();
      int count = 0;
      for(int i = 0; i < adjTable.length; i++)
      {
         if(temp[i] == 0)
            queue.enqueue(i);
      }
      while(!queue.isEmpty())
      {
         int v = queue.dequeue();
         answer[count] = v;
         count++;
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[v][j] == 1)
            {
               temp[j]--;
               if(temp[j] == 0)
                  queue.enqueue(j);
            }   
         }
      }
      if(count != adjTable.length)
      {
         throw new LQueue.MyException();
      }
      return answer;
   }
}