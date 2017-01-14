import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Twitter {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

		List<String> list=new ArrayList<String>();
		FileReader fr=new FileReader("Input.txt");
		BufferedReader scanner = new BufferedReader (fr);
		String[] splitter=new String[1000000];    //to split input string into expression and opeartion
		String str;                              //read each input string
		String exp=null;                        //expression
		String op=null;                        //opeartion

		while((str=scanner.readLine())!=null && str.length()!=0)
		{
			str = str.replaceAll("\\s","");  //remove space from input string if any	
			list.add(str);                   //add string into list to itearte
		}
		for(int i=0;i<list.size();i++)
		{
			splitter= list.get(i).split("/");  //split string into expression and opeartion
			exp=splitter[0];
			System.out.println(exp);
			if(splitter.length==1)             //if no opeartion mentioned then print expression
			{
				System.out.println(exp);    				
			}
			else
			{
				op=splitter[1];
				String[] opeartion = op.split("");
				for(String w:opeartion)         //iterate for all opearions
				{
					if(w.equals("R"))         //if operation is R
					{
						char in[]=exp.toCharArray();        //convert exp to char array
						char out[]=new char[exp.length()];  //output char array
						int k=0;
						for(int j=(exp.length())-1;j>=0;j--)  //reverse each charcter from in and put in out char array
						{
							if(in[j]==')')
								out[k]=40;                  //ACCII value for '('
							else if(in[j]=='(')
								out[k]=41;                  //ASCII value for ')'
							else
							out[k]=in[j];                   //If charcter then add as it is
							k++;
						}
						exp=String.valueOf(out);
					
					}
					else if(w.equals("S"))                     //if opeartion is S
					{
						char in[]=exp.toCharArray();          //convert exp to char array
						char out[]=new char[exp.length()];    //output char array
						int k=0;
						boolean flag=false;
						for(int j=0;j<exp.length();j++)
						{
							
							if(in[j]=='(')                   //if charcter is '('
							{
								if(in[j+1]!='('&&in[j+2]!='(')  //if (AB then output _AB
								{
									out[k]=' ';
									flag=true;                 //flag to indicate to replace next ')' with '_'
								}
								else
									out[k]=40;                 //if '((' then output '('
							}
							else if(in[j]==')')              //if charcter is ')'
							{
								if(flag==true)              //if flag is true ; input=(AB) then _AB_
								{
									out[k]=' ';
									flag=false;
								}
								else
									out[k]=41;             //if '))' then ')'
							}
							else
							{
								if(in[j]!='('||in[j]!=')')      //if chacter other than ')' or '('
								    out[k]=in[j];
								else if(in[j]=='(')             
									out[k]=40;
								else out[k]=41;
							}
                            if(j+1<in.length)                   //to check if C(AB) then print as is
                            {
                            	int l=j+1;
                            	
									if(in[l]=='(')
									{
										while(in[l]!=')')
											l++;
										//System.out.println(in[l]);
										if(l+1<exp.length())
										{
											if(in[l+1]!='('||in[l+1]!=')')
												{
												System.out.println(in[l+1]);
												k++;
												j++;
												out[k]=' ';
												flag=true;
												}
										}
									}
                            }
							k++;								
						}
						
						exp=String.valueOf(out);              //convert char[] to exp string
						 System.out.println(exp);
						exp=exp.replaceAll("\\s","");         //to replace '_' to nospace
					}
					
				}
                System.out.println(exp);
			}
		

		}

	}

}

   