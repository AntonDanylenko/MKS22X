import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDeque<E>{
	private E[] deque;
	private int front;
	private int back;
    private int size;
	
	@SuppressWarnings("unchecked") public MyDeque(){
		deque = (E[]) new Object[10];
		front = 0;
		back = 0;
		size = 0;
	}
	
	@SuppressWarnings("unchecked") public MyDeque(int capacity){
		deque = (E[]) new Object[capacity];
		front = 0;
		back = 0;
		size = 0;
	}
	
	public String toString(){
		return Arrays.toString(deque);
	}
	
	public int size(){
	    return size;
	}
	
	@SuppressWarnings("unchecked") private void doubleCap(){
	    E[] temp = (E[]) new Object[deque.length * 2];
		if (back == 0){
			back = deque.length;
			for (int n=0; n<deque.length; n++){
				temp[n] = deque[n];
			}
		}
		else{
			for (int n=0; n<back; n++){
				temp[n] = deque[n];
			}
			for (int r=front; r<deque.length; r++){
				temp[temp.length - deque.length + r] = deque[r];
			}
			front += deque.length;
		}
		deque = temp;
		//System.out.println("frrront =" + front + ", back =" + back);
		//System.out.println(Arrays.toString(deque));
	}

	public void addFirst(E element){
		if(element == null){
		    //System.out.println("threw exception");
			throw new NullPointerException();
		}
		if (size()==0){
		    //System.out.println("front = null");
			deque[front] = element;
			back++;
			size++;
			//System.out.println("front =" + front + ", back =" + back);
		}
		else{
			if (front<1){
				if (front == back){
					doubleCap();
				}
				deque[deque.length-1] = element;
				front = deque.length-1;
				size++;
			}
			else{
				if (back == front){
					doubleCap();
				}
				deque[front-1] = element;
				front--;
				size++;
			}
			//System.out.println("front =" + front + ", back =" + back);
		}
	}

	public void addLast(E element){
		if(element == null){
			throw new NullPointerException();
		}
		//System.out.println(size());
		if (size()==0){
			deque[back] = element;
			back++;
			size++;
			//System.out.println("front =" + front + ", back =" + back);
		}
		else{
			if (back==0){
				if (back == front){
					doubleCap();
					deque[back] = element;
					back++;
				}
				else{
				    deque[0] = element;
				    back = 1;
				}
				size++;
			}
			else{
				if (back == front){
					doubleCap();
				}
				deque[back] = element;
				back++;
				if (back == deque.length){
					back = 0;
				}
				size++;
			}
			//System.out.println("front =" + front + ", back =" + back);
		}
	}


    public E removeFirst(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	else{
	    //System.out.println("First= " + front);
	    E value = deque[front];
	    deque[front] = null;
	    if (front == deque.length-1){
		front = 0;
	    }
	    else{
		front++;
	    }
	    size--;
	    return value;
	}
    }

    public E removeLast(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	else{
	    //System.out.println("Last= " + back);
		if (back == 0){
			E value = deque[deque.length-1];
			deque[deque.length-1] = null;
			back = deque.length-1;
			size--;
			return value;
		}
		else{
			E value = deque[back-1];
			deque[back-1] = null;
			back--;
			size--;
			return value;
		}
	}
    }

    public E getFirst(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	return deque[front];
    }

    public E getLast(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	if (back==0){
		return deque[deque.length-1];
	}
	return deque[back-1];
    }
    
	public static void main(String[]args){
		MyDeque<Integer> thing = new MyDeque<Integer>();
		System.out.println(thing);
		System.out.println(thing.size());
	    thing.addLast(7);
		System.out.println(thing);
		thing.addLast(5);
		System.out.println(thing);
		thing.addLast(3);
		System.out.println(thing);
		thing.addLast(9);
		System.out.println(thing);
		thing.addLast(11);
		System.out.println(thing);
		thing.addLast(2);
		System.out.println(thing);
		thing.addLast(4);
		System.out.println(thing);
		thing.addLast(6);
		System.out.println(thing);
		//thing.addFirst(13);
		//System.out.println(thing);
		thing.addLast(8);
		System.out.println(thing);
		thing.addLast(10);
		System.out.println(thing);
		thing.addLast(1);
		System.out.println(thing);
		thing.addFirst(12);
		System.out.println(thing);
		thing.removeFirst();
		System.out.println(thing);
		thing.removeLast();
		System.out.println(thing);
	}
}
