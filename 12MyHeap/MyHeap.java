import java.util.Arrays;

public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private boolean max;
    private int size;
    
	@SuppressWarnings("unchecked")
    public MyHeap(){
	max = true;
	data = (T[]) new Comparable[10];
    }//- construct empty max heap

	@SuppressWarnings("unchecked")
    public MyHeap(boolean bool){
	max = bool;
	data = (T[]) new Comparable[10];
    } //- true: construct empty max heap, false: construct empty min heap.

	public String toString(){
		System.out.println(Arrays.toString(data));
		String result = "";
		int index = 0;
		int rows = (int) (Math.log(size) / Math.log(2));
		for (int s=0; s<=rows; s++){
			for (int n=0; n<Math.pow(2, rows-s)-1; n++){
				result += " ";
			}
			result += data[index];
			index++;
			for (int r=0; r<Math.pow(2,s)-1 && index<size; r++){
				for (int n=0; n<Math.pow(2, rows-s+1)-1; n++){
					result += " ";
				}
				result += data[index];
				index++;
			}
			result += "\n";
		}
		return result;
	}
	
    public void add(T s){
		if (size>=data.length){
			resize();
		}
		data[size]=s;
		size++;
		int n=size-1;
		while(n>=0){
			if (max){
				if (data[n].compareTo(data[(n-1)/2]) >0){
					swap(n, (n-1)/2);
					n=(n-1)/2;
				}
				else{
					n=-1;
				}
			}
			else{
				if (data[n].compareTo(data[(n-1)/2]) <0){
					swap(n,(n-1)/2);
					n=(n-1)/2;
				}
				else{
					n=-1;
				}
			}
		}
    }
	
	@SuppressWarnings("unchecked")
	public void resize(){
		T[] temp = (T[]) new Comparable[data.length*2];
		for (int n=0; n<size; n++){
			temp[n] = data[n];
		}
		data = temp;
	}
    
	public void swap(int a, int b){
		T temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
    public T remove(){
	T element = data[0];
	data[0] = data[size-1]; //SWITCH THEN PUSH UP
	data[size-1] = null;
	size--;
	int index = 0;
	int rows = (int) (Math.log(size) / Math.log(2));
	while (2*index+2<size){
	    if (data[2*index+1].compareTo(data[2*index+2])<0 ^ max){
	        swap(index, 2*index+1);
	        index = 2*index+1;
	    }
	    else{
	        swap(index, 2*index+2);
			index = 2*index+2;
	    }
	}
	if (2*index+2==size && (data[index].compareTo(data[2*index+1])>0 ^ max)){
		swap(index, 2*index+1);
	}
	return element;
    }
	

    public T peek(){
		return data[0];
    }

    public int size(){
	return size;
    }
	
	@SuppressWarnings("unchecked")
	public static void main(String[]args){
		MyHeap heap = new MyHeap<String>(false);
		heap.add(Integer.valueOf(4));
		System.out.println(heap);
		heap.add(Integer.valueOf(8));
		System.out.println(heap);
		heap.add(Integer.valueOf(2));
		heap.add(Integer.valueOf(1));
		heap.add(Integer.valueOf(7));
		heap.add(Integer.valueOf(8));
		heap.add(Integer.valueOf(3));
		heap.add(Integer.valueOf(7));
		heap.add(Integer.valueOf(6));
		heap.add(Integer.valueOf(4));
		heap.add(Integer.valueOf(3));
		heap.add(Integer.valueOf(0));
		heap.add(Integer.valueOf(2));
		System.out.println(heap);
		heap.remove();
		System.out.println(heap);
	}
}
