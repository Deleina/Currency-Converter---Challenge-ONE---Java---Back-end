import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiClient {

        private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";
        private String apiKey;

        public ApiClient(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getExchangeRate(String baseCurrency) throws IOException {

            URL url = new URL(API_BASE_URL + apiKey + "/latest/"+ baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();

                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }

                scanner.close();
                return response.toString();
            }else {
                throw new IOException("Failed to fetch data from API: " + responseCode);
            }

        }



}