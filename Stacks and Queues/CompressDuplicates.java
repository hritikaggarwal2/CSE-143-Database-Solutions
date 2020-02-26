import java.util.*;

/*
 * Takes in a stack of integers as parameter and modifies it by replacing 
 * each sequence of duplicates with a pair of values representing a count
 * of the numbers duplicates followed by that number.
 * 
 * Example - 
 * Passed Stack = bottom [2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 0, 17, 0] top
 * Returned Stack = bottom [5, 2, 2, -5, 4, 3, 2, 4, 1, 0, 1, 17, 1, 0] top
 * 
 * Space Allowed - One Auxilary Queue
 * Runtime Required - O(n)
 * 
*/
public class CompressDuplicates {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        int[] arr = new int[]{2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 0, 17, 0};

        for (int i = 0; i < arr.length; i++) {
			stack1.push(arr[i]);
        }
        
        compressDuplicates(stack1);
        System.out.println(stack1);
    }

    public static void compressDuplicates(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<Integer>();

		int x = 0;
		int count = 0;

		if (s.size() > 1) {
			x = s.pop();
			count++;
		} else if (s.size() == 1) {
			q.add(s.pop());
			q.add(1);
		}

		while (!s.isEmpty()) {
			int num = s.pop();

			if (num == x) {
				count++;
			} else {
				q.add(x);
				q.add(count);
				x = num;
				count = 1;
			}
		}

		q.add(x);
		q.add(count);

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