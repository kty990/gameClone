package engine;

public class ImageScaler {
    private int[][] originalPixels;

    // Constructor
    public ImageScaler(int[][] originalPixels) {
        this.originalPixels = originalPixels;
    }

    // Method to scale the image
    public int[][] scaleImage(int newWidth, int newHeight) {
        int originalWidth = originalPixels.length;
        int originalHeight = originalPixels[0].length;
        
        int[][] scaledPixels = new int[newWidth][newHeight];
        
        double xRatio = (double) originalWidth / newWidth;
        double yRatio = (double) originalHeight / newHeight;

        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                int px = (int) (x * xRatio);
                int py = (int) (y * yRatio);
                scaledPixels[x][y] = originalPixels[px][py];
            }
        }
        
        return scaledPixels;
    }
}
