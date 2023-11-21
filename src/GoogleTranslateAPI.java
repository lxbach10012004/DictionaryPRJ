import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GoogleTranslateAPI {

    public static void translate() throws IOException {
        String url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=";
        String src;
        String des;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. English to Vietnamese");
        System.out.println("2. Vietnamese to English");
        System.out.print("Your choice: ");
        String choice = sc.nextLine();
        if (choice.equals("2")) {
            src = "vi";
            des = "en";
        } else {
            src = "en";
            des = "vi";
        }
        url += src + "&tl=" + des + "&dt=t&q=";
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[] words = text.split(" ");
        for (String word : words) {
            url += word + "%20";
        }

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        String jsonString = response.toString();
        // Find the index of the first double quote
        int firstQuoteIndex = jsonString.indexOf('"');

        // Find the index of the second double quote
        int secondQuoteIndex = jsonString.indexOf('"', firstQuoteIndex + 1);

        // Extract the substring between the first and second double quotes
        String extractedWord = jsonString.substring(firstQuoteIndex + 1, secondQuoteIndex);

        System.out.println("Translation: " + extractedWord);
    }
}
