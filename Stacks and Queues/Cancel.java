import java.util.*;

/*
 * Takes in a stack of integers as parameter and modifies it by removing
 * all consecutive removes all consecutive pairs that sum to zero. IF removing
 * one such pair makes another pair sum to zero, then that pair is also removed.
 * 
 * Example - 
 * Passed Stack = bottom [1, 2, -2, -1, 3, 4, 5] top
 * Returned Stack = bottom [3, 4, 5] top
 * 
 * Assumptions - stack is not null
 * Space Allowed - One Auxilary Stack
 * Runtime Required - O(n)
 * 
*/
public class Cancel {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        int[] arr = new int[]{1, 2, -2, -1, 3, 4, 5};

        for (int i = 0; i < arr.length; i++) {
			stack1.push(arr[i]);
        }
        
        cancel(stack1);
        System.out.println(stack1);
    }

    public static void cancel(Stack<Integer> s) {
		Stack<Integer> s2 = new Stack<>();

		if (s.size() > 1) {
			s2.push(s.pop());
		}

		while(!s.isEmpty()) {
			int num = s.pop();
			int num2 = s2.pop();

			if (num + num2 != 0) {
				s2.push(num2);
				s2.push(num);
			}
		}

		while (!s2.isEmpty()) {
			s.push(s2.pop());
		}
	}
}