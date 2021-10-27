#!/bin/sh
# 程序的根目录
basedir=/usr/local/familyhelper-clannad

PID=$(cat "$basedir/familyhelper.pid")
kill "$PID"
