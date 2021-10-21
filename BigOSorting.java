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
                insertionSort(size,data);
            } else if (choice.equals("merge")) {
                // merge call
            }
            System.out.println("Max: " + data[size-1]);
            System.out.println("Min: " + data[0]);

        } else {
            int[]arr1;
            long beginTime;
            long endTime;

            int[] sizes = {10000,20000,40000,80000,160000};


            if (choice.equals("selection")) {

                for (int i = 0; i < 5; i++) {
                   
                    beginTime = System.currentTimeMillis();
                    selectionSort(sizes[i],createDataset(sizes[i]));
                    endTime = System.currentTimeMillis();
                    long difference = endTime - beginTime;
                    System.out.println("size:" + sizes[i] + "difference:" + difference);
                }
                  

            } else if (choice.equals("insertion")) {
                
                for (int i = 0; i < 5; i++) {
                  
                    beginTime = System.currentTimeMillis();
                    insertionSort(sizes[i],createDataset(sizes[i]));
                    endTime = System.currentTimeMillis();
                    long difference = endTime - beginTime;
                    System.out.println("size:" + sizes[i] + "difference:" + difference);
                }

            } else if (choice.equals("merge")) {
                // merge call
            } else {
                System.out.println("Invalid");
            }


        }


    }

    public static void selectionSort(int size, int[] arr){
        for (int i = 0; i < size; i++)  {
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

    public static void insertionSort(int size, int[] arr){
        int key;
        int j;

        for (int i = 1; i < size; ++i) {
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

    
}
