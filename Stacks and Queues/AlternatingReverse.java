import java.util.*;

/*
 * Takes in a stack of integers as parameter and rearranges the stack
 * such that every other value starting from the bottom of the stack
 * is reversed. 
 * 
 * Example - 
 * Passed Stack = bottom [1, 2, 3, 4, 5, 6, 7, 8] top
 * Returned Stack = bottom [7, 2, 5, 4, 3, 6, 1, 8] top
 * 
 * Throws IllegalArgumentException if stack is not even sized
 * 
 * Space Allowed - One Auxilary Storage
 * Runtime Required - O(n)
 * 
*/
public class AlternatingReverse {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        for (int i = 0; i < arr.length; i++) {
			stack1.push(arr[i]);
        }
        
        alternatingReverse(stack1);
        System.out.println(stack1);
    }

    public static void alternatingReverse(Stack<Integer> s) {
		if (s.size() % 2 != 0) {
			throw new IllegalArgumentException();
		}
	
		Queue<Integer> q = new LinkedList<>();
		
		while (!s.isEmpty()) {
			q.add(s.pop());
		}

		int size = q.size();

		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				q.add(q.remove());
			} else {
				s.push(q.remove());
			}
		}

		for (int i = 0; i < size / 2; i++) {
			q.add(q.remove());
			q.add(s.pop());
		}

        // To reset the order
		while (!q.isEmpty()) {
			s.push(q.remove());
		}

		while (!s.isEmpty()) {
			q.add(s.pop());
		}

		while (!q.isEmpty()) {
			s.push(q.remove());
		}
	}
}