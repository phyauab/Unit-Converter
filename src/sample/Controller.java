package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    @FXML
    private RadioButton radio_length;

    @FXML
    private RadioButton radio_temperature;

    LengthConverter lengthConverter = new LengthConverter();
    TemperatureConverter temperatureConverter = new TemperatureConverter();

    @FXML
    void convert(){
        String input = tf_from.getText();
        //String selectedItem = lv_from.getSelectionModel().getSelectedItem();
        int indexFrom = lv_from.getSelectionModel().getSelectedIndex();
        int indexTo = lv_to.getSelectionModel().getSelectedIndex();
        double result = 0;
        Converter converter = lengthConverter;

        if (radio_length.isSelected())
            converter = lengthConverter;
        else if(radio_temperature.isSelected())
            converter = temperatureConverter;

        try {
            result = converter.validateInput(input);
            if(indexFrom < 0 || indexTo < 0)
                throw new Exception("not yet selected");
        } catch (Exception e){
            System.out.println(e);
            return;
        }
        tf_to.setText(converter.convert(result, indexFrom, indexTo));

    }

    @FXML
    void changeListView(){

    }

    @FXML
    void loadListView(Converter converter){
        ObservableList<String> lengthList = FXCollections.observableArrayList(converter.getUnit());
        lengthList.removeAll();
        lv_from.setItems(lengthList);
        lv_to.setItems(lengthList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        radio_length.setToggleGroup(group);
        radio_temperature.setToggleGroup(group);

        group.selectedToggleProperty().addListener(((observable, oldValue, newValue) -> {
            if (radio_length.isSelected())
                loadListView(lengthConverter);
            else if(radio_temperature.isSelected())
                loadListView(temperatureConverter);
        }));
    }


}
