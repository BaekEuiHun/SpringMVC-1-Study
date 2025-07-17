package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---------전체 파라미터 조회---------------------");
        req.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName ->
                        System.out.println(paramName + "=" + req.getParameter(paramName)));
        System.out.println("---------단일 파라미터 조회---------------------");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("username = " + username);
        String[] usernames = req.getParameterValues("username");
        System.out.println("------------이름이 같은 복수 파라미터 조회-------------");
        for (String name : usernames) {
            System.out.println("username = " + name);

        }
        resp.getWriter().write("ok");
    }
}
