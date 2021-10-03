#Getting base image
#docker exec -it <docker_container_name/id> /bin/sh to connect to docker instance. 

ARG MAVEN_VERSION=3.6.1
ARG USER_HOME_DIR="/root"
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

FROM ubuntu

MAINTAINER naman misra <misranaman@gmail.com>

RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
	apt-get update && \
    apt-get install -y vim && \
	apt-get update && \
	apt-get install -y curl && \
    apt-get clean;


ARG MAVEN_VERSION=3.8.2
ARG USER_HOME_DIR="/root"
ARG SHA=b0bf39460348b2d8eae1c861ced6c3e8a077b6e761fb3d4669be5de09490521a74db294cf031b0775b2dfcd57bd82246e42ce10904063ef8e3806222e686f222
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
	
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
	
WORKDIR /home

COPY . /home/Automation

WORKDIR /home/Automation

RUN echo "You are currently in:" \
   && pwd \
   && chmod 777 /home/Automation

#To Debug and connect to the container
ENTRYPOINT ["bash","./start.sh"]

#ENTRYPOINT ["bash","./run.sh"]
