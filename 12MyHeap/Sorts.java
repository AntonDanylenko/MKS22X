import java.util.Arrays;

public class Sorts{
	public static void heapSort(Integer[] unsorted){
		MyHeap<Integer> m = new MyHeap<>();
		m.heapify(unsorted);
		for(int n = 0; n < unsorted.length; n++){
			Integer t = m.remove();
			unsorted[m.size()] = t;
		}
	}

    public static void main(String[]args){
		Integer[] test = {Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(2), 
						  Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(5), 
                          Integer.valueOf(9), Integer.valueOf(3), Integer.valueOf(5)};
		heapSort(test);
		System.out.println(Arrays.toString(test));
    }
}