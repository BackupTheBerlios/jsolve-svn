package Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclass of exercise specificly for multiple choise exercises.
 */
public class MultichoiceExercise extends Exercise {

	/**
	 * The list of possible answers.
	 */
    private List<String> possibilities;

    /**
     * Represents the index of the right answer in the list.
     */
    private int correctSolution;    
    
    /**
     * Constructor
     */
    public MultichoiceExercise(){
        super("","","");
        possibilities = new ArrayList<String>();
        correctSolution = 0;
        addPanel = new MultichoiceAddPanel();
        solvePanel = new MultichoiceSolvePanel();
    }
    
    /**
     * Constructor
     * @param title title of the exercise
     * @param theme theme of the exercise
     * @param question question to be asked
     */
    public MultichoiceExercise(String title, String theme, String question) {
    	super(title, theme, question);
    	possibilities = new ArrayList<String>();
    	correctSolution = 0;
    	addPanel = new MultichoiceAddPanel();
    	solvePanel = new MultichoiceSolvePanel();
    }
    
    /**
     * Constructor
     * @param title title of the exercise
     * @param theme theme of the exercise
     * @param question question to be asked
     * @param possibilities list of possible answers to the question
     * @param correctSolution the n-th answer in the list of possibilities that is the correct one
     */
    public MultichoiceExercise(String title, String theme, String question, List<String> possibilities, int correctSolution) {
    	super(title,theme,question);
    	this.possibilities = possibilities;
    	this.correctSolution = correctSolution;
    	addPanel = new MultichoiceAddPanel();
    	solvePanel = new MultichoiceSolvePanel();
    }
    
    /**
     * Makes sure this instant is consistant with inputted info.
     */
    public void writeInput() {
    	if (addPanel == null)
    		throw new NullPointerException("No add panel found!");
    	
    	possibilities = ((MultichoiceAddPanel) addPanel).getPossibilities();
    	correctSolution = ((MultichoiceAddPanel) addPanel).getCorrectSolution();
    }

    /**
     * Tests if the given answer is true and calls the right tests.
     * @return List<String> list of strings with intelligent feedback
     */
    public List<String> validate() {
    	if (solvePanel == null)
    		throw new NullPointerException("No solve panel found!");
    	
    	List<String> output = new ArrayList<String>();
    	
    	if (((MultichoiceSolvePanel) solvePanel).getSelected() == correctSolution)
    	    output.add("Uw antwoord is juist.");
    	else
    		output.add("Uw antwoord is verkeerd.");
    	
        return output;
    }
    
    /**
     * Returns whether this MultichoiceExercise is equal to the given MultichoiceExercise.
     * @param ex Given MultichoiceExercise to check against
     * @return true if both MultichoiceExercises are equal
     */
    public boolean equals(MultichoiceExercise ex) {
    	if (ex == null)
    		return (this.possibilities.equals(ex.possibilities)
    				&& (this.correctSolution == ex.correctSolution)
    				&& (ex.getClass() == this.getClass()));
    	else
    		return false;
    }
}

