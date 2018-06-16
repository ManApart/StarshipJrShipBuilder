package rak.starshipJr.controllers;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import rak.starshipJr.ShipbuilderApplication;
import rak.starshipJr.ship.Ship;
import rak.starshipJr.ship.ShipLayout;
import rak.starshipJr.ship.Tile;
import rak.starshipJr.ship.TileType;

public class ShipBuildController {
	@FXML
	protected GridPane gridPane;
	
	private TileType currentTileType = TileType.STRUCTURE;
	private ShipLayout layout;
	
	public void initialize(){
		Ship ship = ShipbuilderApplication.getShipBuilder().getShip();
		layout = ship.getLayout();
		drawShip(layout);
	}

	private void drawShip(ShipLayout layout) {
		gridPane.getRowConstraints().clear();
		gridPane.getColumnConstraints().clear();
//		gridPane.setGridLinesVisible(true);
		
		int size = layout.getTiles().length;
		
		for (int x=0; x<layout.getTiles().length; x++){
			//create a column
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0 / size);
			gridPane.getColumnConstraints().add(colConst);
			
			//create a row
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / size);
			gridPane.getRowConstraints().add(rowConst);
			
			for (int y=0; y<layout.getTiles()[x].length; y++){
	            Tile tile = layout.getTiles()[x][y];
	            Pane pane = createPane(tile);
				gridPane.add(pane, x, y);
			}
		}
		
		gridPane.setOnMouseDragged(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				MouseEvent me = (MouseEvent) event;
				
				//Get the bounds of a typical cell
				Bounds cell = gridPane.getChildren().get(0).getBoundsInLocal();
				int x = (int) (me.getX() / cell.getWidth());
				int y = (int) (me.getY() / cell.getHeight());
				Pane pane = (Pane) gridPane.getChildren().get(x * layout.getTiles().length + y );
				Tile tile = layout.getTiles()[x][y];
				//If we need to update the tile, do so
				if (tile.getTileType() != currentTileType){
					changeTileType(tile, pane);
				}
			}
		});
		
	}
	
	private Pane createPane(Tile tile){
		Pane pane = new Pane();
		pane.setBackground(new Background(new BackgroundFill(tile.getTileType().getColor(), CornerRadii.EMPTY, new Insets(2))));
		
		pane.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				changeTileType(tile, pane);
				
			}
		});
		
		return pane;
	}
	
	public void changeTileType(Tile tile, Pane pane){
		tile.setTileType(currentTileType);
		pane.setBackground(new Background(new BackgroundFill(tile.getTileType().getColor(), CornerRadii.EMPTY, new Insets(2))));	
	}
	
	
	
	@FXML
	protected void setTileTypeSpace(){
		currentTileType = TileType.SPACE;
	}
	
	@FXML
	protected void setTileTypeStructure(){
		currentTileType = TileType.STRUCTURE;
	}
	
	@FXML
	protected void setTileTypeSystem(){
		currentTileType = TileType.SYSTEM;
	}
	
	@FXML
	protected void back(){
		ShipbuilderApplication.setScene(ShipbuilderApplication.MAIN_MENU);
	}
}
