exam <- read.csv('csv_exam.csv');
colnames(exam) <- c('id','class','math','english','science')

exam
aggregate(math~class,exam,mean)

#위의 aggregate는 mean(3번째값1개함수)만 할 수 있는 반면, summarise는 함수를 다양하게 사용할 수 있다.
ex1 <- exam %>%
  group_by(class) %>%
  summarise(mean_math=mean(math),
            sum_english = sum(english),
            mean_science = mean(science),
            n=n() #자동으로 group_by 행의갯수들을 count!!!
           )

ex1

#p149p이랑 유사
#q1
mpg %>%
  group_by(manufacturer,drv) %>%  #제조사별, 드라이버별 그룹
  summarise(mcty=mean(cty)) %>%
  arrange(desc(mcty)) %>%
  head(5)

#150p
#q1
mpg %>%
  group_by(class) %>%
  summarise(mcty=mean(cty))


#q2
mpg  %>%
  group_by(class) %>%
  summarise(mcty=mean(cty)) %>%
  arrange(desc(mcty))

#q3
mpg
mpg %>%
  group_by(manufacturer) %>%
  summarise(mhwy=mean(hwy)) %>%
  arrange(desc(mhwy)) %>%
  head(3)

#q4
mpg
mpg %>%
  group_by(manufacturer) %>%
  filter(class=="compact") %>%
  summarise(count = n()) %>%
  arrange(desc(count)
)

#q2
mmpg1 <- aggregate(cty~class,mpg,mean)
mmpg1[order(mmpg1$cty,decreasing = T),]

#q3
mmpg2 <- aggregate(hwy~manufacturer,mpg,mean)
head(mmpg2[order(mmpg2$hwy,decreasing = T),],3)

#q4
mmpg3 <- mpg[mpg$class %in% c('compact'),]
sort(table(mmpg3$manufacturer),decreasing = T)












