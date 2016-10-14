
public class BinarySearch {
	  public static void main(String args[])
	  {
	    int first, last, middle, n=0, search=0;
	    boolean flag=false;
	   int array[]={-9,-6,-2,0,1,2,3,4,6,8};
	   n = array.length;
	 for(int i=0;i<=n;i++)
	 {
	   if(array[i]<=0)
	   {
		search=Math.abs(array[i]);
		System.out.println("Original:"+array[i]+" Search:"+search);
	    first  = 0;
	    last   = n - 1;
	    middle = (first + last)/2;
		{
	    while( first <= last )
	    {
	      if ( array[middle] < search )
	        first = middle + 1;    
	      else if ( array[middle] == search ) 
	      {
	        System.out.println(search + " found at location " + (middle + 1) + ".");
	        flag=true;
	        break;
	      }
	      else
	         last = middle - 1;
	 
	      middle = (first + last)/2;
	   }
	   if ( first > last )
	      System.out.println(search + " is not present in the list");
		}
	  }
	   else break;
	   
	 }
	 System.out.println("The output is:"+flag);
	  }
}

