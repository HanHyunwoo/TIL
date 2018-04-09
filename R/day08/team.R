getDel <- function(){
  library('rJava')
  library('RJDBC')
  library('DBI')
  drvName <- 'oracle.jdbc.driver.OracleDriver';
  #127.0.0.1:8080/apex에서 DB를 만들어줌
  id <- 'ruser';
  pwd <- 'ruser';
  url <- 'jdbc:oracle:thin:@70.12.114.144:1521:XE';
  
  #70.12.114.144
  #1. Driver Loading
  drv <- JDBC(driverClass = drvName,
              classPath = 'c:\\java_hive_lib\\ojdbc6.jar');
  
  
  #2. Connection
  conn <- dbConnect(drv,url,id,pwd);
  #3. Statement
  sqlstr <- 'SELECT * FROM food2'
  #4. ResultSet
  food <- dbGetQuery(conn, sqlstr);
  #5. Close
  dbDisconnect(conn)
  
  return (food);
  
}

getWeather <- function(){
  
  library(rJava)
  library(RJDBC)
  library(DBI)
  
  
  drvName <- 'org.apache.hive.jdbc.HiveDriver';
  id <- 'root';
  pwd <- '111111';
  url <- 'jdbc:hive2://192.168.111.100:10000';
  
  hive_lib <- "c:\\java_hive_lib"
  .jinit();
  .jaddClassPath(dir(hive_lib, full.names = T));
  .jclassPath();
  
  #1. Driver Loading
  drv <- JDBC(driverClass = drvName,
              classPath = 'hive-jdbc-1.0.1.jar');
  
  
  #2. Connection
  conn <- dbConnect(drv,url,id,pwd);
  #3. Statement
  sqlstr <- 'SELECT date, AVG(sky), SUM(rain) FROM weather GROUP BY date'
  #4. ResultSet 
  weather <- dbGetQuery(conn, sqlstr);
  #5. Close
  dbDisconnect(conn)
  return (weather);
}

library('dplyr')

#--------------------------------------------------------------------------------
# weather hive에서 받고 칼럼명 변경 및 날짜 => date 형으로 casting
weather <- getWeather()
weather <- rename(weather,
                  DAY = date,
                  sky = '_c1',
                  rain = '_c2')
weather$DAY <- as.Date(weather$DAY, format="%Y-%m-%d") 

#--------------------------------------------------------------------------------

# delivery oracle에서 깨지는 칼럼명 변경 및 날짜 => date형으로 casting
delivery <- getDel()
delivery <- rename(delivery,
                   DAY = 癤풡AY)
delivery2 <- aggregate(CALLS~DAY+FOOD, delivery, sum)
delivery2$DAY <- as.Date(delivery2$DAY, format="%Y-%m-%d")

#--------------------------------------------------------------------------------

# weather 가공
weather$state <- ifelse(weather$rain >= 5, 2,
                        ifelse(weather$sky>=3, 1, 0))
weather$state <- ifelse(is.na(weather$state), 0, weather$state)
weather$sky <- round(weather$sky, 0)


#--------------------------------------------------------------------------------

# delivery 가공


#--------------------------------------------------------------------------------
result <- delivery2
result <- left_join(result, weather, id = "DAY")
result2<-aggregate(CALLS~state+FOOD, result, mean)
result2$states <- ifelse(result2$state == 2, '눈/비',
                         ifelse(result2$state == 1, '흐림', '맑음'))
# 데이터 합치기
View(result2)

tmp1 <- result2[result2$state==0,'CALLS']  
tmp2 <- result2[result2$state==1,'CALLS']  
tmp3 <- result2[result2$state==2,'CALLS']  

data <- data.frame(tmp1,tmp2,tmp3)
colnames(data) <- c('맑음','흐림','눈비')
rownames(data) <- c('족발보쌈','중국음식','치킨','피자')

data


#--------------------------------------------------------------------------------
library(ggplot2)
#ggplot(result2, aes(x=state, y=CALLS, col=FOOD))+ geom_line()
ggplot(result2, aes(x=state, y=CALLS, fill=FOOD))+ geom_col(position = 'dodge')
# 그리기

