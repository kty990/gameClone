package game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import engine.Display;
import engine.entity.Entity;
import engine.tiles.Tile;

public class index {
	private static Display display;
	private static Tile[] tiles;
	private static Entity[] entities;
	
	public static void main(String[] args) {
		display = new Display();
		tiles = new Tile[] {};
		entities = new Entity[] {};
		
		ExecutorService executor = Executors.newFixedThreadPool(2); // Create a thread pool with 2 threads
        
        // Start update and render threads
        executor.submit(index::update);
        executor.submit(index::render);
        
        // Shutdown the executor when the program exits
        Runtime.getRuntime().addShutdownHook(new Thread(executor::shutdown));
	}
	
	private static void update() {
		int updates = 0;
		while (true) {
            // Game logic here
			for (int i = 0; i < tiles.length; i++) {
				Tile t = tiles[i];
				t.update(updates);
			}

			for (int i = 0; i < entities.length; i++) {
				Entity e = entities[i];
				e.update(updates);
			}			
			// =================== NO GAME LOGIC PAST THIS POINT =====================
            
            try {
                Thread.sleep(50); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interrupted exception
            }
            updates++;
        }		
	}
	
	private static void render() {
		while (true) {
            // Game logic here
			for (int i = 0; i < tiles.length; i++) {
				Tile t = tiles[i];
				t.render(display);
			}

			for (int i = 0; i < entities.length; i++) {
				Entity e = entities[i];
				e.render(display);
			}			
			// =================== NO GAME LOGIC PAST THIS POINT =====================
            
            try {
                Thread.sleep(200); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interrupted exception
            }
        }
	}
}
