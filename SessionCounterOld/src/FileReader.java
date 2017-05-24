import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

	public static String read(String fileName) throws FileNotFoundException {
	    
	    StringBuilder sb = new StringBuilder();
	 
	    exists(fileName);
	 
	    try {
	       
	        BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	        try {
	           
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	           
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	 
	    
	    return sb.toString();
	}
}