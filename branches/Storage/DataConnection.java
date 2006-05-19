package Storage;

/**
 * @author Birger Anckaert
 *
 * Layer for dataretrieval from datastorage
 */

import Exercise.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.jdo.JDOException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.objectdb.Utilities;

public class DataConnection {
	
	//Datafile for storage
	private final static String URL = "./Storage/data.odb";
	private PersistenceManager pm;
	
	/**
	 * Initialize all used classes for database usage
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
	 * Closes a database connection and ends active transactions
	 */
	public void close(){
        if (pm.currentTransaction().isActive())
            pm.currentTransaction().rollback();
        if (!pm.isClosed())
            pm.close();
	}
	
	/**
	 * Add an exercise to the database
	 * @param exercise to be added
	 * @return boolean representing the succes of the action
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
	 * Retrieve an exercise from the database
	 * @param name of the exercise to be retrieved
	 * @return exercise with the given name
	 */
	public Exercise getExercise(String name){
		return (Exercise)(pm.getObjectById(name, false));		
	}
	
	/**
	 * Removes an exercise from the database
	 * @param name of the exercise to be deleted
	 * @return boolean  representing the succes of the action
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
	 * Add an exercise sequence to the database
	 * @param exercises contained in the list
	 * @param seqID unique id of the sequence object
	 */
	public void saveList(List<Exercise> exercises,int seqID) {        
        pm.currentTransaction().begin();
		pm.makePersistent(exercises);
		Utilities.bind(pm,exercises,"seq"+seqID);
		pm.currentTransaction().commit();
	}

	/**
	 * Retrieve an exercise sequence from the database
	 * @param seqID unique id of the sequence object
	 * @return List of the exercises under that id
	 */
	@SuppressWarnings("unchecked")
	public List<Exercise> loadList(int seqID) {
		return (List<Exercise>)(pm.getObjectById("seq"+seqID, false));
	}

	/**
	 * Lists all themes of exercises in the database
	 * @return List of themestrings
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
	 * @param theme The wanted theme
	 * @return List of exercises corresponding to that theme
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
	
	/**
	 * List all exercise types
	 * @return List of exercisetypes
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
     * List all exercises of one specific type
     * @param obj Dummy object of the wanted type
     * @return List of all exercises of a corresponding class
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
	 * Returns all names of the exercises in the database
	 * @return List of all exercisenames 
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
	 * Returns all exercises in the database
	 * @return List of all exercises in the database
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
	
	/*
	 * Extra functionality
	 */
	
	/**
	 * Performce a query on exercises in the database
	 * @param search Query on the exercises
	 * @return Collection of all corresponding exercises
	 */
	public Collection exerciseQuery(String search){
		Query query = pm.newQuery(Exercise.class, search);
        Collection results = (Collection)query.execute();
        return results;		
	}
	
	/**
	 * Print a Collection object to console
	 * @param title Title of the Collection
	 * @param iter Iterator on the Collection
	 */
    @SuppressWarnings("unused")
	private void printCollection(String title, Iterator iter) {
        System.out.println(title);
        while (iter.hasNext())
            System.out.println("  " + iter.next());
    }
    
    /**
     * Converts a set to list
     * @param set Set to be converted
     * @return List of converted Set
     */
    private List<String> setToList(Set<String> set) {
    	List<String> out = new ArrayList<String>();
    	Iterator iter = set.iterator();
    	while (iter.hasNext())
    		out.add((String) iter.next());
    	return out;    		
    }
}
