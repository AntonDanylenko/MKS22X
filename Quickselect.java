public class Quickselect{
    private int[] unsorted;

    public Quickselect(){
	unsorted = new int[] {2,7,12,8,23,8,4,6};
    }

    public void sort(){
	int pivot = unsorted[(int)(Math.random()*unsorted.length)];
	System.out.println(pivot);
	int small = 0;
	int large = math.index - 1;
	for (int n=0; n<unsorted.length; n++){
	    if (unsorted[n] > pivot){
		swap(n, unsorted.length-1);
	    }
	}
    }

    public void swap(int a, int b){
	int temp = unsorted[b];
	unsorted[b] = unsorted[a];
	unsorted[a] = temp;
    }

    public static void main(String[]args){
	Quickselect newarray = new Quickselect();
	newarray.sort();
    }
}
