package Controller;

import Models.DBConnect;
import Models.MobilePhone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableOfPhonesController implements Initializable {
    @FXML
    private TableView<MobilePhone> tableView;

    @FXML
    private TableColumn<MobilePhone, String> makeColumn;

    @FXML
    private TableColumn<MobilePhone, String> modelColumn;

    @FXML
    private TableColumn<MobilePhone, String> osColumn;

    @FXML
    private TableColumn<MobilePhone, Double> screenSizeColumn;

    @FXML
    private TableColumn<MobilePhone, Integer> memoryColumn;

    @FXML
    private TableColumn<MobilePhone, Double> priceColumn;

    @FXML
    private TableColumn<MobilePhone, Image> imageColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // confgure the table columns
        makeColumn.setCellValueFactory(new PropertyValueFactory<MobilePhone, String>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<MobilePhone, String>("model"));
        osColumn.setCellValueFactory(new PropertyValueFactory<MobilePhone, String>("os"));
        screenSizeColumn.setCellValueFactory(new PropertyValueFactory<MobilePhone, Double>("screenSize"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<MobilePhone, Integer>("memory"));

        try {
            tableView.getItems().addAll(DBConnect.getAllPhones());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void viewSelectedPhone(ActionEvent event) throws IOException {
        MobilePhone phone = tableView.getSelectionModel().getSelectedItem();
        if (phone != null)
        {
            SceneChanger.changeScenes(event, "../Views/PhoneView.fxml",
                                        "Phone View",phone,
                                        new PhoneViewController());
        }
        else
            System.err.println("no phone selected");
    }

    @FXML
    public void viewGraphButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../Views/GraphView.fxml",
                                    "Cool graph");
    }
}
