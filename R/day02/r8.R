library(MASS)
library(doBy)

getcsv <- function(){
  data <- read.csv('2013 대학 현황.csv',header = T);
  return(data);
}

data <- getcsv()

#지역별로 폐교된 학교의 개수를 구하라.
count <- 0;

for (i in data){     #for문 돌아갈때는 항상 뒤에 데이터가 들어가야 함
  if (i=='폐교')
  count <- count + 1;  #c1[i]  = i 
}


data

result <- data[c('시도','학교상태')]

k <- summary(result[result$학교상태=='폐교','시도'])
class(k)

as.data.frame(k)
colnames(k) <- '폐교개수'



do <- colMeans(dfm[,c(3:6)])  #남자 평균



