package hello;


import org.springframework.data.annotation.Id;


public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;

    public Customer() {}

    public Customer(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', age='%s']",
                id, firstName, lastName, age);
    }

}

