package Weather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/setLocalization")
public class WeatherServletPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // WeatherServletGet weatherServletGet = new WeatherServletGet();
        String city = req.getParameter("city");
        Cookie cookie = new Cookie("lokalizacja", city);
        resp.addCookie(cookie);
        resp.getWriter().println("Pobrano lokalizację!");

    }
}
