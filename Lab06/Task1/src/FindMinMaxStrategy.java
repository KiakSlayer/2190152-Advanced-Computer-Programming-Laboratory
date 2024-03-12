import java.util.NoSuchElementException;

public interface FindMinMaxStrategy {
    int findMin(int[] array);
    int findMax(int[] array);
    int[] sortArray(int[] array);
    int[] append(int value, int[] array);
    void check();
}

class UnsortedFindMinMaxStrategy implements FindMinMaxStrategy {
    public void check(){
        System.out.println("B");
    }
    @Override
    public int findMin(int[] array) {
        if (array.length == 0) throw new NoSuchElementException("No element in array");
        int min = Integer.MAX_VALUE;
        for(int a: array) {
            if(a < min) min = a;
        }
        return min;
    }

    @Override
    public int findMax(int[] array) {
        if (array.length == 0) throw new NoSuchElementException("No element in array");
        int max = Integer.MIN_VALUE;
        for(int a: array) {
            if(a > max) max = a;
        }
        return max;
    }

    @Override
    public int[] sortArray(int[] array) {   
        return array;
    }

    @Override
    public int[] append(int v, int[] array) {
        int[] a = new int[array.length+1];
        for(int i=0;i<array.length;i++) {
            a[i] = array[i];
        }
        a[array.length]=v;
        return a;
    }
}

class SortedFindMinMaxStrategy implements FindMinMaxStrategy {
    public void check(){
        System.out.println("A");
    }
    @Override
    public int findMin(int[] array) {
        if (array.length == 0) throw new NoSuchElementException("No element in array");
        return array[0];
    }

    @Override
    public int findMax(int[] array) {
        if (array.length == 0) throw new NoSuchElementException("No element in array");
        return array[array.length - 1];
    }

    @Override
    public int[] sortArray(int[] array) {
        for (int lastIndex = array.length - 1; lastIndex >= 1; lastIndex--) {
            for (int i = 0; i < lastIndex; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    @Override
    public int[] append(int v, int[] array) {
        int[] a = new int[array.length+1];
        int i = 0;
        while(i < array.length && v > array[i]) {
            a[i] = array[i];
            i++;
        }
        a[i++] = v;
        for(int j=i-1; j < array.length; j++) {
            a[i++] = array[j];
        }
        return a;
    }
}