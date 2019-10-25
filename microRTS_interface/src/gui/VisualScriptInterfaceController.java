package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import ai.ScriptsGenerator.GPCompiler.ICompiler;
import ai.ScriptsGenerator.GPCompiler.MainGPCompiler;
import gui.custom.NumberTextField;
import model.Context;
import model.MapPath;
import rts.units.UnitTypeTable;
import model.IdScripts;
public class VisualScriptInterfaceController implements Initializable {
	

    @FXML
    private HBox principal;
    
    @FXML
    private ComboBox<MapPath> cbMaps;
    private List<MapPath> maps = new ArrayList<>();
    private ObservableList<MapPath> obsMaps;
    private List<IdScripts> scripts = new ArrayList<>();
    
    ICompiler compiler = new MainGPCompiler();
    
    @FXML
    private ComboBox<String> cbAI1;
    @FXML
    private ComboBox<String> cbAI2;
    
    private List<String> ais = new ArrayList<>();
    private ObservableList<String> obsAIs;
    private List<String> targets = new ArrayList<>();
    private ObservableList<String> obsTargets;
    private List<String> directions = new ArrayList<>();
    private ObservableList<String> obsDirections;

    // Aba Workers
    @FXML
    private TextField txtQuantWorkers1;
    @FXML
    private TextField txtHarvestWorkers1;
    @FXML
    private TextField txtQuantBases1;
    @FXML
    private TextField txtQuantBarracks1;
    @FXML
    private TextField txtQuantWorkers2;
    @FXML
    private TextField txtHarvestWorkers2;
    @FXML
    private TextField txtQuantBases2;
    @FXML
    private TextField txtQuantBarracks2;
    @FXML
    private ComboBox<String> cbWorkerTarget1;
    @FXML
    private ComboBox<String> cbWorkerTarget2;
    @FXML
    private ComboBox<String> cbWorkerDir1;
    @FXML
    private ComboBox<String> cbWorkerDir2;
    @FXML
    private CheckBox cbAttackWorker1;
    @FXML
    private CheckBox cbAttackWorker2;
    @FXML
    private ComboBox<String> cbWorkerTrainDir1;
    @FXML
    private ComboBox<String> cbWorkerTrainDir2;
    
    // Aba Light
    @FXML
    private TextField txtQuantLight1;
    @FXML
    private TextField txtQuantLight2;
    @FXML
    private CheckBox cbAttackLight1;
    @FXML
    private CheckBox cbAttackLight2;
    @FXML
    private ComboBox<String> cbLightTarget1;
    @FXML
    private ComboBox<String> cbLightTarget2;
    @FXML
    private ComboBox<String> cbLightDir1;
    @FXML
    private ComboBox<String> cbLightDir2;
    @FXML
    private ComboBox<String> cbLightTrainDir1;
    @FXML
    private ComboBox<String> cbLightTrainDir2;
    
    // Aba Heavy
    @FXML
    private TextField txtQuantHeavy1;
    @FXML
    private TextField txtQuantHeavy2;
    @FXML
    private CheckBox cbAttackHeavy1;
    @FXML
    private CheckBox cbAttackHeavy2;
    @FXML
    private ComboBox<String> cbHeavyTarget1;
    @FXML
    private ComboBox<String> cbHeavyTarget2;
    @FXML
    private ComboBox<String> cbHeavyDir1;
    @FXML
    private ComboBox<String> cbHeavyDir2;
    @FXML
    private ComboBox<String> cbHeavyTrainDir1;
    @FXML
    private ComboBox<String> cbHeavyTrainDir2;
    
    // Aba Ranged
    @FXML
    private TextField txtQuantRanged1;
    @FXML
    private TextField txtQuantRanged2;
    @FXML
    private CheckBox cbAttackRanged1;
    @FXML
    private CheckBox cbAttackRanged2;
    @FXML
    private ComboBox<String> cbRangedTarget1;
    @FXML
    private ComboBox<String> cbRangedTarget2;
    @FXML
    private ComboBox<String> cbRangedDir1;
    @FXML
    private ComboBox<String> cbRangedDir2;
    @FXML
    private ComboBox<String> cbRangedTrainDir1;
    @FXML
    private ComboBox<String> cbRangedTrainDir2;
    
    
    
    @FXML
    void clickBtnPause(ActionEvent event) {
    	//System.out.println("pause");
    	Context.getInstance().setPause(true);
    }
 
