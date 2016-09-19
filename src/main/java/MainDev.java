import com.example.rest.HelloWorldEndpoint;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * Created by joachimhuber on 16.09.2016.
 */
public class MainDev {
    public static void main(String... args) throws Exception {
        Logger logger = Logger.getLogger(MainDev.class);
        logger.info("Startin Application in Development Mode");
        // Instantiate the container
        Swarm swarm = new Swarm();

        // Create one or more deployments
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

        // Add resource to deployment
        deployment.addClass(HelloWorldEndpoint.class);
        deployment.addAllDependencies(true);
        swarm.start();
        swarm.deploy(deployment);
    }
}
