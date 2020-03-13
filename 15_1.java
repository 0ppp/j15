import java.io.*;

class s15_1
{
	
	public static void main(String []args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
			File f=new File("osim.dat");
			RandomAccessFile ras= new RandomAccessFile(f,"rw");

			System.out.println("Enter n");
			int n=Integer.parseInt(br.readLine());
			System.out.println("Enter Records");
	
			for(int i=0;i<n;i++)
			{
			
				System.out.println("Enter id");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Enter name");
				String name=br.readLine();
				System.out.println("Enter price");
				double price=Double.parseDouble(br.readLine());
				System.out.println("Enter qty");
				int qty=Integer.parseInt(br.readLine());
				
				
				ras.writeBytes(""+id+" "+name+" "+price+" "+qty+"\n");
			}
			ras.close();
			
		while(true)
		{
			System.out.println("1.search by name");
			System.out.println("2.find costliest item");
			System.out.println("3. display all items");
			System.out.println("4.Exit");
			System.out.println("Enter Choice");
			int ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
				
				case 1:		
							ras= new RandomAccessFile(f,"r");
							System.out.println("Enter name for Searching..");
							String get=br.readLine();
							for(int i=0;i<n;i++)
							{
								String buff=ras.readLine();
								String indi[]=buff.split(" ");
								if(indi[1].equals(get))
								{
								System.out.println("id: "+indi[0]+" and price: "+indi[2]+" and Qty :"+indi[3]);
											
								}
							}
							ras.close();
							break;
				case 2:
							ras= new RandomAccessFile(f,"r");
							
							String buff=ras.readLine();
							String indi[]=buff.split(" ");
							double maxc=Double.parseDouble(indi[2]);
							int maxi=0;
							
							for(int i=1;i<n;i++)
							{
								 String buff1=ras.readLine();
								 String indi1[]=buff1.split(" ");
								if(Double.parseDouble(indi1[2])>maxc)
								{
								maxi=i;
								maxc=Double.parseDouble(indi1[2]);
								}
							}
							ras.close();							
							ras= new RandomAccessFile(f,"r");// this for again traversing from starting record
							// now display info of maxi ^th index record
								for(int i=0;i<n;i++)
							{
							String buff2=ras.readLine();
								if(i==maxi)
								{								
							String indi2[]=buff2.split(" ");
								System.out.println("id: "+indi2[0]+" and name: "+indi2[1]+" and price: "+indi2[2]+" and Qty :"+indi2[3]);
							
								}
							}
							ras.close();
							break;
				case 3:	
							ras= new RandomAccessFile(f,"r");
							for(int i=0;i<n;i++)
							{
								String buff3=ras.readLine();
								System.out.println(buff3);
								
							}
							ras.close();
							break;
							
							case 4: System.exit(0);
							
			}
			
		}
		
	}
	
	
}