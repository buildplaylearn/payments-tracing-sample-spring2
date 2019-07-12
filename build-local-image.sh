#!/bin/bash
PROJECT_ROOT=`dirname "$0"`
PROJECT_ROOT=`( cd "$PROJECT_ROOT" && pwd )`

cd $PROJECT_ROOT

docker build -t "payments-tracing-sample" $PROJECT_ROOT