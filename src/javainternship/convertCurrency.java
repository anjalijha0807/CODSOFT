package currencyConvertor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class convertCurrency {
    private static final String CODE_API_KEY = "6f28f703fe49e09fd4f8481f";

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base currency code for conversion:");
        String referenceCurrency = sc.nextLine().toUpperCase();
        System.out.print("Enter the code for the currency to be converted in:");
        String convertedCurrency = sc.nextLine().toUpperCase();

        double currencyConvRate = getConversionRate(referenceCurrency, convertedCurrency);

        if (currencyConvRate == -1) {
            System.out.println("Unable to get the exchange rates. Please make sure you are using the correct API key.Do check that your input currency code is valid");
            sc.close();
            return;
        }

        System.out.print("Enter the amount for conversion from " + referenceCurrency + " to " + convertedCurrency+":" );
        double conversionAmount = sc.nextDouble();
        double convertedAmount = conversionAmount * currencyConvRate;
        System.out.println("The desired converted amount from "+referenceCurrency +" to "+convertedCurrency +" is: " + convertedAmount + " " + convertedCurrency);

        sc.close();
    }

    private static double getConversionRate(String primaryCurrency, String convertedCurrency) {
        try {
            URL apiurl = new URL("https://open.er-api.com/v6/latest/" + primaryCurrency + "?apikey=" + CODE_API_KEY);
            HttpURLConnection connectionStatus = (HttpURLConnection) apiurl.openConnection();

            try {
                if (connectionStatus.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    Scanner input = new Scanner(connectionStatus.getInputStream());
                    StringBuilder responseReceived = new StringBuilder();

                    while (input.hasNextLine()) {
                        responseReceived.append(input.nextLine());
                    }

                    input.close();

                    String jsonResponse = responseReceived.toString();
                    return passExchangeRate(jsonResponse, convertedCurrency);
                } else {
                    System.out.println("Failed to fetch exchange rates for desired currency conversion. HTTP response code: " + connectionStatus.getResponseCode());

                    // Print error response
                    Scanner error = new Scanner(connectionStatus.getErrorStream());
                    while (error.hasNextLine()) {
                        System.out.println(error.nextLine());
                    }

                    return -1;
                }
            } finally {
                connectionStatus.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static double passExchangeRate(String jsonResponse, String targetCurrency) {
        try {
            String keyRate = "\"" + targetCurrency.toLowerCase() + "\":";
            int indexRate = jsonResponse.toLowerCase().indexOf(keyRate);

            if (indexRate != -1) {
                int startingIndex = indexRate + keyRate.length();
                int indexEnd = jsonResponse.indexOf(",", startingIndex);
                String rateString = jsonResponse.substring(startingIndex, indexEnd);
                return Double.parseDouble(rateString);
            } else {
                System.out.println("Failed to parse exchange rate for target currency: " + targetCurrency);
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while parsing exchange rate value.");
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while parsing exchange rate.");
            e.printStackTrace();
            return -1;
        }
    }
}
	            
	

		
	
		
	
