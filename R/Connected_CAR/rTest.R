n=c(4,5,7,12,5,6,7,8,9,2,4,23);
a <- data.frame(n)

for (i in 1:nrow(a)-1){
  print(a[i+1,1]-a[i,1])
};


df_raw <- data.frame(var1 = c(1,2,1),
                   var2 = c(2,3,2))

df_new <- df_raw

df_new <- rename(df_new, v2= var2)
