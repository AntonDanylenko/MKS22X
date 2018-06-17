import java.util.NoSuchElementException;
import java.util.*;
import java.io.*;

public class FrontierQueue implements Frontier{
    private ArrayDeque<Location> queue;
	
	public FrontierQueue(){
		queue = new ArrayDeque<>();
	}
	
	public Location next(){
		return queue.removeFirst();
	}

	public void add(Location n){
		queue.addLast(n);
	}

	public boolean hasNext(){
		return queue.peek() != null;
	}
}
