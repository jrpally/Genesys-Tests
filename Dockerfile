FROM selenium/standalone-edge:4.1.3-20220405
ENV MAVEN_VERSION 3.3.9
ENV DISPLAY :99

USER root

RUN apt-get update -qqy \
  && apt-get install -y default-jdk && \
  rm -rf /var/lib/apt/lists/*

RUN wget -O- http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /opt \
  && mv /opt/apache-maven-$MAVEN_VERSION /opt/maven \
  && ln -s /opt/maven/bin/mvn /usr/bin/mvn

USER root

ENV MAVEN_HOME /opt/maven

WORKDIR /app
COPY . .
WORKDIR /app
