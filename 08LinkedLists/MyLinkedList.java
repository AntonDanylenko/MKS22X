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
}
