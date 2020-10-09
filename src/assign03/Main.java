package assign03;
import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class Main {

    public static String askCity()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the city name: ");
        String city = sc.nextLine();
        System.out.print("\n");
        return city;
    }

    //this will return the conditions
    public static WeatherConditions weather()
    {
        Gson gson = new Gson();
        String conditions = data(askCity());
        return gson.fromJson(conditions, WeatherConditions.class);
    }

    //this function will receive the data from the API,
    //and return a readable string
    public static String data(String city)
    {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&apiKey=d34afb3fdfc325497c39164e8622731d";
        String charset = "UTF-8";
        String param1 = "value1";
        String param2 = "value2";
        String param3 = "value3";
        String responseBody = "";

        try {
            String query = //String.format("param1=%s+param2=%s+param3=%s",
                    URLEncoder.encode(param1, charset) + URLEncoder.encode(param2, charset) +
                            URLEncoder.encode(param3, charset);

            URLConnection connection = new URL(url + "&" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();

            Scanner scanner = new Scanner(response);
            responseBody = scanner.useDelimiter("\\A").next();


        }catch (MalformedURLException e)
        {

        }catch (IOException e)
        {

        }
        return responseBody.toString();
    }

    public static void main(String[] args) {

            System.out.println(weather());
    }
}
