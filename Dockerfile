FROM ubuntu:latest
LABEL authors="danez"

ENTRYPOINT ["top", "-b"]