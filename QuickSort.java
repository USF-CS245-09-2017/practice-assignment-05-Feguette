import java.util.Arrays;
/**
 * Sorts an array in-place using the quick sort algorithm.
 *
 * @author Jason Liang
 * @vesion (27 February 2019)
 */
public class QuickSort implements SortingAlgorithm {


    public void sort(int[] a) {
        //Arrays.sort(a);
        quickSort(a, 0, a.length - 1);

    }
    /*
     * Program breaks between 1 to 1.5 million integers
     */
    private void quickSort(int[] a, int lower, int upper) {
        if (lower < upper) {
            int pivot = partition(a, lower, upper);
            quickSort(a, lower, pivot - 1);
            quickSort(a,pivot + 1, upper);
        }

    }
    /*
     *
     */
    private int partition (int[] a, int lower, int upper) {
        //Escape case: if the leftmost index is higher than the rightmost index or at.
        if (lower >= upper)
            return lower;

        //Setting the pivot: Gets the most median value of the leftmost, rightmost, and middle index,
        //then swaps them to pivot index, which is the leftmost "lower"
        //No swapping required if index lower is already the median.
        int mid = (lower + upper)/2;
        if (a[mid] < Math.max(a[lower], a[upper]) && a[mid] > Math.min(a[lower], a[upper]))
            swap(a, mid, lower);
        else if (a[upper] < Math.max(a[lower], a[mid]) && a[upper] > Math.min(a[lower], a[mid]))
            swap(a, lower, upper);


        int left = lower + 1;
        int right = upper;
        while (left < right) {
            //Next while loops "lock onto" possible swapping values
            while (left <= upper && a[left] <= a[lower])
                left++;
            while (right >= left && a[right] > a[lower])
                right--;
            if (left <= upper && left < right)
                swap(a, left, right);
        }
        swap(a, lower, right);
        return right;

    }

    /*
     * Assumes in bounds, swap() swaps 2 values in an array
     */
    public void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }


//    public int getClosestAverage(int[] a) {
//
//        return mid;
//    }

}

