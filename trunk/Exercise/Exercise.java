
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
    
/**
 * constructor
 */
    public Exercise(String title, String theme, String question) {
    	this.title = title;
    	this.theme = theme;
    	this.question = question;
    }

/**
 * <p>Draws the answer panel of the exercice, wich depends on the type of exercise</p>
 */
    public abstract void draw(JPanel panel);

/**
 * <p>Tests if the given answer is true and calls the right tests.</p> 
 */
    public abstract List<String> validate(String answer);
    
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
 }
