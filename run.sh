#!/bin/bash
cd ms-config
./mvnw clean package -DskipTests
cd ..
cd ms-eureka
./mvnw clean package -DskipTests
cd ..
cd ms-user
./mvnw clean package -DskipTests
cd ..
cd ms-transfers
./mvnw clean package -DskipTests
cd ..
cd ms-gateway
./mvnw clean package -DskipTests
cd ..
