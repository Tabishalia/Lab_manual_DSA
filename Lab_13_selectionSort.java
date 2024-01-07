public class Lab_13_selectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = { 64, 25, 12, 22, 11 };
        selectionSort(arrayToSort);

        System.out.println("Selection Sort Result:");
        for (int element : arrayToSort) {
            System.out.print(element + " ");
        }
    }
}
