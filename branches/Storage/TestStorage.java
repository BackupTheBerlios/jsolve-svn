package Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.jdo.PersistenceManager;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.*;

import Exercise.Exercise;
import Exercise.MultichoiceExercise;

public class TestStorage {
	
	private DataConnection conn = new DataConnection();
	private Exercise[] buffer = new Exercise[500];
	private Set<String> themes = new HashSet<String>();
	
	public static Test suite(){
		return new JUnit4TestAdapter(TestStorage.class);
	}
	
	@Before
	public void testAdd(){
		conn.connect();
		
		for(int i=0;i<250;i++){
			List<String> pos = new ArrayList<String>();
			pos.add("A");
			pos.add("B");
			pos.add("C");
			pos.add("D");
			String theme = "algemeen";
			Exercise ex = new MultichoiceExercise("exercise "+i,theme,"What is this question",pos,1);
			buffer[i] = ex;
			themes.add(theme);
			conn.addExercise(ex);
		}
		for(int i=250;i<500;i++){
			List<String> pos = new ArrayList<String>();
			pos.add("A");
			pos.add("B");
			pos.add("C");
			pos.add("D");
			String theme = "expert";
			Exercise ex = new MultichoiceExercise("exercise "+i,theme,"What is this question",pos,2);
			buffer[i] = ex;
			themes.add(theme);
			conn.addExercise(ex);
		}
		
		conn.close();
	}
	
	//FIXME: equals methods of exercise types
	@org.junit.Test
	public void testGet(){
		conn.connect();
		for (int i=0; i<500; i++)
			Assert.assertEquals(buffer[i].toString(), (conn.getExercise("exercise "+ i)).toString());
		conn.close();
	}
	
	@org.junit.Test
	public void testGetThemes(){
		conn.connect();
		ArrayList<String> dbthemes = (ArrayList<String>)conn.getThemes();
		for (int i=0; i<dbthemes.size(); i++)
			Assert.assertEquals((setToList(themes)).size(), dbthemes.size());
		conn.close();
	}
	
	@org.junit.Test
	public void testGetTheme(){
		conn.connect();
		List<String> themes = conn.getThemes();
		for (int i=0;i<themes.size();i++){
			List<String> tmp = new ArrayList<String>();
			String theme = themes.get(i);
	    	for (int j=0; j<buffer.length; j++){
	    		if (buffer[j].getTheme().equals(theme))
	    		tmp.add((String)buffer[j].getTheme());
	    	}
			Assert.assertEquals(tmp, conn.getTheme(theme));
		}
		conn.close();		
	}
	
	//Manually add the types to check!!
	@org.junit.Test
	public void testGetExerciseTypes(){
		conn.connect();
		Assert.assertEquals("MultichoiceExercise", (conn.getExerciseTypes()).get(0));
		conn.close();
	}
	
	
	
	@org.junit.Test
	public void testGetExerciseType(){
		Set<Exercise> tmp = new HashSet<Exercise>();
		MultichoiceExercise dum = new MultichoiceExercise();
		for(int i=0; i<buffer.length; i++){
			if((dum.getClass()).equals(buffer[i].getClass()))
				tmp.add(buffer[i]);
		}
			
		conn.connect();
		Assert.assertEquals(tmp, listToSet(conn.getExerciseType(dum)));
		conn.close();
	}
	
	@org.junit.Test
	public void testGetExerciseNames(){
		conn.connect();
		
		Set<String> tmp = new HashSet<String>();
    	for (int i=0; i<buffer.length; i++)
    		tmp.add(buffer[i].getTitle());
    	
		Assert.assertEquals(tmp, listToSet(conn.getExerciseNames()));
		conn.close();
	}
	
	//FIXME: equals methods of exercise types
	@org.junit.Test
	public void testGetAllExercises(){
		conn.connect();
		
		Set<Exercise> tmp = new HashSet<Exercise>();
    	for (int i=0; i<buffer.length; i++)
    		tmp.add(buffer[i]);
    	
		for (int i=0; i<5000; i++)
			Assert.assertEquals(tmp, listToSet(conn.getAllExercises()));
		conn.close();
	}
	/*
	@After
	public void testRemove(){
		conn.connect();
		for(int i=0;i<5000;i++)
			conn.deleteExercise("exercise "+i);
		conn.close();
	}
	*/
	/**
     * Converts a set to a list
     * @param set
     * @return
     */
    private List<String> setToList(Set<String> set) {
    	List<String> out = new ArrayList<String>();
    	Iterator iter = set.iterator();
    	while (iter.hasNext())
    		out.add((String) iter.next());
    	return out;    		
    }
    
    private Set listToSet(List list) {
    	Set out = new HashSet();
    	Iterator iter = list.iterator();
    	while (iter.hasNext())
    		out.add(iter.next());
    	return out;
    }
}
