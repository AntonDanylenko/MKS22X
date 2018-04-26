import java.util.Arrays;
import java.util.LinkedList;

public class MyDeque<E>{
	private E[] deque;
	private int front;
	private int back;
	
	@SuppressWarnings("unchecked") public MyDeque(){
		deque = (E[]) new Object[10];
		front = 0;
		back = 0;
	}
	
	@SuppressWarnings("unchecked") public MyDeque(int capacity){
		deque = (E[]) new Object[capacity];
		front = 0;
		back = 0;
	}
	
	public String toString(){
		return Arrays.toString(deque);
	}
	
	public int size(){
		return deque.length;
	}
	
	@SuppressWarnings("unchecked") private void doubleCap(){
		E[] temp = (E[]) new Object[size() * 2];
		if (back<front){
			for (int n=0; n<=back; n++){
				temp[n] = deque[n];
			}
			for (int r=front; r<size(); r++){
				temp[temp.length - size() + r] = deque[r];
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
			throw new NullPointerException();
		}
		if (deque[front].equals(null)){
			deque[front] = element;
		}
		else{
			if (front<1){
				if (!deque[size()-1].equals(null)){
					doubleCap();
				}
				deque[size()-1] = element;
				front = size()-1;
			}
			else{
				if (!deque[front-1].equals(null)){
					doubleCap();
				}
				deque[front-1] = element;
				front--;
			}
		}
	}

	public void addLast(E element){
		if(element == null){
			throw new NullPointerException();
		}
		if (deque[back].equals(null)){
			deque[back] = element;
		}
		else{
			if (back+1==size()){
				if (!deque[0].equals(null)){
					doubleCap();
				}
				deque[0] = element;
				back = 0;
			}
			else{
				if (!deque[back + 1].equals(null)){
					doubleCap();
				}
				deque[back + 1] = element;
				back++;
			}
		}
	}
	
	public static void main(String[]args){
		MyDeque<Integer> thing = new MyDeque<Integer>();
		System.out.println(thing);
		System.out.println(thing.size());
		thing.addFirst(7);
		System.out.println(thing);
	}
}