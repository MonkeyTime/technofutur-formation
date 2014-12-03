package ex2;

public abstract class BinarySearch {

    private BinarySearch() {
        // hidden
    }

    public static int search(int[] a, int target) {
        int low = 0;
        int high = a.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midVal = a[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
