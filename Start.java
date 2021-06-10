package homework5core;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Start {
    public static void main(String[] args) throws IOException {
        AppData appData = new AppData(new FileWriter("users.csv"));
        appData.setHeadersAndData(new String[]{" Username ", " Email ", " Phone "});
        appData.setData(new int[][]{{300, 600, 100}, {400, 700, 102}, {500, 800, 103}});
        FileWriter fileWriterInFile = new FileWriter("users.csv", false);
        fileWriterInFile.write(appData.getHeaderString());
        fileWriterInFile.write(appData.separatingGetData());
        fileWriterInFile.close();

        AppData appDataRead = new AppData(new FileReader("users.csv"));
        appDataRead.readAll();
        System.out.println(Arrays.toString(appDataRead.getHeader()));
        System.out.println(Arrays.deepToString(appDataRead.getData()));

    }

}

