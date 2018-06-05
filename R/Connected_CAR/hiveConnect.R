getLoginfo <- function(){

library(rJava)
library(RJDBC)
library(DBI)
library(dplyr)
library(sqldf)

# Hive 연동 (Linux 서버
drvName <- 'org.apache.hive.jdbc.HiveDriver';
id <- 'root'
pwd <- '1234'
url <- 'jdbc:hive2://70.12.114.146:10000'


# 폴더에 있는 jar들을 class path로 사용한다
hive_lib <- 'c:\\java_hive_lib'
.jinit();                              #클래스패스에 지정
.jaddClassPath(dir(hive_lib, full.names = T));
.jclassPath();

# 1. Driver Loading
drv <- JDBC(driverClass = drvName, 
            classPath = 'hive-jdbc-1.0.1.jar')

# 2. Connection
conn <- dbConnect(drv, url, id, pwd)


# 3. Statement 
sqlstr <- 'select t1.carid, t1.date, t2.date, if (t2.speed-t1.speed>=30 and t1.speed!=0,1,0) as Burst, if (t1.speed-t2.speed>=30 and t1.speed!=0,1,0) as Deceleration, if (t2.speed-t1.speed>=30 and t1.speed=0,1,0) as QuickStart, if (t1.speed-t2.speed>=30 and t1.speed=0,1,0) as SuddenStop, cast(round((t1.SAFETYDIS+t2.SAFETYDIS)/2) as int), cast(round((t1.SNOOZE+t2.SNOOZE)/2) as int), t2.battery from (SELECT carid, date, ROUND(AVG(speed)) as speed, SAFETYDIS, SNOOZE FROM loginfo where unix_timestamp() - unix_timestamp(date,\'yyyy-MM-dd HH:mm:ss\') <=600 GROUP BY date,carid,SAFETYDIS, SNOOZE) t1, (SELECT carid, date, ROUND(AVG(speed)) as speed, SAFETYDIS, battery, SNOOZE FROM loginfo where unix_timestamp() - unix_timestamp(date,\'yyyy-MM-dd HH:mm:ss\') <=601 GROUP BY date,carid,SAFETYDIS, battery, SNOOZE) t2 where ROUND(  (unix_timestamp(t2.date,\'yyyy-MM-dd HH:mm:ss\')-unix_timestamp(t1.date,\'yyyy-MM-dd HH:mm:ss\'))) =1 and t1.carid = t2.carid'

head(logData)


# 4. ResultSet
logData <- dbGetQuery(conn, sqlstr);

#------------------------------------------------------------
# Hive Query
query <- "select t1.carid, t2.carid, speed2-speed , t1.logdate , t2.logdate
from (SELECT carid, date as logdate, ROUND(AVG(speed)) as speed FROM loginfo GROUP BY date,carid) t1, 
(SELECT carid, date as logdate, ROUND(AVG(speed)) as speed2 FROM loginfo GROUP BY date,carid) t2
where ROUND((from_unixtime(unix_timestamp(t2.logdate ,'yyyy-MM-dd HH:mm:ss'))-from_unixtime(unix_timestamp(t1.logdate ,'yyyy-MM-dd HH:mm:ss')))
*24*60*60)=1 and t1.carid = t2.carid
ORDER BY t2.logdate limit 30"
db_qry <- dbGetQuery(conn, query);

head(df_new)

a<- split(df_new,df_new$carid)  #carid별로 나눔

str(df_new)
dim(df_new)  #행,열 개수
kk <-df_new %>% filter(carid ==1000)
i<-kk %>% select(date,speed)
ii<-kk %>% select(speed)


# 5. Close
dbDisconnect(conn)
return (df_new);
}

