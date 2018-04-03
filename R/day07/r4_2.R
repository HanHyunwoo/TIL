install.packages('ggiraphExtra')
#install.packages("stringi")
#install.packages("devtools")   #깃허브에서 공유된 패키지를 설치할 때 사용됨
#devtools::install_github("cardiomoon/kormaps2014")
#devtools::install_github("cardiomoon/moonBook2")
#----------------------------------------------------------------

#library(stringi)


library(ggiraphExtra)
library(kormaps2014)
library(dplyr)
library(ggplot2)
korpop1<-rename(korpop1, pop=총인구_명, name=행정구역별_읍면동)

# 인코딩을 CP949로 바꿈
str(changeCode(korpop1))
str(changeCode(kormap1))
options(encoding="UTF-8")
ggChoropleth(data=korpop1, aes(fill=pop,
                               map_id=code,
                               tooltip=name),
             map=kormap1, interactive=T)







korpop1 #시도별 인구통계 데이터임, 

str(changeCode(korpop1))  #글자가 깨져서 바꿈

korpop1 <- rename(korpop1,
                   pop = 총인구_명,
                   name =행정구역별_읍면동)

str(changeCode(korpop1))

ggChoropleth(data=korpop1,
             aes(fill=pop,map_id=code, toolip=name),
             map=kormap1,
             interactive=T
)

