package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	private ComboBox<String> cbxOption;
	@FXML
	private ComboBox<String> cbxAction;
	@FXML
	private Label lblOptionMsj;
	@FXML
	private Label lblActionMsj;
	@FXML
	private Label lblPriceMsj;
	
	/////////////////////////////////////
	@FXML
	private Tab tabPeriods;
	
	/**
	 * Aquí van los atributos de periodos de tiempo*/
	
	////////////////////////////////////
	
	@FXML
	private Tab tabActions;
	
	
	/**
	 * Aquí van los atributos de acciones*/
	
	////////////////////////////////////
}
