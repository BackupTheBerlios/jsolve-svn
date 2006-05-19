package Storage;

/**
 * @author Birger Anckaert
 *
 * JUnit TestClass for automatic testing of the database
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import java.util.Set;

import org.junit.Before;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import Exercise.Exercise;
import Exercise.MultichoiceExercise;

public class TestStorage {
	
	private DataConnection conn = new DataConnection();
	private Exercise[] buffer = new Exercise[500];
	private Set<String> themes = new HashSet<String>();
	
	/**
	 * Adapter for JUnit platforms running previous versions of 4
	 * @return JUnit4TestAdapter
	 */
	public static Test suite(){
		return new JUnit4TestAdapter(TestStorage.class);
	}
	
	/**
	 * Test DataConnection.addExercise() method
	 *
	 */
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
	
	/**
	 * Test DataConnection.getExercise() method
	 *
	 */
	@org.junit.Test
	public void testGet(){
		conn.connect();
		for (int i=0; i<500; i++)
			Assert.assertEquals(buffer[i].equals(conn.getExercise("exercise "+ i)),true);
		conn.close();
	}
	
	/**
	 * Test DataConnection.getThemes() method
	 *
	 */
	@org.junit.Test
	public void testGetThemes(){
		conn.connect();
		Assert.assertEquals(((conn.getThemes()).equals(setToList(themes))),true);
		conn.close();
	}

	/**
	 * Test DataConnection.getTheme() method
	 *
	 */
	@org.junit.Test
	public void testGetTheme(){
		conn.connect();
		List<String> themes = conn.getThemes();
		for (int i=0;i<themes.size();i++){
			String theme = themes.get(i);
	    	for (int j=0; j<buffer.length; j++){
	    		if ((buffer[j].getTheme()).equals(theme)){
	    			List<Exercise> tmp = conn.getTheme(theme);
	    			List<String> id = new ArrayList<String>();
	    			for (Exercise ex : tmp)
	    				id.add(ex.toString());
	    			Assert.assertEquals((id).contains(buffer[j].toString()), true);
	    		}
	    	}
		}
		conn.close();		
	}
	
	/**
	 * Test DataConnection.getExerciseTypes() method
	 * Be sure to manually add the Exercise types to be checked
	 */
	@org.junit.Test
	public void testGetExerciseTypes(){
		conn.connect();
		Assert.assertEquals("MultichoiceExercise", (conn.getExerciseTypes()).get(0));
		conn.close();
	}
	
	/**
	 * Test DataConnection.getExerciseType() method
	 * Be sure to manually add the Exercise types to be checked
	 */
	@org.junit.Test
	public void testGetExerciseType(){
		conn.connect();
		MultichoiceExercise dum = new MultichoiceExercise();
		for(int i=0; i<buffer.length; i++){
			if((dum.getClass()).equals(buffer[i].getClass())){
				List<Exercise> tmp = conn.getExerciseType(dum);
    			List<String> id = new ArrayList<String>();
    			for (Exercise ex : tmp)
    				id.add(ex.toString());
				Assert.assertEquals((id).contains(buffer[i].toString()), true);
			}
		}
		conn.close();
	}
	
	/**
	 * Test DataConnection.getExerciseNames() method
	 *
	 */
	@org.junit.Test
	public void testGetExerciseNames(){
		conn.connect();
    	for (int i=0; i<buffer.length; i++)
    		  	Assert.assertEquals((conn.getExerciseNames()).contains(buffer[i].getTitle()), true);
		conn.close();
	}
	
	/**
	 * Test DataConnection.getAllExercises() method
	 *
	 */
	@org.junit.Test
	public void testGetAllExercises(){
		conn.connect();
		
		for(int i=0; i<buffer.length; i++){
				List<Exercise> tmp = conn.getAllExercises();
    			List<String> id = new ArrayList<String>();
    			for (Exercise ex : tmp)
    				id.add(ex.toString());
				Assert.assertEquals((id).contains(buffer[i].toString()), true);
		}
		conn.close();
	}
	
	/**
	 * Test DataConnection.deleteExercise() method
	 *
	 */
	@org.junit.Test
	public void testRemove(){
		conn.connect();
		for(int i=0;i<5000;i++)
			conn.deleteExercise("exercise "+i);
		conn.close();
	}
	
	/**
     * Converts a set to a list
     * @param set
     * @return list
     */
    private List<String> setToList(Set<String> set) {
    	List<String> out = new ArrayList<String>();
    	Iterator iter = set.iterator();
    	while (iter.hasNext())
    		out.add((String) iter.next());
    	return out;    		
    }
    
    @SuppressWarnings({"unused","unchecked"})
	private Set listToSet(List list) {
    	Set out = new HashSet();
    	Iterator iter = list.iterator();
    	while (iter.hasNext())
    		out.add(iter.next());
    	return out;
    }
}
