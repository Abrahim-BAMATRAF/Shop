import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyAppli {
	static MyShop shop;

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		shop = new MyShop("shop1");
		shop.addStock(new Stock("stock1","address1"));
		String n = scan.nextLine();
		System.out.println(n);
		if(n.equals("stock1")){
			System.out.println("yes");
		}
		Stock s = shop.nameToStock(n);

		s.display();


	}
}

