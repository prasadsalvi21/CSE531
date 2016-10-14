package project1;

import java.nio.file.*;
import java.util.*;


public class PrimsAlgo
{
	public static void main(String[] args)
	{
		int n,m,u,v,i=0,w=0;
		ArrayList<Graph1>[] g;
		int nl=0;
		try
		{
			//BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			Path filePath = Paths.get("test5.txt");
			Scanner src = new Scanner(filePath);
			List<Integer> integers = new ArrayList<>();
			n=src.nextInt();
			m=src.nextInt();
			g = new ArrayList[n];
			if(n>10000||m>10000||n<1||m<1)
			{
				System.out.println("Invalid graph entries present in input file");
			}
			else
			{
			System.out.println("n="+n+" m="+m);
			while (src.hasNext()&&(i<=n)) 
			{
				if (src.hasNextInt()) 
			    {
					u=src.nextInt();
					
					System.out.print("u="+u);
					//src.next();
			        //integers.add(src.nextInt());
					v=src.nextInt();
			    	System.out.print(" v="+v);
			    	//src.next();
			    	if(u>=v||v>n||u<1||v<1)
			    	{
			    		System.out.println("\nVertices (u,v) of graph should be 1 <= u < v <= n");
			    		break;
			    	}
			    	w=src.nextInt();
					if(w>1000000||w<1)
					{
						System.out.println("\nWight (w) of graph in input file should be 1 <= w <= 10^6");
						break;
					}
					System.out.print(" w="+w);
					g[i].add(new Graph1(u,v,w));
					i++;
					
					System.out.println();
					
				}
				else
			        src.next();
				nl=nl+1;
			    }
				if(nl!=m)
				{
				System.out.println("The number of entries for edges in file "+nl+" doesnot match with m="+m+" specified");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
		  System.out.println("success");      
		}
		
	}

