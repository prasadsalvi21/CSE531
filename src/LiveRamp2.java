// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int count=0,i=0,j=0;
        
        for(i=0;i<A.length-1;i++)
        {
            if(A[i]>A[i+1])
                break;
            
        }
        int start =i;
        for(j=i;j<A.length-1;j++)
            {
                if(A[j]<A[j+1])
                    break;
            }
         int end=j;
         return (end-start+1);
    }
}