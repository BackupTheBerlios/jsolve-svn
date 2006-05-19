package Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclass of exercise specificly for multiple choise exercises.
 */
public class MultichoiceExercise extends Exercise {

	/**
	 * Intelligent feedback strings. Changes these in order to get other feedback.
	 */
	private static final String STRING_CORRECT = "Uw antwoord is juist.";
	private static final String STRING_INCORRECT = "Uw antwoord is foutief.";
	
	/**
	 * The list of possible answers.
	 */
	// Instead of a List<String> we had to use one big String, and parse it to a List<String> 
	// when that info had to leave this class. This is all due to the ObjectDB.
	private String possibilities;
		
    /**
     * Represents the index of the right answer in the list.
     */
    private int correctSolution;    
    
    // Sorry for this hacked code, but ObjectDB won't work without it.
    private transient List<String> output;
    
    /**
     * Constructor
     */
    public MultichoiceExercise(){
        super("","","");
        possibilities = new String();
        correctSolution = 0;
        init();
    }
    
    public void init() {
    	addPanel = new MultichoiceAddPanel();
    	solvePanel = new MultichoiceSolvePanel(StringToList(possibilities));
    }
    
    /**
     * Constructor
     * @param title title of the exercise
     * @param theme theme of the exercise
     * @param question question to be asked
     */
    public MultichoiceExercise(String title, String theme, String question) {
    	super(title, theme, question);
    	possibilities = new String();
    	correctSolution = 0;
    	addPanel = new MultichoiceAddPanel();
    	solvePanel = new MultichoiceSolvePanel(StringToList(possibilities));
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
    	this.possibilities = ListToString(possibilities);
    	this.correctSolution = correctSolution;
    	addPanel = new MultichoiceAddPanel();
    	solvePanel = new MultichoiceSolvePanel(possibilities);
    }
    
    /**
     * Function for converting a List of strings to one long string.
     * Format: string;string;string;string;
     * @param list List<string> to convert to one big string
     * @return oen big string (format: string;string;string;)
     */
    private String ListToString(List<String> list) {
    	String output = new String();
    	for (String el : list) {
    		output += el;
    		output += ";";
    	}
    	return output;
    }
    
    /**
     * Function for converting one long string to a List of strings
     * Given long string should have the following format: string;string;string;
     * @param string String to be converted
     * @return List of strings
     */
    private List<String> StringToList(String string) {
    	output = new ArrayList<String>();
    	String[] temp = string.split(";");
    	for (int i = 0; i < temp.length; i++) {
    		output.add(temp[i]);
    	}
    	return output;
    }
    
    /**
     * Returns the possibilities
     * @return List of possible answers
     */
    public List<String> getPossibilities(){
    	return StringToList(possibilities);
    }
    
    /**
     * Returns the correct answer
     * @return index of correct answer
     */
    public int getCorrectSolution(){
    	return correctSolution;
    }
    
    /**
     * Makes sure this instant is consistant with inputted info.
     */
    public void writeInput() {
    	if (addPanel == null)
    		throw new NullPointerException("No add panel found!");
    	
    	possibilities = ListToString(((MultichoiceAddPanel) addPanel).getPossibilities());
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
    	    output.add(STRING_CORRECT);
    	else
    		output.add(STRING_INCORRECT);
    	
        return output;
    }
    
    /**
     * Returns the panel used for solving an exercise
     * @return the panel used for solving an exercise
     */
    public SolvePanel createSolvePanel() {
    	return solvePanel;
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

