package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

import gui.custom.NumberTextField;
import model.Context;
import model.MapPath;
import model.IdScripts;
public class VisualScriptInterfaceController implements Initializable {
	

    @FXML
    private HBox principal;
    
    @FXML
    private ComboBox<MapPath> cbMaps;
    private List<MapPath> maps = new ArrayList<>();
    private ObservableList<MapPath> obsMaps;
    private List<IdScripts> scripts = new ArrayList<>();
    
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
    
    @FXML
    private TextField txtAI1_00;
    @FXML
    private TextField txtAI1_10;
    @FXML
    private TextField txtAI1_01;
    @FXML
    private TextField txtAI1_11;
    @FXML
    private TextField txtAI1_02;
    @FXML
    private TextField txtAI1_12;
    @FXML
    private TextField txtAI2_00;
    @FXML
    private TextField txtAI2_10;
    @FXML
    private TextField txtAI2_01;
    @FXML
    private TextField txtAI2_11;
    @FXML
    private TextField txtAI2_02;
    @FXML
    private TextField txtAI2_12;
    
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
    private TextField txtAttackWorkers1;
    @FXML
    private TextField txtQuantWorkers2;
    @FXML
    private TextField txtHarvestWorkers2;
    @FXML
    private TextField txtQuantBases2;
    @FXML
    private TextField txtQuantBarracks2;
    @FXML
    private TextField txtAttackWorkers2;
    @FXML
    private ComboBox<String> cbWorkerTarget1;
    @FXML
    private ComboBox<String> cbWorkerTarget2;
    @FXML
    private ComboBox<String> cbWorkerDir1;
    @FXML
    private ComboBox<String> cbWorkerDir2;
    
    // Aba Light
    @FXML
    private TextField txtQuantLight1;
    @FXML
    private TextField txtAttackLight1;
    @FXML
    private TextField txtQuantLight2;
    @FXML
    private TextField txtAttackLight2;
    @FXML
    private ComboBox<String> cbLightTarget1;
    @FXML
    private ComboBox<String> cbLightTarget2;
    @FXML
    private ComboBox<String> cbLightDir1;
    @FXML
    private ComboBox<String> cbLightDir2;
    
    // Aba Heavy
    @FXML
    private TextField txtQuantHeavy1;
    @FXML
    private TextField txtAttackHeavy1;
    @FXML
    private TextField txtQuantHeavy2;
    @FXML
    private TextField txtAttackHeavy2;
    @FXML
    private ComboBox<String> cbHeavyTarget1;
    @FXML
    private ComboBox<String> cbHeavyTarget2;
    @FXML
    private ComboBox<String> cbHeavyDir1;
    @FXML
    private ComboBox<String> cbHeavyDir2;
    
    // Aba Ranged
    @FXML
    private TextField txtQuantRanged1;
    @FXML
    private TextField txtAttackRanged1;
    @FXML
    private TextField txtQuantRanged2;
    @FXML
    private TextField txtAttackRanged2;
    @FXML
    private ComboBox<String> cbRangedTarget1;
    @FXML
    private ComboBox<String> cbRangedTarget2;
    @FXML
    private ComboBox<String> cbRangedDir1;
    @FXML
    private ComboBox<String> cbRangedDir2;
    
    
    
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
    	
