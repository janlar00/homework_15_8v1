package guru.qa;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import guru.qa.jsonClasses.JsonDeserialization;

public class JsonDeserializeAndValuesCheckTest {

    @Test
    void jsonDeserializeAndValuesCheckTest() throws Exception {
        JsonDeserialization.doDeserialize();
        assertThat(JsonDeserialization.FishMarket.getId()).isEqualTo(2);
        assertThat(JsonDeserialization.FishMarket.getName()).isEqualTo("Salmon");
        assertThat(JsonDeserialization.Supplier.getName()).isEqualTo("Atlantic Salmon Ltd");
        assertThat(JsonDeserialization.Supplier.getAmountKg()).isEqualTo(200);
        assertThat(JsonDeserialization.Department.getName()).isEqualTo("See fish");
    }
}
