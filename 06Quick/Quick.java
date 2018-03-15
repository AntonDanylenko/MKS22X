public class Quick{
    public static void quicksort(int[] data){
	quickHelp(data, 0, data.length-1);
	String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
	System.out.println(line);
    }

    public static void quickHelp(int[] data, int i, int j){
	int v = partition(data, i, j);
	if (i!=v){
	    quickHelp(data, i, v-1);
	}
	if (j!=v){
	    quickHelp(data, v+1, j);
	}
    }

    
    public static int quickselect(int[] data, int k){
	int j = data.length -1;
	int i = 0;
	int v = partition(data, i, j);
	while(v!=k){
	    if (v>k){
		j = v;
	    }
	    else if(v<k){
		i = v;
	    }
	    v = partition(data, i, j);
	    System.out.println(v);
	}
	return data[v];
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
	/*String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
	System.out.println(line);*/
	return pivotInd;
    }

    public static int[] part(int[] data, int start, int end){
	int i = (int)(Math.random()*(end-start)) + start;
	int pivot = data[i];
	System.out.println(pivot);
	swap(data, i, start);
	i = start+1;
	while (i<end){
	    if (data[i]==pivot){
		i++;
	    }
	    else if (data[i]>pivot){
		swap(data,i,end);
		end--;
	    }
	    else{
		swap(data,i,start);
		i++;
		start++;
	    }
	}
	int[] array = new int[2];
	array[0] = start;
	array[1] = i;
	String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
	System.out.println(line);
	return array;
    }
    public static void main(String[]args){
	//int[] unsorted = {2,5,8,3,1,4,7,6};
	//int[] unsorted = {999,999,999,4,1,0,3,2,999,999,999};
	int[] unsorted = {1,2,0,1,1,2,1,1,0,0,0,2,0,1,0,0,2,1,0,2,0,1,0,2,0,2};
	//int[] unsorted = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        part(unsorted, 0, unsorted.length-1);
    }
}
