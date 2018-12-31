public class Sentinel{
	private class IntNode{
		public int item;
		public IntNode next;
	
		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}
	
	public IntNode sentinel;
	private int size;

    public Sentinel(){
		sentinel = new IntNode(22, null);
		size = 0;
    }
    
	public Sentinel(int i){
        sentinel = new IntNode(22, null);
		sentinel.next = new IntNode(i, null);
		size = 1;
	}

	public Sentinel(int[] a){
		sentinel = new IntNode(22, null);
		for(int i = 0; i < a.length; i++){
			addLast(a[i]);
		}
	}

	public void addFirst(int x){
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
    }
    
    public void deleteFirst(){
		if(sentinel.next == null){
            System.out.println("empty list!!!");
            return;
        }
        sentinel.next = sentinel.next.next;

	}

	public void addLast(int x){
		IntNode p = sentinel;
		// int size = this.size();
		// for(int i =0; i < size - 1; i++){
		// 	p = p.next;
		// }
		while(p.next != null){
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;

	}

	public int getFirst(){ 
		return sentinel.next.item;
	}

	/** using caching method, oop programming, everything is controlled by object  */
	public int size(){
		return size;
	}

	public static void main(String[] args){

		Sentinel a = new Sentinel();
		a.addLast(4);
		a.addFirst(5);
		a.addFirst(9);
		a.addLast(6);
		a.deleteFirst();
		// System.out.println(a.first.item);
		// System.out.println(a.first.next);

		System.out.println(a.size());
		System.out.println(a.sentinel.next.item);
		System.out.println(a.sentinel.next.next.item);
		System.out.println(a.sentinel.next.next.next.item);

		int[] b = new int[]{3,4,5,6};
		Sentinel c = new Sentinel(b);
		// System.out.println(a.first.item);
		// System.out.println(a.first.next);

		System.out.println(c.size());
		System.out.println(c.sentinel.next.item);
		System.out.println(c.sentinel.next.next.item);
		System.out.println(c.sentinel.next.next.next.item);
		System.out.println(c.sentinel.next.next.next.next.item);

	}
}