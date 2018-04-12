import java.util.Iterator;

public class MyLinkedListImproved<T> implements Iterator<T>{
    private class Node{
	private Node next, prev;
	private T data;

	private Node(T value){
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
	
	private T getValue(){
	    return data;
	}

	private void setValue(T value){
	    data = value;
	}
	
	public String toString(){
	    return data + "";
	}
    }

    private Node first;
    private Node last;
    private int length;

    public MyLinkedListImproved(){
    }

    public Iterator<T> iterator(){
	return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
	private int cursor;

	public LinkedListIterator(){
	    this.cursor = MyLinkedListImproved.this.first;
	}

	public boolean hasNext(){
	    return cursor < length;
	}

	public T next(){
	    if(this.hasNext()){
		int current = cursor;
		cursor++;
		return current;
	    }
	    System.exit(0);
        }
	
    public String toString(){
	if (length<1){
	    return "[]";
	}
	Node m = first;
	String result = "[";
	for (int n=0; n<length-1; n++){
	    result = result + m.getValue() + ", ";
	    m = m.getNext();
	}
	return result + m.getValue() + "]";
    }

    public void clear(){
	first = null;
	last = null;
	length = 0;
    }
    
    public T get(int n){
	if(n>=length || n<0){
	    throw new IndexOutOfBoundsException();
	}
	Node m = first;
	for (int r=0; r<n; r++){
	    m = m.getNext();
	}
	return m.getValue();
    }
	    
    public T set(int index,T value){
	if(index>=length || index<0){
	    throw new IndexOutOfBoundsException();
	}
	Node m = first;
        for (int r=0; r<index; r++){
	    m = m.getNext();
	}
	T old = m.getValue();
	m.setValue(value);
	return old;
    }

    public int size(){
	return length;
    }

    public int indexOf(T value){
	Node m = first;
        for (int n=0; n<length; n++){
	    if (m.getValue().equals(value)){
		return n;
	    }
	    m = m.getNext();
	}
	return -1;
    }

    public boolean add(T value){
	Node temp = new Node(value);
	if(length == 0){
	    first = temp;
	    last = temp;
	    length++;
	    return true;
	}
	last.setNext(temp);
	temp.setPrev(last);
	last = temp;
	length++;
	return true;
    }
    
    public boolean add(int index,T value){
	if (index<0 || index>length){
	    return false;
	}
	if (index == 0){
	    first = new Node(value);
	    if (length == 0){
		last = first;
	    }
	    length++; 
	}
	if (index == length){
	    add(value);
	}
	return true;
    }

    public boolean remove(T value){
	Node m = first;
	if (m.getValue().equals(value)){
        first = m.getNext();
        length--;
        return true;
    }
    m = m.getNext();
    for (int n=1; n<length-1; n++){
	    if (m.getValue().equals(value)){
            m.getPrev().setNext(m.getNext());
            m.getNext().setPrev(m.getPrev());
            length--;
		return true;
	    }
	    m = m.getNext();
	}
	//System.out.println(m.getValue());
    if (m.getValue().equals(value)){
        //System.out.println(m.getValue());
        last = m.getPrev();
        length--;
        return true;
    }
	return false;
    }
    
    public T remove(int index){
	if (index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
	Node m = first;	
	if (length == 1){
	    T old = m.getValue();
	    first = null;
	    last = null;
	    length=0;
	    return old;
	}
	if (index == length-1){
	    T old = last.getValue();
	    last = last.getPrev();
	    length--;
	    return old;
	}
	if (index == 0){
	    T old = m.getValue();
	    first = m.getNext();
	    length--;
	    return old;
	}
	for (int r=0; r<index-1; r++){
	    m = m.getNext();
	}
	T old = m.getNext().getValue();
	m.setNext(m.getNext().getNext());
	m.getNext().setPrev(m);
	length--;
	return old;
    }


    public static void main(String[]args){
	MyLinkedListImproved list = new MyLinkedListImproved();
	//System.out.println(list.get(0));
	list.add("aaa");
	list.add(1, "bbb");
	System.out.println(list);
	/*list.set(0, Integer.valueOf(8));
	System.out.println(list);
	list.remove(0);
	System.out.println(list);
	list.add(Integer.valueOf(2));
	list.add(Integer.valueOf(5));
	System.out.println(list);
	list.remove(2);
	System.out.println(list);*/
	//System.out.println(list.indexOf(Integer.valueOf(2)));
	//System.out.println(list.indexOf(Integer.valueOf(5)));
    //list.remove(Integer.valueOf(3));
	//System.out.println(list);
    }
}
