import java.util.*;

/*
 * Takes in a stack of integers as parameter and modifies it by replacing 
 * each successive pair of integers with the sum of the pair. If the stack is
 * odd length, then the last element is not affected.
 * 
 * Example - 
 * Passed Stack = bottom [1, 2, 3, 4, 5] top
 * Returned Stack = bottom [3, 7, 5] top
 * 
 * Space Allowed - One Auxilary Storage
 * Runtime Required - O(n)
 * 
*/
public class Collapse {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        int[] arr = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < arr.length; i++) {
			stack1.push(arr[i]);
        }
        
        collapse(stack1);
        System.out.println(stack1);
    }

    public static void collapse(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<Integer>();
	    
	    while (!s.isEmpty()){
	        q.add(s.pop());
	    }
	    
	    if (q.size() % 2 != 0) {
	        s.push(q.remove());
	    }
	    
	    while (!q.isEmpty()) {
	        s.push(q.remove() + q.remove());
	    }
	    
	    while (!s.isEmpty()){
	        q.add(s.pop());
	    }
	    
	    while (!q.isEmpty()){
	        s.push(q.remove());
	    }
	}
}