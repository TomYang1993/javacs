public class Step{
	public class LengthComparator implements NullSafeStringComparator {
		public int compare(String s1, String s2) {
			if ((s1 == null) && (s2 == null)) return 0;
			if (s1 == null) return -1;
			if (s2 == null) return 1;
			return s1.length() - s2.length();
		}
	}

	public static String max(String[] a, NullSafeStringComparator sc) {
		String maxStr = a[0];
		for(int i = 0; i < a.length; i += 1) {
			if (sc.compare(a[i], maxStr) > 0){
				maxStr = a[i];
			}
		}
		return maxStr;
	}

	public static String[][] step(String[][] arr) {
		String[][] stepped = new String[arr.length][arr[0].length];
		for (int i = 1; i < arr.length - 1; i += 1) {
			for (int j = 1; j < arr[0].length - 1; j += 1) {
				String[] temp = new String[9];
 // temp holds all the neighbors + itself: there will
 // be exactly 8 neighbors + self
				int count = 0;
				for (int k = -1; k <= 1; k += 1) {
					for (int m = -1; m <= 1; m += 1) {
						temp[count] = arr[i+k][j+m];
 // Store the all the neighbors
						count += 1;
					}
				}
				stepped[i][j] = max(temp, new LengthComparator());
 // Here we need to construct a new LengthComparator
 // every time, since it’s not static.
			}
		}
		return stepped;
	}

}
