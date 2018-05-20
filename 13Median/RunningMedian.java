import java.util.NoSuchElementException;

public class RunningMedian{
    private MyHeap maxHeap;
	private MyHeap minHeap;
    private int sizeMax;
	private int sizeMin;

    public RunningMedian(){
	maxHeap = new MyHeap(true);
	minHeap = new MyHeap(false);
    }

	public String toString(){
		return "Max:\n" + maxHeap + "\nMin:\n" + minHeap;
	}

    public void add(double value){
	int index = 0;
	if (size()==0){
		maxHeap.add(value);
		sizeMax++;
	}
	else if (value<getMedian()){
		maxHeap.add(value);
		sizeMax++;
	}
	else{
		minHeap.add(value);
		sizeMin++;
	}
	if (sizeMax-sizeMin>=2){
		minHeap.add(maxHeap.remove());
		sizeMax--;
		sizeMin++;
	}
	else if (sizeMin-sizeMax>=2){
		maxHeap.add(minHeap.remove());
		sizeMax++;
		sizeMin--;
	}
    }

    public int size(){
	return sizeMax + sizeMin;
    }
    
    public double getMedian(){
		if (size()==0){
			throw new NoSuchElementException();
		}
		if (sizeMax-sizeMin==0){
			return (maxHeap.peek() + minHeap.peek())/2;
		}
		else if (sizeMax>sizeMin){
			return maxHeap.peek();
		}
		else{
			return minHeap.peek();
		}
    }

	public static void main(String[]args){
		RunningMedian test = new RunningMedian();
		test.add(3);
		System.out.println(test);
		System.out.println("\n");
		System.out.println(test.getMedian());
		test.add(2);
		test.add(5);
		test.add(3);
		test.add(2);
		System.out.println(test);
		System.out.println("\n");
		System.out.println(test.getMedian());
		test.add(20);
		test.add(13);
		test.add(17);
		test.add(5);
		test.add(12);
		test.add(0);
		test.add(19);
		test.add(20);
		test.add(20);
		System.out.println(test);
		System.out.println("\n");
		System.out.println(test.getMedian());
	}
}
