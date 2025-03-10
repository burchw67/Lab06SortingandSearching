import java.util.Scanner;
import java.util.Random;


public class Lab06SortSearchWAB
{
    public static void main(String[] args)
    {
        //Necessary strings
        String introString =
                "Welcome to the Sorting and Searching System\n" +
                        "Author: William Anthony Burch\n";

        String optionString =
                "\nSelect an Option:\n\n" +
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
                        "12. Quit\n"+
                        "\nEnter your choice: ";


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

        //Boolean for choice 3 confirmation
        boolean sorted = false;

        System.out.println(introString);

        while (quit.charAt(0) != 'Y' && quit.charAt(0) != 'y')
        {
            System.out.print(optionString);
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

                    System.out.println("\nArray populated with 15 random elements successfully.");
                    sorted = false;
                    break;

                case "2":
                    System.out.print("Enter an integer to search for using linear search: ");
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
                    if(!sorted)
                    {
                        System.out.print("\nThe list must be sorted for binary search to work, try again!\n");
                        break;
                    }
                    System.out.print("Enter an integer to search for using binary search: ");
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
                    if(sorted)
                    {
                        System.out.print("\nThe array is already sorted!\n");
                        break;
                    }

                    System.out.print("\nOriginal array: ");

                    for(int x : intArr)
                    {
                        System.out.print(x + " ");
                    }
                    System.out.println(" ");

                    System.out.println("\n\nArray sorted in " + selectionSort(intArr) + " steps, using Selection Sort");
                    sorted = true;
                    break;

                case "5":
                    if(sorted)
                    {
                        System.out.print("\nThe array is already sorted!\n");
                        break;
                    }

                    System.out.print("\nOriginal array: ");

                    for(int x : intArr)
                    {
                        System.out.print(x + " ");
                    }
                    System.out.println(" ");

                    System.out.println("\n\nArray sorted in " + insertionSort(intArr) + " steps, using Insertion Sort");
                    sorted = true;
                    break;

                case "6":
                    if(sorted)
                    {
                        System.out.print("\nThe array is already sorted!\n");
                        break;
                    }

                    System.out.print("\nOriginal array: ");

                    for(int x : intArr)
                    {
                        System.out.print(x + " ");
                    }
                    System.out.println(" ");

                    System.out.println("\n\nArray sorted in " + bubbleSortSlow(intArr) + " steps, using the slow bubble Sort");
                    sorted = true;
                    break;

                case "7":
                    if(sorted)
                    {
                        System.out.print("\nThe array is already sorted!\n");
                        break;
                    }

                    System.out.print("\nOriginal array: ");

                    for(int x : intArr)
                    {
                        System.out.print(x + " ");
                    }
                    System.out.println(" ");

                    System.out.println("\n\nArray sorted in " + bubbleSort(intArr) + " steps, using the optimized bubble Sort");
                    sorted = true;
                    break;

                case "8":
                    if(sorted)
                    {
                        System.out.print("\nThe array is already sorted!\n");
                        break;
                    }

                    System.out.println("\n\nArray sorted in " + mergeSort(intArr,15) + " steps using merge Sort.");
                    sorted = true;
                    break;

                case "9":
                    if(sorted)
                    {
                        System.out.print("\nThe array is already sorted!\n");
                        break;
                    }

                    luckySort(intArr);
                    sorted = true;
                    break;


                case "10":
                    for(int i = 0; i < 15; i++)
                    {
                        intArr[i] = originArr[i];
                    }
                    System.out.println("\nOriginally generated array contents successfully.");
                    sorted = false;
                    break;

                case "11":
                    for(int element : intArr)
                    {
                        System.out.print(element + " ");
                    }
                    System.out.println("");
                    break;

                case "12":
                    System.out.print("Are you sure you want to quit? [Y/N]");
                    quit = scanMan.nextLine();

                    if(Character.toUpperCase(quit.charAt(0)) == 'N' || Character.toLowerCase(quit.charAt(0)) == 'n')
                    {
                        break;
                    }
                    else if(Character.toUpperCase(quit.charAt(0)) == 'Y' || Character.toLowerCase(quit.charAt(0)) == 'y')
                    {
                        quit = "yes";
                        break;
                    }
                    else
                    {
                        break;
                    }

                case "cycle1":

            }
        }
    }


    //////////////////////---------------Sorting and Searching Methods---------------//////////////////////
    //////////////////////-All code sourced from elsewhere is slightly modified by me-//////////////////////
    public static int linearSearch(int[] arr, String intChoice)
    {//This search method is originally written by me
        //'Hit' counter
        int hitCount = 1;

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
    {//This search method was sourced from GeeksforGeeks.com
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
            hitCount++;
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == Integer.parseInt(intChoice)) {
                return hitCount;
            }
            // If choice is greater, ignore left half
            else if (arr[mid] < Integer.parseInt(intChoice)) {
                low = mid + 1;
            }
            // If choice is smaller, ignore right half
            else
            {
                high = mid - 1;
            }
        }

        //If this return is reached element does not exist in the array
        return -1;
    }

    public static int selectionSort(int[] arr)
    {//Code sourced from GeeksforGeeks.com
        int passCount = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            // Assume the current position holds the minimum element
            int minIndex = i;

            // Iterate through the unsorted portion to find the actual minimum
            for (int j = i + 1; j < arr.length; j++)
            {
                passCount++;
                if (arr[j] < arr[minIndex])
                {
                    // Update minIndex if a smaller element is found
                    minIndex = j;
                    passCount++;
                }
            }

            // Move minimum element to its correct position
            if (minIndex != i)
            {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                passCount++;
            }

            System.out.print("\n");
            for(int x : arr)
            {
                System.out.print(x + " ");
            }
        }
        return passCount;
    }

    public static int insertionSort(int[] arr)
    {//Code sourced from GeeksforGeeks.com
        int passCount = 0;

        for (int i = 1; i < arr.length; ++i)
        {
            passCount++;
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key)
            {
                passCount++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return passCount;
    }

    public static int bubbleSortSlow(int[] arr)
    {//Code sourced from class
        int passCount = 0;

        int swap;
        for (int i = 0; i < arr.length - 1; i++)
        { // Loop for passes
            passCount++;
            for (int j = 0; j < arr.length - 1; j++)
            { // Inner loop for comparisons
                passCount++;
                if (arr[j] > arr[j + 1])
                { // Swap if out of order
                    swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }

            System.out.print("\n");
            for(int x : arr)
            {
                System.out.print(x + " ");
            }
        }
        return passCount;
    }

    public static int bubbleSort(int[] arr)
    {//Code sourced from class
        int passCount = 0;
        boolean swapped = false;

        int swap;
        for (int i = 0; i < arr.length - 1; i++)
        { // Loop for passes
            passCount++;
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++)
            { // Inner loop for comparisons
                passCount++;
                if (arr[j] > arr[j + 1])
                { // Swap if out of order
                    swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    swapped = true;
                }
            }

            if(!swapped)
            {
                return passCount;
            }

            System.out.print("\n");
            for(int x : arr)
            {
                System.out.print(x + " ");
            }
        }
        return passCount;
    }

    public static int mergeSort(int[] arr, int n)
    {//Code sourced from chatGPT.
        int passCount = 0;
        if (n < 2) {
            return passCount;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
            passCount++;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
            passCount++;
        }
        mergeSort(l, mid);
        passCount += mergeSort(r, n - mid);
        passCount += merge(arr, l, r, mid, n - mid);
        return passCount;
    }

    public static int merge(int[] a, int[] l, int[] r, int left, int right)
    {//Code sourced from chatGPT.

        int i = 0, j = 0, k = 0;
        int passCount = 0;

        while (i < left && j < right)
        {
            passCount++;
            if (l[i] <= r[j])
            {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left)
        {
            a[k++] = l[i++];
            passCount++;
        }
        while (j < right)
        {
            a[k++] = r[j++];
            passCount++;
        }

        return passCount;
    }

    public static void luckySort(int[] arr)
    {//Code sourced from chatGPT.
        int count = 0;
        int start = 0;
        int stop = arr.length - 1;
        int passCount = 0;
        Random rand = new Random();

        for (int n = start; n <= stop; n++)
        {
            while (true)
            {
                count++;

                // Shuffle the range [n, stop]
                for (int i = n; i <= stop; i++) {
                    int randomIndex = rand.nextInt(stop - n + 1) + n;
                    int temp = arr[i];
                    arr[i] = arr[randomIndex];
                    arr[randomIndex] = temp;
                    count++;
                }

                // Find the smallest value in range [n, stop]
                int min = arr[n];
                for (int i = n + 1; i <= stop; i++)
                {
                    count++;
                    if (arr[i] < min)
                    {
                        min = arr[i];
                    }
                }

                // Check if array[n] is the smallest in the range
                if (arr[n] == min)
                {
                    break;  // Stop shuffling and move to the next element
                }
            }
        }

        System.out.print("\nSorted array: ");
        for(int x : arr)
        {
            System.out.print(x + " ");
        }
        System.out.println("\nWith a total of " + count + " steps");
    }
}