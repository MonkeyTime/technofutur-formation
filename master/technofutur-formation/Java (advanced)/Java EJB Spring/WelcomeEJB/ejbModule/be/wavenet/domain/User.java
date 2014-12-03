package be.wavenet.domain;

public class User {

	private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isAdmin;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public void setId(int id) {
		this.id = id;
	}

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        User other = (User) o;

        return login.equals(other.login);
    }

    public int hashCode() {
        return login.hashCode();
    }

    public int getId() {
        return id;
    }
}
