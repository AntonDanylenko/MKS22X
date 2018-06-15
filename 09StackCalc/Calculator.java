import java.util.Arrays;
import java.util.LinkedList;

public class Calculator{
    public static double eval(String s){
	Stack stack = new Stack();
	String temp = "";
    for (int n=0; n<s.length(); n++){
	    char val = s.charAt(n);
	    if (Character.isDigit(val) || val == '.'){
			temp += val;
	    }
	    else if (val == ' '){
			if (temp.length()>0){
				stack.push(Double.parseDouble(temp));
				temp = "";
			}
	    }
	    else{
			double second = stack.pop();
			double first = stack.pop();
			if (val == '+'){
				stack.push(first + second);
			}
			else if(val == '-'){
				stack.push(first - second);
			}
			else if(val == '*'){
				stack.push(first*second);
			}
			else if(val == '/'){
				stack.push(first/second);
			}
			else if(val == '%'){
				stack.push(first%second);
			}
	    }
	}
	if (stack.size()==0){
		return Double.parseDouble(temp);
	}
	else{
        return stack.peek(0);
	}
    }

    public static void main(String[]args){
	System.out.println(eval("2"));
	System.out.println(eval("2 3 +"));
        System.out.println(eval("2 3 + 9 *"));
        System.out.println(eval("2 3 + 9 * 10.5 5 - .5 - %"));
    }
}
