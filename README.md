# Notes
- do not touch properties file
- run mvn quarkus:dev
- call http://localhost:8080/train to test your soulution
- do not modify getNextTrain() method in TrainStationService class

# Steps
1. Read and use 'service-not-available' property in StationResource class.
2. Set its default value to false.
3. Create 'StationConfig' interface in config package.
4. Map all properties starting with 'service' inside this file.
5. Field that maps 'max-delay-in-minutes' property, should be called 'maxDelay'.
6. Make subgroup for properties starting with 'service.train'.
7. Set default value for 'service.train.next-station' to 'n/a'.
8. Set 'station.reconstruction' property to true for dev profile. (Set it using %)
9. Set 'station.train.first-class-available' property to true for dev profile. (Set it using %)
9. Set 'station.max-delay-in-minutes' to 100 for test profile. (Set it with new properties file)

## Additional steps:
1. Try to set 'station.name' property in .env file with STATION_NAME=from_env_file
2. Try to set 'station.name' property before running quarkus:dev with 'EXPORT STATION_NAME=from_env_property'
3. Try to set 'station.name' property as java system property together with quarkus:dev command