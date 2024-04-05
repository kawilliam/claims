package claims.controllers.Advisor;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import claims.models.Advisor;
import claims.models.Claims;
import claims.models.Customer;
import claims.models.Model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateTimeStringConverter;

public class AdvisorClaimsController implements Initializable {
    @FXML
    private TableColumn<Claims, Boolean> atfault_col;

    @FXML
    private TableColumn<Claims, Number> cliID_col;

    @FXML
    private Label clientname_lbl;

    @FXML
    private TableColumn<Claims, Number> clmID_col;

    @FXML
    private TableView<Claims> clm_table;

    @FXML
    private TableColumn<Claims, String> dam_col;

    @FXML
    private Label dam_lbl;

    @FXML
    private TableColumn<Claims, LocalDate> datefil_col;

    @FXML
    private Label datefilled_lbl;

    @FXML
    private Label descript_lbl;

    @FXML
    private Label notes_lbl;

    @FXML
    private TableColumn<Claims, Number> polID_col;

    @FXML
    private TableColumn<Claims, String> sta_col;

    @FXML
    private TableColumn<Claims, LocalDateTime> time_col;

    @FXML
    private TableColumn<Claims, Boolean> tol_col;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateClaimsTable();
    }

    public void populateClaimsTable() {
        Advisor advisor = Model.getInstance().getAdvisor();
        clmID_col.setCellValueFactory(cellData -> cellData.getValue().claimIDProperty());
        dam_col.setCellValueFactory(cellData -> cellData.getValue().damageProperty());
        datefil_col.setCellValueFactory(cellData -> cellData.getValue().dateFiledProperty());
        sta_col.setCellValueFactory(cellData -> cellData.getValue().claimStatusProperty());
        atfault_col.setCellValueFactory(cellData -> cellData.getValue().atFaultProperty());
        tol_col.setCellValueFactory(cellData -> cellData.getValue().totalledProperty());
        cliID_col.setCellValueFactory(cellData -> cellData.getValue().clientIDProperty());
        polID_col.setCellValueFactory(cellData -> cellData.getValue().policyIDProperty());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd,  HH:mm");
        time_col.setCellFactory(tc -> new TextFieldTableCell<>(new LocalDateTimeStringConverter(formatter, null)));
        time_col.setCellValueFactory(cellData -> cellData.getValue().accidentTimeProperty());


        Platform.runLater(() -> clm_table.setItems(Model.getInstance().getClaimsByAdvisor(advisor.getUserID())));
    }
}
