


tf <- data.frame(
  id = c(1:5),
  test=c(86:90)
)

tf2 <- data.frame(
  id = c(6:10),
  test=c(91:95)
)


total <- rbind(tf,tf2)   #2개의 프레임 구조가 같아야만 한다. 

total$test2 <- c(90:99)

#avg colum에 평균을 입력하시오. 

total$avg <- (total$test + total$test2)/2


# 평균이 높은 순으로 탑3을 조회 하시오
library(dplyr)
library(sqldf)
  
  total %>%
    group_by(total$avg) %>%  
    arrange(desc(avg)) %>%
    head(3)

  head(total[order(total$avg,decreasing = T),],3)
  
# 평균이 평균 이상인 학생을 조회하시오. 

total[total$avg >= mean(total$avg),]
  
  
  
  
  
  
  
  
  