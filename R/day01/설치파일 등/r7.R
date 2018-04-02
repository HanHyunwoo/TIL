# r7
name <- c('lee','kim','park','jang','hong');
age <-c(10,20,30,40,50);
weight <- c(40,50,60,70,80);
df <- data.frame(name,age,weight);
dim(df);
nrow(df); ncol(df)

df[1,] #데이타 프레임임
df[,2] #하나의 벡터가 됨
df2 <- df[c(1,2),] #전체 데이터에서 2개(1행,2행)의 데이터만 끄집어냄
df2 <- df[c(1:3),]
mean(df2[,2])      #(바로 앞에 줄의 df2)3명의 나이(2번째열)에 평균을 구하라
mean(df2[,'age'])  #(바로 앞에 줄의 df2)3명의 나이(2번째열)에 평균을 구하라

rowMeans(df2[,c('age','weight')])  #나이와 키의 평균을 구하시오 , 2개는 항상 벡터이다.
mean(df2[,c('age','weight')])  #나이와 키의 평균을 구하시오 , 2개는 항상 벡터이다.

df2[,c('age','weight')]
colMeans(df2[,c('age','weight')])

df2 <- df[1,]  #데이터 프레임임
df2 <- df[,2]  #전체행의 2열만 나와라, 벡터가 됨

df2 <- df[2,'age']  #벡터, 
mean(df$age) #나이의 평균

df$age # 나이,(벡터)

mean(df$age[1:3]) #1번과 3번의 나이의 평균

max(df$age)

df2 <- df[,'age']
c <- df$age

which(df$age ==50)  #which 아주 단순한 비교연산, age가 50인게 몇번째 값인지 보여줘

which.max(df$age)
which.min(df$age)

#나이의 평균값을 구하는데 최대값과 최소값을 뺀 평균 값을 구하여라 
mx <- which(df$age == max(df$age))
mn <- which(df$age == min(df$age))

mean(df$age[c(-mx,-mn)])

df
df$height <- c(180,170,160,150,155)
# weight / (height) * (height) * 10000   , BMI :비만도

df$BMI <- c( df[1,3]/(df[1,4]*df[1,4]) *10000, df[2,3]/(df[2,4]*df[2,4]) *100 , 
             df[3,3]/(df[3,4]*df[3,4]) *10000, df[4,3]/(df[4,4]*df[4,4]) *100 ,
             df[5,3]/(df[5,4]*df[5,4]) *10000)
df

df$bmi<- df$weight/(df$height*df$height) *10000
df$bmi<- df$weight/(df$height^2) *10000
df


