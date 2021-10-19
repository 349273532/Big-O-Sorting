
import java.util.Scanner;
import java.util.Random;

public class BigOSorting {
    public static void main (String[] args) {
        Random ran = new Random();
      
        Scanner input = new Scanner(System.in);
        int max = -1;
        System.out.println("Selection, insertation or merge sort?");
        String choice = input.nextLine(); // to do: put in methods

        choice = choice.toLowerCase();

        System.out.println("How much do you want to sort? (-1 for all sizes)");
        int size = input.nextInt();

        if (size != -1) {
        int[] data = new int[size];
            
        } else {
            // sort 5 arrays of 10000, 20000, 40000, 80000, 160000 size
        }
        for (int i = 0; i < size; i++) {
            data[i] = ran.nextInt(Integer.MAX_VALUE);
        }

        if (choice.equals("selection")) {
            selectionSort(size,data);
        } else if (choice.equals("insertation")) {
            // insertation call
        } else if (choice.equals("merge")) {
            // merge call
        }

        System.out.println("Max: " + data[size-1]);
        System.out.println("Min: " + data[0]);

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
}
