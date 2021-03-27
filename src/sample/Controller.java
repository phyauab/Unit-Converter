package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label label_from;

    @FXML
    private Label label_to;

    @FXML
    private TextField tf_from;

    @FXML
    private TextField tf_to;

    @FXML
    private ListView lv_from;

    @FXML
    private ListView lv_to;

    @FXML
    private Button convert;

    @FXML
    void convert(){
        String s = tf_from.getText();
        tf_to.setText(s);
    }

}
