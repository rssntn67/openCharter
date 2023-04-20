package OpenCharterDB;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TestInfo {

    @Test
    public void contextLoads() throws Exception {

        URL url = new URL("http://localhost:9001/info");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        int responseCode = http.getResponseCode();

        assertEquals(HttpURLConnection.HTTP_OK, responseCode);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);


        String s= "{\"lat\":13.0,\"lon\":14.0,\"idnave\":1,\"data\":\"2023-04-20T20:59:06.411508\"}";

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = s.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());

        }
    }
}