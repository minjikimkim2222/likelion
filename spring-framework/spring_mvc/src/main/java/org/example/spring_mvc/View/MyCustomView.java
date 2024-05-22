package org.example.spring_mvc.View;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.io.PrintWriter;
import java.util.Map;

public class MyCustomView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 뷰가 만들어질 때, response에 담아 넘겨줄 것이기에..
        response.setContentType(getContentType());
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h1>Custom View Content</h1>");
        out.print("<p>jsp등장 전에 뷰를 만들려면 이렇게 하나하나했어야 했어.. 너무 힘들지요.. </p>");
        out.print("</body></html>");

        out.close();
    }
}
