#미완


# 1. 데이터 수집

# 2. Developer를 이용하여 테이블을 생성하여 입력한다. 

# 3. R을 이용하여 데이터를 분석

#install.packages('RJDBC') #모두 대문자로 써야함 
#install.packages('DBI') #DATA BASE INTERFACE 
#install.packages('rJAVA')

library(rJava)
library(RJDBC)
library(DBI)
library(sqldf)

#----------------------------------------------------------------------
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


sqlstr <- 'select region,"2015","2016","2017" from RegistrationCount';


#4. ResultSet
re <- dbGetQuery(conn,sqlstr)


library(ggplot2)

ggplot(re, aes(x=REGION, y=2015)) + geom_point() +
    geom_line() + geom_point() + 
    geom_line(data=re,aes(x=REGION,y=2016),colour="red") +
    geom_point(data=re,aes(x=REGION,y=2016),colour="red")
  
#5. Close
dbDisconnect(conn)  #db연결 끊기

#options(scipen=1000000000)
#----------------------------------------------------------------------
ggplot(emp,aes(x=MON,y=SAL))+ geom_line() + geom_point() +
  
  geom_line() +geom_point() +
  
  geom_line(data = emp2,aes(x=MON/2,y=SAL),colour="red") +
  
  geom_point(data=emp2,aes(x=MON/2,y=SAL),colour="red")

#----------------------------------------------------------------------

