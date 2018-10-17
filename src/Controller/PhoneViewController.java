package Controller;

import Models.MobilePhone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PhoneViewController implements Initializable, ControllerClass {
    @FXML
    private Label makeLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private Label osLabel;

    @FXML
    private Label memoryLabel;

    private MobilePhone activePhone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void updateView()
    {
        makeLabel.setText(activePhone.getMake());
        modelLabel.setText(activePhone.getModel());
        osLabel.setText(activePhone.getOs());
        memoryLabel.setText(Double.toString(activePhone.getMemory()));
    }

    @FXML
    public void returnToTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../Views/TableOfPhones.fxml",
                "Table of Phones");
    }

    @Override
    public void preloadData(MobilePhone phone) {
        activePhone=phone;
        updateView();
    }
}
