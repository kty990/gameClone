package engine;

public class Sprite {
	private int[][] pixels;
	private int width,height;
	private int x,y;
	
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setPixels(int[][] pixels) {
		this.pixels = pixels;
	}
	
	public void render(Display d) {
		for (int yy = 0; yy < height; y++) {
			for (int xx = 0; xx < width; x++) {
				d.setPixel(x + xx, y + yy, pixels[yy][xx]);
			}
		}

	}
}
