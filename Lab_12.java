public class Lab_12 {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Return the index if the target is found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Return -1 if the target is not found in the array
    }

    public static void main(String[] args) {
        int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13 };
        int targetValue = 13;

        int result = binarySearch(sortedArray, targetValue);

        if (result != -1) {
            System.out.println("Target " + targetValue + " found at index " + result + ".");
        } else {
            System.out.println("Target " + targetValue + " not found in the array.");
        }
    }
}
