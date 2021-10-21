import java.util.Scanner;
import java.util.Random;

public class BigOSorting {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Selection, insertion or merge sort?");
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        System.out.println("How much do you want to sort? (-1 for all sizes)");
        int size = input.nextInt();

        if (size != -1) {
            int[] data = createDataset(size);

            if (choice.equals("selection")) { // make this a method
                selectionSort(size,data);
            } else if (choice.equals("insertion")) {
                insertionSort(data);
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

            long beginTime;
            long endTime;

            


            if (choice.equals("selection")) {

                beginTime = System.currentTimeMillis();
                selectionSort(10000,arr1);
                endTime = System.currentTimeMillis();
                long difference = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                selectionSort(20000,arr2);
                endTime = System.currentTimeMillis();
                long difference2 = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                selectionSort(40000,arr3);
                endTime = System.currentTimeMillis();
                long difference3 = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                selectionSort(80000,arr4);
                endTime = System.currentTimeMillis();
                long difference4 = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                selectionSort(160000,arr5);
                endTime = System.currentTimeMillis();
                long difference5 = endTime - beginTime;

            } else if (choice.equals("insertion")) {
                beginTime = System.currentTimeMillis();
                insertionSort(arr1);
                endTime = System.currentTimeMillis();
                long difference = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                insertionSort(arr2);
                endTime = System.currentTimeMillis();
                long difference2 = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                insertionSort(arr3);
                endTime = System.currentTimeMillis();
                long difference3 = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                insertionSort(arr4);
                endTime = System.currentTimeMillis();
                long difference4 = endTime - beginTime;

                beginTime = System.currentTimeMillis();
                insertionSort(arr5);
                endTime = System.currentTimeMillis();
                long difference5 = endTime - beginTime;

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

    public static void insertionSort(int[] arr){
        int key;
        int j;

        for (int i = 1; i < arr.length; ++i) {
            key = arr[i];
            j = i - 1;

            // Re-arrange elements that are greater than the key to in front of the key's index
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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

