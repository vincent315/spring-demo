package edit;

import entity.Address;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 属性编辑器
 */
public class AddressEditor extends PropertyEditorSupport {
    public AddressEditor(){
        super();
    }
    @Override
    public String getAsText() {
        Address address = (Address) getValue();
        return "[" + address.getCity() + "-" + address.getProvince() + "]";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("\\[(.*)-(.*)\\]");
        Matcher matcher = pattern.matcher(text);
        if(matcher.matches()){
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            Address address = new Address();
            address.setCity(group1);
            address.setProvince(group2);
            setValue(address);
        }

    }
}
