#!/bin/sh

JAR_LOC=../jars
export JAR_LOC

CLASSPATH=${JAR_LOC}/autobc.jar:${JAR_LOC}/XliffBackConverter.jar:${JAR_LOC}/file-harvester-lib.jar:${JAR_LOC}/xslt-runner-lib.jar
export CLASSPATH

java -classpath ${CLASSPATH} com.sun.transtech.app.AutoBackConv $*

