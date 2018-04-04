
#--------------------------------------------------
# 1. Database 데이터와 
# Hadoop 데이터를 가지고 와서 R로 분석한다.

# 2. R에서 함수화시켜 스크립트 작성한다. 
#--------------------------------------------------


getDel <- function(){
  library(rJava)
  library(RJDBC)
  library(DBI)
  library(sqldf)
  
  #----------------------------------------------------------------------
  drvName <- 'oracle.jdbc.driver.OracleDriver';
  id <- 'ruser';
  pwd <- 'ruser';
  url <- 'jdbc:oracle:thin:@70.12.114.144:1521:XE';
  
  
  #1. Driver Loading
  
  drv <- JDBC(driverClass = drvName, 
              classPath = 'c:\\java_hive_lib\\ojdbc6.jar')
  
  #2. Connection
  conn <- dbConnect(drv,url,id,pwd)
  
  #3. Statement
  #emp회사의 근속 연수(오늘날짜기준 월)와 월급의 상관 관계를 그래프로 표현 하시오.
  
  
  sqlstr <- 'select * FROM food';
  
  
  #4. ResultSet
  food <- dbGetQuery(conn,sqlstr)
  
  #5. Close
  dbDisconnect(conn)  #db연결 끊기
  return(food)
  
}

getDel()

getWeather <- function(){
  
  
  library(rJava)
  library(RJDBC)
  library(DBI)
  
  drvName <- 'org.apache.hive.jdbc.HiveDriver';
  id <- 'root';
  pwd <- '111111';
  url <- 'jdbc:hive2://192.168.111.100:10000';
  
  hive_lib <- 'c:\\java_hive_lib'
  .jinit();               #클래스패스에 지정
  .jaddClassPath(dir(hive_lib,full.names=T));
  .jclassPath();
  
  
  #1. Driver Loading
  
  drv <- JDBC(driverClass = drvName, 
              classPath = 'hive-jdbc-1.0.1.jar')
  
  #2. Connection
  conn <- dbConnect(drv,url,id,pwd)
  
  #3. Statement
  
  sqlstr <- 'SELECT * from weather';
  
  
  #4. ResultSet
  weather <- dbGetQuery(conn,sqlstr)
  
  #5. Close
  dbDisconnect(conn)  #db연결 끊기
  return(weather)
}

getWeather()
