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

	private void setValue(int value){
	    data = value;
	}
	
	public String toString(){
	    return data + "";
	}
    }

    private Node first;
    private Node last;
    private int length;

    public MyLinkedList(int length){
	
    }
    
    public String toString(){
	Node m = first;
	String result = "[";
	for (int n=0; n<length; n++){
	    result = result + m.getValue() + ", ";
	    m = m.getNext();
	}
	return result + "]";
    }
    
    public int get(int n){
	Node m = first;
	for (int r=0; r<n; r++){
	    m = m.getNext();
	}
	return m.getValue();
    }
	    
    public void set(int index,int value){
	Node m = first;
	get(index);
	m.setValue(value);
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


    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList(4);
	list.set(2,9);
	System.out.println(list);
    }
}
