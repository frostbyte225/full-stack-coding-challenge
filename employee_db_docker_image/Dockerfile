FROM postgres:latest
ENV POSTGRES_ROOT_PASSWORD root
ENV POSTGRES_DB employee_db
ENV POSTGRES_USER api
ENV POSTGRES_PASSWORD api_pass
# ENV POSTGRES_ROOT_HOST 0.0.0.0

# USE IF YOU WOULD LIKE TO INSERT DATA INTO DOCKER IMAGE
ADD data.sql /docker-entrypoint-initdb.d

# COPY my.cnf /usr/my.cnf
EXPOSE 5432
