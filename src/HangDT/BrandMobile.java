package HangDT;

public class BrandMobile {
	private String ID_Company;
	private String Name;
	
	public BrandMobile() {}

	public BrandMobile(String ID_Company, String Name) {
		this.ID_Company = ID_Company;
		this.Name = Name;
	}

	public String getID_Company() {
		return ID_Company;
	}

	public void setID_Company(String iD_Company) {
		ID_Company = iD_Company;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	};
	
}
