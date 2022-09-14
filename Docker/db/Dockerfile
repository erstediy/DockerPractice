FROM mysql:8.0.30
COPY Animal.sql home/init.sql
CMD [ "mysqld", "--init-file=/home/init.sql" ]