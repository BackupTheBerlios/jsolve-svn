package ExerciseManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Exercise.Exercise;

/**
 * Manages the sequence of exercises to be solved.
 * The functionality of this class in the demo is minimal, since there aren't any sequences. * 
 */
public class ExerciseManagement {

	/**
	 * A list with all loaded exercices.
	 */
    private List<Exercise> list;

    /**
     * The index of the currently active exercise from the list.
     */
    private int index;
    
    /**
     * Constructor
     */
    public ExerciseManagement() {
        list = new ArrayList<Exercise>();
        index = 0;
    }

    /**
     * Returns the number of active exercises at this moment. This is a dummyfunction.
     * @return number of active exercises at this moment 
     */
    public int getActiveExerciseCount() {        
        
        return 0;
    } 

    /**
     * Returns the active exercise
     * @return the active exercise
     */
    public Exercise getActiveExercise() {        
        if(list.size() == 0)
        	return null;
        else
        	return list.get(index);
    } 

    /**
     * Adds a new exercise to the list
     * @param ex new exercise
     */
    public void addExercise(Exercise ex) { 
        list.add(ex);
    } 
    
    /**
     * Changes the active exercise.
     * @param index index of new exercise
     */
    public void setIndex(int index) {
    	this.index = index;
    }

    /**
     * Returns the sequence of exercises which are currently active
     * @return list of exercises
     */
    public List<Exercise> getList() {
        return list;
    } 
    
    /**
     * Returns the index of the currently active exercise
     * @return index
     */
    public int getIndex() {
    	return index;
    }

    /**
     * Sets a new sequence of exercises to solve.
     * @param list new list of exercises
     */
    public void setList(List<Exercise> list) {        
        this.list = list;
    } 
    
    /**
     * Returns the size of the list.
     * @return size of the list
     */
    public int getListSize() {
    	return list.size();
    }

    /**
     * Saves the list of exercises.
     * Dummymethod
     */
    public Map<String,List<Integer>> saveList(List<Exercise> list) {        
        
        return null;
    } 
    
    /**
     * Clears the list of active exercises.
     */
    public void clearList() {
    	list.clear();
    	index = 0;
    }

    /**
     * Loads the list of exercises
     * Dummymethod
     */
    public List<Exercise> loadList(Map<String,List<Integer>> list) {        
        
        return null;
    } 

    /**
     * Validates the current exercise.
     * @return list of strings containing intelligent feedback
     */
    public List<String> validateExercise() {        
        List<String> comments = list.get(index).validate();
        return comments;
    } 
 }
