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
	swap(data, pivotInd, start);
	pivotInd = start;
	start++;
	for (int n=start; n<=end; n++){
	    while(data[end]>pivotEl){
		end--;
	    }
	    if (data[n]>pivotEl && n<end){
		swap(data, n, end);
	    }
	    //start = n-1;
	    /*if (data[n] < pivotEl){
		swap(data, n, start);
		if (data[n] < pivotEl){
		    start++;
		}
	    }
		else if (data[n] > pivotEl){
		swap(data, n, end);
		if (data[n] > pivotEl){
		end--;
		}
		}*/
	    System.out.println(n + ", " + end);
	    String line = "";
	    for (int r=0; r<data.length; r++){
		line = line + data[r] + ", ";
	    }
	    System.out.println(line);
	}
	swap(data, end, pivotInd);
	String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
        System.out.println(line);
	return pivotInd;
	}

    public static void main(String[]args){
	//int[] unsorted = {2,5,8,3,1,4,7,6};
	int[] unsorted = {999,999,999,4,1,0,3,2,999,999,999};
	partition(unsorted, 0, unsorted.length -1);
    }
}
