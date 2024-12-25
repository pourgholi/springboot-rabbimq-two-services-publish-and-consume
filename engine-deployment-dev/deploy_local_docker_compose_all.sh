cd ../engine-identity && ./gradlew clean build
cd ../engine-core && ./gradlew clean build
cd ../engine-deployment-dev && docker-compose -f docker-compose-all-debug.yml up --build -d