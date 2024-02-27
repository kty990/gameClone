package engine;

public class Inventory {
	private Item[][] items = new Item[][]{};
	private int size;
	public Inventory(int size) {
		this.size = size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Item[][] getItems() {
		return this.items;
	}
	
	private boolean checkEmptySpot() {
	    for (int y = 0; y < items.length; y++) {
	        for (int x = 0; x < items[y].length; x++) {
	            if (items[y][x] == null) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	
	public void addItem(Item item) {
	    boolean found = false;
	    for (int y = 0; y < items.length; y++) {
	        for (int x = 0; x < items[0].length; x++) {
	            Item tmp = items[y][x];
	            if (tmp != null && tmp.getID() == item.getID()) {
	                if (tmp.stackSize < tmp.stackLimit) {
	                    tmp.stackSize++;
	                    found = true;
	                    break;
	                }
	            }
	        }
	        if (found) break;
	    }
	    if (!found) {
	        if (this.checkEmptySpot()) {
	            for (int y = 0; y < items.length; y++) {
	                for (int x = 0; x < items[0].length; x++) {
	                    if (items[y][x] == null) {
	                        items[y][x] = item;
	                        return; // Item added successfully
	                    }
	                }
	            }
	        } else {
	            // Can't insert, inventory is full
	            System.out.println("Inventory is full, cannot add item: " + item.getName());
	        }
	    }
	}

}