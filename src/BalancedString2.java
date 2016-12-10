import java.util.Stack;

public class BalancedString2 {

	public static void main(String[] args) {
		String s="())";
		 Stack<Integer> stack = new Stack<Integer>();
		    int max=0;
		    int top = -1;
		    for(int i=0;i<s.length();i++){
		        if(s.charAt(i)=='(') stack.push(i);            
		        else {
		            if (stack.isEmpty())
		            	top=i;
		            else{
		                stack.pop();
		                if(stack.isEmpty())
		                	max=Math.max(max,i-top);
		                else 
		                	max=Math.max(max,i-stack.peek());
		               }
		            }
		        }
		    System.out.println("Length of balanced String = "+max);
		

	}

}
