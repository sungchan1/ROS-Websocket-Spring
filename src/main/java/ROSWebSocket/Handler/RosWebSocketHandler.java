package ROSWebSocket.Handler;

import ROSWebSocket.domain.RosDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ROSWebSocket.service.RosService;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Controller
public class RosWebSocketHandler extends TextWebSocketHandler{
    private final RosService rosService;

    @Autowired
    public RosWebSocketHandler(RosService rosService) {
        this.rosService = rosService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 웹 소켓으로 받은 데이터 처리
        String payload = message.getPayload();
        // TODO: ROS 데이터 처리 로직 추가
        // 예시: 데이터 모델에 매핑하여 서비스로 전달
        RosDataModel rosData = new RosDataModel();
        // 데이터 모델에 payload를 매핑하는 코드
        rosService.processRosData(rosData);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // 연결 종료 시 처리
        // TODO: 연결 종료 처리 로직 추가
    }
}
