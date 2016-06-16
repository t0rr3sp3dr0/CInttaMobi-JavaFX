package systems.singularity.cinttamobi.util;

public class ArraysUtil {
    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> void bubbleSort(E[] array, boolean order) {
        boolean swapped = true;
        for (int i = 0; i < array.length - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                E a = array[j];
                E b = array[j] instanceof String ? (E) array[j].toString().toLowerCase() : array[j];
                if ((order && b.compareTo(array[j + 1]) > 0) || (!order && b.compareTo(array[j + 1]) < 0)) {
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                    swapped = true;
                }
            }
        }
    }

    public static <E> boolean contains(E[] array, E obj) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(obj))
                return true;
        return false;
    }

    public static <E> int indexOf(E[] array, E obj) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(obj))
                return i;
        return -1;
    }

    public static <E> void invert(E[] array) {
        E[] e = array.clone();
        for (int i = 0; i < array.length; i++)
            array[i] = e[array.length - i - 1];
    }
}
