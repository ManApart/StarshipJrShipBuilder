package rak.starshipJr;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ShipbuilderApplication extends Application {
	public final static String MAIN_MENU = "MainMenu";
	public final static String SHIP_BUILD_MENU = "ShipBuild";
	private static Stage primaryStage;
	private static ShipBuilder shipBuilder;
	
	public static void main(String[] args) {
		launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		ShipbuilderApplication.primaryStage = primaryStage;
		ShipbuilderApplication.shipBuilder = new ShipBuilder();
		
        primaryStage.setTitle("Starship Ship Builder");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images//Logo Icon.png")));
//        setScene(MAIN_MENU);
        setScene(SHIP_BUILD_MENU);
        primaryStage.show();
	}
	
	public static void setScene(String sceneName){
		try {
			Scene scene = loadFXML(sceneName);
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Scene loadFXML(String fileName) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(ShipbuilderApplication.class.getResource("view/" + fileName + ".fxml"));
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		return scene;
	}
	
	public static ShipBuilder getShipBuilder(){
		return shipBuilder;
	}
	

}
