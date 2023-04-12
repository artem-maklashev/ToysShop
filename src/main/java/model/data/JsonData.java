package model.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonData implements DataIO{
    private final String FILE_PATH = "shop.json";
    @Override
    public String loadData() {
        StringBuilder sb = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }

    @Override
    public void saveData(String data) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(data);
        }
    }
}
