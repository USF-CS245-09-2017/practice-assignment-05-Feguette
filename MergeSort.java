/**
 * Sorts an array in-place using the merge sort algorithm.
 *
 * @author Jason Liang
 * @vesion (27 February 2019)
 */
public class MergeSort implements SortingAlgorithm {
    public void sort(int[] a) {
        mergeSplit(a);
    }
    /*
     * Splits the array. Naming scheme similar to cell division
     * @param parent int[] used to be split into two, then remerged at mergeSplice()
     */
    private void mergeSplit(int[] parent) {
        int genome = parent.length;
        if (genome > 1) {
            int[] clone1 = new int[genome/2], clone2 = new int[genome - genome/2];
            //Copies both arrays
            for (int i = 0; i < genome / 2; i++)
                clone1[i] = parent[i];
            for (int i = 0; i < genome - genome/2; i++)
                clone2[i] = parent[i + genome/2];
            mergeSplit(clone1);
            mergeSplit(clone2);
            mergeSplice(parent, clone1, clone2);
        }
    }
    /*
     * Merges the clone arrays into parent
     * @param
     */
    private void mergeSplice(int[] parent, int[] clone1, int[] clone2) {
        int counter1 = 0, counter2 = 0;
        while (parent.length > counter1 + counter2) {
            //1st case of if-statement for when clone2 elements are used up
            //2nd case(after ||) is if clone1 has enough elements and the
            //current clone1 element is less than clone2's element
            //No necessity for parent counter since counter1 and 2 compose it
            if (counter2 > clone2.length - 1 || (counter1 <= clone1.length - 1 && clone1[counter1] <= clone2[counter2]))
                parent[counter1+counter2] = clone1[counter1++];
            else
                parent[counter1+counter2] = clone2[counter2++];
        }
    }
}
