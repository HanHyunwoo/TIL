getcsv <- function(){
  data <- read.csv('csv_exam3.csv',header = F);
  class(data$V2) #factor 
  return(data);
}

data <- getcsv()

#----------------------------------------------------------------
getcsv <- function(){
  data <- read.csv('csv_exam3.csv',header = F
                   ,stringsAsFactors = F, encoding = "UTF-8");
  class(data$V2) #character 
  return(data);
}

data <- getcsv()

#----------------------------------------
getcsv <- function(){
 #data <- read.csv('csv_exam3.csv', header = F)
  data <- read.csv('csv_exam3.csv', header = F, stringsAsFactors=F) #문자열 섞이면 이걸 사용하자
  class(data$V2)
  return (data)
}

writedata <- function(df){
  write.csv(df, file='result0328.csv');
}
data <- getcsv()
data$avg <- round(rowMeans(data[,c(4:6)]), 2) # avg라는 열을 만들고 반올림해준것이다!
writedata(data)

newdata <- read.csv('result0328.csv',header = F
                    ,stringsAsFactors = F,encoding = 'UTF-8')

