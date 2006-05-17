
package ExerciseManagement;
import java.util.List;
import java.util.Map;

import Exercise.Exercise;
import java.util.ArrayList;

/**
 * <p>Manages the sequence of exercises to be solved.
 * The functionality of this class in the demo is minimal, since there aren't any sequences.</p>
 * 
 * 
 */
public class ExerciseManagement {

/**
 * <p>A list with all loaded exercices.</p>
 */
    private List<Exercise> lijst;

/**
 * <p>The index of the currently active exercise from the list.</p>
 * 
 */
    private int index;
    
    
    public ExerciseManagement() {
        lijst = new ArrayList<Exercise>();
    }

/**
 * Dummy
 */
    public int getActiveExerciseCount() {        
        
        return 0;
    } 

/**
 * <p>Returns the active exercise</p>
 */
    public Exercise getActiveExercise() {        
        if(lijst.size() == 0)
        	return null;
        else
        	return lijst.get(0);
    } 

/**
 * <p>Adds a new exercise to the list</p>
 */
    public void addExercise(Exercise ex) {        
        lijst.add(ex);
    } 
    
/**
 * <p>Changes the active exercise.</p>
 */
    public void setActiveExercise(int index) {
    	this.index = index;
    }

/**
 * <p>Returns the sequence of exercises</p>
 */
    public List<Exercise> getList() {
        return lijst;
    } 

/**
 * <p>Sets a new sequence of exercises to solve.</p>
 */
    public void setList(List<Exercise> lijst) {        
        this.lijst = lijst;
    } 
    
 /**
  * <p>Returns the size of the list.</p>
  */
    public int getListSize() {
    	return lijst.size();
    }

/**
 * <p>Dummy</p>
 */
    public Map<String,List<Integer>> saveList(List<Exercise> lijst) {        
        
        return null;
    } 

/**
 * Dummy
 */
    public List<Exercise> loadList(Map<String,List<Integer>> lijst) {        
        
        return null;
    } 

/**
 * Validates the current exercice.
 */
    public List<String> validateExercise() {        
        List<String> comments = lijst.get(index).validate();
        return comments;
    } 
 }
