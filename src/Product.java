
public class Product {
	
	private Manufacturer manufacturer;
	private String name;
	private int quantity;
	private double unitPrice;
	private	String purchaseDate;

	
	public Product(Manufacturer manufacturer, String name, int quantity, double unitPrice, String purchaseDate) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void reorder(int quantity) {
		this.quantity = this.quantity + quantity;
	}
	
	public void sell(int quantity) {
		this.quantity = this.quantity - quantity;
	}
	
	

}
