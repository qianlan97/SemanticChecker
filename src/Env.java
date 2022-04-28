// Author:
// Nan Chen & Xinyu Li

import java.util.HashMap;
import java.util.Map;

public class Env
{
    private final Map<String, Object> table;
    public Env prev;

    public Env(Env prev) {
        this.table = new HashMap<>();
        this.prev = prev;
    }

    public void Put(String name, Object value) {
        if (table.containsKey(name)) {
            System.out.println("key " + name + " is already added");
        } else {
            table.put(name, value);
        }
    }

    public Object Get(String name) {
        Env tempEnv = prev;
        if (table.containsKey(name)) {
            return table.get(name);
        }
        while (tempEnv != null) {
            if (tempEnv.table.containsKey(name)) {
                return tempEnv.table.get(name);
            }
            tempEnv = tempEnv.prev;
        }
        return null;
    }
}
