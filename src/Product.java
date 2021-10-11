
public abstract class Product {
	public static int nextId = 0;
	
	private String name;
	private int quantity;
	private int reference;
	
	public Product(String n, int q) {
		this.setName(n);
		this.setQuantity(q);
		this.reference = nextId;
		nextId++;
	}
	
	public Product(String n) {
		this.setName(n);
		this.setQuantity(0);
		this.reference = nextId;
		nextId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getReference() {
		return this.reference;
	}
	
	public void addToQuantity(int q) {
		this.quantity += q;
	}
	
	public void takeFromQuantity(int q) {
		if(q > this.quantity) {
			throw new IllegalArgumentException("Not enough stock");
		}else {
			this.quantity -= q;
		}
	}
	
	public void display(){
		System.out.println("the product name is : " + this.getName());
		System.out.println("the product quantity is : " + this.getQuantity());
	}

	public void sell(int quantity){
		if(quantity <= this.quantity){
			this.quantity -= quantity;
		}
	}
	

}
