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

    public void add(String s){
	
    }
    
    public String remove(){
	return "";
    }

    public String peek(){
	return "";
    }

    public int size(){
	return -1;
    }
}
