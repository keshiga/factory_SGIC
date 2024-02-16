
        import java.util.Arrays;
        import java.util.Scanner;

        // Interface for sorting algorithms
        interface SortingAlgorithm {
            void sort(int[] arr);
        }

// Bubble sort algorithm
        class BubbleSort implements SortingAlgorithm {
            @Override
            public void sort(int[] arr) {
                int n = arr.length;
                for (int i = 0; i < n-1; i++) {
                    for (int j = 0; j < n-i-1; j++) {
                        if (arr[j] > arr[j+1]) {
                            // Swap arr[j] and arr[j+1]
                            int temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                        }
                    }
                }
            }
        }

// Quick sort algorithm
        class QuickSort implements SortingAlgorithm {
            @Override
            public void sort(int[] arr) {
                quickSort(arr, 0, arr.length - 1);
            }

            private void quickSort(int[] arr, int low, int high) {
                if (low < high) {
                    int pi = partition(arr, low, high);
                    quickSort(arr, low, pi - 1);
                    quickSort(arr, pi + 1, high);
                }
            }

            private int partition(int[] arr, int low, int high) {
                int pivot = arr[high];
                int i = low - 1;
                for (int j = low; j < high; j++) {
                    if (arr[j] < pivot) {
                        i++;
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                int temp = arr[i + 1];
                arr[i + 1] = arr[high];
                arr[high] = temp;
                return i + 1;
            }
        }

// Factory class to create instances of sorting algorithms
        class SortingFactory {
            enum SortingType {BUBBLE_SORT,QUICK_SORT};
                public static SortingType sortingType;


            // Factory method to get SortingAlgorithm instance based on type
            public static SortingAlgorithm getSortingAlgorithm(SortingType type) {
                switch (type) {
                    case BUBBLE_SORT:
                        return new BubbleSort();
                    case QUICK_SORT:
                        return new QuickSort();
                    default:
                        throw new IllegalArgumentException("Unsupported sorting algorithm type");
                }}}

        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the number of elements in the array: ");
                int n = scanner.nextInt();

                // Create an array of size n
                int[] arr = new int[n];

                // Prompt the user to enter the elements of the array
                System.out.println("Enter the elements of the array:");

                for (int i = 0; i < n; i++) {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                }
                System.out.println("Select the sorting pattern:");
                System.out.println("1. bubble sort");
                System.out.println("2. Quick sort");
                System.out.println("Enter your choice: ");
                int choice =scanner.nextInt();
                
                //SortingFactory.SortingType.sortingType;
                SortingFactory.SortingType sortingType;
                if (choice==1) {
                    sortingType = SortingFactory.SortingType.BUBBLE_SORT;} 
                else if (choice ==2) { 
                    sortingType= SortingFactory.SortingType.QUICK_SORT;}
                else {
                    System.out.println("Invalid choice Exiting..");
                    return;}
                    


                

                // Print the array
                System.out.println("Array entered by the user:");
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                scanner.close();

                // Create a BubbleSort instance using Factory pattern
                SortingAlgorithm bubbleSort = SortingFactory.getSortingAlgorithm(SortingFactory.SortingType.BUBBLE_SORT);
                bubbleSort.sort(arr.clone());
                System.out.println("Bubble Sorted array: " + Arrays.toString(arr));

                // Create a QuickSort instance using Factory pattern
                SortingAlgorithm quickSort = SortingFactory.getSortingAlgorithm(SortingFactory.SortingType.QUICK_SORT);
                quickSort.sort(arr.clone());
                System.out.println("Quick Sorted array: " + Arrays.toString(arr));
            }
        }


