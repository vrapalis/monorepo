FROM ubuntu:18.04
LABEL maintainer="vrapalis" description="janus server"
WORKDIR janus
COPY /scripts/ scripts
RUN chmod -R +x scripts/* && scripts/dep.sh && scripts/lib.sh