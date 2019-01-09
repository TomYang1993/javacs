public class AList {

    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[10];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size == items.length){
            int[] a = new int[items.length * 2];
            System.arraycopy(items,0,a,0,size);
            items = a;
        }
        items[size] = x;
        size += 1;
    }


    public void addFirst(int x){


        size += 1;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {

        int result = items[size - 1];
        size = size - 1;
        return result;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

} 