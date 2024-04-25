import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name, email;

    Customer(String name, String email ){
        this.name = name;
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

}
