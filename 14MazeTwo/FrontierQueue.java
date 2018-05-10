public class FrontierQueue implements Frontier{
    private String[] queue;
	private int size;
	
	public FrontierQueue(){
		queue = new String[10];
	}
	
	public void resize(){
		String[] temp = new String[queue.length*2];
		for (int n=0; n<size; n++){
			temp[n] = queue[n];
		}
		queue = temp;
	}

	public Location next(){
		Location result = queue[0];
		for (int n=1; n<size; n++){
			queue[n-1] = queue[n];
		}
		size--;
		return result;
	}

	public void add(Location n){
		if (size==queue.length){
			resize();
		}
		queue[size] = n;
		size++;
	}

	public boolean hasNext(){
		return size!=0;
	}
}
