package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.StockExchange;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static StockExchange stockExchange;
	
	public Main() {
		stockExchange = new StockExchange("Stock Exchange");
	}
	
	public static StockExchange getStockExchange() {
		return stockExchange;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
