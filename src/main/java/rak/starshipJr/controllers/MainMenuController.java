package rak.starshipJr.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import rak.starshipJr.ShipbuilderApplication;

public class MainMenuController {
	
	
	

	@FXML
	protected void newShip(){
		ShipbuilderApplication.getShipBuilder().newShipLayout();
		ShipbuilderApplication.setScene(ShipbuilderApplication.SHIP_BUILD_MENU);
	}
	
	@FXML
	protected void loadShip(){
		ShipbuilderApplication.getShipBuilder().loadShipLayout(null);
	}
	
	@FXML
	protected void exit(){
		Platform.exit();
		System.exit(0);
	}
	

}
