if test $# -ne 1
then 
	echo "Uso: ./dockerhub.sh user"
	exit 1
fi

docker build -f server/Dockerfile -t $1/server server/
docker build -f planner/Dockerfile -t $1/planner planner/
pack build $1/weatherservice --path weatherservice/ --builder gcr.io/buildpacks/builder:v1
mvn compile -f toposervice/pom.xml jib:build -Dimage=$1/toposervice

docker push $1/server
docker push $1/planner
docker push $1/weatherservice
