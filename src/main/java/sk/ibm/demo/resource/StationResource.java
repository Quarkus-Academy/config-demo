package sk.ibm.demo.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sk.ibm.demo.service.TrainStationService;

@Path("/train")
public class StationResource {

  @Inject
  TrainStationService svc;

  // TODO
  boolean serviceNotAvailable;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    if (serviceNotAvailable) {
      return "Service not available";
    }
    return svc.getNextTrain();
  }
}
