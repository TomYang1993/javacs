public class IntList{


	public static IntList incrList(IntList L, int x) {

		if(L == null){
			return L;
		}else{
			/** reconsider base case, square function here always needs to return something at the end
			 * so there's always a base case that in a different condition with square function
			 */
			IntList P = incrList(L.next, x);
			IntList M = new IntList(L.first + x, P);
			return M;
		}
	}

	public static IntList decrList(IntList L, int x) {

		if(L == null){
			return L;
		}else{
			
			decrList(L.next, x);
			L.first += x;
		}
		/** return L only once */
		return L;
	}


	public static IntList square(IntList L) {

		// if(L.next == null){
		// 	IntList P = square(L.next);
		// 	IntList M = new IntList(L.first, P);
		// 	return M;
		// }

		/** above original code, base case is wrong at the beginning. 
		 * ROT: consider what's base case, consider what will every step return */
		if(L == null){
			return L;
		}else{
			/** reconsider base case, square function here always needs to return something at the end
			 * so there's always a base case that in a different condition with square function
			 */
			IntList P = square(L.next);
			IntList M = new IntList(L.first*L.first, P);
			return M;
		}
	
	}

	public static IntList newsquare(IntList L) {

		/** key is to find a temp variable record the change to the reference value
		 * and keep the right order to get to the end of the linkedlist
		 */
		IntList result = new IntList(L.first * L.first, null);
		IntList temp = result;
		while(L != null){
			temp.next = new IntList(L.first * L.first, null);
			L = L.next;
			temp = temp.next;
		}
		return result;
	}

	public static IntList squareMutative(IntList L) {
		/** P is losing references to get to null
		 * if you directly using L here, it will reduce L to null
		 */
		IntList P = L;
		while(P != null){
			/** update P.first then move to P.next */
			P.first = P.first * P.first;
			P  = P.next;
		}
		return L;
	
	}

	public static IntList newsquareMutative(IntList L) {
		if(L == null){
			return L;
		}else{
			
			newsquareMutative(L.next);
			L.first *= L.first;
		}
		/** return L only once */
		return L;
	}


	public int first;
	public IntList next;

	public IntList(int f, IntList n){
		first = f;
		next = n;
	}

	/** recursion method preferred*/
	// public int size(){
	// 	if(next == null){
	// 		return 1;
	// 	}
	// 	return 1 + next.size();
	// }

	/** iterative method 
	 * size() do not have 0 edge case, or else call size() on null(which means IntList's size is zero) will cause NullPointerException
	 * you can start off by change condition p => p.rest, which result should be instantiated as 1, work the same
	 * you can not change this object, which is a java keyword always points to the current object
	*/
	public int size(){
		int result =0;
		IntList p = this;
		while(p != null){
			p  = p.next;
			result = result + 1;

		}
		return result;
	}

	public int get(int index){

		if(index == 0){
			return first;
		}
		
		return next.get(index - 1);
	}

	/** not efficient, not straight-forward */
	public void addFirst(int x){
		next = new IntList(first, next);

		first = x;
	}

	public static void main(String[] args){

    /** code will work even without constructor */
		// IntList a = new IntList();
		// a.first = 4;
		// a.next = new IntList();
		// a.next.first = 5;
		// a.next.next = new IntList();

		IntList a = new IntList(4,null);
		a = new IntList(5, a);
		a = new IntList(7, a);
		System.out.println(a.size());

		System.out.println(IntList.square(a).first);
		System.out.println(IntList.square(a).next.first);
		System.out.println(IntList.square(a).next.next.first);

		IntList.squareMutative(a);
		System.out.println(a.first);
		System.out.println(a.next.first);
		System.out.println(a.next.next.first);

		a = new IntList(4,null);
		a = new IntList(5, a);
		a = new IntList(7, a);

		IntList.newsquareMutative(a);
		System.out.println(a.first);
		System.out.println(a.next.first);
		System.out.println(a.next.next.first);

		a = new IntList(4,null);
		a = new IntList(5, a);
		a = new IntList(7, a);

		IntList.newsquare(a);
		System.out.println(IntList.square(a).first);
		System.out.println(IntList.square(a).next.first);
		System.out.println(IntList.square(a).next.next.first);

		System.out.println(IntList.incrList(a, 3).first);
		System.out.println(IntList.incrList(a, 3).next.first);
		System.out.println(IntList.incrList(a, 3).next.next.first);

		a = new IntList(4,null);
		a = new IntList(5, a);
		a = new IntList(7, a);
		IntList.decrList(a, 4);
		System.out.println(a.first);
		System.out.println(a.next.first);
		System.out.println(a.next.next.first);

		a = new IntList(4,null);
		a.addFirst(5);
		a.addFirst(8);
		System.out.println(a.first);
		System.out.println(a.next.first);
		System.out.println(a.next.next.first);
	}
}