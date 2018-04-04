#install.packages('RJDBC') #모두 대문자로 써야함 
#install.packages('DBI') #DATA BASE INTERFACE 
#install.packages('rJAVA')

library(rJava)
library(RJDBC)
library(DBI)
library(sqldf)
drvName <- 'oracle.jdbc.driver.OracleDriver';
id <- 'ruser';
pwd <- 'ruser';
url <- 'jdbc:oracle:thin:@localhost:1521:XE';


#1. Driver Loading

drv <- JDBC(driverClass = drvName, 
            classPath = 'c:\\java_hive_lib\\ojdbc6.jar')

#2. Connection
conn <- dbConnect(drv,url,id,pwd)

#3. Statement
#emp회사의 근속 연수(오늘날짜기준 월)와 월급의 상관 관계를 그래프로 표현 하시오.


sqlstr <- 'SELECT round(months_between(sysdate,hiredate),0) as mon, SAL FROM EMP';


#4. ResultSet
emp <- dbGetQuery(conn,sqlstr)

#5. Close
dbDisconnect(conn)  #db연결 끊기

library(ggplot2)
ggplot(data = emp, aes(x=MON, y=SAL)) + geom_line()

emp2 <- emp*2

#----------------------------------------------------------------------
ggplot(emp,aes(x=MON,y=SAL))+ geom_line() + geom_point() +
  
  geom_line() +geom_point() +
  
  geom_line(data = emp2,aes(x=MON/2,y=SAL),colour="red") +
  
  geom_point(data=emp2,aes(x=MON/2,y=SAL),colour="red")

#----------------------------------------------------------------------





