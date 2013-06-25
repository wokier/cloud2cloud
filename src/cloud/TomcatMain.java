package cloud;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.google.common.base.Strings;

public class TomcatMain {

    public static void main(String[] args) throws ServletException, LifecycleException {

	Tomcat tomcat = new Tomcat();

	String webPort = System.getenv("PORT");
	if (Strings.isNullOrEmpty(webPort)) {
	    webPort = "8080";
	}
	tomcat.setPort(Integer.valueOf(webPort));

	String warAbsolutePath = new File("war").getAbsolutePath();
	tomcat.addWebapp("/", warAbsolutePath);
	System.out.println("Configuring tomcat app with basedir: " + warAbsolutePath);

	tomcat.start();
	tomcat.getServer().await();
    }
}
