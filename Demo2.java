import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class Demo2 {
	  	public static void main(String[] args) {
	  		Copy("C:/1/abc.txt", "C:/1/abc-copy-2.txt");
	  		 Copy("C:/1/image.JPG","C:/1/image2.JPG");
	  		} 	
	  	
	  	//buffercopy();����,���в�ͬbuffer֮��ĸ����滻����,��Դbuffer�������ݲ��滻��Ŀ��buffer��ָ��λ�á�
	  	public static void Copy(String source, String dest) {
	  		InputStream is = null;		
	  		OutputStream os = null;		
	  		BufferedInputStream bi = null;	
	  		BufferedOutputStream bo = null;		
	  		int temp = 0;		
	  		try {			
	  			is = new FileInputStream(source);	
	  			bi = new BufferedInputStream(is);		
	  			os = new FileOutputStream(dest);			
	  			bo = new BufferedOutputStream(os); 			
	  			while ((temp = bi.read()) != -1) {			
	  				bo.write(temp);				
	  				bo.flush();			
	  				} 	
	  			} catch (IOException e) {
	  				// TODO Auto-generated catch block
	  				e.printStackTrace();		
	  				} finally { // �ȴ򿪵ĺ�ر�		
	  					try {				
	  						if (is != null) {
	  							is.close();		
	  							}			
	  						} catch (IOException e) {
	  							// TODO Auto-generated catch block
	  							e.printStackTrace();			
	  							}		
	  					try {				
	  						if (bi != null) {	
	  							bi.close();		
	  							} 			
	  						} catch (IOException e) {
	  							// TODO Auto-generated catch block	
	  							e.printStackTrace();			
	  							}			
	  					try {				
	  						if (os != null) {	
	  							os.close();			
	  							} 			
	  						} catch (IOException e) {	
	  							// TODO Auto-generated catch block	
	  							e.printStackTrace();		
	  							}	
	  					try {			
	  						if (bo != null) {		
	  							bo.close();			
	  							} 		
	  						} catch (IOException e) {
	  							// TODO Auto-generated catch block		
	  							e.printStackTrace();			
	  							}		
	  					} 
	  		}
	  	
}