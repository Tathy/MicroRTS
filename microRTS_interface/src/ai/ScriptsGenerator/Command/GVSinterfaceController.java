package ai.ScriptsGenerator.Command;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GVSinterfaceController {

    @FXML
    private HBox principal;

    @FXML
    private ImageView imgMenu;

    
    
    @FXML
    void teste(ActionEvent event) {
    	System.out.println("teste");
    }
    

    // Barra superior
    //@FXML
    void closeApp(ActionEvent event) {
        Platform.exit();
    }

    //@FXML
    //void minimizeApp(ActionEvent event) {
    //    Stage stage = (Stage) principal.getScene().getWindow();
        //Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    //    stage.setIconified(true);
    //}
    

}
