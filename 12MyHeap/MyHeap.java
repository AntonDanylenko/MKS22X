import java.util.Arrays;

public class MyHeap{
    private String[] data;
    private boolean max;
    private int size;
    
    public MyHeap(){
	max = true;
	data = new String[10];
    }//- construct empty max heap

    public MyHeap(boolean bool){
	max = bool;
	data = new String[10];
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
		
		
		/*for (int n=0; n<Math.pow(2, rows)-1; n++){
			result += " ";
		}
		result = result + data[0] + "\n";
		
		for (int n=0; n<Math.pow(2, rows-1)-1; n++){
			result += " ";
		}
		result = result + data[1];
		for (int n=0; n<Math.pow(2, rows)-1; n++){
			result += " ";
		}
		result = result + data[2] + "\n";*/
		
		
		return result;
	}
	
    public void add(String s){
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
	
	public void resize(){
		String[] temp = new String[data.length*2];
		for (int n=0; n<size; n++){
			temp[n] = data[n];
		}
		data = temp;
	}
    
	public void swap(int a, int b){
		String temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
    public String remove(){
	String element = data[0];
	//data[0] = data[size-1]; SWITCH THEN PUSH UP
	int index = 0;
	int rows = (int) (Math.log(size) / Math.log(2));
	for (int n=0; n<rows-1; n++){
	    if (data[2*index+1].compareTo(data[2*index+2])<0 ^ max){
	        data[index] = data[2*index+1];
	        index = 2*index+1;
	    }
	    else{
	        data[index] = data[2*index+2];
		index = 2*index+2;
	    }
	}
	if (2*index+2<size){
	    if (data[2*index+1].compareTo(data[2*index+2])<0 ^ max){
	        data[index] = data[2*index+1];
	        index = 2*index+1;
	    }
	    else{
	        data[index] = data[2*index+2];
		index = 2*index+2;
	    }
	}
	else if (2*index+1<size){
	    data[index] = data[2*index+1];
	    index = 2*index+1;
	}
	data[index]=null;
	return element;
    }
	

    public String peek(){
	return "";
    }

    public int size(){
	return size;
    }
	
	public static void main(String[]args){
		MyHeap heap = new MyHeap();
		heap.add("a");
		System.out.println(heap);
		heap.add("d");
		System.out.println(heap);
		heap.add("b");
		heap.add("c");
		heap.add("e");
		heap.add("g");
		heap.add("f");
		heap.add("a");
		System.out.println(heap);
		heap.remove();
		System.out.println(heap);
	}
}
