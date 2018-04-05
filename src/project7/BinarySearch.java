package project7;

public class BinarySearch{
	/*
	 * Searches the array for a key. If key is not in the array segment, then -1 is
	 * returned. Otherwise returns an index in the segment such that key ==
	 * a[index]. Precondition: a[first] <= a[first+1] <= ... <= a[last]
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int search(Comparable[] a, int first, int last, Comparable key) {
		int result = 0; // to keep the compiler happy
		if (first > last)
			result = -1;
		else {
			int mid = (first + last) / 2;
			if (key.compareTo(a[mid])==0)
				result = mid;
			else if (key.compareTo(a[mid])<0)
				result = search(a, first, mid - 1, key);
			else if (key.compareTo(a[mid])>0)
				result = search(a, mid + 1, last, key);
		}
		return result;
	}
}
