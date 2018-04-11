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
    
    public Integer get(int n){
	if(n>=length || n<0){
	    return -1;
	}
	Node m = first;
	for (int r=0; r<n; r++){
	    m = m.getNext();
	}
	return m.getValue();
    }
	    
    public Integer set(int index,Integer value){
	if(index>=length || index<0){
	    return -1;
	}
	Node m = first;
        for (int r=0; r<index; r++){
	    m = m.getNext();
	}
	Integer old = m.getValue();
	m.setValue(value);
	return old;
    }

    public int size(){
	return length;
    }

    public int indexOf(Integer value){
	Node m = first;
        for (int n=0; n<length; n++){
	    if (m.getValue().equals(value)){
		return n;
	    }
	    m = m.getNext();
	}
	return -1;
    }

    public boolean add(Integer value){
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
    
    public boolean add(int index,Integer value){
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

    public boolean remove(Integer value){
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
    
    public Integer remove(int index){
	if (index<0 || index>=length){
	    return -1;
	}
	Node m = first;	
	if (length == 1){
	    Integer old = m.getValue();
	    first = null;
	    last = null;
	    length=0;
	    return old;
	}
	if (index == length-1){
	    Integer old = last.getValue();
	    last = last.getPrev();
	    length--;
	    return old;
	}
	if (index == 0){
	    Integer old = m.getValue();
	    first = m.getNext();
	    length--;
	    return old;
	}
	for (int r=0; r<index-1; r++){
	    m = m.getNext();
	}
	Integer old = m.getNext().getValue();
	m.setNext(m.getNext().getNext());
	m.getNext().setPrev(m);
	length--;
	return old;
    }


    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	//System.out.println(list.get(0));
	list.add(Integer.valueOf(9));
	list.add(1, Integer.valueOf(3));
	System.out.println(list);
	list.set(0, Integer.valueOf(8));
	System.out.println(list);
	list.remove(0);
	System.out.println(list);
	list.add(Integer.valueOf(2));
	list.add(Integer.valueOf(5));
	System.out.println(list);
	list.remove(2);
	System.out.println(list);
	//System.out.println(list.indexOf(Integer.valueOf(2)));
	//System.out.println(list.indexOf(Integer.valueOf(5)));
    //list.remove(Integer.valueOf(3));
	//System.out.println(list);
    }
}
