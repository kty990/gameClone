package engine;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel canvasPanel;
    private int[][] pixels;

    public Display() {
    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        DisplayMode mode = gd.getDisplayMode();

        // Get the width and height of the monitor
        int screenWidth = mode.getWidth();
        int screenHeight = mode.getHeight();
        setTitle("Pixel Canvas");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Get the default screen device
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        
        // Make the frame fullscreen exclusive
        if (device.isFullScreenSupported()) {
            setUndecorated(true); // Hides window borders
            device.setFullScreenWindow(this);
        } else {
            // If fullscreen exclusive mode is not supported, fallback to maximizing
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        
        // Make sure the frame is visible
        setVisible(true);

        canvasPanel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPixels(g);
            }
        };

        pixels = new int[screenWidth][screenHeight];

        add(canvasPanel);
        
        

    }

    public void displayPixels(int[][] pixels, int xOffset, int yOffset) {
        this.pixels = pixels;
        canvasPanel.repaint();
    }

    private void drawPixels(Graphics g) {
        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[0].length; y++) {
                int pixelValue = pixels[x][y];
                g.setColor(new Color(pixelValue));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

	public void setPixel(int x, int y, int p) {
		pixels[y][x] = p;
	}
}
