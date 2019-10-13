package Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;
import java.util.stream.Stream;

@WebServlet("/welcomeemployee")
public class WelcomeEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        //old way
//        for (Cookie cookie : cookies) {
//            String name = cookie.getName();
//            String value = cookie.getValue();
//            if (name.equals("employee_position")){
//                resp.getWriter().println("Welcome: " + value);
//            }
//        }

        //stream api way
        PrintWriter printWriter = resp.getWriter();
        Stream.of(cookies)
                .filter((Cookie cookie) -> cookie.getName().equals("employee_position"))
                .findFirst()
//                .ifPresent(new Consumer<Cookie>() {
//                    @Override
//                    public void accept(Cookie cookie) {
//                        printWriter.println("Welcome: " + cookie.getValue());
//                    }
//                })
                .ifPresent((Cookie cookie) -> printWriter.println("Welcome: " + cookie.getValue()));
    }
}
