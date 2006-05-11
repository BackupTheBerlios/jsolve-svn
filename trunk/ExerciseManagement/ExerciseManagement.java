
package ExerciseManagement;
import java.util.List;
import java.util.Map;

import Exercise.Exercise;

/**
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
    
    
    public ExerciseManagement() {}

/**
 * Dummy
 */
    public int getActiveExerciseCount() {        
        
        return 0;
    } 

/**
 * <p>Does ...</p>
 */
    public Exercise getActiveExercise() {        
        if(lijst.size() == 0)
        	return null;
        else
        	return lijst.get(0);
    } 

/**
 * <p>Does ...</p>
 */
    public void setActiveExercise(Exercise ex) {        
        lijst.add(ex);
    } 

/**
 * <p>Does ...</p>
 */
    public List<Exercise> getList() {
        return lijst;
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @param lijst 
 */
    public void setList(List<Exercise> lijst) {        
        this.lijst = lijst;
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @param lijst 
 * @return 
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
 * Dummy
 * 
 */
    public List<String> validateExercise(String answer) {        
        List comments = lijst.get(index).validate(answer);
        return comments;
    } 
 }
