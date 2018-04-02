c1 <- c(1:10);
sum <- 0;

for (i in c1){     #for문 돌아갈때는 항상 뒤에 데이터가 들어가야 함
  sum <- sum + i;  #c1[i]  = i 
}
print(sum)


