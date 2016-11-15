package project2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LCS_Prasad_Salvi_prasadde {
	public static String a1,b1;
	public static char []a,b;
	public static char [][]p;
	public static int opt[][];
	public static int n,m;
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			Path filePath = Paths.get("input.txt");
			Scanner src = new Scanner(filePath);
			a1 = src.next();
			b1 = src.next();
			a=a1.toCharArray();
			b=b1.toCharArray();
			n=a.length;
			m=b.length;
			opt=new int[n][m];
			p=new char[n][m];
			for(int i=0;i<a.length;i++)
				System.out.println(b[i]);
			for(int j=0;j<m;j++)
				opt[0][j]=0;
			for(int i=1;i<n;i++)
			{
				opt[i][0]=0;
				for(int j=1;j<m;j++)
				{
					if(a[i]==b[j])
					{
						opt[i][j]=opt[i-1][j-1]+1;
						p[i][j]='d';
					}
					else if(opt[i][j-1]>=opt[i-1][j])
					{
						opt[i][j]=opt[i][j-1];
						p[i][j]='l';
					}
					else
					{
						opt[i][j]=opt[i-1][j];
						p[i][j]='u';
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
					System.out.print(p[i][j]+" ");
				System.out.println();
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
