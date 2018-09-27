import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Address;
import model.Employee;

public class TestNotNull {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Employee soniWithFullDetails = new Employee("soni", 32, new Address("George Street", "TW18 4EZ"));

        Employee soniWithNullAddress = new Employee("soni", 32, null);

        Employee soniWithPostCodeNull = new Employee("soni", 32, new Address("GeorgeStreet", ""));

        System.out.println("The soniWithFullDetails" + mapper.writeValueAsString(soniWithFullDetails));
        System.out.println();
        System.out.println("The soniWithNullAddress" + mapper.writeValueAsString(soniWithNullAddress));
        System.out.println();
        System.out.println("The soniWithPostCodeNull" + mapper.writeValueAsString(soniWithPostCodeNull));
        System.out.println();
    }
}
