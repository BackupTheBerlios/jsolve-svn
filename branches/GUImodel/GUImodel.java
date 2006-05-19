/*
 * GUImodel.java
 *
 */

package GUImodel;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

import Exercise.Exercise;
import Exercise.MultichoiceExercise;
import ExerciseManagement.ExerciseManagement;
import GUI.ExercisePanel;
import GUI.HoofdVenster;
import GUI.InfoDialog;
import GUI.InlogDialog;
import GUI.NewExercisePanel;
import GUI.SelectDialog;
import Storage.DataConnection;


/**
 *
 * 
 */
public class GUImodel {
    
    private boolean teacherMode;
    private InlogDialog iDialog;
    private SelectDialog sDialog;
    private List<Exercise> selectOefnList;
    //private List<String> typeNamesList;
    private DataConnection connection;
    private Exercise lastShowedExercise;
    private ExerciseManagement exManagement;
    private NewExercisePanel newExPanel;
    private Boolean showExercise;
    
    
    
    public GUImodel() {
        connection = new DataConnection();
        //typeNamesList = new ArrayList<String>();
        selectOefnList = new ArrayList<Exercise>();
        lastShowedExercise = null;
        exManagement = new ExerciseManagement();
        showExercise = false;
    
    }
    
    
    
    //////////////////////////////////////////
    //                                      //
    //          GETTERS EN SETTERS          //
    //                                      //
    //////////////////////////////////////////
   
    /**
     * instellen of we in leraarmode zijn of niet
     * @param teacher zet op true om in leraarmode te gaan
     */
    public void setTeacherMode(boolean teacher){
        teacherMode = teacher;
        fireStateChanged();
    }
    
    
    /**
     * geeft weer of de navigatie knop enabled moet zijn of niet
     * @param richting "vorige" of "volgende"
     * @return true indien de navigatieknop enabled moet zijn, anders false
     */
    public boolean getButtonState(String richting){
        boolean state = true;
        if (richting.equals("vorige")){
            if(exManagement.getIndex()<1)
                state = false;
            else
                state = true;
        }
        else if(richting.equals("volgende")){
            if(exManagement.getIndex()>= exManagement.getListSize()-1)
                state = false;
            else
                state = true;
        }
        return state;
    }
    
    /**
     * boolean opvragen die zegt of er al of niet exercise moeten weergegeven worden
     * @return true indien er een exercise weergegeven moet worden
     */
    public boolean getShowExercise(){
        return showExercise;
    }
    
    /**
     *  set of we al of niet moeten oefeningen weergeven
     *  @param status moeten er oefeningen weergegeven worden of niet
     */
    public void setShowExerces(boolean status){
        showExercise = status;
    }
    
    /**
     * ophalen van TeacherMode status
     * @return true indien we in leraarmode staan
     */
    public boolean getTeacherMode(){
        return teacherMode;
    }
    
    /**
     * geeft oefening terug die het laatst getoond werd
     * @return laatst getoonde oefening
     */
    public Exercise getLastShowedExercise(){
        return lastShowedExercise;
    }
    
    /**
     * slaat de huidig getoonde oefening op in veld lastShowedExercise
     * @param newEx huidig getoonde oefening
     */
    public void setShowedExercise(Exercise newEx){
        lastShowedExercise = newEx;
    }
    
    /**
     *  vraagt aan ExerciseManagment welke oefn focus zou moeten hebben
     *  @return de oefening die focus zou moeten hebben
     */
    public Exercise getActiveExercise(){
        return exManagement.getActiveExercise();
    }
    
    
    /**  
     *  geeft namen van alle oefening types terug
     *  @return lijst van alle oefeningen types
     */
    public List<String> getOefnTypes(){       
        
        List<String> typeNamesList = new ArrayList<String>();
        
        //  indien we zouden werken met meerdere oefn, moet je die oefntypes in databank stoppen, 
        //  en er dan opvragen via dataConnection
        typeNamesList.add("multiplechoice vraag");

        return typeNamesList;
    }
    
    
    /**   
     *  geeft namen van alle oefening themas terug
     *  @return lijst van alle oefeningen themas
     */
    public List<String> getOefnThemes(){       
        
        List<String>themeNamesList = new ArrayList<String>();
        
        connection.connect();
        themeNamesList = connection.getThemes();
        connection.close();
        
        return themeNamesList;
    }
    
    
    /**
     * geeft een ExercisePanel terug gemaakt met de opgegeven oefn
     * @param ex de oefening die getoond moet worden
     * @return het paneel waar de oefening in staat
     */
    public ExercisePanel getExercisePanel(Exercise ex){
        ExercisePanel exPanel = new ExercisePanel(ex, this);
        return exPanel;
    }
    
    //////////////////////////////////////////
    //                                      //
    //    WEERGEVEN VAN DIALOOGVENSTERS     //
    //                                      //
    //////////////////////////////////////////
    
