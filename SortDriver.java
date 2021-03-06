/**
 * Sorting Lab
 * Date - October 2, 2021
 * Arjun, Victor, James S.
 * Mr. Ho
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class SortDriver {
  public static void main (String[] args) {
    //Set Up
    long beginTime, endTime;
    long difference = 0;
    boolean choosing = true;
    String choice = "";
    Scanner input = new Scanner(System.in);
   
    
    //Sort choice and validation
    while(choosing){
      System.out.println("Selection, insertion or merge sort?");
      choice = input.nextLine();
      choice = choice.toLowerCase();
      if(choice.equals("selection") || choice.equals("insertion")|| choice.equals("merge")){     
        choosing = false;  
      } else {
        System.out.println("Incorrect word, please choose again:");
      }
    }
    
    //Check for valid sort size selection
     System.out.println("How much do you want to sort? (-1 for all sizes)");
    int size = 0;
    boolean invalid = true;
        while (invalid) {
            if (input.hasNextInt()) { 
                size = input.nextInt();
                if (size < -1 || size == 0) {
                    System.out.println("\nError: too small. Please enter a number that is -1 or above 0:");
                    continue;
                }           
            }  else { // when the input is not an integer
                System.out.println("\nError: invalid type or too large. Please enter a number that is -1 or above 0:");  
                input.next();
                continue;
            }
            invalid = false; // when all of the conditions are false there will be no continue and we will reach here 
        }
      
      if (size > 0) {// If the size is custom
        int[] data = createDataset(size);
        ///Measures the time when the method started until it ends exceution and finds the difference
        if (choice.equals("selection")) { // The selection method
            beginTime = System.currentTimeMillis();
            selectionSort(size,data);
            endTime = System.currentTimeMillis();
            difference = endTime - beginTime;
        } else if (choice.equals("insertion")) { // The insertion method
            beginTime = System.currentTimeMillis();
            insertionSort(size,data);
            endTime = System.currentTimeMillis();
            difference = endTime - beginTime;
        } else if (choice.equals("merge")) { // The merge method
            beginTime = System.currentTimeMillis();
            sort(data,0,size-1);
            endTime = System.currentTimeMillis();
            difference = endTime - beginTime;
        } //Prints out the max, min, and the sorting time
        System.out.println("Max: " + data[size-1]);
        System.out.println("Min: " + data[0]);
        System.out.println("Sorting time: " + difference + "ms");
        
      } else if (size == -1) {//If the size is -1 it will do the preset sizes
        String[] arr = new String[5];
        
        int[] sizes = {10000,20000,40000,80000,160000};
         //Choosing the method for the preset: will loop through all sizes and push results to array
        if (choice.equals("selection")) {
          
          for (int i = 0; i < 5; i++) {
            beginTime = System.currentTimeMillis();
            selectionSort(sizes[i],createDataset(sizes[i]));
            endTime = System.currentTimeMillis();
            difference = endTime - beginTime;
            arr[i] = sizes[i] + "," + difference;
          }
          
        } else if (choice.equals("insertion")) {
          
          for (int i = 0; i < 5; i++) { 
            beginTime = System.currentTimeMillis();
            insertionSort(sizes[i],createDataset(sizes[i]));
            endTime = System.currentTimeMillis();
            difference = endTime - beginTime;
            arr[i] = sizes[i] + "," + difference;
          }
          
        } else if (choice.equals("merge")) {

          for (int i = 0; i < 5; i++) {
            int mergeArr[] = createDataset(sizes[i]); //needs to be created ahead of time because mergesort is recursive, calling each time is costly
            beginTime = System.currentTimeMillis();
            sort(mergeArr,0,(sizes[i]-1));
            endTime = System.currentTimeMillis();
            difference = endTime - beginTime;
            arr[i] = sizes[i] + "," + difference;
          }  

        }
        //Printing out the array to the csv file
        writeToFile(arr);
        System.out.println("results.csv file updated");
      }
    input.close();
  } 
 /**
   * Sorts an array of size elements using selection sort.
   * @param size size of array
   * @param arr array containing unsorted elements
   */
  public static void selectionSort(int size, int[] arr){
        for (int i = 0; i < size; i++)  {
            // min is the index of the smallest element with an index equal to i (or greater, if condition below met)
            int min = i;
            for (int j = i + 1; j < size; j++){
                if (arr[j] < arr[min]){
                    min = j; // if there is an element to the right of min that is smaller than it, update min to that
                }
            }
            // swapping i-th and min-th elements
            int swap = arr[i];
            arr[i] = arr[min];
            arr[min] = swap;
        }
    }
  /**
     * Sorting algorithm that sorts each element one at a time. For each element, insertionSort looks at the sorted array of elements
     * in the indices before it and determines the element's correct location among the array of sorted elements
     * @param size - size of the array to be sorted 
     * @param arr - array to be sorted
     */
    public static void insertionSort(int size, int[] arr){
        int key;
        int j;
        
        //Loop through each element of the array
        for (int i = 1; i < size; ++i) {
          key = arr[i];
          j = i - 1;
          
          // Re-arrange elements that are greater than the key to in front of the key's index
          while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
          }
          // Inserts element in correct position of the sorted part of the array
          arr[j + 1] = key;
        }
      }
  
  // Merges two subarrays of arr[].
  // First subarray is arr[l..m]
  // Second subarray is arr[m+1..r]
  
  /**
   * This is merging part of the sorting method 
   * it will then procced to mergeing them back together
   * @para arr is that will be formated 
   * @para l this is the left side of the array
   * @para m this is to check the middle of the array 
   * @para r this is the right side of the array
   */
  static void merge(int arr[], int l, int m, int r)
  {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;
    
    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];
    
    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];
    
    /* Merge the temp arrays */
    
    // Initial indexes of first and second subarrays
    int i = 0, j = 0;
    
    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }    
    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
  // Main function that sorts arr[l..r] using
  // merge()
  /**
   * This is the sort method that will take all the parts of the spit up array and call upon the combine method
   * it will then procced to mergeing them back together
   * @para arr is that will be formated 
   * @para l this is the left side of the array
   * @para r this is the right side of the array
   */
  static void sort(int arr[], int l, int r)
  {
    if (l < r) {
      // Find the middle point
      int m =l+ (r-l)/2;
      
      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m + 1, r);
      
      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }
/**
 * Creates an array of size specificed filled with random numbers from 0 to integer max value.
 * @param size desired array size
 * @return unsorted randomized array of size specified
 */
    public static int[] createDataset(int size) {
    Random ran = new Random();
    int[] data = new int[size];
    for (int i = 0; i < size; i++) {
      data[i] = ran.nextInt(Integer.MAX_VALUE);
    }
    return data;
  }
  /**
   * This method will print the array of the output to the file two values for each row sepreated by a comma
   * @para arr is the arr that we will print to the file
   */
  public static void writeToFile(String[] arr){
    try {
      FileWriter file = new FileWriter("results.csv");
      for (int i = 0; i < 5; i++) {
        file.append(arr[i]);//Prints out the row and then create another row
        file.append("\n");
      }
      file.close();
    } catch (IOException e) {//if there is an error catch it
      e.printStackTrace();
    }
  }
  
}
