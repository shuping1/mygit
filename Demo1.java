import java.io.*;
import java.util.Arrays; 
public class Demo1{   
	public static void main(String[] args)  {  
		try {        
			//产生5个随机整数按从小到大的顺序写入文件        
			BufferedWriter out = new BufferedWriter(new FileWriter("C:/1/d.txt"));  //绝对路径和相对路径均可             
			int a[]=new int[100];  
			 
			for(int k=0;k<100;k++)           {      
				a[k]=(int)(Math.random()*99);     
				//System.out.print(a[k]+" ");     
				}     
			
			 
			for(int i=0;i<100;i++)            { 
				out.write((String.valueOf(a[i])));          
				out.write(" ");            
				}          
			out.close();    
			//将文件中的内容读到屏幕上  
			BufferedReader in=new BufferedReader(new FileReader("C:/1/d.txt"));        
			String s=new String("");          
			String b=null;           
			while((s=in.readLine())!=null) {     
				System.out.print(s);         
				}       
			in.close();      
			}catch (IOException e) {}   
		
			
	}
}
