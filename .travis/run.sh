set -e
#pdd --source=$(pwd) --verbose --file=/dev/null
mvn clean verify -Pqulice,jacoco --errors --batch-mode sonar:sonar