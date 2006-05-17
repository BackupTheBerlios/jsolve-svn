
package Exercise;
import java.util.List;

import javax.swing.JPanel;

import ExerciseManagement.*;

/**
 * Abstract class that defines the main funtions of an exercise object.
 */
public abstract class Exercise {

    private String theme;

    private String question;

    private String title;

    protected AddPanel addPanel;
    
    /**
     * constructor
     */
    public Exercise(String title, String theme, String question) {
    	this.title = title;
    	this.theme = theme;
    	this.question = question;
    }

    /**
     * <p>Empty constructor for enchance method of database</p>
     */
    public Exercise() {}

    /**
     * <p>Tests if the given answer is true and calls the right tests.</p> 
     */
    public abstract List<String> validate();
    
    /**
     * <p>Returns the theme of the exercise.</p>
     */
    public String getTheme() {
    	return theme;
    }

    /**
     * <p>Returns the title of the exercise.</p>
     */
    public String getTitle() {
        return title;
    } 

    /**
     * <p>Returns the question of the exercise.</p>
     */
    public String getQuestion() {
        return question;
    } 
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public void setQuestion(String question) {
    	this.question = question;
    }
    
    public void setTheme(String theme) {
    	this.theme = theme;
    }
    
    /**
     * Returns the panel used for adding a new exercise.
     * @return panel used for adding a new exercise
     */    
    public AddPanel getAddPanel(){
        return addPanel;
    }

    /**
     * <p>Returns a string representation of this Object</p>
     */
    public String toString() {
	  return title + "\t" + theme;
    }
   
    /**
     * <p>Makes sure this instant is consistant with inputted info.</p>
     */
    public abstract void writeInput();
 }
