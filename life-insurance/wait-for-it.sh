#!/bin/bash

echo "⏳ Waiting for MySQL to be ready at db:3306..."

while ! echo > /dev/tcp/db/3306 2>/dev/null; do
  echo "MySQL not ready yet. Retrying in 2s..."
  sleep 2
done

echo "✅ MySQL is ready - starting Spring Boot app"
exec java -jar app.jar
