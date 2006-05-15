/*
 * GUImodel.java
 *
 * Created on 12 mei 2006, 14:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package GUI;

import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import Storage.*;
import ExerciseManagement.*;
import Exercise.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author Kurt Deklerck
 */
public class GUImodel {
    
    private boolean teacherMode;
    private InlogDialog iDialog;
    private SelectDialog sDialog;
    private List<Exercise> selectOefnList;
    private List<String> typeNamesList;
    private DataConnection connection;
    private Exercise shownExercise;
    private ExerciseManagement exManagement;
//    private ExercisePanel shownExercisePanel;
    private NewExercisePanel newExPanel;
    
    
    
    public GUImodel() {
        connection = new DataConnection();
        typeNamesList = new ArrayList<String>();
        selectOefnList = new ArrayList<Exercise>();
    }
    
    
    /**
     * instellen of we in leraarmode zijn of niet
     */
    public void setTeacherMode(boolean teacher){
        teacherMode = teacher;
        fireStateChanged();
    }
    
    /**
     * ophalen van TeacherMode status
     */
    public boolean getTeacherMode(){
        return teacherMode;
    }
    
    /**
     * weergeven van de inlogDialog
     */
    public void showInlogDialog(java.awt.Frame parent){
        iDialog = new InlogDialog(parent, true);
        if (iDialog.showInlogDialog()){
            setTeacherMode(true);  
        }else 
            setTeacherMode(false);
    }
    
    /**
     * opnieuw inloggen
     */
    public void opnieuwInloggen(java.awt.event.ActionEvent evt) {                                 
        if (iDialog.showInlogDialog()){
            setTeacherMode(true);  
        }else 
            setTeacherMode(false);
    } 
    
    /**
     * weergeven van de selectDialog
     */  
    public void showSelectDialog(java.awt.Frame parent){
        
        connection.connect();
        selectOefnList = connection.getAllExercises();
        //selectNamesList = connection.getExerciseNames();
        connection.close();
        
        
        sDialog = new SelectDialog(parent, true, selectOefnList, this);
        sDialog.setVisible(true);
            
    }
    
    
    public void addExercise(Exercise ex){
        exManagement.setActiveExercise(ex);
        
    }
    
    public void setShownExercise(Exercise ex){
        shownExercise = ex;
        fireStateChanged();
    }
    
    public Exercise getShownExercise(){
        return shownExercise;
    }
    
    
    
    /**
     *  geeft namen van alle oefening types terug
     */
    public List<String> getOefnTypes(){
        /**
         * haalt lijst op van bestaande types
         */
        
//        DataConnection dCon = new DataConnection();
//        dCon.connect();
//        typeNamesList = dCon.getExerciseTypes();
//        dCon.close();
        
        /**
         * nu hardcoded
         */
        typeNamesList.add("Multiplechoise");
        return typeNamesList;
    }
    
    
    /**
     * nieuwe oefening maken
     */
    public NewExercisePanel createNewExercisePanel(ActionEvent e){
           /**
            *   deels code indien het niet hardcoded zou zijn
            */
        
//           String command = e.getActionCommand();
//            // TODO kijken welk dummie type er geopend moet worden
//            for(int i =0; i< typeNamesList.size(); i++){
//                if (command.equals(typeNamesList.get(i)))
//                    ;
//            }
            /**
             *  Hardcoded
             */
             //javax.swing.JPanel testPanel = new javax.swing.JPanel();
             newExPanel = new NewExercisePanel();
             return newExPanel;
             
    }
    
   
    
//    public void setNewExercisePanel(ExercisePanel ePanel){
//        if(ePanel != shownExercisePanel){
//            shownExercisePanel = ePanel;
//            fireStateChanged();
//        }
//    }
//    
//    public ExercisePanel getShownExercisepanel(){
//        return shownExercisePanel;
//    }
    
    
    
    protected EventListenerList listenerList= new EventListenerList();
    
    public void addChangeListener (ChangeListener l){
        listenerList.add (ChangeListener.class, l);
    }
    
    public void removeChangeListener (ChangeListener l){
        listenerList.remove(ChangeListener.class, l);
    }
    
    protected final ChangeEvent changeEvent = new ChangeEvent(this);
    
    protected void fireStateChanged(){
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length-2; i>=0; i-=2){
            if ( listeners[i] == ChangeListener.class){
                ((ChangeListener)listeners[i+1]).stateChanged (changeEvent);
            }
        }
    }
    
}
