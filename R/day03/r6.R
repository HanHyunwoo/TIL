mpg2 <- mpg[,c('model','year')]
#mpg2 <- mpg[,c(-3,-4)]

exam[exam$class==2,'english']
exam[exam$class==2,c('english','math')]

temp<- c(3,1,3,5,4,2,3)


#sort(exam,x= exam$math) #sort는 데이터프레임 안들어가짐, 벡터만 들어가짐
exam %>% arrange(math) #math 오름차순 정렬


exam[order(exam$math),]

exam[order(exam$math,decreasing =T),] #내림차순~ 

exam <- read.csv('csv_exam.csv');
colnames(exam) <- c('id','class','math','english','science')

exam[order(exam$class,exam$math,decreasing =T),]
exam2 <- exam %>% arrange(class,desc(math))   #class 오름차순이고, 다음 수학점수로 내림차순
exam3 <- exam %>% arrange(desc(math))
ex4 <- head(exam3,5)

#각 반 별 3과목 평균이 높은사람 순으로 정렬하시오. 
exam$avg <- (exam$math+exam$english+exam$science)/3
exam$avg <- rowMeans(exam[,c(3:5)])

so <- exam %>% arrange(exam$avg)
so <- exam %>% arrange(class,desc(exam$avg))
exam4 <- exam %>% arrange(class,desc(avg))

#p141---------------------------------------------------------------------

tmp <- mpg %>% filter(mpg$manufacturer=='audi')

tmp %>% arrange(hwy)
head(tmp,5)

#p144---------------------------------------------------------------------

mpg2 <- mpg

mpg2$cthwSum <- mpg$cty + mpg$hwy
mpg2$cthwAvg <- mpg2$cthwSum / 2

mpg2 %>% arrange(desc(cthwAvg))
head(mpg2,3)

#q4
mpg3 <- mpg
mpg3 %>% 
  mutate(total = cty+hwy,
         mean = total/2) %>%
  arrange(desc(mean)) %>%
  head(3)

mpg3 <- mpg
mpg3
mpg3 <- mpg3 %>%   mutate(total = cty+hwy, mean = total/2)
mpg3 <- mpg3 %>%   arrange(desc(mean)) 
mpg3 %>% head(3)

#-------------------------------------------------------------------------

















