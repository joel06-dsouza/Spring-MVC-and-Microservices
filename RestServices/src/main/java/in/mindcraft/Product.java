package in.mindcraft;

public class Product {

	private int pid;
	
	private String make;
	
	private double cost;
	
	public Product() {
		
	}

	public Product(int pid, String make, double cost) {
		super();
		this.pid = pid;
		this.make = make;
		this.cost = cost;
	}



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void show() {
		System.out.println(pid+"  "+make+"  "+cost);
	}
	
	
}