    @FXML
    void clickBtnPlay(ActionEvent event) {
    	Context.getInstance().setPause(false);
    	Context.getInstance().setPlay(true);
    }

    @FXML
    void clickBtnRestart(ActionEvent event) {
    	Context.getInstance().setPause(true);
    	Context.getInstance().setRestart(true);
    	//System.out.println("restart");
    }
    
    @FXML
    void clickApply(ActionEvent event) {
    	Context.getInstance().setApply(true);
    	
    	Context.getInstance().setMap(cbMaps.getValue());
    	Context.getInstance().setAI1(cbAI1.getValue());
    	Context.getInstance().setAI2(cbAI2.getValue());
    	
    	Context.getInstance().clearScriptsAI1();
    	Context.getInstance().clearScriptsAI2();
    	
    	// ----- Aba Workers ------
    	// --- IA 1 ---
    	
    	if( txtQuantWorkers1.getText() != null && Integer.parseInt(txtQuantWorkers1.getText()) != 0 ) {				//cria workers
    		int q = Integer.parseInt(txtQuantWorkers1.getText());
    		String i = "train(Worker," + Integer.toString(q) + "," + cbWorkerTrainDir1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    
    	if( txtQuantBases1.getText() != null && Integer.parseInt(txtQuantBases1.getText()) != 0 ) {					//constroi bases
    		int q = Integer.parseInt(txtQuantBases1.getText());
    		String i = "build(Base," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	if( txtQuantBarracks1.getText() != null && Integer.parseInt(txtQuantBarracks1.getText()) != 0 ) {			//constroi barracks
    		int q = Integer.parseInt(txtQuantBarracks1.getText());
    		String i = "build(Barrack," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	if( txtHarvestWorkers1.getText() != null && Integer.parseInt(txtHarvestWorkers1.getText()) != 0 ) {			//workers coletando
    		int q = Integer.parseInt(txtHarvestWorkers1.getText());
    		String i = "harvest(" + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI1(i);
    	}

    	if( cbAttackWorker1.isSelected()) { 																		//ataque de workers
    		String i = "attack(Worker," + cbWorkerTarget1.getValue() + "," + cbWorkerDir1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}

    	
    	// --- IA 2 ---
    	
    	if( txtQuantWorkers2.getText() != null && Integer.parseInt(txtQuantWorkers2.getText()) != 0 ) {				//cria workers
    		int q = Integer.parseInt(txtQuantWorkers2.getText());
    		String i = "train(Worker," + Integer.toString(q) + "," + cbWorkerTrainDir2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtQuantBases2.getText() != null && Integer.parseInt(txtQuantBases2.getText()) != 0 ) {					//constroi bases
    		int q = Integer.parseInt(txtQuantBases2.getText());
    		String i = "build(Base," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtQuantBarracks2.getText() != null && Integer.parseInt(txtQuantBarracks2.getText()) != 0 ) {			//constroi barracks
    		int q = Integer.parseInt(txtQuantBarracks2.getText());	
    		String i = "build(Barrack," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtHarvestWorkers2.getText() != null && Integer.parseInt(txtHarvestWorkers2.getText()) != 0 ) {			//workers coletando
    		int q = Integer.parseInt(txtHarvestWorkers2.getText());
    		String i = "harvest(" + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI2(i);
    	}

    	if( cbAttackWorker2.isSelected() ) {																		//ataque de workers
    		String i = "attack(Worker," + cbWorkerTarget2.getValue() + "," + cbWorkerDir2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}

    	// ----- Aba Light ------
    	// --- IA 1 ---
    
    	if( txtQuantLight1.getText() != null && Integer.parseInt(txtQuantLight1.getText()) != 0 ) {					//cria light units
    		int q = Integer.parseInt(txtQuantLight1.getText());
    		String i = "train(Light," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
   	
    	if( cbAttackLight1.isSelected() ) {																			//ataque de light units	
    		String i = "attack(Light," + cbLightTarget1.getValue() + "," + cbLightDir1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
  	
    	// --- IA 2 ---
    	
    	if( txtQuantLight2.getText() != null && Integer.parseInt(txtQuantLight2.getText()) != 0 ) {					//cria light units
    		int q = Integer.parseInt(txtQuantLight2.getText());
    		String i = "train(Light," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
   	
    	if( cbAttackLight2.isSelected() ) {																			//ataque de light units
    		String i = "attack(Light," + cbLightTarget2.getValue() + "," + cbLightDir2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}   	
    	
    	// ----- Aba Heavy ------
    	// --- IA 1 ---
    	
    	if( txtQuantHeavy1.getText() != null && Integer.parseInt(txtQuantHeavy1.getText()) != 0 ) {					//cria heavy units
    		int q = Integer.parseInt(txtQuantHeavy1.getText());
    		String i = "train(Heavy," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
   	
    	if( cbAttackHeavy1.isSelected() ) {																			//ataque de heavy units	
    		String i = "attack(Heavy," + cbHeavyTarget1.getValue() + "," + cbHeavyDir1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
  	
    	// --- IA 2 ---
    	
    	if( txtQuantHeavy2.getText() != null && Integer.parseInt(txtQuantHeavy2.getText()) != 0 ) {					//cria heavy units
    		int q = Integer.parseInt(txtQuantHeavy2.getText());
    		String i = "train(Heavy," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
   	
    	if( cbAttackHeavy2.isSelected() ) {																			//ataque de heavy units
    		String i = "attack(Heavy," + cbHeavyTarget2.getValue() + "," + cbHeavyDir2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	// ----- Aba Ranged ------
    	// --- IA 1 ---
    	
    	if( txtQuantRanged1.getText() != null && Integer.parseInt(txtQuantRanged1.getText()) != 0 ) {				//cria ranged units
    		int q = Integer.parseInt(txtQuantRanged1.getText());
    		String i = "train(Ranged," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
   	
    	if( cbAttackRanged1.isSelected() ) {																		//ataque de ranged units	
    		String i = "attack(Ranged," + cbRangedTarget1.getValue() + "," + cbRangedDir1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
  		
    	// --- IA 2 ---
    	
    	if( txtQuantRanged2.getText() != null && Integer.parseInt(txtQuantRanged2.getText()) != 0 ) {				//cria ranged units
    		int q = Integer.parseInt(txtQuantRanged2.getText());
    		String i = "train(Ranged," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
   	
    	if( cbAttackRanged2.isSelected() ) {																		//ataque de ranged units
    		String i = "attack(Ranged," + cbRangedTarget2.getValue() + "," + cbRangedDir2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	
    	//impressão dos Scripts
    	System.out.println("\nScripts AI1:");
    	for(int i = 0; i < (Context.getInstance().getScritpsAi1()).size(); i++ ) {
    		System.out.println((Context.getInstance().getScritpsAi1()).get(i));
    	}
    	
    	System.out.println("\nScripts AI2:");
    	for(int i = 0; i < (Context.getInstance().getScritpsAi2()).size(); i++ ) {
    		System.out.println((Context.getInstance().getScritpsAi2()).get(i));
    	}
    	System.out.println();


    }

    
    // Inicialização da interface
	public void initialize(URL location, ResourceBundle resources) {
		loadMaps();
		loadAIs();
		loadTargets();
		loadDirections();
	}
	
	public void loadMaps() {
		MapPath map1 = new MapPath("16x16 - Bases Workers","maps/16x16/basesWorkers16x16.xml");
        MapPath map2 = new MapPath("16x16 - Bases With Walls","maps/16x16/BasesWithWalls16x16.xml");     
        MapPath map4 = new MapPath("24x24 - Bases Workers A","maps/24x24/basesWorkers24x24A.xml");
        MapPath map5 = new MapPath("16x16 - 2 Bases Barracks","maps/16x16/TwoBasesBarracks16x16.xml");
        MapPath map6 = new MapPath("32x32 - Distant Resources","maps/BWDistantResources32x32.xml");
        MapPath map7 = new MapPath("63x63 - BloodBath","maps/BroodWar/(4)BloodBath.scmB.xml");
        MapPath map8 = new MapPath("8x8 - 4 Bases Workers","maps/8x8/FourBasesWorkers8x8.xml");
        MapPath map9 = new MapPath("9x8 - Nowhere to Run","maps/NoWhereToRun9x8.xml");
        MapPath map10 = new MapPath("24x24 - Double Game","maps/DoubleGame24x24.xml");
        MapPath map11 = new MapPath("8x8 - Bases Workers Obstacle","maps/8x8/basesWorkers8x8Obstacle.xml");
        MapPath map12 = new MapPath("8x8 - Bases Workers A","maps/8x8/basesWorkers8x8A.xml");
        
        maps.add(map1);
        maps.add(map2);
        maps.add(map4);
        maps.add(map5);
        maps.add(map6);
        maps.add(map7);
        maps.add(map8);
        maps.add(map9);
        maps.add(map10);
        maps.add(map11);
        maps.add(map12);
		
		obsMaps = FXCollections.observableArrayList(maps);
		cbMaps.setItems(obsMaps);
	}
	
	public void loadAIs() {
		String ai1 = "Passive";
		String ai2 = "Worker Rush";
		String ai3 = "Light Rush";
		String ai4 = "Ranged Rush";
		String ai5 = "Heavy Rush";
		String ai6 = "Chromosome";
        
        ais.add(ai1);
        ais.add(ai2);
        ais.add(ai3);
        ais.add(ai4);
        ais.add(ai5);
        ais.add(ai6);
		
		obsAIs = FXCollections.observableArrayList(ais);
		cbAI1.setItems(obsAIs);
		cbAI2.setItems(obsAIs);
	}
	
	public void loadTargets() {
		String t1 = "closest";
		String t2 = "farthest";
		String t3 = "weakest";
		String t4 = "strongest";
		String t5 = "lessHealthy";
		String t6 = "mostHealthy";
		String t7 = "random";
        
		targets.add(t1);
		targets.add(t2);
		targets.add(t3);
		targets.add(t4);
		targets.add(t5);
		targets.add(t6);
		targets.add(t7);
		
		obsTargets = FXCollections.observableArrayList(targets);
		cbWorkerTarget1.setItems(obsTargets);
		cbWorkerTarget2.setItems(obsTargets);
		cbLightTarget1.setItems(obsTargets);
		cbLightTarget2.setItems(obsTargets);
		cbHeavyTarget1.setItems(obsTargets);
		cbHeavyTarget2.setItems(obsTargets);
		cbRangedTarget1.setItems(obsTargets);
		cbRangedTarget2.setItems(obsTargets);
		
		//valores iniciais
		cbWorkerTarget1.setValue(t1);
		cbWorkerTarget2.setValue(t1);
		cbLightTarget1.setValue(t1);
		cbLightTarget2.setValue(t1);
		cbHeavyTarget1.setValue(t1);
		cbHeavyTarget2.setValue(t1);
		cbRangedTarget1.setValue(t1);
		cbRangedTarget2.setValue(t1);
		
	}
	
	public void loadDirections() {
		String d1 = "EnemyDir";
		String d2 = "Up";
		String d3 = "Down";
		String d4 = "Left";
		String d5 = "Right";
        
		directions.add(d1);
		directions.add(d2);
		directions.add(d3);
		directions.add(d4);
		directions.add(d5);
		
		obsDirections = FXCollections.observableArrayList(directions);
		cbWorkerDir1.setItems(obsDirections);
		cbWorkerDir2.setItems(obsDirections);
		cbLightDir1.setItems(obsDirections);
		cbLightDir2.setItems(obsDirections);
		cbHeavyDir1.setItems(obsDirections);
		cbHeavyDir2.setItems(obsDirections);
		cbRangedDir1.setItems(obsDirections);
		cbRangedDir2.setItems(obsDirections);
		cbWorkerTrainDir1.setItems(obsDirections);
		cbWorkerTrainDir2.setItems(obsDirections);
		cbLightTrainDir1.setItems(obsDirections);
	    cbLightTrainDir2.setItems(obsDirections);
	    cbHeavyTrainDir1.setItems(obsDirections);
	    cbHeavyTrainDir2.setItems(obsDirections);
	    cbRangedTrainDir1.setItems(obsDirections);
	    cbRangedTrainDir2.setItems(obsDirections);
		
		//valores iniciais
		cbWorkerDir1.setValue(d1);
		cbWorkerDir2.setValue(d1);
		cbLightDir1.setValue(d1);
		cbLightDir2.setValue(d1);
		cbHeavyDir1.setValue(d1);
		cbHeavyDir2.setValue(d1);
		cbRangedDir1.setValue(d1);
		cbRangedDir2.setValue(d1);
		cbWorkerTrainDir1.setValue(d1);
		cbWorkerTrainDir2.setValue(d1);
		cbLightTrainDir1.setValue(d1);
	    cbLightTrainDir2.setValue(d1);
	    cbHeavyTrainDir1.setValue(d1);
	    cbHeavyTrainDir2.setValue(d1);
	    cbRangedTrainDir1.setValue(d1);
	    cbRangedTrainDir2.setValue(d1);
	}
	
	

}
