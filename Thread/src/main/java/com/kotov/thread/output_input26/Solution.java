package src.main.java.com.kotov.thread.output_input26;

/**
 * Адаптируй IncomeData к Customer и Contact.
 * Классом-адаптером является IncomeDataAdapter.
 * Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
 * UA Ukraine
 * RU Russia
 * CA Canada
 * Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
 * Обратите внимание на формат вывода фамилии и имени человека.
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        /*Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };*/
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);
        System.out.println(String.format("%s\n%s\n%s\n%s\n", incomeDataAdapter.getCountryName(), incomeDataAdapter.getCompanyName(), incomeDataAdapter.getName(), incomeDataAdapter.getPhoneNumber()));
    }

    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: Java

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }


    public static interface Customer {
        String getCompanyName();        //For example: Java

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder temp = new StringBuilder();
            String z = Integer.toString(data.getPhoneNumber());
            for (int i = 0; i < 10 - z.length(); i++)
            {
                temp.append(0);
            }
            temp.append(z);

            return "+" + data.getCountryPhoneCode() +"(" + temp.substring(0,3) + ")" + temp.substring(3,6) + "-" + temp.substring(6,8) + "-" + temp.substring(8);
        }
       /*@Override
        public String getCountryCode() {
            for (Map.Entry<String, String> m : countries.entrySet()) {
                if (m.getValue().equals(costumer.getCountryName())) {
                    return m.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return costumer.getCompanyName();
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
        public int getCountryPhoneCode() {
            String rst = contact.getPhoneNumber().substring(contact.getPhoneNumber().lastIndexOf('(') + 1, contact.getPhoneNumber().length()).replace("-", "").replace(")", "");
            return Integer.parseInt(rst);
        }

        @Override
        public int getPhoneNumber() {
            String rst = contact.getPhoneNumber().substring(contact.getPhoneNumber().lastIndexOf('+'), contact.getPhoneNumber().lastIndexOf('('));//.replace("-", "").replace(")", "");
            return Integer.parseInt(rst);
        }*/
    }
}