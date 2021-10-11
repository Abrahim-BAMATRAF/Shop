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
					saveInFile();
					break;

			}

			
		}
		
		

	}
	
	public static MyShop createShop(){
		System.out.println("Enter the shop name");
		String shopName = scan.next();
		System.out.println(shopName);
		
		return new MyShop(shopName);
	}
	
	public static int menu(){
		System.out.println("do you want to create stock(1) or create product(2) or browse stocks(3) or " +
				"exit the program(4) save all data into file(5) enter the number that corresponde");
		int response = scan.nextInt();
		return response;
	}
	
	public static void createStock(){
		System.out.println("Enter the stock name");
		String stockName = scan.next();
		System.out.println("Enter the stock address");
		String stockAddress = scan.next();
		
		Stock stock = new Stock(stockName,stockAddress);
		stock.display();
		shop.addStock(stock);
	}
	
	public static void createProduct(){
		Stock stockChosen = chooseStock();
		switch (chooseProductType()){
			case "Alimentary":
				createProductAlimentary(stockChosen);
				break;
			case "Sanitary":
				createProductSanitary(stockChosen);
				break;
			default:
				System.out.println("type of product is wrong ");
				createProduct();
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
		System.out.println(currentStockName);
		Stock currentStock = shop.nameToStock(currentStockName);
		shop.display();
		currentStock.display();
		return currentStock;
	}
	
	public static String chooseProductType(){
		System.out.println("Enter the type of product (Alimentary/Sanitary)");
		String productType = scan.next();
		return productType;
	}
	
	public static void browseStock(){
		Stock stockChosen = chooseStock();
		stockChosen.display();
		
	}

	public static void saveInFile(){


	}
	
	

}
