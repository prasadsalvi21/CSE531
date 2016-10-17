package project1;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.*;
import java.util.*;

public class PrimsAlgo
{
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args)
	{
		int n=0,m=0,u=0,v=0,i=0,j=0,w=0,u1=0,v1=0,w1=0,temp=0,sum=0,count=0;
		int parent[],min[],child[];
		boolean visited[],temp1;
		int nl=0;
		try
		{
			Path filePath = Paths.get("test5.txt");
			Scanner src = new Scanner(filePath);
			n=src.nextInt();
			m=src.nextInt();
			ArrayList<Graph1> g,g1;
			g=new ArrayList<Graph1>(2*m);
			g1=new ArrayList<Graph1>(2*m);
			visited=new boolean[n+1];
			parent=new int[n+1];
			child=new int[n+1];
			min=new int[n+1];
			for(i=1;i<visited.length;i++)
			{
				visited[i]=false;
				min[i]=1000000; 
				child[i]=0;
			}
			
			if(n>10000||m>10000||n<1||m<1)
			{
				System.out.println("Invalid graph entries present in input file");
			}
			else
			{
			System.out.println("Given input from file:");
			System.out.println("n="+n+" m="+m);
			while (src.hasNext()&&(i<(2*m))) 
			{
				if (src.hasNextInt()) 
			    {
					u=src.nextInt();
					v=src.nextInt();
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
					g.add(new Graph1(u,v,w));
					g.add(new Graph1(v,u,w));
				}
				else
			        src.next();
				nl=nl+1;
			    }
				if(nl!=m)
				{
				System.out.println("The number of entries for edges in file "+nl+" doesnot match with m="+m+" specified");
				}
				for (i = 0; i < g.size(); i++) {
					System.out.print("U="+g.get(i).getU());
					System.out.print(" V="+g.get(i).getV());
					System.out.print(" W="+g.get(i).getW());
					System.out.println("");
				}
				i=0;
				visited[0]=true;
				visited[1]=true;
				u=g.get(i).getU();
				v=g.get(i).getV();
				w=g.get(i).getW();
				min[u]=0;
				parent[u]=u;
				child[u]=u;
				while(!allVisited(visited))
				{
					for(i=0;i<(2*m);i++)	
					{
						v=g.get(i).getV();
						w=g.get(i).getW();
					if(u==g.get(i).getU()&&visited[v]==false)
					{
					g1.add(new Graph1(u,v,w));
					count=count+1;
					visited[u]=true;
					}
					}
					Collections.sort(g1);
					/*for(Graph1 g11:g1)
						System.out.print(g11);*/
					u1=g1.get(0).getU();
					v1=g1.get(0).getV();
					w1=g1.get(0).getW();					
					if(min[v1]>w1)
					{
						parent[v1]=u1;
						child[v1]=v1;
						min[v1]=w1;
						
					}
					//System.out.println("\nCount="+count+" Visited of "+u1+" ="+visited[u1]+" u="+u1+" v="+v1+" Min="+min[v1]+" Parent="+parent[v1]+" Child="+child[v1]);
					g1.remove(0);
					if(g1.isEmpty())
					break;					
					u=v1;
					
				}
				System.out.println("=============================================");
				for(i=1;i<=n;i++)
				{
					for(j=1;j<=(n-i);j++)
						if(parent[j]>parent[j+1])
						{
							temp=parent[j];
							parent[j]=parent[j+1];
							parent[j+1]=temp;
							temp=child[j];
							child[j]=child[j+1];
							child[j+1]=temp;
							temp1=visited[j];
							visited[j]=visited[j+1];
							visited[j+1]=temp1;
							temp=min[j];
							min[j]=min[j+1];
							min[j+1]=temp;
							
						}
					
				}
				System.out.println("The output of Prims Algorithm:");
				System.out.println("u\tv\tw");
				for(i=1;i<=n;i++)
				{
						System.out.println(parent[i]+"\t"+child[i]+"\t"+min[i]);
						sum=sum+min[i];
				}
				System.out.println("Weighted sum="+sum);
				
				File file = new File("Output.txt");
				file.createNewFile();
				FileWriter writer = new FileWriter(file); 
				writer.write(new Integer(sum).toString());
				writer.write(System.getProperty( "line.separator" ));
				for(i=2;i<=n;i++)
				{
					writer.write(parent[i]+" "+child[i]);
					writer.write(System.getProperty( "line.separator" ));
				}
				 writer.flush();
			     writer.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}      
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

