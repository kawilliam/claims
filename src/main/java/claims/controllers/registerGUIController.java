package claims.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import claims.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registerGUIController implements Initializable {

    @FXML
    private Button Button_Cancel;

    @FXML
    private Button Button_Confirm;

    @FXML
    private AnchorPane registerView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Cancel.setOnAction(event -> onCancel());
    }

    public void onCancel() {
        Stage stage = (Stage) Button_Cancel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}

