The establishment called ABC Enterprise requires a Java program to keep a database of the 
inventory of the products that it sells. Each product is identified by its manufacturer, its 
name, the quantity, and unit price. In addition to storing the information, the program 
should be able to make updates to the quantity and/or the price as time goes on. That is, 
when a sale is made, the quantity of that product must be reduced; similarly, when a product 
is re-ordered, the quantity of that product must be increased. Also, when there is a change 
in the price of a product, the price must be changed. The change must be interpreted as a 
replacement of the value. New products may be added to the inventory at any time; also, a product 
may be removed from the inventory at any time. Maintain a separate list of those products that 
have been deleted from the database of active products.

Your program must be able to produce three kinds of reports, namely:
Locate a single product and display its name, price and quantity alone.

The inventory report should be structured as follows:
Product		Purchase Date		Quantity	Price		Manufacturer	State
Telephone		01/20/2013		10		254.99		Motorola	FL
Computer		01/06/2013		15		756.99		CBS		NY
   :				:		:		:		:		:
   :				:		:		:		:		:

The list of deleted products should be structured as follows:
Product		Date		Manufacturer
Paper reams	01/20/2013	Morgan Jewelry		
   :				:		:		
	
In your design, convince yourself that you need a minimum of four classes, not including the 
test class – Product, Manufacturer, Address, and Database. 

Also, you will be provided with the class called IO.java (that we discussed in class) for input 
and for output purposes only. Use a scrollable pane to display your outputs for requirements 2 
and 3. Use JOptionPane alone for requirement 1.
