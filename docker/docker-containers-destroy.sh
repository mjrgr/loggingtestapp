#!/bin/bash
docker rm -vf $(docker ps -a -q)
echo "All Docker containers removed"

docker volume prune -f
echo "All Docker volumes removed"