    /**
     * weergeven van de inlogDialog
     * @param parent het venster waar het dialoog aan gehecht moet worden
     */
    public void showInlogDialog(Frame parent){
        iDialog = new InlogDialog(parent, true);
        exManagement.clearList();
        int status = iDialog.showInlogDialog();
        if (status ==1){
            setTeacherMode(true); 
            parent.setVisible(true);
        }else if(status ==2){
            parent.setVisible(true);
            setTeacherMode(false);
        }else
            parent.dispose();       
    }
    
    
    /**
     * weergeven van de selectDialog, nodig om oefening te selecteren om op te lossen
     * @param venster venster waaraan het selectie dialoog gehecht hoeft te worden
     */  
    public void showSelectDialog(HoofdVenster venster){
        
        connection.connect();
        selectOefnList = connection.getAllExercises();
        List<String> types = connection.getExerciseTypes();
        List<String> themes = connection.getThemes();
        connection.close();
        
        sDialog = new SelectDialog(venster, true, selectOefnList, types, themes, this);
        sDialog.setVisible(true);       
    }
    
    
    /**
     * weergeven van de InfoDialog
     * @param parent venster waaraan het info dialoog gehecht hoef te worden
     */     
    public void showInfoDialog(Frame parent){
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
    public void opnieuwInloggen(ActionEvent evt, Frame parent) { 
        int status =iDialog.showInlogDialog();
        exManagement.clearList();
        if (status== 1)
            setTeacherMode(true);  
        else if(status == 2)
            setTeacherMode(false);
        parent.setVisible(true);
    } 
    
    
    /**
     * Slaat de gecreëerde oefn op
     */
    public void saveExercise(Exercise ex){
        
        connection.connect();
        connection.addExercise(ex);
        connection.close();
    }
    

    /**
     * Oefening toevoegen aan lijst van Active execises
     * via exerciseManagement
     */
    
    public void addExercises(List<String> oefnNamen){
        connection.connect();
        Exercise startEx = connection.getExercise(oefnNamen.get(0));
        int index = exManagement.getListSize();
        exManagement.addExercise(startEx);
        exManagement.setIndex(index);
        for(int i= 1; i< oefnNamen.size(); i ++){
            Exercise ex = connection.getExercise(oefnNamen.get(i));
            exManagement.addExercise(ex);
        }
        connection.close();
        
    }
    
    /**
     * handelingen navigatie knoppen verwerken
     */   
    public void navigate(ActionEvent e, String command){

        int newIndex=0;
        if (command.equals("vorige")){
            newIndex = exManagement.getIndex()- 1;
        }else if(command.equals("volgende")){
            newIndex = exManagement.getIndex()+ 1;
        }
        exManagement.setIndex(newIndex);
        fireStateChanged();
    }
   
    
    
    /**
     * nieuwe panel maken die dient op een nieuwe oefening te creëren
     */
    public NewExercisePanel createNewExercisePanel(ActionEvent e, HoofdVenster hoofdVenster){

             MultichoiceExercise leegEx = new MultichoiceExercise();
             List<String> themes = getOefnThemes();
             newExPanel = new NewExercisePanel(this, leegEx, hoofdVenster, themes);
             return newExPanel;      
    }
    
    
    
    /**
     *  Filteren van oefeningen
     *  er wordt meegegeven welke types en themes er geselecteerd zijn
     *  de oefeningen die voldoen, worden teruggegeven
     */
    public List<Exercise> filter(List<String> selectedTypes, List<String> selectedThemes){
        
        
        List<Exercise> exList = new ArrayList<Exercise>();
        MultichoiceExercise dum = new MultichoiceExercise();
        
        if (selectedTypes.size() != 0 && selectedThemes.size() ==0){            // enkel types Geselecteerd:
         
            connection.connect();
            for(int i = 0; i< selectedTypes.size(); i++){
            	//FIXME: hardcoded fix
                exList.addAll(connection.getExerciseType(dum));
            }
            connection.close();
        }else if(selectedTypes.size() == 0 && selectedThemes.size() !=0){       // enkel themes Geselecteerd:
            connection.connect();
            for(int i = 0; i< selectedThemes.size(); i++){
                exList.addAll(connection.getTheme(selectedThemes.get(i)));
            }
            connection.close();
        }else{                                                                  // themes en types Geselecteerd:
        	connection.connect();
            for(int i = 0; i< selectedThemes.size(); i++){
                exList.addAll(connection.getTheme(selectedThemes.get(i)));
            }
            connection.close();
            for (Exercise ex : exList){
            	if (!(ex.getClass()).equals(dum.getClass()))
            		exList.remove(ex);
            }
        }
       return exList; 
    }
    
    
    /**
     * valideren of het active antwoord juist is of niet
     */
    public List<String> validate(){
        Exercise ex = exManagement.getActiveExercise();
        List<String> valInfo = ex.validate();
        return valInfo;
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
    
    public void fireStateChanged(){
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length-2; i>=0; i-=2){
            if ( listeners[i] == ChangeListener.class){
                ((ChangeListener)listeners[i+1]).stateChanged (changeEvent);
            }
        }
    }
    
}
