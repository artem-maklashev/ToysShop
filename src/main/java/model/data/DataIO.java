package model.data;

import java.io.IOException;

public interface DataIO {
    String loadData();
    void saveData(String data) throws IOException;
}
