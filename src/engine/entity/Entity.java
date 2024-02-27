package engine.entity;

import engine.Display;
import engine.Inventory;
import engine.Sprite;

public abstract class Entity {
	public double health;
	public int x, y;
	protected Inventory inventory;
	private Sprite[] sprites = new Sprite[]{};
	
	public Entity() {
		this.inventory = new Inventory(0);
	}
	
	public void update(int updates) {}
	
	public void render(Display d) {}
	
	public void move(int xa, int ya) {
		this.x += xa;
		this.y += ya;
	}
}