    	if( txtQuantWorkers1.getText() != null && Integer.parseInt(txtQuantWorkers1.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantWorkers1.getText());
    		String i = "train(Worker," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	if( txtQuantBases1.getText() != null && Integer.parseInt(txtQuantBases1.getText()) != 0 ) {						//quantidade de bases
    		int q = Integer.parseInt(txtQuantBases1.getText());
    		String i = "build(Base," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	if( txtQuantBarracks1.getText() != null && Integer.parseInt(txtQuantBarracks1.getText()) != 0 ) {				//quantidade de barracks
    		int q = Integer.parseInt(txtQuantBarracks1.getText());
    		String i = "build(Barrack," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	if( txtAttackWorkers1.getText() != null && Integer.parseInt(txtAttackWorkers1.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers1.getText());
    		String i = "attack(Worker," + cbWorkerDir1.getValue() + "," + cbWorkerTarget1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	if( txtHarvestWorkers1.getText() != null && Integer.parseInt(txtHarvestWorkers1.getText()) != 0 ) {				//quantidade de workers coletando
    		int q = Integer.parseInt(txtHarvestWorkers1.getText());
    		String i = "harvest(" + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
    	
    	// --- IA 2 ---
    	
    	if( txtQuantWorkers2.getText() != null && Integer.parseInt(txtQuantWorkers2.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantWorkers2.getText());
    		String i = "train(Worker," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtQuantBases2.getText() != null && Integer.parseInt(txtQuantBases2.getText()) != 0 ) {						//quantidade de bases
    		int q = Integer.parseInt(txtQuantBases2.getText());
    		String i = "build(Base," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtQuantBarracks2.getText() != null && Integer.parseInt(txtQuantBarracks2.getText()) != 0 ) {				//quantidade de barracks
    		int q = Integer.parseInt(txtQuantBarracks2.getText());	
    		String i = "build(Barrack," + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtAttackWorkers2.getText() != null && Integer.parseInt(txtAttackWorkers2.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Worker," + cbWorkerDir2.getValue() + "," + cbWorkerTarget2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	if( txtHarvestWorkers2.getText() != null && Integer.parseInt(txtHarvestWorkers2.getText()) != 0 ) {				//quantidade de workers coletando
    		int q = Integer.parseInt(txtHarvestWorkers2.getText());
    		String i = "harvest(" + Integer.toString(q) + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	// ----- Aba Light ------
    	// --- IA 1 ---
    	
    	if( txtQuantLight1.getText() != null && Integer.parseInt(txtQuantLight1.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantLight1.getText());
    		String i = "train(Light," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
   	
    	if( txtAttackLight1.getText() != null && Integer.parseInt(txtAttackLight1.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Light," + cbLightDir1.getValue() + "," + cbLightTarget1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
  	
    	// --- IA 2 ---
    	
    	if( txtQuantLight2.getText() != null && Integer.parseInt(txtQuantLight2.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantLight2.getText());
    		String i = "train(Light," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
   	
    	if( txtAttackLight2.getText() != null && Integer.parseInt(txtAttackLight2.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Light," + cbLightDir2.getValue() + "," + cbLightTarget2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}   	
    	
    	// ----- Aba Heavy ------
    	// --- IA 1 ---
    	
    	if( txtQuantHeavy1.getText() != null && Integer.parseInt(txtQuantHeavy1.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantHeavy1.getText());
    		String i = "train(Heavy," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
   	
    	if( txtAttackHeavy1.getText() != null && Integer.parseInt(txtAttackHeavy1.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Heavy," + cbHeavyDir1.getValue() + "," + cbHeavyTarget1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
  	
    	// --- IA 2 ---
    	
    	if( txtQuantHeavy2.getText() != null && Integer.parseInt(txtQuantHeavy2.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantHeavy2.getText());
    		String i = "train(Heavy," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
   	
    	if( txtAttackHeavy2.getText() != null && Integer.parseInt(txtAttackHeavy2.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Heavy," + cbHeavyDir2.getValue() + "," + cbHeavyTarget2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
    	
    	// ----- Aba Ranged ------
    	// --- IA 1 ---
    	
    	if( txtQuantRanged1.getText() != null && Integer.parseInt(txtQuantRanged1.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantRanged1.getText());
    		String i = "train(Ranged," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
   	
    	if( txtAttackRanged1.getText() != null && Integer.parseInt(txtAttackRanged1.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Ranged," + cbRangedDir1.getValue() + "," + cbRangedTarget1.getValue() + ")";
    		Context.getInstance().addScriptAI1(i);
    	}
  	
    	// --- IA 2 ---
    	
    	if( txtQuantRanged2.getText() != null && Integer.parseInt(txtQuantRanged2.getText()) != 0 ) {					//quantidade de workers
    		int q = Integer.parseInt(txtQuantRanged2.getText());
    		String i = "train(Ranged," + Integer.toString(q) + "," + "EnemyDir" + ")";
    		Context.getInstance().addScriptAI2(i);
    	}
   	
    	if( txtAttackRanged2.getText() != null && Integer.parseInt(txtAttackRanged2.getText()) != 0 ) {				//quantidade de workers atacando
    		//int q = Integer.parseInt(txtAttackWorkers2.getText());	
    		String i = "attack(Ranged," + cbRangedDir2.getValue() + "," + cbRangedTarget2.getValue() + ")";
    		Context.getInstance().addScriptAI2(i);
    	}

    	//Log
    	//System.out.println("Log do Apply:");
    	//System.out.println(cbMaps.getValue());
    	//System.out.println(cbAI1.getValue());
    	//System.out.println(cbAI2.getValue());
    }

    
    
    // ------------ TESTES ------------------
    
    @FXML
    void clickedBtnWorker(ActionEvent event) {
    	Context.getInstance().setClickWorker(true);
    }
    
    @FXML
    void clickedBtnLight(ActionEvent event) {
    	Context.getInstance().setClickLight(true);
    }
    
    @FXML
    void clickedBtnHeavy(ActionEvent event) {
    	Context.getInstance().setClickHeavy(true);
    }
    
    @FXML
    void clickedBtnRanged(ActionEvent event) {
    	Context.getInstance().setClickRanged(true);
    }
    
    @FXML
    void clickedBtnBarrack(ActionEvent event) {
    	Context.getInstance().setClickBarrack(true);
    }

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
	}
	
	
	
	

}
