package homework5core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AppData {
    private String[] header;
    private int[][] data;
    private FileReader file;

    public AppData(FileReader fileReader) {
        this.file = fileReader;
    }

    public AppData(FileWriter file) {}

    public void setHeadersAndData(String[] headerString) {
        this.header = headerString;
        this.data = getData();
    }

    public String[] getHeader() {
        return header;
    }

    public String getHeaderString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < getHeader().length; i++) {
            if (getHeader().length - 1 != i) {
                str.append(getHeader()[i]).append(";");
            }
            else {
                str.append(getHeader()[i]).append("\n");
            }
        }
        return str.toString();
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String separatingGetData() {
        StringBuilder temp = new StringBuilder();
        for (int[] datum : data) {
            for (int j = 0; j < datum.length; j++) {
                if (j != data.length - 1)
                    temp.append(datum[j]).append(";");
                else temp.append(datum[j]);
            }
            temp.append("\n");
        }
        return temp.toString();
    }

    public FileReader getFileReader() {
        return file;
    }

    public void readAll() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(getFileReader());
        ArrayList<String> tempList = new ArrayList<>();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            tempList.add(str);
        }
        bufferedReader.close();
        getFileReader().close();
        String[][] arrStr = new String[tempList.size() - 1][];
        for (int i = 0; i < tempList.size(); i++) {
            if (i == 0) {
                this.header = tempList.get(i).split(";");
            } else {
                arrStr[i - 1] = tempList.get(i).split(";");
            }
        }
        this.data = new int[arrStr.length][arrStr[0].length];
        for (int a = 0; a < arrStr.length; a++) {
            for (int b = 0; b < arrStr[a].length; b++) {
                this.data[a][b] = Integer.parseInt(arrStr[a][b]);
            }
        }
    }
}
