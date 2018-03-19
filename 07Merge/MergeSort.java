public class MergeSort{
    public static void mergesort(int[] data, int start, int end){
    }

    public static int[] merge(int[] data1, int[] data2){
	int[] result = new int[data1.length + data2.length];
	int n=0;
	int m=0;
        while(n<data1.length && m<data2.length){
	    if(data1[n]<data2[m]){
		result[n+m] = data1[n];
		n++;
	    }
	    else{
		result[n+m] = data2[m];
		m++;
	    }
	}
	if(n<data1.length){
	    for (int r=n; r<data1.length; r++){
		result[r+m] = data1[r];
	    }
	}
	if(m<data2.length){
	    for (int r=m; r<data2.length; r++){
		result[r+n] = data2[r];
	    }
	}
	return result;
    }

    public static void main(String[]args){
	//int[] data1 = {2,4,7,9,10};
	//int[] data2 = {1,3,5,6,8};

	int[] data1 = {5,7,8,8,9,10};
	int[] data2 = {1,2,3,4,4,5,6};
	int[] data = merge(data1, data2);
	String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
	System.out.println(line);
    }
}
