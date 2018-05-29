public class FrontierStack implements Frontier{
    private Location[] stack;
	private int size;
	
	public FrontierStack(){
		stack = new Location[10];
	}
	
	public void resize(){
		Location[] temp = new Location[stack.length*2];
		for (int n=0; n<size; n++){
			temp[n] = stack[n];
		}
		stack = temp;
	}

	public Location next(){
		Location result = stack[size-1];
		stack[size-1] = null;
		size--;
		return result;
	}

	public void add(Location n){
		if (size==stack.length){
			resize();
		}
		stack[size] = n;
		size++;
	}

	public boolean hasNext(){
		return size!=0;
	}
}
