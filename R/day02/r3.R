c2 <- c(1,2,3,NULL,5);
sum(c2)   #하나라도 NA면 연산하지 않음,
mean(c2,na.rm = T) 

f1 <- function(a,b){
  return (a+b);
}

f1(1,3)


cc <- c('1','1','1','1')
mean(cc)
mean(as.integer(cc))

ccc <- c(12,43,84,25,101,70,60)

ccc[ccc>=60 & ccc<=80]


ccc[ccc%%2==0]

ccc[which(ccc%%2==0)]

str4 <- c('a','b','c','d')
s <- paste(str4,collapse = ' ')




