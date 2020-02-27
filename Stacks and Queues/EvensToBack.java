import java.util.*;

/*
 * Takes in a queue of integers as parameter and modifies it by placing
 * all the even numbers to the back of the queue. The order of the
 * even-to-even numbers and the odd-to-odd numbers is not affected.
 * 
 * Example - 
 * Passed Stack = front [4, 7, -11, 2, 3, -18, 22, 6, 17, 51, 10] back
 * Returned Stack = bottom [7, -11, 3, 17, 51, 4, 2, -18, 22, 6, 10] top
 * 
 * Space Allowed - One Auxilary Stack
 * Runtime Required - O(n)
 * 
*/
public class EvensToBack {
    public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();

        int[] arr = new int[]{4, 7, -11, 2, 3, -18, 22, 6, 17, 51, 10};

        for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}
        
        evensToBack(queue);
        System.out.println(queue);
    }
    
    public static void evensToBack(Queue<Integer> q) {
		Stack<Integer> s = new Stack<Integer>();

		int size = q.size();

		for (int i = 0; i < size; i++) {
			int num = q.remove();
			if (num % 2 == 0) {
				q.add(num);
			} else {
				s.push(num);
			}
		}

      	while (!q.isEmpty()) {
			s.push(q.remove());
		}

        // To reset the order
		while (!s.isEmpty()) {
			q.add(s.pop());
		}

		while (!q.isEmpty()) {
			s.push(q.remove());
		}

		while (!s.isEmpty()) {
			q.add(s.pop());
		}
	}
}