import java.util.NoSuchElementException;

public class FrontierStack implements Frontier{
    private MyDeque<Location> stack;

	public FrontierStack(){
		stack = new MyDeque<>();
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
