public class Quickselect{

    public void sort(){
    }

    public static void swap(int[] data, int a, int b){
	int temp = data[b];
	data[b] = data[a];
	data[a] = temp;
    }

	public static int partition(int[] data, int start, int end){
	int pivotInd = (int)(Math.random()*(end-start)) + start;
	int pivotEl = data[pivotInd];
	//System.out.println(pivotInd + ", " + pivotEl);
	swap(data, pivotInd, start);
	pivotInd = start;
	start++;
	while(start<=end){
		if (data[start]>=pivotEl){
			swap(data, start, end);
			end--;
		}
		else{
			start++;
		}
	    /*System.out.println(start + ", " + end);
	    String line = "";
	    for (int r=0; r<data.length; r++){
		line = line + data[r] + ", ";
	    }
	    System.out.println(line);*/
	}
	/*for (int n=start; n<=end; n++){
	    while(data[end]>pivotEl){
		end--;
	    }
	    if (data[n]>pivotEl && n<end){
		swap(data, n, end);
	    }
	    System.out.println(n + ", " + end);
	    String line = "";
	    for (int r=0; r<data.length; r++){
		line = line + data[r] + ", ";
	    }
	    System.out.println(line);
	}*/
	swap(data, end, pivotInd);
	pivotInd = end;
	/*String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
    System.out.println(line);*/
	return pivotInd;
	}

    public static void main(String[]args){
	//int[] unsorted = {2,5,8,3,1,4,7,6};
	int[] unsorted = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(partition(unsorted, 0, unsorted.length -1));
    }
}
