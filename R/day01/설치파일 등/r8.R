name <- c('kim','lee','hong','jang');
ko <- c(80,80,90,99);
en <- c(90,99,78,89);
si <- c(70,78,82,78);
ma <- c(100,72,78,90);
df <- data.frame(name,ko,en,si,ma)
print(df);
#-------------------------------------------------------------------

name <- 'avg';
ko <- mean(df$ko);
en <- mean(df$en);
si <- mean(df$si);
ma <- mean(df$ma);
df2 <- data.frame(name,ko,en,si,ma)
print(df2);

combine <- rbind(df,df2)  #df데이터프레임이랑 df2데이터프레임을 합쳐서 combine 데이터프레임에 넣는다. 

print(combine)

combine$avg <- rowMeans(combine[,c('ko','en','si','ma')])        #combine에 avg열을 생성한다.
print(combine)

combine$sum <- combine$ko+ combine$en+ combine$si + combine$ma   #combine에 sum열을 생성한다.
print(combine)

