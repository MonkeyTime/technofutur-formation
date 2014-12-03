package be.object.herit;

public class Person implements Comparable<Person> {

	private String name;
	private boolean married;
	private int age;
	private Address[] addresses;
	
	public Person() {
		this("unknown", false, 0, 1, "", "", "");
	}
	
	public Person(String name, boolean isMarried, int age,
			int capacityAddress, String street, String zip, String city) {
		setName(name);
		setMarried(isMarried);
		setAge(age);
		setAddresses(new Address[capacityAddress]);
		this.addresses[0] = new Address(street, zip, city);
	}
	
	public boolean addAddress(String street, String zip, String city) {
		for(int i=0 ; i<addresses.length ; i++) {
			if(addresses[i]==null) {
				addresses[i] = new Address(street, zip, city);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)	return true;
		if(obj == null) return false;
		if(!getClass().equals(obj.getClass())) return false;
		
		Person pobj = (Person) obj;
		
		boolean result = getName().equals(pobj.getName()) &&
				isMarried()==pobj.isMarried() &&
				getAge()==pobj.getAge();
		
		result = result && getAddresses().length==pobj.getAddresses().length;
		if(!result)
			return false;
		
		for(int i=0 ; i<getAddresses().length ; i++) {
			result = result && getAddresses()[i].equals(pobj.getAddresses()[i]);
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		int result = 15;
		int root = 31;
		
		result = root * result + getName().hashCode();
		result = root * result + (isMarried() ? 1 : 0);
		result = root * result + age;
		for(int i=0 ; i<getAddresses().length ; i++) {
			result = root * result + getAddresses()[i].hashCode();
		}
		return result;
	}
	
	@Override
	public String toString() {
		
		return getClass().getSimpleName() + "["+
		"name:" + getName() +"," +
		"married:" + isMarried() + ", "+
		"age:" + getAge() +"]";
	}
	
	@Override
	public int compareTo(Person o) {
		return getName().compareTo(o.getName());
	}
	
	public Address[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getName() {
		/*if(name==null)
			return new String();*/
		return name;
	}

	public void setName(String name) {
		/*if(name.equalsIgnoreCase("admin"))
			this.name="unknown";*/
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public class Address implements Comparable<Address> {
		private String street;
		private String zipCode;
		private String city;
		
		public Address() {
			this("","","");
		}
		
		public Address(String street, String zipCode, String city) {
			setStreet(street);
			setZipCode(zipCode);
			setCity(city);
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(obj==null) return false;
			if(obj.getClass()!=getClass()) return false;
			
			Address aobj = (Address) obj;
			return getStreet().equals(aobj.getStreet()) &&
					getZipCode().equals(aobj.getZipCode()) &&
					getCity().equals(aobj.getCity());
		}
		
		@Override
		public int hashCode() {
			int result = 11;
			int rt = 7;
			result = rt * result + (getStreet()==null ? 0 : getStreet().hashCode());
			result = rt * result + (getZipCode()==null ? 0 : getZipCode().hashCode());
			result = rt * result + (getCity()==null ? 0 : getCity().hashCode());
			return result;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(getClass().getSimpleName() + "[");
			sb.append("street:" + getStreet() + ", ");
			sb.append("zipCode:" + getZipCode() + ", ");
			sb.append("city:" + getCity());
			sb.append("]");
			return sb.toString();
		}
		
		@Override
		public int compareTo(Address o) {
			String ad1 = this.toString();
			String ad2 = o.toString();
			//return ad1.compareTo(ad2);
			
			return toString().compareTo(o.toString());
		}
		
		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		
	}
}
