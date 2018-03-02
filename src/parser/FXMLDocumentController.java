/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Anjay
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Stage stage;
    
    @FXML
    private Label label;
    
    @FXML
    private VBox container;
    
    @FXML
    private TreeView<String> xmlshow;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("XML", "*.xml")
        );
        File file = fileChooser.showOpenDialog(stage);
        
        if (file == null) {
            Alert alert = new Alert(AlertType.ERROR, "Invalid file");
        }
        else
        {
            TreeItem<String> content = Parser.load(file);
            if(content!=null)
            {
                container.getChildren().remove(xmlshow);
                xmlshow = new TreeView<>(content);
                container.getChildren().add(xmlshow);
            }
            else
            {
                Alert alert = new Alert(AlertType.ERROR, "Invalid xml");
            }

           
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
