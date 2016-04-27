package development.alberto.com.exerciseparsingjson;

/**
 * Created by alber on 27/04/2016.
 */
public class Contacts {
    private String name, email, number;

    public Contacts(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
