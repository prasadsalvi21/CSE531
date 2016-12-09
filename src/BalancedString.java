
public class BalancedString {

	public static void main(String[] args) {
		String s="()";
		char c[]=s.toCharArray();
		char count[]=new char[s.length()+1];
		int top=0;
		boolean flag=true;
		for(int i=0;i<s.length();i++)
		{
			if(c[i]==')')
			{
				top--;
				if(top<0)
				{
					flag=false;
					break;
				}
			}
			else if(c[i]=='(')
			{
				top++;
				count[top]='(';
				//flag=true;
			}
				
		}
		if(flag==true && count[top]!='(')
		System.out.println("String is balanced");
		else
			System.out.println("String is not balanced");

	}

}
