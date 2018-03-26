# Running MySQL in a docker container

To build:

```
docker build . -t development-mysql
```

To run:

```
docker run -it --rm --publish 3306:3306 --hostname mysql --name mysql development-mysql
```

To execute commands:

```
docker exec -it mysql mysql --user root --password
```
