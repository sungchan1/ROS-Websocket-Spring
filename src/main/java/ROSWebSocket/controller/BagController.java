package ROSWebSocket.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BagController {

    @GetMapping("/bag-list")
    @ResponseBody
    public List<String> getBagList() {
        // Specify the directory where bag files are stored
        String bagDirectoryPath = "rosbag"; // 상대 경로

        // Get a list of bag files in the directory
        try {
            ClassPathResource classPathResource = new ClassPathResource(bagDirectoryPath);
            File bagDirectory = classPathResource.getFile();
            File[] bagFiles = bagDirectory.listFiles((dir, name) -> name.endsWith(".bag"));

            if (bagFiles != null) {
                // Extract file names from File objects
                return Arrays.stream(bagFiles)
                        .map(File::getName)
                        .collect(Collectors.toList());
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리 필요
            return null;
        }
    }

}