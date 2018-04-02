library(ggplot2) #하드디스크의 ggplot2라이브러리를 메모리에 올려놓고 사용하겠다.

data <- c(10,10,20,30,30,50,80)
qplot(data)

mpg #ggplot2패키지에 들어있는 데이터
qplot(data=mpg,y=hwy,x=drv, geom="boxplot")


