package ROSWebSocket.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BagControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBagList()  {
        BagController bagController = new BagController();

        List<String> bagList = bagController.getBagList();
        Assertions.assertThat(bagList).contains("test2.bag");


    }

}


