echo "------------------ Down"
docker-compose down

echo "------------------ maven Build image"


echo "------------------ Build"
docker-compose build

echo "------------------ Run"
docker-compose up -d --build