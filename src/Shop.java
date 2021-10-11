import java.util.Scanner;
/*
public class MyShop {

	public static void main(String[] args) {
		
		boolean finish = false;
		Scanner scan = new Scanner(System.in);

        System.out.println("Enter the stock name");
        String stockName = scan.nextLine();
        System.out.println("Enter the stock address");
        String stockAddress = scan.nextLine();
        Stock stock = new Stock(stockName,stockAddress);
		
		while(!finish) {
	
				
            
            //creating the products
            boolean createProduct = false;
            
            System.out.println("Do you want to create a product?(y/n)");
            String answer = scan.nextLine();
            if(answer.contains("y")) {
                createProduct = true;
            }else {
                createProduct = false;
            }
            
            while(createProduct) {
                System.out.println("every product you create will be added to the stock \n");
                System.out.println("Enter the product name");
                String productName = scan.nextLine();
                System.out.println("Enter the product quantity");
                int productQuantity = scan.nextInt();

                stock.addProduct(new Product(productName,productQuantity));
                
                System.out.println("do you want to continue adding other products?(y/n)");
                answer = scan.nextLine();
                if(answer.contains("y")) {
                    createProduct = true;
                }else {
                    createProduct = false;
                }
            }

            //creating the products
            boolean showProduct = false;
            
            System.out.println("Do you want to show the info of a product?(y/n)");
            answer = scan.nextLine();
            if(answer.contains("y")) {
                showProduct = true;
            }else {
                showProduct = false;
            }

            while(showProduct){
                System.out.println("Enter the name of the produc you want to see the info of");
                String nameGivenByUser = scan.nextLine(); 
                stock.nameToProduct(nameGivenByUser).display();

                System.out.println("Do you want to show the info of a product?(y/n)");
                answer = scan.nextLine();
                if(answer.contains("y")) {
                    showProduct = true;
                }else {
                    showProduct = false;
                }

            }


            



                
        }


            
        
			
        scan.close();

    }
		

	

}
*/