import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

import javax.servlet.ServletContext;

/**
 * Created by Ксения on 12.12.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RequestMirror requestMirror = new RequestMirror();

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(requestMirror), "/mirror");
        Logger log = Log.getLogger(Server.class);

        server.start();
        log.info("Server started");
        server.join();



    }
}
