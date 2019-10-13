package Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeCarBrandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("brand")){
                Brand brand = Brand.getBrand(cookie.getValue());
                printWriter.printf("%s -> %s\n", brand.getBrandName(), brand.getColor());

//                switch (cookie.getValue()) {
//                    case "VW":
//                        printWriter.println("VW -> niebieski");
//                        break;
//                    case "Skoda":
//                        printWriter.println("Skoda -> zielony");
//                        break;
//                    case "Seat":
//                        printWriter.println("Seat -> czerwony");
//                        break;
//                }
            }
        }
    }
}
