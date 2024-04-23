import org.json.JSONObject;
import java.io.IOException;

public class CurrencyConverter {

    private ApiClient apiClient;

    public CurrencyConverter(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    public double convert(String fromCurrency, String toCurrency, double amount) throws IOException {
        String exchangeData = apiClient.getExchangeRate(fromCurrency);
        JSONObject jsonObject = new JSONObject(exchangeData);
        JSONObject rates = jsonObject.getJSONObject("conversion_rates");

        double exchangeRate = rates.getDouble(toCurrency);
        return exchangeRate * amount;
    }
}
