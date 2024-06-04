package sk.ibm.demo.service;

import jakarta.enterprise.context.ApplicationScoped;
import sk.ibm.demo.exception.TrainException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class TrainStationService {

  @ConfigProperty(name = "min-prize")
  double minPrize;

  /**
   * 
   * @param money
   * @return
   * @throws TrainException 
   */
  public String getNextTrain(double money) throws TrainException {
    if (money < minPrize) {
      throw new TrainException("No way!");
    }

    return "Ok that is enough, your train is leaving in 20 minutes";
  }

}
