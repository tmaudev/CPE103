/* Program 5: SortTimes2
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: November 24, 2013
 *
 * Description: Second Sort Times Test
 */

public class SortTimes2
{
   //Main Method
   public static void main(String[] args)
   {
      int N;
      long time1, time2, time3, time4, time5, start, end;

      //Create 5 Arrays of Size 80000
      Integer[] a1 = new Integer[80000];
      Integer[] a2 = new Integer[80000];
      Integer[] a3 = new Integer[80000];
      Integer[] a4 = new Integer[80000];
      Integer[] a5 = new Integer[80000];

      //Print Test Name
      System.out.println("\nTEST2: reverse sorted list");

      //Set N to 5000
      N = 5000;

      //Loop Testing for 5 Values of N
      for(int j=0; j<5; j++)
      {
         //Create Reverse Sorted Array of Size N
         for(int i=0; i<N; i++)
         {
            a1[i] = N-1-i;
         }

         //Copy Reverse Sorted Array to 4 Identical Arrays
         for(int i=0; i<N; i++)
         {
            a2[i] = a1[i];
            a3[i] = a1[i];
            a4[i] = a1[i];
            a5[i] = a1[i];
         }

         //Calculate Time for Selection Sort Algorithm
         start = System.nanoTime();
         Sorts.selectionSort(a1,N);
         end = System.nanoTime();
         time1 = (end-start)/1000000;

         //Calculate Time for Bubble Sort Algorithm
         start = System.nanoTime();
         Sorts.bubbleSort(a2,N);
         end = System.nanoTime();
         time2 = (end-start)/1000000;

         //Calculate Time for Insertion Sort Algorithm
         start = System.nanoTime();
         Sorts.insertionSort(a3,N);
         end = System.nanoTime();
         time3 = (end-start)/1000000;

         //Calculate Time for Merge Sort Algorithm
         start = System.nanoTime();
         Sorts.mergeSort(a4,N);
         end = System.nanoTime();
         time4 = (end-start)/1000000;

         //Calculate Time for Quick Sort Algorithm
         start = System.nanoTime();
         Sorts.quickSort(a5,N);
         end = System.nanoTime();
         time5 = (end-start)/1000000;

         //Print Time Results for N Elements
         System.out.println("N=" +N+
               ": T_ss=" + time1 +
               ", T_bs=" + time2 +
               ", T_is=" + time3 +
               ", T_ms=" + time4 +
               ", T_qs=" + time5);

         N = N * 2;
      }
      //Indicate End of Test
      System.out.println("END TEST2");
   }
}
