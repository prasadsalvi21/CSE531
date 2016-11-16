package project2;

import java.io.File;
import java.io.FileWriter;
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
			a1 = src.next();   //String input A
			b1 = src.next();	//String Input B
			n=a1.length();
			m=b1.length();
			a=new char[n+1];
			b=new char[m+1];
			for (int i = 0; i < n; i++) {
			      a[i+1] = new Character(a1.charAt(i));
			   }
			for (int i = 0; i < m; i++) {
			      b[i+1] = new Character(b1.charAt(i));
			   }
			
			opt=new int[n+1][m+1];	
			p=new char[n+1][m+1];

			for(int j=0;j<=m;j++)
				opt[0][j]=0;
			for(int i=1;i<=n;i++)
			{
				opt[i][0]=0;
				for(int j=1;j<=m;j++)
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
			/* p[i][j]
			for(int i=0;i<=n;i++)
			{
				for(int j=0;j<=m;j++)
					System.out.print(p[i][j]+" ");
				System.out.println();
			}*/
			int x=n;
			int y=m;
			StringBuilder op = new StringBuilder();
			while(x>0 && y>0)
			{
				if(p[x][y]=='d')
				{
					op.append(a[x]);
					x--;
					y--;
				}
				else if(p[x][y]=='u')
					x--;
				else
					y--;
					
			}
			op=op.reverse();
			System.out.println("Output= "+op+" length= "+op.length());
			
			File file = new File("output.txt");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(new Integer(op.length()).toString());
			writer.write(System.getProperty("line.separator"));
			writer.append(op);
			writer.flush();
			writer.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
