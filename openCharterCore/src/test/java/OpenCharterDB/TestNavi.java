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
class TestNavi {

	@Test
	public void contextLoads() throws Exception {

		URL url = new URL("http://localhost:9001/navi");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		int responseCode = http.getResponseCode();

		assertEquals(HttpURLConnection.HTTP_OK, responseCode);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String s = "{\"name\":\"Costa\",\"tipo\":\"Crociera\",\"nazione\":\"Italia\",\"portorif\":\"Napoli\",\"armatore\":\"MicheleBottiglieri\",\"proprietario\":\"MicheleBottiglieri\",\"lung\":20.0,\"larg\":50.0,\"alt\":3.0}";
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