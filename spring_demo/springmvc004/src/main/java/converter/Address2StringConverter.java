package converter;

import entity.Address;
import org.springframework.core.convert.converter.Converter;

public class Address2StringConverter implements Converter<Address,String> {
    public String convert(Address address) {
        return "[" + address.getCity() + "-" + address.getProvince() + "]";
    }
}
