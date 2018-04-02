library('ggplot2') #그래프를 이쁘게 할려고
mpg

View(mpg)
summary(mpg)

tf <- data.frame(x=c(1:5), y=c(6:10))
tfc <- tf
colnames(tfc) <- c('Col1','Col2')   

install.packages("dplyr")    #rename쓰기 위해서 dplyr 패키지 설치
library(dplyr)
tfc <- rename(tf,'xx1'=x,'YY1'=y)   #colnames는 다 넣어줘야 하는데, rename은 하나만 컬럼 변경 가능

#---------------------------------------------
#p 112 혼자해보기

mpg <- rename(mpg,'city'=cty,'highway'=hwy)


mpg$total <- (mpg$city+mpg$highway)/2

hist(mpg$total)

table(mpg$test) #특정 컬럼의 기준으로 count를 셈

mpg$test <- ifelse(mpg$total>=20,"PASS","FAIL")
as.vector(table(mpg$test))  #자바로 넘길때는 벡터로 넘기는게 편함 
qplot(mpg$test) #gglpot2에 있는 함수, 기본함수 아님 

#---------------------------------------------
#p 119 직접해보기
#total 연비를 3등급으로 나누고자 한다.
# 30이상 A  20~29 B  20미만 C , grade라는 컬럼을 만들어 추가 한다.
#grade를 기준으로 그래프를 그린다. 

mpg$grade <- ifelse(mpg$total >=30,'A',
                    ifelse(mpg$total >=20,'B','C'))
View(mpg)
head(mpg,20)

qplot(mpg$grade)   #빈도 막대 그래프


