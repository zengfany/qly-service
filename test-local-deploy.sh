#!/bin/bash
mkdir -p ~/qly-service/bin ~/qly-service/conf
#backup previous version
#tar -cvf qly-service.tar ~/qly-service || { echo "tar failed"; exit 1; }   
#mv qly-service.tar /tmp || { echo "mv failed"; exit 1; }
cp ./target/qly-service-*-jar-with-dependencies.jar ~/qly-service/bin/qly-service.jar 
cp src/main/java/com/qly/conf/qly-service-config-local.cfg ~/qly-service/conf 
kill -9 `ps -e | grep qly-service | grep java | awk '{print $1}'` 
cd ~/qly-service
nohup java -jar ./bin/qly-service.jar & 
exit 0

