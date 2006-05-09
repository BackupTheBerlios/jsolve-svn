
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
 * <p>Represents ...</p>
 * 
 */
    private List<Exercise> lijst;

/**
 * <p>Represents ...</p>
 * 
 */
    private int index;
    
    
    public ExerciseManagement() {}

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public int getActiveExerciseCount() {        
        // your code here
        return 0;
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public Exercise getActiveExercise() {        
        if(lijst.size() == 0)
        	return null;
        else
        	return lijst.get(0);
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @param ex 
 */
    public void setActiveExercise(Exercise ex) {        
        lijst.add(ex);
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public List<Exercise> getList() {        
        // your code here
        return null;
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @param lijst 
 */
    public void setList(List<Exercise> lijst) {        
        // your code here
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @param lijst 
 * @return 
 */
    public Map<String,List<Integer>> saveList(List<Exercise> lijst) {        
        // your code here
        return null;
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @param lijst 
 * @return 
 */
    public List<Exercise> loadList(Map<String,List<Integer>> lijst) {        
        // your code here
        return null;
    } 

/**
 * <p>Does ...</p>
 * 
 */
    public void validateExercise() {        
        // your code here
    } 
 }
