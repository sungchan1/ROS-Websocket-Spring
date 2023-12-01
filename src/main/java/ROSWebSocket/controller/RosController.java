package ROSWebSocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ROSWebSocket.service.RosService;
import org.springframework.stereotype.Controller;


@Controller
public class RosController {
    private final RosService rosService;

    @Autowired
    public RosController(RosService rosService) {
        this.rosService = rosService;
    }

}
