FROM mysql:8.0.16

ENV MYSQL DATABASE omniviewbd
ENV MYSQL_ROOT PASSWORD root

COPY ./scripts//docker-entrypoint-initdb.d/
EXPOSE 3306
