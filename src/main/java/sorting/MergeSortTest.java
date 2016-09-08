package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


/**
 * Created by SBT-Ryazanov-IV on 05.09.2016.
 */
public class MergeSortTest {
    @Test
    public void testMergeToSort() {
        Random random = new Random(47);
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt();
        }
        int[] arraySorted = MergeSort.mergeToSort(array);
        Arrays.sort(array);
        Assert.assertArrayEquals(arraySorted, array);
    }
}
