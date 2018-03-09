# from base image centos

#第一行必须指令基于的基础镜像
FROM centos

#维护者信息
MAINTAINER yangann<yangann@sina.com>

#镜像的操作指令
#install java
RUN yum -y install java
#inatall app
#ADD <src> <dest> from appUrl to container destUrl
COPY demo-0.0.1-SNAPSHOT.jar /usr/project/
#start app
ENTRYPOINT ["java" ,"-jar","/usr/project/demo-0.0.1-SNAPSHOT.jar"]

