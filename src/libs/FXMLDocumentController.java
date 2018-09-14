/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import static com.sun.javaws.ui.SplashScreen.hide;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;




/**x    
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane,anchor;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            VBox box = FXMLLoader.load(getClass().getResource("drawer.fxml"));
           // box.prefWidthProperty().bind(anchorPane.widthProperty());
            drawer.setSidePane(box);
            
            for(Node node : box.getChildren()){
                    if(node.getAccessibleText()!=null){
                            node.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
                            switch(node.getAccessibleText()){
                                case "but1":{  
                                try {
                                    AnchorPane a=FXMLLoader.load(getClass().getResource("profile.fxml"));
                                    anchor.getChildren().setAll(a);
                                    
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    
                                    
                                
                            }
                              
        
                            }
                            
                            
                            
                            
                            
                            });
                    
                    
                    
                    }
        
        
        }
            
            
            
            HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
            burgerTask2.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask2.setRate(burgerTask2.getRate()* -1);
                burgerTask2.play();
                if(drawer.isClosed()){
                    drawer.open();
                }
                else{
                    drawer.close();
                    
                }
                
            }); } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
