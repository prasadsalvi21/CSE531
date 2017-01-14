
public class LiveRamp1 {

	public static void main(String[] args) {
		int A,B,C,D;
		A=0;
		B=3;
		C=0;
		D=7;
		        String a[]=new String[24];
		        int max=0;
		        a[0]=Integer.toString(A)+Integer.toString(B)+Integer.toString(C)+Integer.toString(D);
		        a[1]=Integer.toString(A)+Integer.toString(B)+Integer.toString(D)+Integer.toString(C);
		        a[2]=Integer.toString(A)+Integer.toString(C)+Integer.toString(D)+Integer.toString(B);
		        a[3]=Integer.toString(A)+Integer.toString(D)+Integer.toString(C)+Integer.toString(B);
		        a[4]=Integer.toString(A)+Integer.toString(D)+Integer.toString(B)+Integer.toString(C);
		        a[5]=Integer.toString(A)+Integer.toString(D)+Integer.toString(C)+Integer.toString(B);
		        a[6]=Integer.toString(B)+Integer.toString(A)+Integer.toString(C)+Integer.toString(D);
		        a[7]=Integer.toString(B)+Integer.toString(A)+Integer.toString(D)+Integer.toString(C);
		        a[8]=Integer.toString(B)+Integer.toString(C)+Integer.toString(A)+Integer.toString(D);
		        a[9]=Integer.toString(B)+Integer.toString(C)+Integer.toString(D)+Integer.toString(A);
		        a[10]=Integer.toString(B)+Integer.toString(D)+Integer.toString(C)+Integer.toString(A);
		        a[11]=Integer.toString(B)+Integer.toString(D)+Integer.toString(A)+Integer.toString(C);
		        a[12]=Integer.toString(C)+Integer.toString(B)+Integer.toString(A)+Integer.toString(D);
		        a[13]=Integer.toString(C)+Integer.toString(B)+Integer.toString(D)+Integer.toString(A);
		        a[14]=Integer.toString(C)+Integer.toString(A)+Integer.toString(B)+Integer.toString(D);
		        a[15]=Integer.toString(C)+Integer.toString(A)+Integer.toString(D)+Integer.toString(B);
		        a[16]=Integer.toString(C)+Integer.toString(D)+Integer.toString(B)+Integer.toString(A);
		        a[17]=Integer.toString(C)+Integer.toString(D)+Integer.toString(A)+Integer.toString(B);
		        a[18]=Integer.toString(D)+Integer.toString(A)+Integer.toString(C)+Integer.toString(B);
		        a[19]=Integer.toString(D)+Integer.toString(A)+Integer.toString(B)+Integer.toString(C);
		        a[20]=Integer.toString(D)+Integer.toString(B)+Integer.toString(C)+Integer.toString(A);
		        a[21]=Integer.toString(D)+Integer.toString(B)+Integer.toString(A)+Integer.toString(C);
		        a[22]=Integer.toString(D)+Integer.toString(C)+Integer.toString(A)+Integer.toString(B);
		        a[23]=Integer.toString(D)+Integer.toString(C)+Integer.toString(B)+Integer.toString(A);
		       	        
		        for(int i=0;i<24;i++)
		        {
		           // System.out.println(a[i]+" "+i);
		        	int time;
		            int h1,h2,m1,m2;
		          
		            h1=Character.getNumericValue(a[i].charAt(0));
		            h2=Character.getNumericValue(a[i].charAt(1));
		            m1=Character.getNumericValue(a[i].charAt(2));
		            m2=Character.getNumericValue(a[i].charAt(3));
		            		            
		            if(h1<=2)
		            {
		                if(h1==2)
		                {
		                  if(h2<=3&&m1<=5&&m2<=9)  
		                  {
		                      //System.out.println(h1+" "+h2+" "+m1+" "+m2);
		                      time=Integer.parseInt(a[i]);
		                      if(max<time)
		                    	  max=time;
		                      
		                  }
		                }
		                else if(m1<=5&&m2<=9)
		                {
		                    time=Integer.parseInt(a[i]);
		                      if(max<time)
		                    	  max=time;
		                  //System.out.println(h1+" "+h2+" "+m1+" "+m2);
		                }
		            }
		        }
		        
		        
		        if(max!=0)
		        {
		             
		             String maxtime = String.format("%04d", max);
		            String maxtime1=maxtime.substring(0,2)+":"+maxtime.substring(2,4);
		                System.out.println(maxtime1);;
		        }
		        else
		            System.out.println("NOT POSSIBLE");
		        
		    }
		

	}


