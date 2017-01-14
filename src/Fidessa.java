import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Fidessa {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       Scanner src=new Scanner(System.in);
        int n;
        //n=src.nextInt();
        n=1;
        
       // src.next();
       // System.out.println(n);
        int a,b,c;
        for(int i=0;i<n;i++)
            {
           // a=src.nextInt();
            //b=src.nextInt();
            //c=src.nextInt();
            a=3;b=3;c=4;
            boolean flag=false;
           // System.out.println("A="+a+"B="+b+"C="+c);
            //src.next();
            if(((a+b)>c)&&((a+c)>b)&&((b+c)>a))
            {
            if(a==b&&b==c&&a==c)
                System.out.println("Equilateral");
            else if(a==b||b==c||a==c)
               
                System.out.println("Isosceles");
            }
                else
                System.out.println("None of these");
                
        }
    }
}