public class LinkedListDeque<T> {

	private class LinkedNode {

		private T item;
		private LinkedNode prev;
		private LinkedNode next;

		public LinkedNode(T i, LinkedNode p, LinkedNode n){
			item = i;
			prev = p;
			next = n;
		}

		private T getRecursive(int index){
			if(index == 0){
				return this.item;
			}
			return next.getRecursive(index -1);
		}
	}

	private LinkedNode sentinel;
	private LinkedNode last;
	private int size;

	public LinkedListDeque(){
		sentinel = new LinkedNode(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		last = sentinel;
		size = 0;
	}

//	public LinkedListDeque(T i){
//		sentinel = new LinkedNode(null, null, null);
//		sentinel.next = new LinkedNode(i, sentinel, sentinel);
//		sentinel.prev = sentinel.next;
//		last = sentinel.next;
//		size = 1;
//	}

	public void addFirst(T x){
		sentinel.next = new LinkedNode(x, sentinel, sentinel.next);
		sentinel.next.next.prev = sentinel.next;
		// trace last when only one item in the list and then removed
		if(size == 0) {
			last = sentinel.next;
		}
		size += 1;
	}

	public void addLast(T x){
		last.next = new LinkedNode(x, last, sentinel);
		last = last.next;
		sentinel.prev = last;
		size += 1;
	}

	public T removeFirst(){
		if(isEmpty()){
			System.out.println("empty list!!!");
			return null;
		}
		T result;
		result = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		size -= 1;
		if(size == 0) {
			last = sentinel;
			sentinel.prev = sentinel;
			return result;
		}
		sentinel.next.prev = sentinel;
		return result;
	}

	public T removeLast(){
		if(isEmpty()){
			System.out.println("empty list!!!");
			return null;
		}
		T result;
		result = last.item;
		last.prev.next = sentinel;
		last = last.prev;
		sentinel.prev = last;
		size -= 1;
		return result;
	}

	/** */
	public T get(int index){
		LinkedNode p = sentinel.next;
		for (int i = 0; i < index; i++){
			p = p.next;
		}
		return p.item;
	}

	/** recursive */
	public T getRecursive(int index){
		if(size() == 0 || index >= size()){
			return null;
		}
		return sentinel.next.getRecursive(index);
	}

	private T getFirst(){
		return sentinel.next.item;
	}

	private T getLast(){
		return sentinel.prev.item;
	}

	/** */
	public void printDeque(){
		LinkedNode p = sentinel.next;
		for (int i = 0; i < size(); i++){
			System.out.println(p.item);
			p = p.next;
		}
	}

	/** using caching method, oop programming, everything is controlled by object  */
	public int size(){
		return size;
	}

	/** using caching method, oop programming, everything is controlled by object  */
	public boolean isEmpty(){
		return (size == 0);
	}


}