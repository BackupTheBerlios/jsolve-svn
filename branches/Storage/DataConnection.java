/*
 * 
 */
package Storage;
import Exercise.*;
/**
 * 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.jdo.JDOException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.objectdb.Utilities;

public class DataConnection {
	
	private final static String URL = "./Storage/data.odb";
	private PersistenceManager pm;
	
	/**
	 * Initialize all used classes
	 */
	public DataConnection(){
		//Enhance the used classes if necessary:
		com.objectdb.Enhancer.enhance("Exercise.Exercise");
        com.objectdb.Enhancer.enhance("Exercise.MultichoiceExercise");
	}
	
	/**
	 * Obtains a database connection
	 */
	public void connect(){
		try{
			Properties properties = new Properties();
			properties.setProperty("javax.jdo.PersistenceManagerFactoryClass","com.objectdb.jdo.PMF");
			properties.setProperty("javax.jdo.option.ConnectionURL", URL);
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(
        		properties, JDOHelper.class.getClassLoader());
			pm = pmf.getPersistenceManager();
		} catch(JDOException e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * Closes a database connection and end active transactions
	 */
	public void close(){
        if (pm.currentTransaction().isActive())
            pm.currentTransaction().rollback();
        if (!pm.isClosed())
            pm.close();
	}
	
	//TODO: id ophalen met de juiste exercise methode.
	/**
	 * Add an Exercise to the database
	 * 
	 * @param
	 */
	public boolean addExercise(Exercise exercise){
		try{
			pm.currentTransaction().begin();
			pm.makePersistent(exercise);
			Utilities.bind(pm,exercise,exercise.getTitle());
			pm.currentTransaction().commit();
			return true;
		}catch(Exception x){
			return false;
		}
	}
	
	/**
	 * Get an exercise from the database
	 * 
	 * @param
	 */
	public Exercise getExercise(String name){
		return (Exercise)(pm.getObjectById(name, false));		
	}
	
	/**
	 * Delete an exercise from the database
	 * 
	 * @param
	 */
	public boolean deleteExercise(String name){
		try{
			pm.currentTransaction().begin();
			Exercise ex = getExercise(name);
			pm.deletePersistent(ex); // object is marked for deletion 
			pm.currentTransaction().commit(); // object is physically deleted
			return true;
		}catch(Exception x){
			return false;
		}
	}
	
	/**
	 * Add an exercisesequence to the database
	 *
	 *
	 */
	public void saveList(List<Exercise> exercises,int seqID) {        
        pm.currentTransaction().begin();
		pm.makePersistent(exercises);
		Utilities.bind(pm,exercises,"seq"+seqID);
		pm.currentTransaction().commit();
	}

	/**
	 * Get an exercisesequence from the database
	 *
	 *
	 */
	public List<Exercise> loadList(int seqID) {
		return (List<Exercise>)(pm.getObjectById("seq"+seqID, false));
	}

	/**
	 * Returns a list of exercise themes 
	 *
	 *
	 */
	public List<String> getThemes() {
		Set<String> themes = new HashSet<String>();
		
		Query query = pm.newQuery(Exercise.class);
        Collection results = (Collection)query.execute();
        Iterator iter = results.iterator();
        while(iter.hasNext())
        	themes.add(((Exercise)iter.next()).getTheme());
        query.closeAll();

		return setToList(themes);
	}
	
	/**
     * Gets all exercises of one specific theme
     * 
     * 
     */
    public List<Exercise> getTheme(String theme) { 
    	List<Exercise> out = new ArrayList<Exercise>();
    	
    	Query query = pm.newQuery(Exercise.class, "this.theme == theme");
    	query.declareParameters("String theme");
    	Collection results = (Collection)query.execute(theme);
    	Iterator iter = results.iterator();
        while(iter.hasNext())
        	out.add((Exercise)(iter.next()));
        query.closeAll();
    	
    	return out;
    }
	
    //FIXME: zeer moeilijke methode!!!
	/**
	 * Lists the available exercise types
	 * 
	 * 
	 */
    public List<String> getExerciseTypes() {        
    	Set<String> types = new HashSet<String>();
    	
    	Query query = pm.newQuery(Exercise.class);
        Collection results = (Collection)query.execute();
        Iterator iter = results.iterator();
        while(iter.hasNext())
        	types.add(((((Exercise)(iter.next())).getClass()).toString()).substring(15));
        query.closeAll();
		return setToList(types);
    }
    
    /**
     * 
     * @return
     */
    public List<Exercise> getExerciseType(Object obj) {
    	List<Exercise> exercises = new ArrayList<Exercise>();
    	 
    	Query query = pm.newQuery(obj.getClass());
        Collection results = (Collection)query.execute();
        Iterator iter = results.iterator();
        while(iter.hasNext())
        	exercises.add((Exercise)iter.next());
        query.closeAll();
		return exercises;
    }
	
	/**
	 * Lists all exercises names
	 *
	 *
	 */
	public List<String> getExerciseNames() {
		Query query = pm.newQuery(Exercise.class);
        Collection results = (Collection)query.execute();
        List<String> names = new ArrayList<String>();
        Iterator iter = results.iterator();
        while(iter.hasNext())
        	names.add(((Exercise)(iter.next())).getTitle());
        query.closeAll();
		return names;
	}
	
	/**
	 * List all exercises
	 * 
	 * 
	 */
	public List<Exercise> getAllExercises() {
		Query query = pm.newQuery(Exercise.class);
        Collection results = (Collection)query.execute();
        List<Exercise> exercises = new ArrayList<Exercise>();
        Iterator iter = results.iterator();
        while(iter.hasNext())
        	exercises.add((Exercise)iter.next());
        query.closeAll();
		return exercises;
	}
	
    //Hulpfuncties
	
	/**
	 * Executes a query on exercises in the database
	 * 
	 * @param
	 */
	public Collection exerciseQuery(String search){
		Query query = pm.newQuery(Exercise.class, search);
        Collection results = (Collection)query.execute();
        return results;		
	}
	
	/**
     * Prints a collection content using a specified iterator.
     */
    private void printCollection(String title, Iterator iter) {
        System.out.println(title);
        while (iter.hasNext())
            System.out.println("  " + iter.next());
    }
    
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
}
