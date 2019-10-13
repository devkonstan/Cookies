package Weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("main")
    WeatherInfo weatherInfo;

    @SerializedName("weather")
    List<DescriptionInfo> description;

    @SerializedName("wind")
    WindInfo windInfo;

    @Override
    public String toString() {
        return "Weather{" +
                "weatherInfo=" + weatherInfo +
                ", description=" + description +
                ", windInfo=" + windInfo +
                '}';
    }
}
