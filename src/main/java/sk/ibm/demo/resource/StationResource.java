package sk.ibm.demo.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import sk.ibm.demo.service.TrainStationService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import io.quarkus.logging.Log;

@Path("/train")
public class StationResource {

  @Inject
  TrainStationService svc;

  @ConfigProperty(name = "service-not-available", defaultValue = "false")
  boolean serviceNotAvailable;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getMyTrain(@QueryParam("user") String user) {

    // TODO: add MDC

    Log.info("Next schedule requested");

    if (serviceNotAvailable) {
      return "Service not available";
    }
    return svc.getNextTrain();
  }
}
