package engine.tiles;

public class grass extends Tile{

	public grass(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public grass(int x, int y, int width, int height, int[][] pixels) {
		super(x, y, width, height, pixels);
	}

}
