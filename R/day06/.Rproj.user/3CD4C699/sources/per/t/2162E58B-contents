#r3~r6이 없는데 빠진게 아님, r2,3,4에 다 있음
#--------------------------------------------------------------------------

#foreign : SPSS,SAS,STATA 등 통계분석 소프트웨어파일의 불러올 수 있는 패키지 
install.packages("foreign") 
install.packages("readxl") 

#데이터 불러오기 (210P)

library(foreign)
library(dplyr)
library(ggplot2)
library(readxl)

raw_welfare <- read.spss(file = "Koweps_hpc10_2015_beta1.sav",to.data.frame = T)


#복사본 만들기
welfare <- raw_welfare
View(welfare)
str(welfare)  #컬럼 구조보기
length(colnames(welfare))  #컬럼갯수 보기

welfare <- rename(welfare,
                  sex=h10_g3,
                  birth=h10_g4,
                  marriage=h10_g10,
                  religion=h10_g11,
                  income=p1002_8aq1,
                  code_job=h10_eco9,
                  code_region=h10_reg7)

gender <- table(welfare$sex)
welfare$sex <- ifelse(welfare$sex==1,'maile', 'female')
qplot(welfare$sex)


