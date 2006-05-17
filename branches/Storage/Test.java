package Storage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exercise.*;

public class Test {
	
	private static DataConnection conn = new DataConnection();
	
	public static void main(String[] args){        
		conn.connect();
		
		TestPrint();
		
		conn.close();
	}
	
	public static void TestAdd(){
		for(int i=0;i<2500;i++){
			List<String> pos = new ArrayList<String>();
			pos.add("A");
			pos.add("B");
			pos.add("C");
			pos.add("D");
			Exercise ex = new MultichoiceExercise("exercise "+i,"main","What is this question",pos,1);
			conn.addExercise(ex);
		}
		for(int i=2500;i<5000;i++){
			List<String> pos = new ArrayList<String>();
			pos.add("A");
			pos.add("B");
			pos.add("C");
			pos.add("D");
			Exercise ex = new MultichoiceExercise("exercise "+i,"sub","What is this question",pos,2);
			conn.addExercise(ex);
		}
	}
	
	public static void TestGet(){
		System.out.println(conn.getExercise("exercise 3"));
	}
	
	public static void TestRemove(){
		for(int i=0;i<5000;i++){
			conn.deleteExercise("exercise "+i);
		}
	}
	
	public static void TestPrint(){
		List<String> list = conn.getExerciseTypes();
		Iterator iter = list.iterator();
	    while(iter.hasNext())
	    	System.out.println((String)(iter.next()));
	    System.out.println(""+list.size());
	}

}
