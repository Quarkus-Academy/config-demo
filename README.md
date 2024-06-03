# Notes
- run mvn quarkus:dev
- call http://localhost:8080/train to test your soulution

# Steps
1. Add Logs with any logs messages into 'TrainStationService' class for INFO,DEBUG,TRACE levels.
2. Put some parameters to some messages.
3. Put CORRELATION_ID to MDC in 'getMyTrain()' method in 'StationResource' class.
4. Put USER to MDC in 'getMyTrain()' method in 'StationResource' class. (Take user from method's arguments)
5. Modify log format to include all values from MDC in logs