import java.util.*;

/*
 * Takes in two stack of integers as parameter and returns true if they are
 * exactly equal (with same elements at same positions and no extra elements)
 * 
 * Example - 
 * Passed Stack 1 = bottom [1, -3, 512, 0, 7, 8] top
 * Passed Stack 2 = bottom [1, -3, 512, 0, 7, 8] top
 * Returns = True
 * 
 * Space Allowed - One Auxilary Storage
 * Runtime Required - O(n)
 * 
*/
public class Equals {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        int[] arr = new int[]{1, -3, 512, 0, 7, 8};
        int[] arr2 = new int[]{1, -3, 512, 0, 7, 8};

        for (int i = 0; i < arr.length; i++) {
			stack1.push(arr[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
			stack2.push(arr2[i]);
        }
        
        System.out.println(equals(stack1, stack2));
    }

    public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
		Stack<Integer> s = new Stack<Integer>();

		if (s1.size() != s2.size()) {
			return false;
		}

		while (!s1.isEmpty()) {
			s.push(s1.pop());
			s.push(s2.pop());
		}

		int size = s.size();
		for (int i = 0; i < size / 2; i++) {
			int num1 = s.pop();
			int num2 = s.pop();

			if (num1 != num2) {
				return false;
			}

			s1.push(num2);
			s2.push(num1);
		}

		return true;
	}
}