FROM postgres:16

ENV POSTGRES_USER=kitchen_inventory
ENV POSTGRES_PASSWORD=kitchen_inventory
ENV POSTGRES_DB=kitchen_inventory

# Copy your SQL files into the init folder
# Any .sql or .sh files here will be executed in order on first startup
COPY ./ddl/ /docker-entrypoint-initdb.d/
