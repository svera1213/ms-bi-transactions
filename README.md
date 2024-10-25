# ms-bi-transactions
Backend microservices for bank transfers (example)

### 1)
`./run.sh`

### 2)
`sudo docker compose up -d ms_config`

`sudo docker compose up -d ms_eureka`

`sudo docker compose up -d ms_user_db ms_transfers_db ms_auth_db`

`sudo docker compose up -d ms_user ms_transfers`

`sudo docker compose up -d ms_auth`

`sudo docker compose up ms_gateway`

### General
`docker compose ps`

`docker compose logs -f ms_config`

`docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' ms_config`

`rm  ~/.docker/config.json `
