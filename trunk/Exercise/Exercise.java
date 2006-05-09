
package Exercise;
import javax.swing.JPanel;

import ExerciseManagement.*;

/**
 * 
 * 
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
 * <p>...</p>
 */
    public abstract void draw(JPanel panel);

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public abstract java.util.List validate();
    


/**
 * <p>Returns the title of the exercice.</p>
 */
    public String getTitle() {
        return title;
    } 

/**
 * <p>Returns the question of the exercice.</p>
 */
    public String getQuestion() {
        return question;
    } 
 }
