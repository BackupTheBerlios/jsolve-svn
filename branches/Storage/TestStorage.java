package Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

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
	
	@org.junit.Test
	public void testGet(){
		conn.connect();
		for (int i=0; i<500; i++)
			Assert.assertEquals(buffer[i].equals(conn.getExercise("exercise "+ i)),true);
		conn.close();
	}
	
	@org.junit.Test
	public void testGetThemes(){
		conn.connect();
		Assert.assertEquals(((conn.getThemes()).equals(setToList(themes))),true);
		conn.close();
	}
	//FIXME
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
	
	//Manually add the types to check!!
	@org.junit.Test
	public void testGetExerciseTypes(){
		conn.connect();
		Assert.assertEquals("MultichoiceExercise", (conn.getExerciseTypes()).get(0));
		conn.close();
	}
	
	
	//FIXME
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
	
	@org.junit.Test
	public void testGetExerciseNames(){
		conn.connect();
		
		List<String> tmp = new ArrayList<String>();
    	for (int i=0; i<buffer.length; i++)
    		tmp.add(buffer[i].getTitle());
    	
		Assert.assertEquals(tmp, conn.getExerciseNames());
		conn.close();
	}
	
	//FIXME: equals methods of exercise types
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
