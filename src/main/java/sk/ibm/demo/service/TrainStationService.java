package sk.ibm.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import sk.ibm.demo.config.StationConfig;
import java.util.Optional;
import io.quarkus.logging.Log;

@ApplicationScoped
public class TrainStationService {

  @Inject
  StationConfig config;

  public String getNextTrain() {
    StringBuilder sb = new StringBuilder();
    sb.append("### Station " + config.name() + " ###" + System.lineSeparator());
    sb.append("Hello, your train is leaving in 1 hour." + System.lineSeparator());

    // first class
    if(config.train().firstClassAvailable()) {
      sb.append("First class now available! Please consider ticked upgrade." + System.lineSeparator());
      Log.info("First class is not available");
    }

    // reconstruction
    if (config.reconstruction()) {
      sb.append("We are sorry, your train will be delayed due to a reconstruction." + System.lineSeparator());
    }

    // max delay
    if (config.maxDelay().isPresent()) {
      Optional<Integer> maxDelay = config.maxDelay();
      sb.append("Max delay: " + maxDelay.get() + " min" + System.lineSeparator());
      Log.debugv("Max delay: {0}", maxDelay.get());
    }

    // next station
    sb.append("Next stop: " + config.train().niceMsg() + System.lineSeparator());

    if (config.adminPwd().isPresent()) {
      sb.append("Admin pwd: " + config.adminPwd().get());
      Log.tracev("Admin pwd is present: {0}", config.adminPwd().get());
    }

    return sb.toString();
  }

}
