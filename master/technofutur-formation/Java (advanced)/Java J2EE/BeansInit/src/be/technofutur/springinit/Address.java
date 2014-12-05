package be.technofutur.springinit;

public class Address {
	
	private String street;
	private Integer number;
	private String city;
	private Integer postalCode;
	private String region;
	
	public Address() {}
	
	public String getStreet() {
		
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public Integer getNumber() {
		
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getCity() {
		
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getPostalCode() {
		
		return postalCode;
	}
	
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getRegion() {
		
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		
		return "Address [street=" + street + ", number=" + number + ", city="
				+ city + ", postalCode=" + postalCode + ", region=" + region
				+ "]";
	}
	
}
