package Storage;

import java.util.Iterator;
import java.util.List;

import Exercise.Exercise;

public class Test {
	
	private static DataConnection conn = new DataConnection();
	
	public static void main(String[] args){
		conn.connect();
		
		List<String> list = conn.getThemes();
		
		conn.close();
		
		Iterator iter = list.iterator();
		while(iter.hasNext())
			System.out.println((String)iter.next());
				
	}

}
