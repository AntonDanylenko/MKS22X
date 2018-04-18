import java.util.LinkedList;

public class Stack{
    private LinkedList<Double> stack;

    public Stack(){
	stack = new LinkedList<Double>();
    }

    public double pop(){
	return stack.remove(stack.size()-1);
    }

    public double peek(int index){
        return stack.get(index);
    }

    public void push(double value){
	stack.add(value);
    }
}
