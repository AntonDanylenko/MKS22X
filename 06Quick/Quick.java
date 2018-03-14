public class Quick{

    public static int quickselect(int[] data, int k){
		int result = data.length-1;
		for(int n=0; n<k; n++){
			result = partition(data, 0, result);
			System.out.println(result);
		}
		return data[result];
    }

    public static void swap(int[] data, int a, int b){
	int temp = data[b];
	data[b] = data[a];
	data[a] = temp;
    }

	public static int partition(int[] data, int start, int end){
	int pivotInd = (int)(Math.random()*(end-start)) + start;
	int pivotEl = data[pivotInd];
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
	}
	swap(data, end, pivotInd);
	pivotInd = end;
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
	System.out.println(quickselect(unsorted, 2));
    }
}
