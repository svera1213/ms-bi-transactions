# ms-bi-transactions
Backend microservices for bank transfers (example)

### Requirements:
- Docker

### Architecture:
- Spring boot
- Docker
- Postgres
- Redis

### Run `rm  ~/.docker/config.json` before

### 1) Build .jar files
`./run.sh`

### 2) Build and run containers in the following order:

1) `sudo docker compose up -d ms_config`
2) `sudo docker compose up -d ms_eureka`
3) `sudo docker compose up -d ms_user_db ms_transfers_db ms_auth_db cache`
4) `sudo docker compose up -d ms_user ms_transfers`
5) `sudo docker compose up -d ms_auth`
6) `sudo docker compose up -d ms_gateway`

### 3) Check that all containers are running `docker compose ps`

### General commands

- Bring containers down `docker compose down`
- Show logs from container `docker compose logs -f ms_config`
- Show ip of container `docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' ms_config`
- Enter redis terminal `docker exec -it ms-bi-transactions-cache-1 redis-cli`
