package model.data;

import model.Shop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonData implements DataIO {
    private static final String FILE_PATH = "shop.json";
    private static final Formatter formatter = new JsonFormatter();

    @Override
    public Shop loadData() {
        try {
            String data = Files.readString(Paths.get(FILE_PATH));
            if (data.isEmpty()) {
                return new Shop();
            } else {
                return formatter.parseIn(data);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return new Shop();
        }
    }

    @Override
    public void saveData(Shop shop) throws IOException {
        String data = formatter.parseOut(shop);
        Files.writeString(Path.of(FILE_PATH), data);
    }

    @Override
    public void saveData(String data, String pathFile) throws IOException {
        Files.writeString(Path.of(pathFile), data);
    }
}
