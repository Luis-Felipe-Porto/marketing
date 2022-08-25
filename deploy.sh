echo "------------------ maven Build image"
./mvnw package -DskipTests

echo "------------------ Build"
docker-compose buildgiotn

echo "------------------ Run"
docker-compose up -d
