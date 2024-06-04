package sk.ibm.demo.resource;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sk.ibm.demo.exception.TrainException;
import sk.ibm.demo.service.TrainStationService;
import java.util.UUID;
import org.jboss.logmanager.MDC;

@Path("/train")
public class StationResource {

  @Inject
  TrainStationService svc;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getMyTrain(@QueryParam("money") double money) {
    Log.info("Next schedule requested");

    try {
      String train = svc.getNextTrain(money);
      Log.infov("Train: {0}", train);
    } catch (TrainException e) {
      Log.error(e);
      return Response.ok("Not enough money!").build();
    }
    return Response.status(201).build();
  }
}
