# $ docker build -t my-springboot-app .
# $ docker run -p 8080:8080 my-springboot-app

# 使用 JAVA 基礎映像檔
FROM openjdk:17-jdk-slim

# 設定卷宗
VOLUME /tmp

# 複製 jar 檔案
COPY target/*.jar app.jar

# 執行應用程式
ENTRYPOINT ["java", "-jar", "app.jar"]