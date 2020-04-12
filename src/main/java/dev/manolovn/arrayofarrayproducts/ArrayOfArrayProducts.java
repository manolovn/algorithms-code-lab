package dev.manolovn.arrayofarrayproducts;

public class ArrayOfArrayProducts {

    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return new int[]{};
        }

        int len = arr.length;
        int[] result = new int[len];
        result[0] = 1;

        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        int aux = 1;
        for (int i = len - 2; i >= 0; i--) {
            aux *= arr[i + 1];
            result[i] *= aux;
        }

        return result;
    }
}
