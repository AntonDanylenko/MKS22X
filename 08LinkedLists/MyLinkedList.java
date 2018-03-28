public class MyLinkedList{
    private class Node{
	private Node next, prev;
	private int data;

	private Node getNext(){
	    return next;
	}

	private void setNext(Node thing){
	    next = thing;
	}
	
	private Node getPrev(){
	    return prev;
	}

	private void setPrev(Node thing){
	    prev = thing;
	}
	
	private int getValue(){
	    return data;
	}
	
	private String toString(){
	    return data + "";
	}
    }

    private Node first;
    private Node last;
    private int length;

    public string toString(){
    }
    
    public int get(int n){
	for (int r=0; r<n; r++){
	    getNext();
	}
	return data;
    }
	    
    public void set(int index,int value){
	get(index);
	data = value;
    }

    public int size(){
	return length;
    }
    
    public void add(int index,int value){
        get(index-1);
	//??????
    }
    
    public void remove(int index){
    }
}
