package subin;

import java.util.Stack;

public class Parentheses {
	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println("::MAIN:::" + isValid(s));
	}
	
    public static boolean isValid(String s) {
        /*
        https://leetcode.com/problems/valid-parentheses/
        String / Stack => Easy
      	() / {} / [] 짝맞추기 -> return boolean값
        */
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(char c : s.toCharArray()) {
    		if(c=='(') {
    			stack.push(')');
    		}else if( c== '{') {
    			stack.push('}');
    		}else if( c == '[') {
    			stack.push(']');
    		}else if(stack.isEmpty() || stack.pop() != c) {
    			return false;
    		}
    	}
    	
    	return stack.isEmpty();
    }
}
