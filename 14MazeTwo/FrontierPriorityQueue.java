public class FrontierPriorityQueue implements Frontier{
	private MyHeap<Location> queue;
	
	public FrontierPriorityQueue(){
        queue = new MyHeap<Location>(false);
    }

    public Location next(){
		return queue.remove();
    }

    public void add(Location n){
		queue.add(n);
    }

    public boolean hasNext(){
		return queue.peek() != null;
    }
}  