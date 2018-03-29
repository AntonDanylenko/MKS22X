public class MyLinkedList{
    private class Node{
	private Node next, prev;
	private Integer data;

	private Node(Integer value){
	    data = value;
	}

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
	
	private Integer getValue(){
	    return data;
	}

	private void setValue(Integer value){
	    data = value;
	}
	
	public String toString(){
	    return data + "";
	}
    }

    private Node first;
    private Node last;
    private int length;

    public MyLinkedList(){
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
	    
    public void set(int index,Integer value){
	Node m = first;
	get(index);
	m.setValue(value);
    }

    public int size(){
	return length;
    }

    public boolean add(Integer value){
	Node temp = new Node(value);
	last.setNext(temp);
	temp.setPrev(last);
	last = temp;
	return true;
    }
    
    public boolean add(int index,Integer value){
	if (index<0 || index>length){
	    return false;
	}
	if (index == 0){
	    first = new Node(value);
	    if (length == 0){
		last = first;
	    }
	    length += 1; 
	}
	if (index == length){
	    add(value);
	}
	return true;
    }
    
    public void remove(int index){
    }


    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	list.set(2,9);
	System.out.println(list);
    }
}
