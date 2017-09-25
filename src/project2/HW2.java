import java.util.Scanner;


public class HW2 {
	
	public static int n=0,m=0,u=0,v=0,w=0,temp=0,sum=0,s=0;
	public static int parent[],child[],a[],p[],key[],keyb[],pb[],b[];
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner src = new Scanner(System.in);
		
		System.out.println("Number of elements");
		n=(int)src.nextInt();
		key=new int[n+1];
		parent=new int[n+1];
		a=new int[n+1];
		p=new int[n+1];
		b=new int[n+1];
		pb=new int[n+1];
		keyb=new int[n+1];
		for(int i1=1;i1<=n;i1++)
		{
			key[i1]=1000000; 
		}

        key[1]=0;
		s=0;
		for(int i=1;i<=n;i++)
		{
		System.out.println("Add element in array");
		m=src.nextInt();
		key[i]=m;
			insertHeap(i,m);
		}
		for(int i1=1;i1<=Math.floor((n+1)/2);i1++)	
			u=extractMin();
		System.out.println("Elements in Array");
		for(int i=1;i<=n;i++)
			System.out.print(key[i]+" ");
		System.out.println("\nMedian="+key[u]);
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
				//System.out.println("key[a["+i7+"]="+key[a[i7]]+" key[a["+j+"]="+key[a[j]]);
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

}
