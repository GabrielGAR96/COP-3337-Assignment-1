import javax.swing.JOptionPane;

public class Driver {

	
	
	public static void main(String[] args) {
		
		Address a1 = new Address("1455 Fort Street", "Miami", "Florida", "33123");
		Address a2 = new Address("9187 109th Ave", "Fort Lauderdale", "California", "31298");
		Address a3 = new Address("123 19th Street", "West Palm Beach", "Texas", "30291");
		Manufacturer m1 = new Manufacturer("Apple", a1);
		Manufacturer m2 = new Manufacturer("Samsung", a2);
		Manufacturer m3 = new Manufacturer("Sony", a3);
		Product p1 = new Product(m1, "iPhone", 10, 300.00, "12/11/2019");
		Product p2 = new Product(m2, "Galaxy", 12, 320.00, "03/10/2019");
		Product p3 = new Product(m3, "Xperia", 13, 250.00, "06/02/2018");
		
		System.out.println(p1.getUnitPrice());
		p1.setUnitPrice(240);
		System.out.println(p1.getUnitPrice());
		
		DataBase db1 = new DataBase(); 
		
		db1.add(p1);
		db1.add(p2);
		db1.add(p3);
		
		db1.printInventory();
		System.out.println();
		
		db1.delete(p1);
		
		db1.printInventory();
		System.out.println();
		
		db1.printDeleted();
		//initial list
		
		
		
		
		boolean done = false;
		
		while(!done) {
			int menu = IO.getInt("\tProducts\n"
	                + "\nPlease Choose From the Following:" 
					+ "\n1. Insert new product"
					+ "\n2. Update price"
					+ "\n3. Sell product"
					+ "\n4. Reorder product"
	                + "\n5. Remove product"
	                + "\n6. Inventory report"
	                + "\n7. View deleted products"
	                + "\n8. Exit");
			switch (menu) {
			case 1: //insert new product
				String cName = IO.getWord("Please insert the company name."); //company name
				
				String street = IO.getWord("Please insert the company address.");
				String city = IO.getWord("Please insert the company city.");
				String state = IO.getWord("Please insert the company state.");
				String zip = IO.getWord("Please insert the company zip code.");
				
				Address address = new Address(street, city, state, zip);
				Manufacturer manufacturer = new Manufacturer(cName, address);
				
				String pName = IO.getWord("Please insert the product name."); //product name
				int pQuantity = IO.getInt("Please insert the product quantity.");
				double pPrice = IO.getDouble("Please insert the product price."); //product price
				String purchaseDate = IO.getWord("Please insert the product purchase date.");
				
				Product newProduct = new Product(manufacturer, pName, pQuantity, pPrice, purchaseDate);
				db1.add(newProduct);				
				
			break;
			case 2: //update price
				String product = IO.getWord("Please insert the product name.");
				for(Product p : db1.getProducts()) {
					if(p.getName().contains(product)) {
						int price = IO.getInt("Insert the new price of the " + p.getManufacturer().getCompanyName() + " " + p.getName() + ".");
						p.setUnitPrice(price);
						break; 
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid product");
						break;
					}
				} 
			break;
			case 3: //selling a product
				product = IO.getWord("Please insert the product name.");
				for(Product p : db1.getProducts()) {
					if(p.getName().contains(product)) {
						int quantity = IO.getInt("How many units of the " + p.getManufacturer().getCompanyName() + " " + p.getName() + " are you going to sell?");
						p.sell(quantity);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid product");
						break;
					}
				} 
			break;
			case 4: //reordering a product
				product = IO.getWord("Please insert the product name.");
				for(Product p : db1.getProducts()) {
					if(p.getName().contains(product)) {
						int quantity = IO.getInt("How many units of the " + p.getManufacturer().getCompanyName() + " " + p.getName() + " are you going to reorder?");
						p.reorder(quantity);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid product");
						break;
					}
				}
			break;
			case 5: // removing a product
				product = IO.getWord("Please insert the product name.");
				for(Product p : db1.getProducts()) {
					if(p.getName().contains(product)) {
						db1.delete(p);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid product");
						break;
					}
				}
			break;
			case 6: //inventory report
				String s = "Product\t Purchase Date\t Quantity\t Price\t Manufacturer\t State\n";
				for(Product p : db1.getProducts()) {
					s += p.getName() + "\t " + p.getPurchaseDate() + "\t " + p.getQuantity() + "\t " + p.getUnitPrice()
					+ "\t " + p.getManufacturer().getCompanyName() + "\t " + p.getManufacturer().getAddress().getState() + "\n";
				}
				IO.display("Inventory report", s, db1.getProducts().size(), 6);
				break;
				
			case 7: //deleted products
				s = "Product\t Purchase Date\t State\n";
				for(Product p : db1.getDeletedProducts()) {
					s += p.getName() + "\t " + p.getPurchaseDate() + "\t " + p.getManufacturer().getAddress().getState();
				}
				IO.display("Deleted Products", s, db1.getDeletedProducts().size(), 3);
			break;
			case 8: //exit loop
				done = true;
			break;
			}
			
		}
		
		
		
		

	}

}
