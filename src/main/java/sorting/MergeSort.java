package sorting;

import java.util.Arrays;

/**
 * Created by SBT-Ryazanov-IV on 02.09.2016.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] integers = new int[]{1, 5, 17, 20, 2, 4, 18, 220};
//        int[] ints1 = new int[]{1, 5, 17, 20};
//        int[] ints2 = new int[]{2, 4, 18, 220};

        System.out.println(Arrays.toString(mergeToSort(integers)));

//        System.out.println(Arrays.toString(
//                mergeSorted(ints1, ints2)));
    }

    public static int[] mergeToSort(int[] intArray){
        if(intArray.length > 1){
            int q = intArray.length / 2;
            int[] left = mergeToSort(Arrays.copyOfRange(intArray, 0, q));
            int[] right = mergeToSort(Arrays.copyOfRange(intArray, q, intArray.length));
            return mergeSorted(left, right);
        }
        return intArray;
    }

    private static int[] mergeSorted(int[] ints1, int[] ints2) {
        int i = 0;
        int j = 0;
        int newLength = ints1.length + ints2.length;
        int[] ints = new int[newLength];
        for (int k = 0; k < newLength; k++) {
            if (ints1[i] < ints2[j]) {
                ints[k] = ints1[i];
                i++;
                if (i == ints1.length) {
                    System.arraycopy(ints2, j, ints, k + 1, ints2.length - j);
                    break;
                }
            } else {
                ints[k] = ints2[j];
                j++;
                if (j == ints2.length) {
                    System.arraycopy(ints1, i, ints, k + 1, ints1.length - i);
                    break;
                }
            }
        }
        return ints;
    }

}
