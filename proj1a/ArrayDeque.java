public class ArrayDeque<genType>{

	private genType[] items;
	private int size;
	private int nextFirst = 4;
	private int nextLast = 5;


	private ArrayDeque(){
		items = (genType[])new Object[8];
		size = 0;
	}

	public genType get(int index){
		return items[index];
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return (size==0);
	}

	public void printDeque(){
		for(genType item: items){
			System.out.print(item + " ");
		}
	}

	private void resize(){
		genType[] resizedArray = (genType[])new Object[items.length * 2];
		System.arraycopy(items, 0, resizedArray, 0, nextFirst + 1);
		if(nextFirst + 1 != items.length){
			System.arraycopy(items, nextFirst + 1, resizedArray, nextFirst + 1, resizedArray.length - nextFirst - 1);
		}
		items = resizedArray;
		nextFirst = nextFirst + resizedArray.length / 2;
	}	

	public void addFirst(genType x){
		if(nextFirst == -1){
			nextFirst = items.length - 1;
		}

		if(nextFirst == nextLast){
			resize();
		}

		items[nextFirst] = x;
		nextFirst = nextFirst - 1;
		size += 1;
	}

	public void addLast(genType x){

		if(nextLast == items.length + 1){
			nextLast = 0;
		}

		if(nextFirst == nextLast){
			resize();
		}

		items[nextLast] = x;
		nextLast = nextLast + 1;
		size += 1;
	}

	public genType removeFirst(genType x){
		if(isEmpty()){
			System.out.println("Deque is empty");
		}
		if(nextFirst >= items.length){
			nextFirst = 0;
		}
		genType result = items[nextFirst + 1];
		items[nextFirst + 1] = null;
		nextFirst += 1;
		size = size - 1;
		return result;
	}

	public genType removeLast(genType x){
		if(isEmpty()){
			System.out.println("Deque is empty");
		}
		if(nextLast < 0){
			nextLast = items.length - 1;
		}
		genType result = items[nextLast - 1];
		items[nextLast - 1] = null;
		nextLast -= 1;
		size = size - 1;
		return result;
	}


	public static void main(String[] args) {
		ArrayDeque<Integer> target = new ArrayDeque<>();
		target.addFirst(3);
		target.addFirst(5);
		target.addLast(1);
		target.addFirst(11);
		target.addLast(8);
		target.addFirst(4);
		target.addFirst(7);
		target.addFirst(14);
		target.addFirst(24);
		target.addFirst(56);
		target.addFirst(100);

//		target.removeFirst(100);
//		target.removeFirst(100);
//		target.removeFirst(100);
//		target.removeFirst(100);
//		target.removeLast(100);
//		target.removeLast(100);

		target.printDeque();
	}



}