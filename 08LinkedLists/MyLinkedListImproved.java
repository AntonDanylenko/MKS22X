import java.util.Iterator;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
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

	//ITERATOR()
    public Iterator<T> iterator(){
	return new LinkedListIterator(first);
    }

	//ITERATOR()
    private class LinkedListIterator implements Iterator<T>{
        private Node current;

	public LinkedListIterator(Node node){
	    current = node;
	}

	public boolean hasNext(){
	    return current.getNext() != null;
	}

	public T next(){
	    if(hasNext()){
		current = current.getNext();
	    }
	    else{
		System.exit(0);
	    }
	    return current.getValue();
        }

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
	
	//TOSTRING()
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

	//CLEAR()
    public void clear(){
	first = null;
	last = null;
	length = 0;
    }
    
	//GET()
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
	
	//SET()
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

	//SIZE()
    public int size(){
	return length;
    }

	//INDEXOF()
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

	//ADD()
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
    
	//ADD()
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

	//REMOVE()
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
    if (m.getValue().equals(value)){
        last = m.getPrev();
        length--;
        return true;
    }
	return false;
    }
    
	//REMOVE()
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

	//MAX()
    public int max(){
	if(length == 0){
	    return -1;
	}
	int max = 0;
	for(T n: this){
	    //System.out.println(n.compareTo(get(max)));
	    if (n.compareTo(get(max))>0){
		max = indexOf(n);
	    }
	}
	return max;
    }

	//MIN()
    public int min(){
	if(length == 0){
	    return -1;
	}
	int min = 0;
	int count = 0;
	for(T n: this){
	    //System.out.println(n.compareTo(get(min)));
	    if (n.compareTo(get(min))<0){
		min = count;
	    }
	    count++;
	}
	return min;
    }
    
	//EXTEND()
    public void extend(MyLinkedListImproved<T> other){
        if (other.size() == 0){
            return;
        }
        if (this.size() == 0){
            this.first = other.first;
            this.last = other.last;
            length = other.length;
            return;
        }
        this.last.setNext(other.first);
        other.first.setPrev(this.last);
        this.last = other.last;
        length += other.length;
        other.clear();
    }

    public static void main(String[]args){
	MyLinkedListImproved<String> list = new MyLinkedListImproved<String>();
	//System.out.println(list.get(0));
	list.add("aaa");
	list.add(1, "bbb");
	list.add("ccc");
	System.out.println(list);
        System.out.println(list.max());
        System.out.println(list.min());
	MyLinkedListImproved<String> list2 = new MyLinkedListImproved<String>();
    list2.add("www");
    list2.add("xxx");
    list2.add("yyy");
    list2.add("zzz");
    list2.add("LLL");
    System.out.println(list2);
    list.extend(list2);
    System.out.println(list);
    System.out.println(list2);
    }
}
