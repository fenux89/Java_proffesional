package homework1.task3;

import java.util.Arrays;
import java.util.Collections;

public class SortItOut {
    public static Double[] sortItOut(Double[] array) {
        int chetCount = 0;
        int nechetCount = 0;
        int indexChet = 0;
        int indexNechet = 0;

        for (int i = 0; i < array.length; i++) {
            if (Math.floor(array[i]) % 2 == 0) {
                chetCount++;
            } else {
                nechetCount++;
            }
        }
        Double[] newchet = new Double[chetCount];
        Double[] newnechet = new Double[nechetCount];

        for (int i = 0; i < array.length; i++) {

            Math.floor(array[i]);

            if (Math.floor(array[i]) % 2 == 0) {
                newchet[indexChet++] = array[i];
            } else {
                newnechet[indexNechet++] = array[i];
            }
        }
        Arrays.sort(newnechet);
        Arrays.sort(newchet, Collections.reverseOrder());

        System.arraycopy(newnechet, 0, array, 0, nechetCount);
        System.arraycopy(newchet, 0, array, nechetCount, chetCount);
        return array;
    }

    public static void main(String[] args) {
        Double[] a = {11d, 22d, 33d, 44d, 55d, 55d, 90.4, 4d, 78d};
        System.out.println(Arrays.toString(sortItOut(a)));
    }
}
