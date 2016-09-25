#!/bin/bash
#if test -z "$MONGODB_PASSWORD"; then
#    echo "MONGODB_PASSWORD not defined"
#    exit 1
#fi

auth="-u user -p password"

# MONGODB USER CREATION
(
echo "setup mongodb auth"
create_user="if (!db.getUser('user')) { db.createUser({ user: 'user', pwd: 'password', roles: [ {role:'readWrite', db:'restdb'} ]}) }"
until mongo restdb --eval "$create_user" || mongo restdb $auth --eval "$create_user"; do sleep 5; done
killall mongod
sleep 1
killall -9 mongod
) &

# INIT DUMP EXECUTION
#(
#if test -n "$INIT_DUMP"; then
#    echo "execute dump file"
#	until mongo restdb $auth $INIT_DUMP; do sleep 5; done
#fi
#) &

#echo "start mongodb without auth"
#chown -R mongodb /data/db
#gosu mongodb mongod "$@"

#echo "restarting with auth on"
sleep 5
exec gosu restdb mongod --auth "$@"
