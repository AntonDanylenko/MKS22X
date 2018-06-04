import java.util.NoSuchElementException;

public class FrontierQueue implements Frontier{
    private MyDeque<Location> queue;
	
	public FrontierQueue(){
		queue = new MyDeque<>();
	}
	
	public Location next(){
		return queue.removeFirst();
	}

	public void add(Location n){
		queue.addLast(n);
	}

	public boolean hasNext(){
		try{
			return queue.getFirst() != null;
		}catch(NoSuchElementException e){
			return false;
		}
	}
}
