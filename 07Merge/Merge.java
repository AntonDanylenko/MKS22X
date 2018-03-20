public class Merge{
    /*public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	mergeHelp(data, temp, 0, data.length-1);
	System.out.println(java.util.Arrays.toString(data));
    }
    
    public static void mergeHelp(int[] data, int[] temp, int start, int end){
	if(start==end){
	}
	else{
	    mergeHelp(data, temp, start, (start+end)/2);
	    //System.out.println(java.util.Arrays.toString(data1));
	
	    mergeHelp(data, temp, (start+end)/2 +1, end);
	    //System.out.println(java.util.Arrays.toString(data2));
	
	    merge(temp, data1, data2);
	}
    }*/

    public static void merge(int[] data, int[] temp, int s1, int e1, int s2, int e2){
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
	System.out.println(java.util.Arrays.toString(data));
    }

    public static void main(String[]args){
	//int[] temp = {-5,-4,-1,2,4,7,8,9,-3,-2,0,1,3,5,6,10};

	int[] temp = {5,7,8,8,9,9,10,1,2,3,4,4,5,6};

	int[] data = new int[temp.length];
	merge(data, temp, 0, temp.length/2-1, temp.length/2, temp.length-1);

	int[] data0 = {4,2};
	
	//int[] data0 = {2,5,1,3,9,10,4,6,7,8};
        //mergesort(data0);
	//System.out.println(java.util.Arrays.toString(data));*/
    }
}
