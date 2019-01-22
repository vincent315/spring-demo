package converter;


import entity.Address;
import org.springframework.core.convert.converter.Converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String2AddressConverter implements Converter<String, Address> {

    public Address convert(String source) {
        Pattern pattern = Pattern.compile("\\[(.*)-(.*)\\]");
        Matcher matcher = pattern.matcher(source);
        if(matcher.matches()){
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            Address address = new Address();
            address.setCity(group1);
            address.setProvince(group2);
            return address;
        }else{
            throw  new RuntimeException("地址转换失败");
        }
    }
}
