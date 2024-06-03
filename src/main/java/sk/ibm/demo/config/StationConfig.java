package sk.ibm.demo.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;
import java.util.Optional;

@ConfigMapping(prefix = "station")
public interface StationConfig {

  String name();

  boolean reconstruction();

  @WithName("max-delay-in-minutes")
  Optional<Integer> maxDelay();

  Optional<String> adminPwd();

  Train train();

  public interface Train {

    boolean firstClassAvailable();

    @WithDefault("n/a")
    String nextStation();

    String niceMsg();

  }

}
