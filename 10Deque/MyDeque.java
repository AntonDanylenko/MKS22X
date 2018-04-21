import java.util.Arrays;
import java.util.LinkedList;

public class MyDeque<E>{
	private E[] deque;
	
	@SuppressWarnings("unchecked") public MyDeque(){
		deque = (E[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked") public MyDeque(int capacity){
		deque = (E[]) new Object[capacity];
	}
	
	public String toString(){
		return Arrays.toString(deque);
	}
	
	public int size(){
		return deque.length;
	}
	
	
	public static void main(String[]args){
		MyDeque thing = new MyDeque();
		System.out.println(thing);
		System.out.println(thing.size());
	}
}