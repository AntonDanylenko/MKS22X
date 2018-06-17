import java.util.NoSuchElementException;
import java.util.*;
import java.io.*;

public class FrontierStack implements Frontier{
    private ArrayDeque<Location> stack;

	public FrontierStack(){
		stack = new ArrayDeque<>();
	}
	
	public Location next(){
		return stack.removeFirst();
	}

	public void add(Location n){
		stack.addFirst(n);
	}

	public boolean hasNext(){
		try{
			return stack.getFirst() != null;
		}catch(NoSuchElementException e){
			return false;
		}
	}
}
