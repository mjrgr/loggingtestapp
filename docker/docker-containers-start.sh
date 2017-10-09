#!/bin/bash
set -u

CURRENT_DIR=$(dirname "$0")
export LOGS_DIR=/tmp/la/logs
export WORK_DIR=`echo $(cd $(dirname "$0")/..; pwd)`

# clean logs dir
rm -rf ${LOGS_DIR}
mkdir -p ${LOGS_DIR}

docker-compose -f ${WORK_DIR}/docker/docker-compose-la.yml up -d