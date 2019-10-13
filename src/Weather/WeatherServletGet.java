package Weather;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@WebServlet("/getTemperature")
public class WeatherServletGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeatherServletPost weatherServletPost = new WeatherServletPost();
        PrintWriter printWriter = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lokalizacja")) {
                //printWriter.println(cookie.getValue());
                Weather weather = getWeather(cookie.getValue());
                printWriter.println(weather);
            }
        }
    }

    public Weather getWeather(String location) throws IOException {
        URL url = new URL(String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=175f106adf71700578947733aa966434", location));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("User-Agent", "Mozilla/5.0");
        int status = con.getResponseCode();
        System.out.println(status);
        Gson gson = new Gson();
        //zczytujemy odpowiedź z serwera pogodowego
        String response = readResponse(con);
        Weather weather = gson.fromJson(response, Weather.class);
        con.disconnect();
        return weather;
    }

    private String readResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader((InputStream) con.getContent()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        return content.toString();
    }
}
