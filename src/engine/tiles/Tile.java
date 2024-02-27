package engine.tiles;

import engine.Display;
import engine.Sprite;

public abstract class Tile {
	private Sprite sprite;
	public int x,y;
	public int width,height;
	protected boolean solid;
	
	public int g, f;
	public Tile parent;
	
	public Tile(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Tile(int x, int y, int width, int height, int[][] pixels) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = new Sprite(x,y,width,height);
		this.sprite.setPixels(pixels);
	}
	
	public void update(int updates) {}
	
	public void render(Display d) {
		sprite.render(d);
	}
	
	public boolean isSolid() {
		return this.solid;
	}
}
