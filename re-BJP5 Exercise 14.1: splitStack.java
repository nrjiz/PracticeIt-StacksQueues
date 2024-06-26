import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class something {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(-2);
		stack.push(5);
		stack.push(-1);
		stack.push(6);
		stack.push(-4);

		System.out.println("Original Stack: " + stack);

		splitStack(stack);

		System.out.println("Modified Stack: " + stack);
	}

//	public static void splitStack(Stack<Integer>stack) {
//		if(stack.isEmpty())return;
//		else {
//			int temp=stack.pop();
//			splitStack(stack);
//			if(temp>0) {
//				stack.push(temp);
//			}else {
//				pushNegativeToFirst(stack,temp);
//			}
//		}
//	}
//	private static void pushNegativeToFirst(Stack<Integer>stack,int val) {
//		if(stack.isEmpty()) {stack.push(val); return;}
//		else {
//			int temp=stack.pop();
//			pushNegativeToFirst(stack,val);
//			stack.push(temp);
//
//		}
//	}
	
	public static void splitStack(Stack<Integer>stack) {
		Queue<Integer>queue=new LinkedList<Integer>();
		int neg=0;
		
		while(!stack.isEmpty()) {
			if(stack.peek()<0) {
				neg++;
			}
			queue.add(stack.pop());
		}
		
		while(neg>0) {
			if(queue.peek()<0) {
				stack.push(queue.remove());
				neg--;
			}
			else {
				queue.add(queue.remove());
			}
		}
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}		
	}
}
