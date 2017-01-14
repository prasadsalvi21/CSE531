import java.util.Arrays;

public class Fidessa2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcba";
		char c[]=s.toCharArray();
		for(int i=0;i<s.length();i++)
		{
			String a=Character.toString(c[i]);
			String b=s.substring(i+1, s.length());
			if(b.contains(a))
			{
				System.out.println(a);
				break;
			}
		}
				

	}

}
