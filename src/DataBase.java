import java.util.ArrayList;

public class DataBase {
	
	private	ArrayList<Product> products = new ArrayList<>(); //list of in stock products
	private	ArrayList<Product> deletedProducts = new ArrayList<>(); //list of deleted products
	
	public void add(Product product) {
		this.products.add(product);
	}
	
	public void printInventory() {
		for(Product p : products) {
			System.out.print( p.getName() + ", " + p.getPurchaseDate() + ", " + p.getQuantity() + ", " + p.getUnitPrice()
			+ ", " + p.getManufacturer().getCompanyName() + ", " + p.getManufacturer().getAddress().getState() + "\n");
		}
		
	}
	
	public void delete(Product product) { 
		products.remove(product);
		deletedProducts.add(product);
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public ArrayList<Product> getDeletedProducts() {
		return deletedProducts;
	}

	public void printDeleted() {
		for(Product p : deletedProducts) {
			System.out.println(p.getName() + ", " + p.getPurchaseDate() + ", " + p.getManufacturer().getAddress().getState());
		}
	}
	

}
