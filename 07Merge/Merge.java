public class Merge{
    public static void mergesort(int[] data){
	if (data.length == 0){
	    return;
	}
	int[] temp = new int[data.length];
	for (int n=0; n<data.length; n++){
	    temp[n] = data[n];
	}
	mergeHelp(data, temp, 0, data.length-1);
	//System.out.println(java.util.Arrays.toString(data));
    }
    

	public static void swap(int[] data, int a, int b){
	int temp = data[b];
	data[b] = data[a];
	data[a] = temp;
    }

	public static void insertionSort(int[] data, int i, int j){
		for (int n=i+1; n<=j; n++){
			int r = n;
			while (r>i && data[r]<data[r-1]){
				swap(data, r, r-1);
				r--;
			}
		}
		/*String line = "";
        for (int r=0; r<data.length; r++){
	        line = line + data[r] + ", ";
        }
		System.out.println(line);*/
	}


    public static void mergeHelp(int[] data, int[] temp, int start, int end){
	if(start==end){
	}
	else{
	    mergeHelp(temp, data, start, (start+end)/2);
	    //System.out.println("MH1: Data: " + java.util.Arrays.toString(data) + ", Temp: " + java.util.Arrays.toString(temp));
	    mergeHelp(temp, data, (start+end)/2+1, end);
	    //System.out.println("MH2: Data: " + java.util.Arrays.toString(data) + ", Temp: " + java.util.Arrays.toString(temp));
	    merge(data, temp, start, (start+end)/2, (start+end)/2+1, end);
	    //System.out.println("MH3: Data: " + java.util.Arrays.toString(data) + ", Temp: " + java.util.Arrays.toString(temp));
	    //System.out.println(" ");
	}
    }

    public static void merge(int[] data, int[] temp, int s1, int e1, int s2, int e2){
	//System.out.println("Merge: Data: " + java.util.Arrays.toString(data) + ", Temp: " + java.util.Arrays.toString(temp));
	int n=s1;
	int m=s2;
        while(n<=e1 && m<=e2){
	    if(temp[n]<temp[m]){
		data[n+m-s2] = temp[n];
		n++;
	    }
	    else{
		data[n+m-s2] = temp[m];
		m++;
	    }
	    //System.out.println("Merge(while): Data: " + java.util.Arrays.toString(data) + ", Temp: " + java.util.Arrays.toString(temp));
	}
	if(n<=e1){
	    for (int r=n; r<=e1; r++){
		data[r+m-s2] = temp[r];
	    }
	}
	if(m<=e2){
	    for (int r=m; r<=e2; r++){
		data[r-s2+n] = temp[r];
	    }
	}
	//System.out.println("PostMerge: Data: " + java.util.Arrays.toString(data) + ", Temp: " + java.util.Arrays.toString(temp));
	for (int r=s1; r<=e2; r++){
		temp[r] = data[r];
	}
	/*for (int r=0; r<data.length; r++){
		data[r] = temp[r];
		}*/
	}

    /*public static void main(String[]args){
	//int[] temp = {-5,-4,-1,2,4,7,8,9,-3,-2,0,1,3,5,6,10};

	//int[] temp = {5,7,8,8,9,9,10,1,2,3,4,4,5,6};

	//int[] data = new int[temp.length];
	//merge(data, temp, 0, temp.length/2-1, temp.length/2, temp.length-1);

	//int[] data0 = {4,2};
	
	int[] data0 = {5,2,3,1,9,10,4,6,7,8};
	//int[] data0 = {10,-10,2,6,1,-3,-7,9,-9,-9,-9,0,0,5,0};

	long start = System.currentTimeMillis();
        mergesort(data0);
	long end = System.currentTimeMillis();
	System.out.println(end-start);
	}*/
}
