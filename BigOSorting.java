
import java.util.Scanner;
import java.util.Random;

public class BigOSorting {
    public static void main (String[] args) {
       
      
        Scanner input = new Scanner(System.in);
       
        System.out.println("Selection, insertation or merge sort?");
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        System.out.println("How much do you want to sort? (-1 for all sizes)");
        int size = input.nextInt();

        if (size != -1) {
        int[] data = createDataset(size);

        if (choice.equals("selection")) { // make this a method
            selectionSort(size,data);
        } else if (choice.equals("insertation")) {
            // insertation call
        } else if (choice.equals("merge")) {
            // merge call
        }
        System.out.println("Max: " + data[size-1]);
        System.out.println("Min: " + data[0]);

        } else { 
            int[]arr1 = createDataset(10000);
            int[]arr2 = createDataset(20000);
            int[]arr3 = createDataset(40000);
            int[]arr4 = createDataset(80000);
            int[]arr5 = createDataset(160000);
            

            

            if (choice.equals("selection")) { 
                
                long beginTime = System.currentTimeMillis();
                selectionSort(10000,arr1);
                long endTime = System.currentTimeMillis();
                long difference = endTime - beginTime;

                long beginTime2 = System.currentTimeMillis();
                selectionSort(20000,arr2);
                long endTime2 = System.currentTimeMillis();
                long difference2 = endTime2 - beginTime2;

                long beginTime3 = System.currentTimeMillis();
                selectionSort(40000,arr3);
                long endTime3 = System.currentTimeMillis();
                long difference3 = endTime3 - beginTime3;

                long beginTime4 = System.currentTimeMillis();
                selectionSort(80000,arr4);
                long endTime4 = System.currentTimeMillis();
                long difference4 = endTime4 - beginTime4;

                long beginTime5 = System.currentTimeMillis();
                selectionSort(160000,arr5);
                long endTime5 = System.currentTimeMillis();
                long difference5 = endTime5 - beginTime5;

            } else if (choice.equals("insertation")) {
                // insertation call
            } else if (choice.equals("merge")) {
                // merge call
            } else {
                System.out.println("Invalid");
            }


        }
        

    }

    public static void selectionSort(int size, int[] arr){  
        for (int i = 0; i < size-1; i++)  {  
            int index = i;  
            for (int j = i + 1; j < size; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }

    public static int[] createDataset(int size) {
        Random ran = new Random();
        int[] data = new int[size];
            
        for (int i = 0; i < size; i++) {
            data[i] = ran.nextInt(Integer.MAX_VALUE);
        }
        return data;
    }

    public static void chooseSort () {

    }
}
