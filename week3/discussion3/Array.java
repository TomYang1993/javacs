
public class Array{

	public static int[] insert(int[] arr, int item, int position){
		position = Math.min(position, arr.length);
		int[] result = new int[arr.length + 1];
		for(int i = 0; i < position; i++){
			result[i] = arr[i];
		}
		result[position] = item;
		for(int j = position + 1; j < result.length; j++){
			result[j] = arr[j - 1];
		}
		return result;
	}

	public static void reverse(int[] arr){
		if(arr.length <= 1){
			return;
		}
		for(int i = 0;i < arr.length/2;i++){
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
	}

	public static int[] replicate(int[] arr){
		int size = 0;
		for(int item: arr){
			size = size + item;
		}
		int[] result = new int[size];
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i];j++){
				result[index] = arr[i];
				index++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] test = new int[]{1,5,2,6,2,6};
		int[] a = insert(test, 5, 3);
		for(int item: a ){
			System.out.println(item);
		}
		reverse(a);
		for(int item: a ){
			System.out.println(item);
		}
		System.out.println("relpicate method");
		int[] b = new int[]{1,4,2};
		int[] result = replicate(b);
		for(int item: result ){
			System.out.println(item);
		}

		

	}
}
