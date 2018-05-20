import java.util.Arrays;

public class MyHeap{
    private double[] data;
    private boolean max;
    private int size;
    
    public MyHeap(){
	max = true;
	data = new double[10];
    }//- construct empty max heap

    public MyHeap(boolean bool){
	max = bool;
	data = new double[10];
    } //- true: construct empty max heap, false: construct empty min heap.

	public String toString(){
		System.out.println(Arrays.toString(data));
		String result = "";
		int index = 0;
		int rows = (int) (Math.log(size) / Math.log(2));
		for (int s=0; s<=rows; s++){
			for (int n=0; n<(Math.pow(2, rows-s)-1)*3; n++){
				result += " ";
			}
			result += data[index];
			index++;
			for (int r=0; r<Math.pow(2,s)-1 && index<size; r++){
				for (int n=0; n<(Math.pow(2, rows-s+1)-1)*3; n++){
					result += " ";
				}
				result += data[index];
				index++;
			}
			result += "\n";
		}
		return result;
	}
	
    public void add(double s){
		if (size>=data.length){
			resize();
		}
		data[size]=s;
		size++;
		int n=size-1;
		while(n>=0){
			if (max){
				if (data[n]>data[(n-1)/2]){
					swap(n, (n-1)/2);
					n=(n-1)/2;
				}
				else{
					n=-1;
				}
			}
			else{
				if (data[n]<data[(n-1)/2]){
					swap(n,(n-1)/2);
					n=(n-1)/2;
				}
				else{
					n=-1;
				}
			}
		}
    }
	
	public void resize(){
		double[] temp = new double[data.length*2];
		for (int n=0; n<size; n++){
			temp[n] = data[n];
		}
		data = temp;
	}
    
	public void swap(int a, int b){
		double temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
    public double remove(){
	double element = data[0];
	data[0] = data[size-1]; //SWITCH THEN PUSH UP
	data[size-1] = 0.0;
	size--;
	int index = 0;
	int rows = (int) (Math.log(size) / Math.log(2));
	while (2*index+2<size){
	    if (data[2*index+1]<data[2*index+2] ^ max){
	        swap(index, 2*index+1);
	        index = 2*index+1;
	    }
	    else{
	        swap(index, 2*index+2);
			index = 2*index+2;
	    }
	}
	if (2*index+2==size && (data[index]>data[2*index+1] ^ max)){
		swap(index, 2*index+1);
	}
	return element;
    }
	

    public double peek(){
		return data[0];
    }

    public int size(){
	return size;
    }
	
	public static void main(String[]args){
		MyHeap heap = new MyHeap(false);
		heap.add(4);
		System.out.println(heap);
		heap.add(10);
		System.out.println(heap);
		heap.add(2);
		heap.add(1);
		heap.add(7);
		heap.add(8);
		heap.add(3);
		heap.add(7);
		heap.add(6);
		heap.add(4);
		heap.add(3);
		heap.add(0);
		heap.add(2);
		System.out.println(heap);
		heap.remove();
		System.out.println(heap);
	}
}
