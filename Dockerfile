FROM ubuntu:latest
LABEL authors="melaragalaz"

ENTRYPOINT ["top", "-b"]