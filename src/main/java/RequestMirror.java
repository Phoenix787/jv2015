import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ксения on 12.12.2015.
 */
public class RequestMirror extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("key");
        Map<String, Object> pageRequest = new HashMap<String, Object>();
        resp.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        pageRequest.put("key", message == null ? "" : message);
        resp.getWriter().println(pageRequest.get("key"));
    }

    private static Map<String, Object> createPageVariables(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", request.getParameterMap().toString());
        return map;
    }

}
