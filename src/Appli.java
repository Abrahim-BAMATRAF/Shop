import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Appli {
	static Scanner scan = new Scanner(System.in);
	static MyShop shop;

	public static void main(String[] args) {
		shop = createShop();
		boolean finished = false;
		
		while(!finished){
			int case_chosen = menu();
			
			switch (case_chosen){
				case 1 :
					createStock();
					break;
				case 2 :
					createProduct();
					break;
				case 3 :
					browseStock();
					break;
				case 4 :
					finished = true;
					break;
				case 5:
					try {
						saveInFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					sellProduct();
					break;
			}

			
		}
		
		

	}
	
	public static MyShop createShop(){
		System.out.println("Enter the shop name");
		String shopName = scan.next();
		return new MyShop(shopName);
	}
	
	public static int menu(){
		System.out.println("do you want to create stock(1) or create product(2) or browse stocks(3) or " +
				"exit the program(4) save all data into file(5) sell a product(6) enter the number that correspond");
		return scan.nextInt();
	}
	
	public static void createStock(){
		System.out.println("Enter the stock name");
		String stockName = scan.next();
		System.out.println("Enter the stock address");
		String stockAddress = scan.next();
		Stock stock = new Stock(stockName,stockAddress);
		shop.addStock(stock);
	}
	
	public static void createProduct(){
		Stock stockChosen = chooseStock();
		switch (chooseProductType()) {
			case "Alimentary" -> createProductAlimentary(stockChosen);
			case "Sanitary" -> createProductSanitary(stockChosen);
			default -> {
				System.out.println("type of product is wrong ");
				createProduct();
			}
		}
	}
	
	public static void createProductAlimentary(Stock s){
		System.out.println("Enter the product name");
		String productName = scan.next();
		System.out.println("Enter the product quantity");
		int productQuantity = scan.nextInt();
		System.out.println("Enter the product expiration year");
		int year = scan.nextInt();
		System.out.println("Enter the product expiration month");
		int month = scan.nextInt();
		System.out.println("Enter the product expiration day");
		int day = scan.nextInt();
		ProductAlimentary prod = new ProductAlimentary(productName, productQuantity, year, month, day);
		s.add(prod);
	}
	
	public static void createProductSanitary(Stock s){
		System.out.println("Enter the product name");
		String productName = scan.next();
		System.out.println("Enter the product quantity");
		int productQuantity = scan.nextInt();
		ProductSanitary prod = new ProductSanitary(productName, productQuantity);
		s.add(prod);
	}
	
	public static Stock chooseStock(){
		System.out.println("Enter the name of the stock you want to choose");
		String currentStockName = scan.next();
		Stock currentStock = shop.nameToStock(currentStockName);
		return currentStock;
	}

	public static Product chooseProduct(Stock s){
		System.out.println("Enter the name of the product you want to choose");
		String productName = scan.next();

		return s.nameToProduct(productName);

	}
	
	public static String chooseProductType(){
		System.out.println("Enter the type of product (Alimentary/Sanitary)");
		return scan.next();
	}
	
	public static void browseStock(){
		Stock stockChosen = chooseStock();
		stockChosen.display();
	}

	public static void saveInFile() throws IOException {
		BufferedWriter buff=new BufferedWriter(new FileWriter("fichier.txt"));
		saveShop(buff);
		buff.write("finish");
		buff.flush();
		buff.close();
	}

	public static void saveShop(BufferedWriter buff) throws IOException {
		buff.write("the shop name is : ");
		buff.write(shop.getName());
		buff.newLine();
		for(int i = 0; i < shop.getStocks().size(); i++){
			buff.write("Stock " + i);
			buff.newLine();
			saveStock(shop.getStocks().get(i), buff);
		}
	}

	public static void saveStock(Stock s, BufferedWriter buff) throws IOException {
		buff.write("the stock name is " + s.getName());
		buff.newLine();

		buff.write("the stock address is " + s.getAdress());
		buff.newLine();

		for (int i =0; i < s.size(); i++){
			buff.write("Product " + i);
			buff.newLine();
			saveProduct(s.get(i), buff);
		}

	}

	public static void saveProduct(Product prod, BufferedWriter buff) throws IOException {
		buff.write("the product name is " + prod.getName());
		buff.newLine();
		buff.write("the product quantity is " + prod.getQuantity());
		buff.newLine();

	}

	public static void sellProduct(){
		Stock stock = chooseStock();
		Product prod = chooseProduct(stock);
		int quantity = QuantityToBeSold();
		if(verifyQuantity(prod,quantity)){
			sellThisItem(prod,quantity);
		}else{
			System.out.println("not enough products in the stock");
		}
	}

	public static boolean verifyQuantity(Product prod, int quantity){
		return (quantity <= prod.getQuantity());
	}

	public static int QuantityToBeSold(){
		System.out.println("Enter the number of pieces you want to sell");
		return scan.nextInt();
	}

	public static void sellThisItem(Product prod, int quantity){
		prod.sell(quantity);
	}
	
	

}
