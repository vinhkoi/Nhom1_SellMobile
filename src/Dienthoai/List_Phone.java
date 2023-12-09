package Dienthoai;

public class List_Phone {
	public String ID_Phone, Name, Color, IDCompany;
	public double Price, Amount;
	

	public String getCompany() {
		return IDCompany;
	}


	public void setCompany(String idcompany) {
		IDCompany = idcompany;
	}


	public String getID_Phone() {
		return ID_Phone;
	}


	public void setID_Phone(String iD_Phone) {
		ID_Phone = iD_Phone;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getColor() {
		return Color;
	}


	public void setColor(String color) {
		Color = color;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public double getAmount() {
		return Amount;
	}


	public void setAmount(double amount) {
		Amount = amount;
	}

	public List_Phone() {
		super();
	}


	public List_Phone(String iD_Phone, String name, String color, String idcompany, double price, double amount) {
		super();
		ID_Phone = iD_Phone;
		Name = name;
		Color = color;
		IDCompany = idcompany;
		Price = price;
		Amount = amount;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
