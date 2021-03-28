package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label label_from;

    @FXML
    private Label label_to;

    @FXML
    private TextField tf_from;

    @FXML
    private TextField tf_to;

    @FXML
    private ListView<String> lv_from;

    @FXML
    private ListView<String> lv_to;

    @FXML
    private Button convert;

    LengthConverter lengthConverter = new LengthConverter();

    @FXML
    void convert(){
        String input = tf_from.getText();
        //String selectedItem = lv_from.getSelectionModel().getSelectedItem();
        int indexFrom = lv_from.getSelectionModel().getSelectedIndex();
        int indexTo = lv_to.getSelectionModel().getSelectedIndex();
        double result = 0;

        try {
            result = lengthConverter.validateInput(input);
            if(indexFrom < 0 || indexTo < 0)
                throw new Exception("not yet selected");
        } catch (Exception e){
            System.out.println(e);
            return;
        }
        tf_to.setText(lengthConverter.convertLength(result, indexFrom, indexTo));

    }

    @FXML
    void loadListView(){
        ObservableList<String> lengthList = FXCollections.observableArrayList(lengthConverter.getLENGTH_UNIT());
        lengthList.removeAll();
        lv_from.setItems(lengthList);
        lv_to.setItems(lengthList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadListView();
    }
}
