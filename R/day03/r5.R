library(dplyr)
library(sqldf)
exam <- read.csv('csv_exam.csv');
colnames(exam) <- c('id','class','math','english','science')

c1 <- exam[exam$class !=1,]
#c1 <- exam %>% filter(class ==1)

c1 <- exam[exam$math >=50 & exam$english >=30,]
c2 <- sqldf('SELECT * FROM exam WHERE math >= 50 
            AND 
            english >=30
            ')

c1 <- exam[exam$class %in% c(1,3),]



#------------------------------------------------------------------------
#133p 혼자 해보기
#Q1
m1 <- mpg %>% filter(mpg$displ <=4)
m2 <- mpg %>% filter(mpg$displ >5)

mm1 <- mean(m1$hwy)
mm2 <- mean(m2$hwy)


aggregate(hwy~displ <=4, mpg,mean)



#Q2
k1 <- mpg %>% filter(mpg$manufacturer == 'audi')
k2 <- mpg %>% filter(mpg$manufacturer == 'toyota')

kk1 <- mean(k1$cty)
kk2 <- mean(k2$cty)

tmp <- aggregate(mpg$cty~manufacturer,mpg,mean)
ex2 <- tmp[tmp$manufacturer=='audi' | tmp$manufacturer=='toyota',]

result1 <- aggregate(cty~manufacturer,mpg,mean)

result2 <- result1[result1$manufacturer %in% c('audi','toyoto'),]

result3 <- aggregate(hwy~manufacturer,mpg,mean)

result4 <- result1[result3$manufacturer %in% c('chevrolet','ford','honda')]

#Q3 

#------------------------------------------------------------------------
# 실습 (경민이가한거)
car1<-mpg %>% filter(displ<=4)
car2<-mpg %>% filter(displ>5)
avg <- mean(car1$hwy)
avg2 <- mean(car2$hwy)
avg3 <- aggregate(hwy~displ,mpg,mean)
class(avg3)
avg4 <- colMeans(avg3[avg3$displ<=4,])
avg5 <- colMeans(avg3[avg3$displ>5,])


car3<-mpg %>% filter(manufacturer=='audi')
car4<-mpg %>% filter(manufacturer=='toyota')
cty_avg1 <- mean(car3$cty)
cty_avg2 <- mean(car4$cty)
aggregate(cty~manufacturer,mpg,mean)

car5<-mpg %>% filter(manufacturer %in% c('chevrolet','ford','honda'))
hwy_avg <- mean(car5$hwy)


#------------------------------------------------------------------------
temp <- aggregate(hwy~displ <=4, mpg,mean)
qplot(temp$hwy,x=c('5<=','4>='))
temp
