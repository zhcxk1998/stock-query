package shares.fetch;

import javafx.collections.ObservableList;
import shares.IGetData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * This method is to get the data of shares
 *
 * @param data The string of shares data
 * @return shares data or error message
 * @throws Exception
 */

public class GetData implements IGetData {
    public String getData(String http) throws Exception {
        URL url = new URL(http);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
        String str = "";
        StringBuffer data = new StringBuffer();
        while ((str = reader.readLine()) != null) {
            data.append(str.split("\"")[1] + "\n");
        }
        return (data.toString().length() == 1) ? "FAILED" : data.toString();
    }
}
