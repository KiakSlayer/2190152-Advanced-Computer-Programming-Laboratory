public class UnsortedList extends PythonList {

    public UnsortedList(int[] array) {
        // Set the strategy to use the unsorted algorithm
        super(array);
        this.strategy = new UnsortedFindMinMaxStrategy();    
    }

    public void append(int v) {
        int[] a = new int[array.length+1];
        for(int i=0; i < array.length; i++) {
            a[i] = array[i];
        }
        a[array.length] = v;
        array = a;
    }
}