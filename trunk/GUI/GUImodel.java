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
    private Exercise lastShowedExercise;
    private ExerciseManagement exManagement;
//    private ExercisePanel shownExercisePanel;
    private NewExercisePanel newExPanel;
    
    
    
    public GUImodel() {
        connection = new DataConnection();
        typeNamesList = new ArrayList<String>();
        selectOefnList = new ArrayList<Exercise>();
        lastShowedExercise = null;
        exManagement = new ExerciseManagement();
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++
    /**
     * bugs: -  bij sluiten reInlogDiaglog vertrekkend van teacher dan diagram sluiten resulteerd
     *          in inloggen als student
     *       -  nmonics werken niet
     */
    //++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    //////////////////////////////////////////
    //                                      //
    //          GETTERS EN SETTERS          //
    //                                      //
    //////////////////////////////////////////
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
     * geeft oefening terug die het laast getoont werd
     */
    
    public Exercise getLastShowedExercise(){
        return lastShowedExercise;
    }
    
    /**
     * slaat de huidig getoonde oefening op in veld lastShowedExercise
     */
    public void setShowedExercise(Exercise newEx){
        lastShowedExercise = newEx;
    }
    
    /**
     *  vraagt aan ExerciseManagment welke oefn focus zou moeten hebben
     */
    public Exercise getActiveExercise(){
        return exManagement.getActiveExercise();
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
    
    
    
    //////////////////////////////////////////
    //                                      //
    //    WEERGEVEN VAN DIALOOGVENSTERS     //
    //                                      //
    //////////////////////////////////////////
    
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
     * weergeven van de selectDialog
     */  
    public void showSelectDialog(java.awt.Frame parent){
        
        connection.connect();
        selectOefnList = connection.getAllExercises();
        connection.close();
        
        sDialog = new SelectDialog(parent, true, selectOefnList, this);
        sDialog.setVisible(true);       
    }
    
    /**
     * weergeven van de InfoDialog
     */     
    public void showInfoDialog(java.awt.Frame parent){
        InfoDialog iDialog = new InfoDialog(parent,false);
        iDialog.setVisible(true);
    }
    
    
    
    //////////////////////////////////////////
    //                                      //
    //          ANDERE METHODEN             //
    //                                      //
    //////////////////////////////////////////
    
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
     * Oefening toevoegen aan lijst van Active execise
     * via exerciseManagement
     */
    
    public void addExercise(Exercise ex){
        exManagement.setActiveExercise(ex);
        fireStateChanged();
        
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
             *
             * TODO genreLijst niet hardcoded? en type oefn doorgeven, zodat we weten hoe we oefn moeten opslaan
             */
//             List<String> themaLijst = new ArrayList<String>();
//             themaLijst.add("algemeen");
//             themaLijst.add("exceptions");
//             themaLijst.add("Java syntax");
//             themaLijst.add("C++ Syntax");
             List<String> testList = new ArrayList<String>();
             MultichoiceExercise dummie = new MultichoiceExercise("","","", testList,1);//(MultichoiceExercise)connection.getExercise("multidum");
             newExPanel = new NewExercisePanel(this, dummie);
             return newExPanel;
             
    }
    

    
    /**
     * Slaat de gecreëerde oefn op
     */
   
    public void saveNewExercise(String title, String thema, String vraag){
        /**
         * extra content nodig, nu hardcoded met multichoisexercise
         *
         */
        
        /**
         * tijdelijk
         */
        List<String> possibilities = new ArrayList<String>();
        int correctSolution = 1;
        
        
        MultichoiceExercise mEx = new MultichoiceExercise(title, thema, vraag , possibilities , correctSolution  );
        
        connection.connect();
        connection.addExercise(mEx);
        connection.close();
    }
    

    
    //////////////////////////////////////////
    //                                      //
    //          CHANGE EVENTHANDLING        //
    //                                      //
    //////////////////////////////////////////
    
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
