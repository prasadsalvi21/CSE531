package project1;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.*;
import java.util.*;

public class PrimsAlgoHeap
{
	public static int n=0,m=0,u=0,v=0,w=0,temp=0,sum=0,s=0,i=0;
	public static int parent[],child[],a[],p[],key[];
	public static boolean visited[];
	public static int nl=0;
	public static ArrayList<Graph1> g;
	@SuppressWarnings({ "resource"})
	public static void main(String[] args)
	{
		
		try
		{
			long startTime = System.currentTimeMillis();
			Path filePath = Paths.get("test1.txt");
			Scanner src = new Scanner(filePath);
			n=src.nextInt();
			m=src.nextInt();
			
			g=new ArrayList<Graph1>(2*m);
			visited=new boolean[n+1];
			parent=new int[n+1];
			a=new int[n+1];
			p=new int[n+1];
			key=new int[n+1];
			child=new int[n+1];
			for(int i1=1;i1<=n;i1++)
			{
				visited[i1]=false;
				key[i1]=1000000; 
				child[i1]=0;
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
				u=1;
				key[u]=0;
				s=0;
				for(int i3=1;i3<=n;i3++)
					insertHeap(i3,key[i3]);
				
				visited[0]=true;
				while(!allVisited(visited))
				{
					u=extractMin();
					//System.out.println("Start exporing Node u="+u);
					
					for(int d=1;d<=n;d++)	
						{
							if(visited[d]==false)
							{
								v=d;
								for(int z=0;z<2*m;z++)
								{
									if(u==g.get(z).getU()&&v==g.get(z).getV()&&g.get(z).getW()<key[v])
									{
									parent[v]=u;
									child[v]=v;
									key[v]=g.get(z).getW();
									decreaseKey(v,key[v]);
									//System.out.println("z="+z+" Visited of "+u+" ="+visited[d]+" u="+u+" v="+v+" Key="+key[d]+" Parent="+parent[d]+" Child="+child[d]);	
									
									}
								}
							}
							visited[u]=true;
							
							//for(int k=1;k<=n;k++)
							//	System.out.println("d="+d+" k="+k+" a["+k+"]="+a[k]+" p["+k+"]="+p[k]+" Parent="+parent[k]+" Child="+child[k]+" key["+k+"]="+key[k]+" Visited["+k+"]="+visited[k]);	
						}
					//System.out.println("Exploring of Node u= "+u+" is completed");
					}
				System.out.println("=============================================");
				
				
				for(int i10=1;i10<=n;i10++)
				{
					for(int j=1;j<=(n-i10);j++)
						if(parent[j]>parent[j+1])
						{
							temp=parent[j];
							parent[j]=parent[j+1];
							parent[j+1]=temp;
							temp=child[j];
							child[j]=child[j+1];
							child[j+1]=temp;
							boolean temp1=visited[j];
							visited[j]=visited[j+1];
							visited[j+1]=temp1;
							temp=key[j];
							key[j]=key[j+1];
							key[j+1]=temp;
							
						}
					
				}
				System.out.println("The output of Prims Algorithm:");
				System.out.println("u\tv\tw");
				for(int i8=2;i8<=n;i8++)
				{
						System.out.println(parent[i8]+"\t"+child[i8]+"\t"+key[i8]);
						sum=sum+key[i8];
				}
				System.out.println("Weighted sum="+sum);
				
				File file = new File("Output.txt");
				file.createNewFile();
				FileWriter writer = new FileWriter(file); 
				writer.write(new Integer(sum).toString());
				writer.write(System.getProperty( "line.separator" ));
				for(int i9=2;i9<=n;i9++)
				{
					writer.write(parent[i9]+" "+child[i9]+" "+key[i9]);
					writer.write(System.getProperty( "line.separator" ));
				}
				 writer.flush();
			     writer.close();
			     long stopTime = System.currentTimeMillis();
			      long elapsedTime = stopTime - startTime;
			      long seconds = (elapsedTime / 100);
			      System.out.println("Total Time taken in milliseconds = "+elapsedTime);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}      
		}
	public static void insertHeap(int v,int key_value)
	{
		s=s+1;
		a[s]=v;
		p[v]=s;
		key[v]=key_value;
		heapifyUp(s);
	}
	public static void heapifyUp(int i7)
	{
		int j=0;
		int temp=0;
		while(i7>1)
		{
			j=(int) Math.floor(i7/2);
			if(key[a[i7]]<key[a[j]])
			{
				temp=a[i7];
				a[i7]=a[j];
				a[j]=temp;
				p[a[i7]]=i7;
				p[a[j]]=j;
				i7=j;
			}
			else
				break;
		}
	}
	public static int extractMin()
	{
		int ret=0;
		ret=a[1];
		a[1]=a[s];
		p[a[1]]=1;
		s=s-1;
		if(s>=1)
			heapifyDown(1);
		return ret;
	}
	public static void heapifyDown(int i6)
	{
		int j=0,temp=0;
		while((2*i6)<=s)
		{
			if(((2*i6)==s)||(key[a[2*i6]]<=key[a[(2*i6)+1]]))
			{
				j=2*i6;
			}
			else
			{
				j=(2*i6)+1;
			}
			if(key[a[j]]<key[a[i6]])
			{
				temp=a[i6];
				a[i6]=a[j];
				a[j]=temp;
				p[a[i6]]=i6;
				p[a[j]]=j;
				i6=j;
			}
			else
				break;
		}
	}
	public static void decreaseKey(int v,int key_value)
	{
		key[v]=key_value;
		heapifyUp(p[v]);
		
	}
		public static boolean allVisited(boolean[] array)
		{
	     if(array.length == 0)
	     {
	         throw new IllegalArgumentException("Array is empty");
	     }
	     boolean first = array[0];
	     for(int i=1;i<array.length;i++) {
	         if(array[i] != first) {
	             return false;
	         }
	      }
	      return true;
		}
	}

