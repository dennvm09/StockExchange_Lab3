package application;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;


public class MainController {
	
	@FXML
	private TabPane tabPaneMain;
	
	@FXML
	private Tab tabMain;
	@FXML
	private Label lblTitle;
	@FXML
	private Button btPrices;
	@FXML
	private Button btPeriods;
	@FXML
	private Button btActions;
	@FXML
	private ImageView imgBanner;

	@FXML
	private Tab tabPrices;
	@FXML
	private Label lblOption;
	@FXML
	private Label lblAction;
	@FXML
	private ChoiceBox<String> cbxOption;
	@FXML
	private ChoiceBox<String> cbxAction;
	@FXML
	private Label lblOptionMsj;
	@FXML
	private Label lblActionMsj;
	@FXML
	private Label lblPriceMsj;
	@FXML
	private DatePicker dateBegin;
	@FXML
	private DatePicker dateEnd;
	
	
	/////////////////////////////////////
	@FXML
	private Tab tabPeriods;
	
	/**
	 * Aqu� van los atributos de periodos de tiempo*/
	
	////////////////////////////////////
	
	@FXML
	private Tab tabActions;
	
	
	/**
	 * Aqu� van los atributos de acciones*/
	
	////////////////////////////////////
	
	
	public void initialize() {
		cbxOption.setItems(FXCollections.observableArrayList("Precio más alto", "Precio más bajo"));
		cbxAction.setItems(FXCollections.observableArrayList("BTCUSD", "EURUSD", "GBPCD", "USDJPY", "XUUSD"));
		
		lblOptionMsj.setVisible(false);
		lblPriceMsj.setVisible(false);	
		lblActionMsj.setVisible(false);
	}
}
