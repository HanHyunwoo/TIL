st <- read.csv('csv_exam.csv',header = F)
colnames(st) <- c('id','class','ko','en','ma')

View(st)

is.na(st)
table(is.na(st)) # 총 NA true, false 개수가 나온다.
table(is.na(st$class)) # class의 NA true, false 개수가 나온다.


mean(st$ko) #NA가 있어서 안된다.
mean(st$ko,na.rm=T) #NA를 제외한 숫자만 가지고 평균을 구한다.

# 학생 정보를 조회 하시오
# 단 id, class, ko 결측치(NA)가 있는 학생은 빼시오
tmp <- st[,c(1:3)]
tmp[,tmp$ko==is.na(tmp$ko)]


st[!is.na(st$ko) & !is.na(st$class), c('id','class','ko')]

na.omit(st[,c('id','class','ko')])  #na.omit 모든 결측치를 빼겠다. 

st2 <- na.omit(st)


# 국어, 영어, 수학 성적의 평균을 구하여 
# vector 를 만든다. 
imsi <- na.omit(st[,c('id','class','ko','en','ma')])
avg = colMeans(st[,c('ko','en','ma')],na.rm =T)


# NA값을 모두 0으로 바꾸시오.       http://rfriend.tistory.com/34 참고
st
notNA <-st
notNA[is.na(notNA)] <- 0

st$ko <- ifelse(is.na(st$ko),0,st$ko)
st$en <- ifelse(is.na(st$en),0,st$en)
st$ma <- ifelse(is.na(st$ma),0,st$ma)

notNA[is.na(notNA)] <- 1

st[is.na(st)] <- 1
boxplot(st$en)

hist(st$en)


