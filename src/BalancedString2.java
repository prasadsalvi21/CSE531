
public class BalancedString2 {

	public static void main(String[] args) {
		String s="((())()())";
		char c[]=s.toCharArray();
		char count[]=new char[s.length()+1];
		int top=0;
		int longest=0;
		boolean flag=true;
		for(int i=0;i<s.length();i++)
		{
			if(c[i]==')')
			{
				top--;
				if(top<0)
				{
					longest=0;
					top=0;
				}
				longest++;
			}
			else if(c[i]=='(')
			{
				top++;
				count[top]='(';
				flag=true;
				longest++;
			}
				
		}
			System.out.println("longest sequence = "+longest);

	}

}
