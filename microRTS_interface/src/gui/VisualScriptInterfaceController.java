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
    private Slider sldQuantWorkers;
    
    
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
    	
    	if(txtAI1_00.getText() != null)
    		Context.getInstance().addScriptAI1(Integer.parseInt(txtAI1_00.getText()));
    	if(txtAI1_10.getText() != null)
    		Context.getInstance().addScriptAI1(Integer.parseInt(txtAI1_10.getText()));
    	if(txtAI1_01.getText() != null)
    		Context.getInstance().addScriptAI1(Integer.parseInt(txtAI1_01.getText()));
    	if(txtAI1_11.getText() != null)
    		Context.getInstance().addScriptAI1(Integer.parseInt(txtAI1_11.getText()));
    	if(txtAI1_02.getText() != null)
    		Context.getInstance().addScriptAI1(Integer.parseInt(txtAI1_02.getText()));
    	if(txtAI1_12.getText() != null)
    		Context.getInstance().addScriptAI1(Integer.parseInt(txtAI1_12.getText()));

    	if(txtAI1_00.getText() != null)
    		Context.getInstance().addScriptAI2(Integer.parseInt(txtAI2_00.getText()));
    	if(txtAI1_10.getText() != null)
    		Context.getInstance().addScriptAI2(Integer.parseInt(txtAI2_10.getText()));
    	if(txtAI1_01.getText() != null)
    		Context.getInstance().addScriptAI2(Integer.parseInt(txtAI2_01.getText()));
    	if(txtAI1_11.getText() != null)
    		Context.getInstance().addScriptAI2(Integer.parseInt(txtAI2_11.getText()));
    	if(txtAI1_02.getText() != null)
    		Context.getInstance().addScriptAI2(Integer.parseInt(txtAI2_02.getText()));
    	if(txtAI1_12.getText() != null)
    		Context.getInstance().addScriptAI2(Integer.parseInt(txtAI2_12.getText()));
    	
    	System.out.println("Quantidade de workers:");
    	System.out.println(String.valueOf((int)sldQuantWorkers.getValue()));
    	
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
		loadScripts();
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
		String ai6 = "A3N";
        
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
	
	public void loadScripts() {
		scripts.add(new IdScripts("1 workers", 13));
		scripts.add(new IdScripts("2 workers", 14));
		scripts.add(new IdScripts("3 workers", 15));
		scripts.add(new IdScripts("4 workers", 16));
		scripts.add(new IdScripts("5 workers", 17));
		scripts.add(new IdScripts("6 workers", 18));
		scripts.add(new IdScripts("7 workers", 19));
	}
	
	
	

}
