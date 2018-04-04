#install.packages('RJDBC') #모두 대문자로 써야함 
#install.packages('DBI') #DATA BASE INTERFACE 
#install.packages('rJAVA')

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

sqlstr <- 'SELECT * from airline_delay LIMIT 10';


#4. ResultSet
air <- dbGetQuery(conn,sqlstr)

#5. Close
dbDisconnect(conn)  #db연결 끊기






