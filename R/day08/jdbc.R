library(sqldf)
library(dplyr) #데이터 전처리 작업에 쓰이는 패키지
library(ggplot2)

str(iris) #화분,입사귀 사이즈 등 데이터..  Species꽃의종류

head(iris)
class(iris)

mydata <- sqldf('select * from iris where Species= "setosa"')
mydata2 <-iris[iris$Species == 'setosa',]


colnames(iris) <- c('sl','sw','pl','pw','s')
mydata <- sqldf('select avg(sl),
                        avg(sw),
                        avg(pl),
                        avg(pw)
                        from iris group by s')

mydata2 <- iris[iris$Species =='setosa']



tmp <- aggregate(sw~s,iris,mean)

mydata4<-iris%>%
  group_by(s)%>%
  summarise(sl_mean =mean(sl),
            sw_mean=mean(sw),
            pl_mean=mean(pl),
            pw_mean=mean(pw))

species.sum2 <- iris %>% 
  group_by(s) %>% 
  summarise_all(mean)

mydata2 <- apply(iris[,c(1:4)],2,tapply,INDEX=iris$s,mean)

mydata2 <- sapply(iris[,c(1:4)],mean) #아이리스에 첫번째부터 4번째까지의 평균 컬럼을 구해라 



ggplot(data=iris,aes(x=sl,y=pl))+geom_line()
ggplot(data=iris,aes(x=sw,y=pw))+geom_line()

