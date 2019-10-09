package ai.ScriptsGenerator.Command;

//import javax.swing.JFrame;

//import gui.PhysicalGameStatePanel;
import javafx.application.Application;
//import javafx.embed.swing.JFXPanel;
//import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import rts.GameState;
//import rts.PhysicalGameState;
import rts.units.UnitTypeTable;

public class GVSinterface extends Application {


	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("GVSinterface.fxml"));
		Scene scene = new Scene(root);
		
		//Desabilita redimensionamento da janela
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
		
	}

}
