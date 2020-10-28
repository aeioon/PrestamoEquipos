package GUI.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 * @author ion
 */

public class LoanRequestController implements Initializable {

      @FXML
    private TextField searchProgramTF;

    @FXML
    private Button searchProgramBtn;

    @FXML
    private TableView<?> avaliableProgramsTable;

    @FXML
    private TableView<?> selectedProgramsTable;

    @FXML
    private TableView<?> avaliableComputersTable;

    @FXML
    private Button askLoanBtn;

    @FXML
    private Button backHomeBtn;

    @FXML
    private Button userInfoBtn;

    @FXML
    void AskLianBtnAction(ActionEvent event) {

    }

    @FXML
    void backHomeBtn(ActionEvent event) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource("/GUI/views/studentHome.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void searchProgramBtnAction(ActionEvent event) {

    }

    @FXML
    void userInfoBtnAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
