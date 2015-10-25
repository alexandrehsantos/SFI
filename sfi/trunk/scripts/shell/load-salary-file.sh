#!/bin/bash
set -eu

PROCESS_NAME="Load Salary File"

PATH_BIN="/opt/sfi/bin/"
JAR_NAME="sfi.jar"

CMD=$PATH_BIN$JAR_NAME

function about(){
	echo "Executando processo: $PROCESS_NAME"
}

function exec(){
	java -jar $CMD load-file
	exit $?
}

about
exec
