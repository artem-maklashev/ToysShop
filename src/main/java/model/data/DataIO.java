package model.data;

import model.Shop;

import java.io.IOException;

public interface DataIO {
    Shop loadData();
    void saveData(Shop shop) throws IOException;
    void saveData(String data, String pathFile) throws IOException;
}
