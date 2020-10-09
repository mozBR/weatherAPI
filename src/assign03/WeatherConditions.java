package assign03;
import com.google.gson.annotations.SerializedName;
import java.util.*;

public class WeatherConditions{
    int id;
    String name;

    //this will map what's related to main on the string
    //that comes from the API, using the serialized name.
    //the map will be populated with this info
    @SerializedName("main")
    public Map<String, Float> _conditions = new HashMap<String, Float>();

    public String toString()
    {
        return "id: " + id + "\n" + "Name: " + name + "\n" + "Current conditions: " + _conditions;
    }
}
