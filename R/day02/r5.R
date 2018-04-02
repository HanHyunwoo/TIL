name <- c('김지훈','이유진','박동현','김민지')
gender <- c('m','f','m','f')
ko <- c(90,80,60,70)
ma <- c(50,60,100,20)
si <- c(87,54,79,89)
en <- c(54,67,87,88)
add <- c('서울시','광주시','대전시','부산시')

df <- data.frame(name,gender,ko,ma,si,en,add)
df

#학생별 과목별 평균을 구하고 각각 vector에 넣으시오 

name <- 'avg';
gender <- 'null';
ko <- mean(df$ko);
ma <- mean(df$ma);
si <- mean(df$si);
en <- mean(df$en);
add <- c('창원시');
df2 <- data.frame(name,gender,ko,ma,si,en,add)
print(df2);


combine <- rbind(df,df2)
combine
combine$avg <- round(rowMeans(df[,c('ko','ma','si','en')]),2)
df

#--------------------
df2 <- df[,c(3:6)]
submean <- colMeans(df2)
stumean <- rowMeans(df2)
names(stumean) <- df[,1]

temp <- df[,'add']
class(temp)
temp2 <- as.character(temp) # as.character : factor를 character로 만듬
class(temp2)  
df$add <- substr(temp2,1,2)
df$add2 <- substr(temp2,3,3)

df
dfm <- df[gender=='m',]
dff <- df[gender=='f',]

fmavg <- colMeans(dfm[,c(3:6)])  #남자 평균
mavg <- colMeans(dff[,c(3:6)])  #여자 평균

#----------평균 이상인 학생들 중 여자만 조회 하시오.  
df[df$gender=='f' & mean(df[,c(3:6)]),]
avgHigh <- dff[]

dfavg <- df[ df$avg>mean(df$avg) & df$gender == 'm',]
#실패 하지마 ~ 
#--------------------------------------------

#학생 별 국어와 영어의 평균을 구하시오. vector로 표현 하시오
#단 , 컬럼 명은 학생의 이름으로 표시하시오
result <- rowMeans(df[,c(3,6)])  
names(result) <- df$name    #names컬럼명을 주는 거임 
result

df
tmp<-df[,c(3,4)]
tmp$avg<-rowMeans(tmp)
rownames(tmp)<-df$name
tmp
t(tmp)

qplot(y=mavg, x=names(mavg))
plot(x=names(submean),y=submean)

#여학생들의 과목 별 평균을 구하시오.  vector로 표현 하시오
#단 , 컬럼 명은 과목 명이 표시 된다. 

result <- colMeans(df[df$gender=='f',c(3:6)])
df[df$gender=='f',][c(3:6)]


#r1 <- colMeans(df[df$gender=='f',][c(3:6)])
#names(r1) <- colnames(df[,c(3:6)])

result1 <- df[df$gender== 'f',] 
r1 <- colMeans(result1[,c(3:6)])

result2 <- df[df$gender== 'm',]
r2 <- colMeans(result2[,c(3:6)])
class(r2)                         #numeric 타입
result3 <- rbind(r1,r2)           #rbind로 합치니까 매트릭스 타입으로 변경됨
class(result3)                    #매트릭스 타입으로 나옴
result4 <- as.data.frame(result3) #매트릭스타입을 데이터프레임으로 변
class(result4)

#----------------------------------------
#경민이가 한 거
name<-c('한지민','김연아','김경민','강필주');
gender<-c('f','f','m','m');
ko <- c(90,80,60,70);
en <- c(50,60,100,20);
ma <- c(87,54,79,89);
si <- c(54,67,87,88);
add <- c('서울시','광주시','대전시','부산시');
df <- data.frame(name,gender,ko,en,ma,si,add)
df

avgrow<- c(rowMeans(df[1:4]));
df$avgrow <- avgrow
df
avgcol<- c(colMeans(df[3:6]))
rbind(df, avgcol)

df2<-df[,c(3:6)]
submean<-colMeans(df2)
stumean<-rowMeans(df2)
names(stumean)<-df[,1]
qplot(data = submean, x=names(submean), y=submean)

temp <- df[,'add']
class(temp)
temp2 <- as.character(temp)
class(temp2)
df$add <- substr(temp2,1,2)
df$add2 <- substr(temp2,3,3)

dfm  <- df[df$gender=='f',]
dff  <- df[df$gender=='m',]
mavg <- colMeans(dfm[,c(3:6)])
favg <- colMeans(dfm[,c(3:6)])
qplot(y=mavg, x=names(mavg))

#평균 이상인 학생들 중 여자만 조회하기
total_avg <- mean(df[,8])
dfaa<-df[df$avgrow>total_avg & df$gender=='m',]

#학생 별 국어와 영어의 평균
df
tmp<-df[,c(3,4)]
tmp$avg<-rowMeans(tmp)
rownames(tmp)<-df$name
tmp
t(tmp)




  
