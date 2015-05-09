package br.com.asser.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Hello world!
 *
 */

@Path("/")
public class App {
	
	@GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
       return "<html> " + "<title>" + "Rest Page" + "</title>"
          + "<body><h1>" + "REST is Working!" + "</body></h1>" + "</html> ";
}
}
