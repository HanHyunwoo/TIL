v1 <- c(70,80,90,100);
names(v1) <- c('ko','en','si','ma');
print(names(v1))
v1[-3]

vv <- v1[1:3]
print(vv)

result <- mean(v1['ko'],v1['ma'])
result <- mean(v1[-2:-3])
print(result)
print(length(v1))
print(NROW(v1))

vv2 <- v1[c(1,4)]
print(vv2)
vv2 <- v1[c(-3,-1)]
print(vv2)


vv2 <- v1[c('ko','ma')]
print(vv2)
vv2 <- v1[c(1,4)]
print(vv2)
vv2 <- v1[-2:-3]
print(vv2)
vv2 <- v1[c(-2,-3)]
print(vv2)


var1 <- seq(1,70,by=2)
var1

names(v1)[2]
v1[names(v1)[2]]

length(v1)
NROW(V1)
nrow(v1) #진짜 row의 갯수를 세는데 벡터는 row가 없다. 그래서 null나옴








