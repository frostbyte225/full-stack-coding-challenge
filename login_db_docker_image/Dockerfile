FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE login_db
ENV MYSQL_USER api
ENV MYSQL_PASSWORD api_pass
# ENV MYSQL_ROOT_HOST 0.0.0.0

# USE IF YOU WOULD LIKE TO INSERT DATA INTO DOCKER IMAGE
ADD data.sql /docker-entrypoint-initdb.d

# COPY my.cnf /usr/my.cnf
EXPOSE 3306
