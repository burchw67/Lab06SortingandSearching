import java.util.Scanner;
import java.util.Random;


public class Lab06SortSearchWAB
{
    public static void main(String[] args)
    {
        //Necessary strings
        String introString =
                "Welcome to the Supermarket Checkout System\n" +
                "Author: William Anthony Burch\n" +
                "Select an Option:\n\n" +
                "1. Create an array of 15 random elements from 10 to 99\n" +
                "2. Search for an element using linear search\n" +
                "3. Search for an element using binary search\n" +
                "4. Sort the array using Selection Sort\n" +
                "5. Sort the array using Insertion Sort\n" +
                "6. Sort the array using Bubble Sort\n" +
                "7. Sort the array using Bubble Sort (Faster)\n" +
                "8. Sort the array using Merge Sort\n" +
                "9. Sort the array using Lucky Sort\n" +
                "10. Reset the array\n" +
                "11. Print the array\n" +
                "12. Quit\n";

        String quit = "N";
        String choice = "x";

        //Scanner Object creation
        Scanner scanMan = new Scanner(System.in);

        //Array & all-purpose integer
        int[] intArr = new int[15];
        int[] originArr = new int[15];

        int alpInt = 0;

        //Random Number Generator
        Random randal = new Random();

        while (quit.charAt(0) != 'Y' && quit.charAt(0) != 'y')
        {
            System.out.print("\nEnter your choice: ");
            choice = scanMan.nextLine();

            switch (choice)
            {
                case "1":
                    for(int i = 0; i < 15; i++)
                    {
                        intArr[i] = randal.nextInt(10,100);
                    }

                    for(int i = 0; i < 15; i++)
                    {
                        originArr[i] = intArr[i];
                    }

                    System.out.println("\nArray populated with 15 random elements successfully.\n");
                    break;

                case "2":
                    System.out.print("Enter an integer to search for: ");
                    choice = scanMan.nextLine();

                    alpInt = linearSearch(intArr, choice);

                    if (alpInt != -1)
                    {
                        System.out.println("\nElement " + choice + " found in " + alpInt + " hits using linear search.\n");
                    }
                    else
                    {
                        System.out.println("\nElement " + choice + " could not be found in " + intArr.length + " hits using linear search.\n");
                    }
                    break;

                case "3":
                    System.out.print("Enter an integer to search for: ");
                    choice = scanMan.nextLine();

                    alpInt = linearSearch(intArr, choice);

                    if (alpInt != -1)
                    {
                        System.out.println("\nElement " + choice + " found in " + alpInt + " hits using binary search.\n");
                    }
                    else
                    {
                        System.out.println("\nElement " + choice + " could not be found using binary search.\n");
                    }
                    break;

                case "4":
                    System.out.print("\nOriginal array: ");

                    for(int x : intArr)
                    {
                        System.out.print(x + " ");
                    }
                    System.out.println(" ");

                    System.out.println("\n\nArray sorted in " + selectionSort(intArr) + " passes, using Selection Sort");
                    break;

                case "5":
                    System.out.print("\nOriginal array: ");

                    for(int x : intArr)
                    {
                        System.out.print(x + " ");
                    }
                    System.out.println(" ");

                    System.out.println("\n\nArray sorted in " + insertionSort(intArr) + " passes, using Insertion Sort");
                    break;

                case "10":
                    for(int i = 0; i < 15; i++)
                    {
                        intArr[i] = originArr[i];
                    }
                    System.out.println("\nOriginally generated array contents successfully.");
                    break;

                case "11":
                    for(int element : intArr)
                    {
                        System.out.print(element + " ");
                    }
                    System.out.println("");
                    break;
            }
            }
        }



    public static int linearSearch(int[] arr, String intChoice)
    {
        //'Hit' counter
        int hitCount = 0;

        //Check to see if entry can parse into an integer
        try
        {
            Integer.parseInt(intChoice);
        } catch (NumberFormatException e) {
            System.out.println("\nEntry must be an integer, try again!");
            return -1;
        }

        //Check to see if its larger than 99 or smaller than 10
        if(intChoice.length() > 2 || Integer.parseInt(intChoice) > 99 || Integer.parseInt(intChoice) < 10)
        {
            System.out.println("\nEntry must be a 2 digit integer between 10 and 99, try again!");
            return -1;
        }

        //FINALLY check to see if its in the array
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == Integer.parseInt(intChoice))
            {
                return hitCount;
            }
            else
            {
                hitCount++;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, String intChoice)
    {
        //'Hit' counter
        int hitCount = 0;

        //Check to see if entry can parse into an integer
        try
        {
            Integer.parseInt(intChoice);
        } catch (NumberFormatException e) {
            System.out.println("\nEntry must be an integer, try again!");
            return -1;
        }

        //Check to see if its larger than 99 or smaller than 10
        if(intChoice.length() > 2 || Integer.parseInt(intChoice) > 99 || Integer.parseInt(intChoice) < 10)
        {
            System.out.println("\nEntry must be a 2 digit integer between 10 and 99, try again!");
            return -1;
        }

        int low = 0, high = arr.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == Integer.parseInt(intChoice)) {
                return hitCount;
            }
            // If choice is greater, ignore left half
            else if (arr[mid] < Integer.parseInt(intChoice)) {
                low = mid + 1;
                hitCount++;
            }
            // If choice is smaller, ignore right half
            else
            {
                high = mid - 1;
                hitCount++;
            }
        }

        //If this return is reached element does not exist in the array
        return -1;
    }

    public static int selectionSort(int[] arr)
    {
        int passCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            // Assume the current position holds the minimum element
            int minIndex = i;

            // Iterate through the unsorted portion to find the actual minimum
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {

                    // Update minIndex if a smaller element
                    // is found
                    minIndex = j;
                }
            }

            // Move minimum element to its correct position
            if (minIndex != i)
            {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                passCount++;

                System.out.print("\nPass " + passCount + ": ");
                for(int x : arr)
                {
                    System.out.print(x + " ");
                }
            }
        }
        return passCount;
    }

    public static int insertionSort(int[] arr)
    {
        int passCount = 0;

        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return passCount;
    }
}


