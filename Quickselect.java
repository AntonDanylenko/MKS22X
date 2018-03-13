public class Quickselect{

    public void sort(){
	/*int pivot = unsorted[(int)(Math.random()*unsorted.length)];
	System.out.println(pivot);
	int small = 0;
	int large = math.index - 1;
	for (int n=0; n<unsorted.length; n++){
	    if (unsorted[n] > pivot){
		swap(n, unsorted.length-1);
	    }
	}*/
    }

    public static void swap(int[] data, int a, int b){
	int temp = data[b];
	data[b] = data[a];
	data[a] = temp;
    }

	public static int partition(int[] data, int start, int end){
	int pivotInd = (int)(Math.random()*(end-start)) + start;
	int pivotEl = data[pivotInd];
	System.out.println(pivotInd + ", " + pivotEl);
	for (int n=start; n<end; n++){
	    if (data[n] < pivotEl){
		swap(data, n, start);
		start++;
	    }
		else if (data[n] > pivotEl){
		swap(data, n, end);
		end--;
		}
		String line = "";
		for (int r=0; r<data.length; r++){
			line = line + data[r] + ", ";
		}
		System.out.println(line);
	}
	return pivotEl;
	}

    public static void main(String[]args){
	int[] unsorted = {2,7,12,8,23,8,4,6};
	partition(unsorted, 0, unsorted.length -1);
    }
}
