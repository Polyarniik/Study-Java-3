package repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {

    public void writeProfile(String name, String email, String password) throws IOException {
        com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(
                new FileWriter("/home/polyarniik/Projects/ITIS/JAVA/Study-Java-3/homework7/src/main/data/data.csv", true));
        String[] arr = new String[]{name, email, String.valueOf(password.hashCode())};
        writer.writeNext(arr);
        writer.flush();
        writer.close();
    }
}
