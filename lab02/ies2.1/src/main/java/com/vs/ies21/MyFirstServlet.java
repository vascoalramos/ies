package com.vs.ies21;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MyFirstServlet", urlPatterns = {"/hello-world"})
public class MyFirstServlet extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalendarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (username != null) {
                out.println("<h2>Welcome " + username + "</h2>");
                out.println("<h2>The time right now is : " + new Date() + "</h2>");
            } else {
                out.println("<h3>Please, do specify your name in the url, so that I can greet you as my friend!</h3>");
                out.println("<h3> URL: http://localhost:8080/ies21_war_exploded/hello-world?username=[NAME] </h3>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        //Do some other work
    }
}