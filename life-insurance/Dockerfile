# 使用官方 JDK 17 執行環境（可依你專案調整版本）
FROM eclipse-temurin:17-jdk

# 設定工作目錄
WORKDIR /app

# 複製已打包好的 jar（建議先用 mvn clean package 建好 jar）
COPY target/life-insurance-0.0.1-SNAPSHOT.jar app.jar

# 複製等待腳本並賦予執行權限
COPY wait-for-it.sh .
RUN chmod +x wait-for-it.sh

# 改用 wait-for-it 啟動應用
ENTRYPOINT ["./wait-for-it.sh"]
