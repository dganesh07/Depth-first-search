import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Stack {
	ArrayList<Integer> Stack;
	Set<Integer> hs = new HashSet<>();

	public Stack() {
		Stack = new ArrayList<>(10);
	}

	public void push(int item) {
		Stack.add(item);
		hs.addAll(Stack);
		Stack.clear();
		Stack.addAll(hs);
		
	}

	public int pop() {
	return Stack.remove(Stack.size()-1);
}
	
	public int stackSize(){
		return Stack.size();
	}
	
	
	public ArrayList<Integer> Display(){
		return Stack;
	}
	
	
	
	  public int peek() {
	        return Stack.get(Stack.size()-1);
	    }
	
	
	public int isEmpty(){
		if(Stack.isEmpty())
			return 1;
		return 0;
	}
	
	
}

