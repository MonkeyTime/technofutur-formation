package be.object.herit;

public class Person implements Comparable<Person> {

	private String name;
	private boolean married;
	private int age;
	
	public Person() {
		this("unknown", false, 0);
	}
	
	public Person(String name, boolean isMarried, int age) {
		setName(name);
		setMarried(isMarried);
		setAge(age);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)	return true;
		if(obj == null) return false;
		if(!getClass().equals(obj.getClass())) return false;
		
		Person pobj = (Person) obj;
		
		return getName().equals(pobj.getName()) &&
				isMarried()==pobj.isMarried() &&
				getAge()==pobj.getAge();
	}
	
	@Override
	public int hashCode() {
		int result = 15;
		int root = 31;
		
		result = root * result + getName().hashCode();
		result = root * result + (isMarried() ? 1 : 0);
		result = root * result + age;
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
	
}
