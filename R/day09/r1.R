
#r은 하이브처럼 데몬(서비스)이 없다. 
#그래서자바 에서 R연결할 때 응답할 데몬을 설치하는거임 
  #- install.packages("Rserve") 

#Rserve::Rserve()       # 백그라운드로 실행
#Rserve::run.Rserve()   #fore-ground로 실행 
#Rserve::run.Rserve(args="--RS-enable-remote")

#------------------------------------------------------------------------------

r1 <- function(a,b){
  v1 <- a*100 + b*0.34;
  return (v1);
}

r2 <- function(){
  v2 <- c(1:10);
  return (v2);
}

r3 <- function(){
  time <- c('6시','7시','8시','9시','10시');
  line2 <- c(1000,2000,3000,4000,5000);
  line3 <- c(2000,3000,4000,5000,6000);
  line4 <- c(3000,4000,5000,6000,7000);
  v3 <- data.frame(time,line2,line3,line4);
  return (v3);
}
