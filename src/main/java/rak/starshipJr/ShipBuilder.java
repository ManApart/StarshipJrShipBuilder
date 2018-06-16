package rak.starshipJr;

import rak.starshipJr.ship.Ship;

public class ShipBuilder {
	private Ship ship;
	private static final int DEFAULT_SHIP_SIZE = 10;
	
	public ShipBuilder(){
		ship = new Ship(DEFAULT_SHIP_SIZE);
	}
	
	public void loadShipLayout(String fileName){
		System.out.println("Load Ship not implemented");
	}
	
	public void newShipLayout(){
		ship = new Ship(DEFAULT_SHIP_SIZE);
	}
	
	public void saveShip(String fileName){
		
	}

	public Ship getShip() {
		return ship;
	}

	private void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
}
