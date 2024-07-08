package in.at;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIResponseHeaders {
    public static void main(String[] args) {
        String urlString = "https://www.flipkart.com/";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            System.out.println("Response Code: " + responseCode);
            if (responseCode == 200) { // Success
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                // close the connections
                in.close();
                connection.disconnect();
                // print the content
                System.out.println(content.toString());
            } else {
                System.out.println("Failed to fetch data. HTTP Response Code: " + responseCode);
                System.out.println("Response Message: " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
