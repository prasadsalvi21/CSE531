package project1;

import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;


public class PrimsAlgo
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		int n=0,m=0,u=0,v=0,i=0,j=0,w=0,u1=0,v1=0,w1=0;
		int parent[],min[];
		boolean visited[];
		int nl=0;
		try
		{
			//BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			Path filePath = Paths.get("test2.txt");
			Scanner src = new Scanner(filePath);
			n=src.nextInt();
			m=src.nextInt();
			ArrayList<Graph1> g,g1;
			//ArrayList<ArrayList<Integer>>g2;
			g=new ArrayList<Graph1>(m);
			g1=new ArrayList<Graph1>(m);
			//g2=new ArrayList<ArrayList<Integer>>(m);
			visited=new boolean[n+1];
			parent=new int[n+1];
			min=new int[n+1];
			System.out.println(visited.length);
			for(i=1;i<visited.length;i++)
			{
				visited[i]=false;
				min[i]=1000000; 
				//System.out.println("Visited["+i+"]="+visited[i]);
			}
			

			if(n>10000||m>10000||n<1||m<1)
			{
				System.out.println("Invalid graph entries present in input file");
			}
			else
			{
			System.out.println("n="+n+" m="+m);
			while (src.hasNext()&&(i<m)) 
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
					g.add(new Graph1(u,v,w));
					System.out.println("");
				}
				else
			        src.next();
				nl=nl+1;
			    }
				if(nl!=m)
				{
				System.out.println("The number of entries for edges in file "+nl+" doesnot match with m="+m+" specified");
				}
				/*for (i = 0; i < g.size(); i++) {
					System.out.print("U="+g.get(i).getU());
					System.out.print(" V="+g.get(i).getV());
					System.out.print(" W="+g.get(i).getW());
					System.out.println("");
				}*/
				i=0;
				visited[0]=true;
				visited[1]=true;
				u=g.get(i).getU();
				v=g.get(i).getV();
				w=g.get(i).getW();
				parent[u]=u;
				boolean match = allVisited(visited);
				//System.out.println(match);
				while(!allVisited(visited))
				{
					System.out.println("1");	
					if(i==m)
					{
						System.out.println("For V");
						visited[v]=true;
						break;
					}
					System.out.println("2");
					while(u==g.get(i).getU()&&visited[v]==false)
					{
						
					u=g.get(i).getU();
					v=g.get(i).getV();
					w=g.get(i).getW();
					System.out.println("3");
					g1.add(new Graph1(u,v,w));
					System.out.println("4");
					i++;
					if(i==m)
					{
						System.out.println("For V");
						visited[v]=true;
						break;
					}
					}
					Collections.sort(g1);
					for(Graph1 g11:g1)
						System.out.print(g11);
					u1=g1.get(0).getU();
					v1=g1.get(0).getV();
					w1=g1.get(0).getW();					
					if(min[v1]>w1)
					{
						parent[v1]=u1;
						min[v1]=w1;
					}
					
					
					visited[u1]=true;
					System.out.println("\ni="+i+" Visited="+visited[u1]+" u="+u1+" v="+v1+" Min="+min[v1]+" Parent="+parent[v1]);
					g1.remove(0);
					u=v1;
					
				}
				System.out.println("+++++++++++++++");
				for(i=1;i<=n;i++)
				System.out.println("Visited="+visited[i]+" Parent="+parent[i]+" Min="+min[i]);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
		  System.out.println("success");      
		}
		public static boolean allVisited(boolean[] array) {
	     if(array.length == 0) {
	         throw new IllegalArgumentException("Array is empty");
	     }
	     boolean first = array[1];
	     for(int i=1;i<=array.length;i++) {
	         if(array[i] != first) {
	             return false;
	         }
	      }
	      return true;
		}
	}

