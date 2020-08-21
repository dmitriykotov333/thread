package src.main.java.com.kotov.thread.output_input28;


import java.util.HashMap;
import java.util.Map;

/**
 * Адаптировать Customer и Contact к RowItem.
 * Классом-адаптером является DataAdapter.
 *
 * Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
 * UA Ukraine
 * RU Russia
 * CA Canada
 */
public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {

    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: Java

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: Java

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> m : countries.entrySet()) {
                if (m.getValue().equals(customer.getCountryName())) {
                    return m.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().lastIndexOf(',') + 1, contact.getName().length()).replace(" ", "");
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0, contact.getName().lastIndexOf(','));
        }

        @Override
        public String getDialString() {
            return "callto://+" + contact.getPhoneNumber().replaceAll("[\\D]", "");
        }
    }
}