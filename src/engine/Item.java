package engine;

public class Item {
	protected double ID;
	protected String name;
	protected int stackLimit;
	protected int stackSize;

	public static Item ironOre = new Item(0, "Iron Ore", 100);
	public static Item ironPlate = new Item(0.1, "Iron Plate", 100);
	public static Item ironWheel = new Item(0.2, "Iron Wheel", 100);
	public static Item pipe = new Item(0.3, "Pipe", 100);

	public static Item copperOre = new Item(1, "Copper Ore", 100);
	public static Item copperPlate = new Item(1.1, "Copper Plate", 100);

	public static Item coal = new Item(2, "Coal", 50);
	public static Item uraniumOre = new Item(3, "Uranium Ore", 100);
	public static Item processedUranium = new Item(3.1, "Processed Uranium", 100);

	public static Item stone = new Item(4, "Stone", 100);
	public static Item stoneBrick = new Item(4.1, "Stone Brick", 100);
	public static Item wood = new Item(4.2, "Wood", 100);

	public Item() {
		this.stackSize = 0;
	}

	public Item(double ID, String name, int stackLimit) {
		this.ID = ID;
		this.stackLimit = stackLimit;
		this.stackSize = 0;
	}

	public double getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}
}
