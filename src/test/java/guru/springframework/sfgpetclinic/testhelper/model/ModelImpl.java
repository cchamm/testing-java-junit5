package guru.springframework.sfgpetclinic.testhelper.model;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;

public class ModelImpl implements Model {
    // a map field
    private HashMap<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    public Object getByKey(String key) {
        return map.get(key);
    }

    public Integer size() {
        return map.size();
    }

    @Override
    public void addAttribute(Object o) {
        throw new NotImplementedException("");
    }
}
