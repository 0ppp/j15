import java.io.*;
import java.util.*;

class s15_2
{
	
	public static void main(String []args) throws IOException
	{
		Hashtable ht= new Hashtable();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n");
		int n=Integer.parseInt(br.readLine());
		
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter Name");
				String name=br.readLine();
				System.out.println("Enter percentage");	
				double per=Double.parseDouble(br.readLine());
				ht.put(name,per);
				
			}
		System.out.println("Details are as follows...");
		
		Enumeration i1=ht.keys();
		while(i1.hasMoreElements())
			{   String buff=""+i1.nextElement();
				System.out.println(" Name"+buff);
				System.out.println(" percentage"+ht.get(buff));
							
			}
			
				while(true)
				{
					System.out.println("Enter name to search or enter exit to Terminate...");
					String temp=br.readLine();
					if(temp.equalsIgnoreCase("exit"))
						System.exit(0);
					
					
					int flag=0;double founded=0;
					Enumeration i2=ht.keys();
						while(i2.hasMoreElements())
						{   
							String buff=""+i2.nextElement();
								if(buff.equals(temp))
								{	founded=(double)ht.get(buff);
										flag=1;
								}
						}
				
					if(flag==1)
						System.out.println("Founded Per: "+founded);
						else
							System.out.println("Not Present");
						
				}
			
				
				
			}
			
	
	}	
	
