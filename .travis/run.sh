set -e
#pdd --source=$(pwd) --verbose --file=/dev/null
mvn clean install -Pqulice,jacoco --errors --batch-mode