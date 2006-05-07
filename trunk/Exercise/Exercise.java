
package Exercise;
import javax.swing.JPanel;

import ExerciseManagement.*;

/**
 * 
 * 
 */
public abstract class Exercise {

/**
 * <p>Represents ...</p>
 * 
 */
    private String theme;

/**
 * <p>Represents ...</p>
 * 
 */
    private String question;

/**
 * <p>Represents ...</p>
 * 
 */
    private String title;

/**
 * <p>Does ...</p>
 * 
 * 
 * @param panel 
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
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public String getTitle() {
        return title;
    } 

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public String getQuestion() {
        return question;
    } 
 }
