package QnA;

import java.util.Stack;

public class StackReverse {

	public void reverseStack(Stack<Integer> st) {
		if (st.size() == 0)
			return;
		int n = getLast(st);
		reverseStack(st);
		st.push(n);

	}

	public int getLast(Stack<Integer> s) {
		int temp = s.pop();
		if (s.isEmpty()) {
			return temp;
		}
		else{
			int k = getLast(s);
			s.push(temp);
			return k;
		}
	}

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		StackReverse st = new StackReverse();
		st.reverseStack(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
