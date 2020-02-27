import java.util.*;

/*
 * Takes in a queue of characters as parameter and modifies it by replacing
 * all the [brackets] in the queue to ordinary (parentheses). It also makes
 * sure that the parenthesis are balanced (i.e. they are properly closed)
 * 
 * Example - 
 * Passed Stack = front <--  (, [, (, ), (, (, ], ) --> back
 * Returned Stack = front <--  (, (, (, ), (, (, ), ), ), ) --> back
 * 
 * Space Allowed - One Auxilary Stack
 * Runtime Required - O(n)
 * 
*/
public class Expand {
    public static void main(String[] args) {
		Queue<Character> queue = new LinkedList<Character>();

        String str = "([()((])";

        for (int i = 0; i < str.length(); i++) {
			queue.add(str.charAt(i));
		}
        
        expand(queue);
        System.out.println(queue);
    }
    
    public static void expand(Queue<Character> q) {
		Stack<Character> s = new Stack<>();

		int size = q.size();

		for (int i = 0; i < size; i++) {
			char c = q.remove();
			
			if (c == '[' || c == '(') {
				s.add(c);
				q.add('(');
			} else if (c == ')') {
				s.pop();
				q.add(')');
			} else if (c == ']') {
				char x = s.pop();
				while (x != '[') {
					q.add(')');
					x = s.pop();
				}
				q.add(')');
			}
		}


	}
}