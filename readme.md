# Genesys Test

Genesys Tests: UI Based Tests for Ryana Air Booking Flights.

## Prerequisites

Git/Docker installed

## Usage
Clone the repository

```bash
# clone repository
git clone https://github.com/jrpally/Genesys-Tests.git .

# Build the docker with any name (maven-rene)
docker build -t maven-rene .

# Run repository and enable port 4444 for Selenium
docker run -d -p 4444:4444 --shm-size="2g" maven-rene:latest

# Get the name ID for docker
docker ps

# output example
# CONTAINER ID   IMAGE               COMMAND                  CREATED          STATUS          PORTS                              NAMES
# aaef55364f48   maven-rene:latest   "/opt/bin/entry_poin…"   21 minutes ago   Up 21 minutes   0.0.0.0:4444->4444/tcp, 5900/tcp   condescending_gauss

# To Run the test:
docker exec aaef55364f48 mvn test

```

## Remarks:
User can see in command line two test passed, related to the E2E flow for flight reservation. More details can be discussed. Given the short amount of time solution has not been optimized.