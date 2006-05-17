
package Exercise;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Subclass of exercise specificly for multiple choise exercises.
 */
public class MultichoiceExercise extends Exercise {

/**
 * <p>The list of possible answers.</p>
 * 
 */
    private List<String> possibilities;

/**
 * <p>Represents the index of the right answer in the list.</p>
 * 
 */
    private int correctSolution;
   
    /**
     * <p>Variables representing the own add/solve panel.</p>
     */
    private List<JCheckBox> chkbox;
    private List<JTextField> txtfield;
    private JTextField correctfield;
    
    
/**
 * <p>Constructor</p>
 */
    public MultichoiceExercise(String title, String theme, String question, List<String> possibilities, int correctSolution)
    {
    	super(title,theme,question);
    	this.possibilities = possibilities;
    	this.correctSolution = correctSolution;
    }
    
/**
 * Returns the list of answer possibilities.
 */
    public List<String> getPossibilities() {
    	return possibilities;
    }
    
/**
 * Returns the index of the correct solution.
 */
    public int getCorrectSolution() {
    	return correctSolution;
    }

/**
 * <p>Tests if the given answer is true and calls the right tests.</p>
 */
    public List<String> validate() {
    	List<String> output = new ArrayList<String>();
    	
    	if (chkbox.get(correctSolution).isSelected())
    	    output.add("Uw antwoord is juist.");
    	else
    		output.add("Uw antwoord is verkeerd.");
    	
        return output;
    }
    
    /**
     * <p>Draws the answer panel of the exercise</p>
 	 */
	public void drawSolvePanel(JPanel panel) {
		panel.setLayout(new GridLayout(possibilities.size(), 1));
		chkbox = new ArrayList<JCheckBox>();
		
		for (int i = 0; i < possibilities.size(); i++) {
			JCheckBox box = new JCheckBox();
			box.setText(possibilities.get(i));
			box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			box.setMargin(new Insets(0, 0, 0, 0));
			chkbox.add(box);
			panel.add(box);
		}	
		
		panel.validate();
	}
	
	/**
	 * <p>Draws the add panel of the exercise</p>
	 */
	public void drawAddPanel(JPanel panel) {		
		panel.setLayout(new GridLayout(11, 2));
		txtfield = new ArrayList<JTextField>();

		for (int i = 0; i < 10; i++) {
			JLabel label = new JLabel();
			label.setText("Antwoord "+(i+1)+":");
			JTextField field = new JTextField();
			field.setText("");
			txtfield.add(field);
			panel.add(label);
			panel.add(field);
		}
				
		JLabel label = new JLabel();
		label.setText("Nummer van correcte oplossing:");
		panel.add(label);
		JTextField correctfield = new JTextField();
		panel.add(correctfield);
				
		panel.validate();
	}
	
	/**
     * <p>Puts the input from the add form in the exercise.</p>
     */
    public void putInput() {
    	possibilities.clear();
    	
    	for (JTextField field : txtfield) {
    		if (!field.getText().equals(""))
    			possibilities.add(field.getText());
    	}
    	
    	correctSolution = Integer.parseInt(correctfield.getText());
    }
}
