c1 <- c(1:5);
print(cs)

c2 <- c(6:10);
print(cs)

cs <- union(c1,c2)
print(cs)

cs <- setequal(c1,c2)
print(cs)

5 %in% cs
5-cs

result <- c(1:3) %in% cs
print(length(result))

c3 <- seq(1,1000,5)

m1 <- matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), nrow=3)
m2 <- matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), ncol=3, byrow =TRUE)
colnames(m1) <- c('c1','c2','c3')
rownames(m1) <= c('r1','r2','r3')
m1[1,2]
m1[1,] #1행을 가져와라


m1[-2,] #2행을 빼고 모두 가져와라

m1[c(1,3),] 
m1[c(1:3),] #1~3행을 가져와라

m1[c(1,2),3] #1행,2행에 3열만 가져와라

m1[c(1,2),c(2,3)] # 1행,2행에서 2열,3열만 가져와라 
m1('r2',) #갑자기 왜 안되지? #2차원은 반드시 행,열 입력해야 함  m1('r2'): x
m1[c('r2','r3'),'c3']

m1 *5
m1 *m1

nrow(m1) #row숫자가 몇인지 알수 있는거
ncol(m1) #col숫자가 몇인지 알수 있는거

ccl <- m1[,1]  #ccl :벡터, 1차원 배열로 나오면 벡터로 된다. 

m1[,1]

m5 <- matrix(c(80,90,70,100,80,99,78,72,90,78,82,78,99,89,78,90), ncol=4, byrow =TRUE) #byrow안하면 열기준이 됨
colnames(m5) <- c('ko','en','si','ma')
rownames(m5) <- c('kim','lee','hong','jang')

d <- dim(m5)  #객체의 차원 수를 구한다.

students <- rowMeans(m5)
subjects <- colMeans(m5)

avg <- ncol(m5)


m1[c(1:4),] #1~3행을 가져와라

result1 <- m5(mean(c(1:4),))


result1 <- mean(m5[1,])
result2 <- mean(m5[2,])
result3 <- mean(m5[3,])
result4 <- mean(m5[4,])

result5 <- mean(m5[,1])
result6 <- mean(m5[,2])
result7 <- mean(m5[,3])
result8 <- mean(m5[,4])

apply(m5, 1, mean)
apply(m5, 2, mean)
``
m5[,mean(c(1:4))]





