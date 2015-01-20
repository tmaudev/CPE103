/* Program 5: Sorting Algorithms
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: November 24, 2013
 *
 * Description: Contains the following sorting algorithms:
 *              Selection Sort, Bubble Sort, Insertion Sort,
 *              Merge Sort, Quick Sort
 */

//Sorts Class
public class Sorts
{
   //Selection Sort Algorithm
   public static <Type extends Comparable<? super Type>> void selectionSort(Type[] arr, int size)
   {
      int i,j,index;

      for(i=0; i<size; i++)
      {
         index = i;
         for(j=i+1; j<size; j++)
         {
            if(arr[j].compareTo(arr[index]) < 0)
            {
               index = j;
            }
         }
         swap(arr,i,index);
      }
   }

   //Bubble Sort Algorithm
   public static <Type extends Comparable<? super Type>> void bubbleSort(Type[] arr, int size)
   {
      boolean done = false;

      while(!done)
      {
         done = true;

         for(int i=0; i<size-1; i++)
         {
            if(arr[i].compareTo(arr[i+1]) > 0)
            {
               swap(arr,i,i+1);
               done = false;
            }
         }
      }
   }

   //Insertion Sort Algorithm
   public static <Type extends Comparable<? super Type>> void insertionSort(Type[] arr, int size)
   {
      int i, j;
      Type item;

      for(i=1; i<size; i++)
      {
         item = arr[i];
         j = i;
         while((j>0) && (item.compareTo(arr[j-1]) < 0))
         {
            arr[j] = arr[j-1];
            j--;
         }
         arr[j] = item;
      }
   }

   //Merge Sort Method
   public static <Type extends Comparable<? super Type>> void mergeSort(Type[] arr, int size)
   {
      mergeSort(arr,0,size-1);
   }

   //Recursive Merge Sort Algorithm
   private static <Type extends Comparable<? super Type>> void mergeSort(Type[] arr, int start, int end)
   {
      if(end > start)
      {
         int middle = (start + end)/2;
         mergeSort(arr,start,middle);
         mergeSort(arr,middle+1,end);
         mergeSortedHalves(arr,start,middle,end);
      }
   }

   //Merge Split Sorted Halves from Merge Sort Method
   private static <Type extends Comparable<? super Type>>
                  void mergeSortedHalves(Type[] arr, int left, int middle, int right)
   {
      Type[] temp = (Type[])new Comparable[right-left+1];
      int index1 = left;
      int index2 = middle + 1;
      int index = 0;

      while(index1 <= middle && index2 <= right)
      {
         if(arr[index1].compareTo(arr[index2]) < 0)
         {
            temp[index] = arr[index1];
            index1++;
         }
         else
         {
            temp[index] = arr[index2];
            index2++;
         }
         index++;
      }

      while(index1 <= middle)
      {
         temp[index] = arr[index1];
         index++;
         index1++;
      }

      while(index2 <= right)
      {
         temp[index] = arr[index2];
         index++;
         index2++;
      }

      for(int i=0; i<temp.length; i++)
      {
         arr[left+i] = temp[i];
      }
   }

   //Quick Sort Method
   public static <Type extends Comparable<? super Type>> void quickSort(Type[] arr, int size)
   {
      quickSort(arr,0,size-1);
   }

   //Recursive Quick Sort Method
   private static <Type extends Comparable<? super Type>>
                  void quickSort(Type[] arr, int start, int end)
   {
      if(end > start)
      {
         setPivotToEnd(arr,start,end);
         int index = splitList(arr,start,end);
         quickSort(arr,start, index-1);
         quickSort(arr,index+1,end);
      }
   }

   //Splits Quick Sort List Into Parts for Recursion
   private static <Type extends Comparable<? super Type>>
                  int splitList(Type[] arr, int start, int end)
   {
      int indexL = start;
      int indexR = end-1;
      Type pivot = arr[end];

      while(indexL <= indexR)
      {
         while(pivot.compareTo(arr[indexL]) > 0)
         {
            indexL++;
         }

         while(indexL <= indexR  && pivot.compareTo(arr[indexR]) < 0)
         {
            indexR--;
         }

         if(indexL <= indexR)
         {
            swap(arr,indexL,indexR);
            indexL++;
            indexR--;
         }
      }
      swap(arr,indexL,end);
      return indexL;
   }

   //Method Uses Median of 3 Pivot and Rotates Left, Right, and Pivot Indexes for Optimization
   private static <Type extends Comparable<? super Type>>
                  void setPivotToEnd(Type[] arr, int left, int right)
   {
      Type temp;
      int center = (left + right)/2;

      if(arr[center].compareTo(arr[left]) < 0)
      {
         swap(arr,center,left);
      }

      if(arr[right].compareTo(arr[left]) < 0)
      {
         swap(arr,right,left);
      }

      if(arr[center].compareTo(arr[right]) < 0)
      {
         swap(arr,center,right);
      }
   }

   //Private Swap Method Swaps 2 Elements in Given Indices
   private static <Type extends Comparable<? super Type>> void swap(Type[] arr, int i, int j)
   {
      Type temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
}
