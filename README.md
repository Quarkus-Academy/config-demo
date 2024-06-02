# Notes
- run mvn quarkus:dev
- call http://localhost:8080/train to test your soulution
- do not modify getNextTrain() method in TrainStationService class

# Steps
1. Read and use 'service-not-available' property in StationResource class.
2. Set its default value to false.
3. Create 'StationConfig' interface in 'config' package.
  - Map all properties starting with 'service' inside this file.
  - Field that maps 'max-delay-in-minutes' property, should be called 'maxDelay'.
  - Make subgroup for properties starting with 'service.train' called Train.
  - Set default value for 'service.train.next-station' to 'n/a'.
  - In 'StationConfig' map property called 'station.admin-pwd'. Make it optional.
4. Use newly created 'StationConfig' bean in 'TrainStationService' class.
5. Set 'station.admin-pwd' property in .env file with STATION_ADMIN-PWD=strong
6. Set 'station.reconstruction' property to 'true' for dev profile. (Set it using %)
7. Set 'station.train.first-class-available' property to 'true' for dev profile. (Set it using %)
8. Set 'station.max-delay-in-minutes' to 100 for test profile. (Set it with new properties file)

## Additional steps:
1. Set 'station.name' property
  - in .env file with STATION_NAME=from_env_file
  - before running quarkus:dev with 'EXPORT STATION_NAME=from_env_property'
  - as java system property together with quarkus:dev command
3. Set namingStrategy for ConfigMapping annotation to SNAKE_CASE and fix the issues.
4. Try to add any new property to properties file and not map it in the class.