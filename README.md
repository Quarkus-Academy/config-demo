# Notes
- run mvn quarkus:dev
- call http://localhost:8080/train?user=your_name to test your soulution

# Steps
1. Add Logs with any messages into 'TrainStationService' class for INFO,DEBUG,TRACE levels.
2. Put some parameters to some messages.
3. Put CORRELATION_ID to MDC in 'getMyTrain()' method in 'StationResource' class. (use UUID.randomUUID().toString() as a value)
4. Put USER to MDC in 'getMyTrain()' method in 'StationResource' class. (Take user from method's arguments)
5. Modify format '%d{yyyy-MM-dd HH:mm:ss} %-5p [%c] (%t) %s%e%n' to include all values from MDC in logs (https://quarkus.io/guides/logging#logging-format).
6. Set TRACE log level for 'sk.ibm.demo.service' package.
7. What does 'j' option in quarkus development mode?
8. Enable json logging with 'quarkus-logging-json' extension, but disable json for dev profile.

## Additional steps
1. Modify existing log format to
  - log only source file name, not the entire package.
  - log only CORRELATION_ID from MDC
2. Enable logging to a file
