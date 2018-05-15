
install.packages("Rserve");
Rserve::Rserve(args = "--RS- encoding utf8")

r1<-function(){
  v1<-c(1:10);
  return(v1);
}
r2<-function(){
  v2<-c(1:10);
  return (v2);
}

r3<-function(){
  log <- read.table('log.txt',header=F,sep = ',')
  
  class(log)
  
  rownames(log)<-c("r1")
  
  v3<-rowMeans(log)
  max(log)
  min(log)
  result<-as.integer(v3)
  
  return(result);
  
}

