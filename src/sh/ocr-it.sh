#!/bin/bash


if [ $# -ne 1 ]
then
    echo "Usage: `basename $0` {file path}"
    exit 1
fi

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/lib
if [[ $OSTYPE != darwin* ]]
then 
    if [ -z "$TESSDATA_PREFIX" ]; then export TESSDATA_PREFIX="~/1/fun/ocr/tesseract/tesseract-ocr/"; fi
fi 

TMP_FILE="/tmp/`date +%s%N`" 

./src/sh/textcleaner -f 60 $1 "$TMP_FILE.jpg"
tesseract "$TMP_FILE.jpg" $TMP_FILE > /dev/null 2>&1

rm "$TMP_FILE.jpg"
cat "$TMP_FILE.txt"
