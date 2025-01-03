#!/bin/bash

docker compose down

# Stop and remove all containers
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

# Remove all images
docker rmi starschematutorialdemo-sales-service
docker rmi starschematutorialdemo-products-service
docker rmi starschematutorialdemo-users-service
docker rmi starschematutorialdemo-db-service
docker rmi starschematutorialdemo-messaging-service
