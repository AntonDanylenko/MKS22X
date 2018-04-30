import java.util.Arrays;

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
		if (back<front){
			for (int n=0; n<=back; n++){
				temp[n] = deque[n];
			}
			for (int r=front; r<deque.length; r++){
				temp[temp.length - deque.length + r] = deque[r];
			}
		}
		else{
			for (int n=front; n<=back; n++){
				temp[n] = deque[n];
			}
		}
		deque = temp;
	}

	public void addFirst(E element){
		if(element == null){
		    System.out.println("threw exception");
			throw new NullPointerException();
		}
		if (size()==0){
		    System.out.println("front = null");
			deque[front] = element;
			size++;
			System.out.println("front =" + front + ", back =" + back);
		}
		else{
			if (front<1){
				if (!deque[deque.length-1].equals(null)){
					doubleCap();
				}
				deque[deque.length-1] = element;
				front = size()-1;
				size++;
			}
			else{
				if (!deque[front-1].equals(null)){
					doubleCap();
				}
				deque[front-1] = element;
				front--;
				size++;
			}
			System.out.println("front =" + front + ", back =" + back);
		}
	}

	public void addLast(E element){
		if(element == null){
			throw new NullPointerException();
		}
		System.out.println(size());
		if (size()==0){
			deque[back] = element;
			size++;
			System.out.println("front =" + front + ", back =" + back);
		}
		else{
			if (back+1==deque.length){
				if (!deque[0].equals(null)){
					doubleCap();
				}
				deque[0] = element;
				back = 0;
				size++;
			}
			else{
				if (back+1 == front){
					doubleCap();
				}
				deque[back + 1] = element;
				back++;
				size++;
			}
			System.out.println("front =" + front + ", back =" + back);
		}
	}
	
	public static void main(String[]args){
		MyDeque<Integer> thing = new MyDeque<Integer>();
		System.out.println(thing);
		System.out.println(thing.size());
		thing.addFirst(7);
		System.out.println(thing);
		thing.addLast(5);
		System.out.println(thing);
		thing.addFirst(3);
		System.out.println(thing);
	}
}
