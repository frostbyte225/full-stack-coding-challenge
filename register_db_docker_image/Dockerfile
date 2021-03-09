FROM mongo:3
ENV MONGO_INITDB_ROOT_USERNAME admin
ENV MONGO_INITDB_ROOT_PASSWORD api_pass
ENV MONGO_INITDB_DATABASE employee
# ENV POSTGRES_ROOT_HOST 0.0.0.0

COPY ./init-mongo.js /docker-entrypoint-initdb.d/

# USE IF YOU WOULD LIKE TO INSERT DATA INTO DOCKER IMAGE
# ADD data.sql /docker-entrypoint-initdb.d

# COPY my.cnf /usr/my.cnf
EXPOSE 27017