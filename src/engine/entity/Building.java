package engine.entity;

public abstract class Building extends Entity {
	protected String name;
	protected double ID;
	
	public Building() {
		super();
	}
	public Building(double ID, String name) {
		super();
		this.ID = ID;
	}
	
	public double getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
}
