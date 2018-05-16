public class RunningMedian{
    private double[] container;
    private int size;

    public RunningMedian(){
	container = new double[10];
    }

    public void add(double value){
	if (size = container.length){
	    resize();
	}
	container[size] = value;
    }

    public void resize(){
	String[] temp = new String[data.length*2];
	for (int n=0; n<size; n++){
	     temp[n] = data[n];
        }
        data = temp;
    }

    public int size(){
	return size;
    }
    
    public double getMedian(){
    }
}
