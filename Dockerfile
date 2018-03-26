FROM mysql:5.7.18

ENV MYSQL_ROOT_PASSWORD=test1234

ADD init-development.sql /docker-entrypoint-initdb.d
