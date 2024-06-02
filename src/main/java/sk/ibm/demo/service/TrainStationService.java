package sk.ibm.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import sk.ibm.demo.config.StationConfig;
import java.util.Optional;

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
    }

    // reconstruction
    if (config.reconstruction()) {
      sb.append("We are sorry, your train will be delayed due to a reconstruction." + System.lineSeparator());
    }

    // max delay
    if (config.maxDelay().isPresent()) {
      Optional<Integer> maxDelay = config.maxDelay();
      sb.append("Max delay: " + maxDelay.get() + " min" + System.lineSeparator());
    }

    // next station
    sb.append("Next stop: " + config.train().nextStation());

    return sb.toString();
  }

}
