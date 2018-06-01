package ch08;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by wsn on 2018/5/23.
 */
public class DictionaryDemo extends Dictionary {
    private Vector keys = new Vector();
    private Vector values = new Vector();

    public int size() {
        return keys.size();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public Object put(Object key, Object value) {
        keys.addElement(key);
        values.addElement(value);
        return key;
    }

    public Object get(Object key) {
        int index = keys.indexOf(key);

        if (index == -1) {
            return null;
        }
        return values.elementAt(index);
    }

    public Object remove(Object key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }
        keys.removeElementAt(index);
        Object returnval = values.elementAt(index);
        values.removeElementAt(index);
        return returnval;
    }

    public Enumeration keys() {
        return keys.elements();
    }

    public Enumeration elements() {
        return values.elements();
    }

    public static void main(String[] args) {
        DictionaryDemo dictionaryDemo = new DictionaryDemo();

        for(char c = 'a'; c<='z'; c++) {
            dictionaryDemo.put(String.valueOf(c), String.valueOf(c).toUpperCase());
        }

        char[] dd = {'a', 'e', 'i', 'o', 'u'};

        for(int i=0; i<dd.length; i++) {
            System.out.println("Uppercase: "+ dictionaryDemo.get(String.valueOf(dd[i])));
        }
    }
}
