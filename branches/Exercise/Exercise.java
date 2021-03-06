
package Exercise;
import java.util.List;

/**
 * Abstract class that defines the main funtions of an exercise object.
 */
public abstract class Exercise {

	/**
	 * Theme
	 */
    private String theme;

    /**
     * Question
     */
    private String question;

    /**
     * Title
     */
    private String title;

    /**
     * Panel with controls to add a new exercise
     */
    protected transient AddPanel addPanel;
    
    /**
     * Panel with controls to solve an existing exercise
     */
    protected transient SolvePanel solvePanel;
    
    /**
     * Constructor
     * @param title title of exercise
     * @param theme theme of exercise
     * @param question question to be answered
     */
    public Exercise(String title, String theme, String question) {
    	this.title = title;
    	this.theme = theme;
    	this.question = question;
    }

    /**
     * Empty constructor for enhance method of database
     */
    public Exercise() {}
    
    /**
     * Abstract method to initialize the solve and add panel.
     */
    public abstract void init();

    /**
     * Tests if the given answer is true and calls the right tests.
     * @return List of strings containing intelligent feedback 
     * @throws NullPointerException when there is no solvepanel
     */
    public abstract List<String> validate();
    
    /**
     * Returns the theme of the exercise
     * @return theme of exercise
     */
    public String getTheme() {
    	return theme;
    }

    /**
     * Returns the title of the exercise
     * @return title of exercise
     */
    public String getTitle() {
        return title;
    } 

    /**
     * Returns the question of the exercise.
     * @return question to be answered
     */
    public String getQuestion() {
        return question;
    } 
    
    /**
     * Changes exercisetitle to given title
     * @param title new title
     */
    public void setTitle(String title) {
    	if (title != null && !title.equals(""))
    		this.title = title;
    }
    
    /**
     * Changes question to given question
     * @param question new question
     */
    public void setQuestion(String question) {
    	if (question != null && !question.equals(""))
    		this.question = question;
    }
    
    /**
     * Changes theme to given theme
     * @param theme new theme
     */
    public void setTheme(String theme) {
    	if (theme != null && !theme.equals(""))
    		this.theme = theme;
    }
    
    /**
     * Returns the panel used for adding a new exercise.
     * @return panel used for adding a new exercise
     */    
    public AddPanel getAddPanel() {
        return addPanel;
    }
    
    /**
     * Returns the panel used for solving an existing exercise.
     * @return panel used for solving an existing exercise
     */
    public SolvePanel getSolvePanel() {
    	return solvePanel;
    }
    
    /**
     * Creates a panel used for solving an existing exercise.
     * @return panel used for solving an existing exercise
     */
    public abstract SolvePanel createSolvePanel();

    /**
     * Returns a string representation of this Exercise
     * @return string representation of this Exercise
     */
    public String toString() {
	  return title + "\t" + theme;
    }
   
    /**
     * Call this to make sure this instant is consistant with inputted info.
     * @throws NullPointerException when there is no AddPanel
     */
    public abstract void writeInput();
    
    /**
     * Returns whether this Exercise is equal to the given Exercise.
     * @param ex Given Exercise to check against
     * @return true if both Exercises are equal
     */
    public boolean equals(Exercise ex) {
    	return (this.question.equalsIgnoreCase(ex.question)
    			&& this.title.equalsIgnoreCase(ex.title)
    			&& this.theme.equalsIgnoreCase(ex.theme)
    			&& (this.getClass() == ex.getClass()));
    }    
 }
