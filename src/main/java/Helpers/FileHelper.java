package Helpers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileHelper {
    private String _filePath;

    public FileHelper(String filePath) {
        _filePath = filePath;
    }


    public List<String> GetAllLineAsList() {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(_filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  lines;
    }

}

