public class Lab_11 {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }

    public static void main(String[] args) {
        int[] myArray = { 1, 3, 5, 7, 9, 11, 13 };
        int targetValue = 7;

        int result = linearSearch(myArray, targetValue);

        if (result != -1) {
            System.out.println("Target " + targetValue + " found at index " + result + ".");
        } else {
            System.out.println("Target " + targetValue + " not found in the array.");
        }
    }
}
