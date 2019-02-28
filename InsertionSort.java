public class InsertionSort implements SortingAlgorithm {
    public void sort(int[] a) {

        int temp, j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            j = i-1;
            while (j >= 0 && temp < a[j])
                a[j+1] = a[j--];
            a[j+1] = temp;
        }
    }
}
