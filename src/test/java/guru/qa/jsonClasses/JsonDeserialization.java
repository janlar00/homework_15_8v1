package guru.qa.jsonClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

public class JsonDeserialization {
    public static void doDeserialize() throws Exception {
        InputStream json = Thread.currentThread().getContextClassLoader().getResourceAsStream("fishMarket.json");
        ObjectMapper objectMapper = new ObjectMapper();
        FishMarket fishMarket = objectMapper.readValue(json, FishMarket.class);
        System.out.println(fishMarket);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FishMarket {
        private static int id;
        private static String name;

        @JsonProperty("dep")
        private Department department;

        private List<Supplier> supplier;

        public List<Supplier> getSupplier() {
            return supplier;
        }

        public void setSupplier(List<Supplier> supplier) {
            this.supplier = supplier;
        }

        public static String getName() {
            return name;
        }

        public void setName(String name) {
            FishMarket.name = name;
        }

        public static int getId() {
            return id;
        }

        public void setId(int id) {
            FishMarket.id = id;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "FishMarket {"
                    + "id='" + id + '\'' + ", name='" + name + '\''
                    + '}';
        }
    }

    public static class Department {
        private static String name;

        public static String getName() {
            return name;
        }

        public void setName(String name) {
            Department.name = name;
        }
    }

    public static class Supplier {
        private static String name;
        private static int amountKg;

        public static int getAmountKg() {
            return amountKg;
        }

        public void setAmountKg(int amountKg) {
            Supplier.amountKg = amountKg;
        }

        public static String getName() {
            return name;
        }

        public void setName(String name) {
            Supplier.name = name;
        }
    }
}
