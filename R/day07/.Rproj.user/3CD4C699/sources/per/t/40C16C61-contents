#266p 자바JDK 환경변수설정 안되어있으면 rJava 설치 안됨
# JAVA_HOME :  C:\Program Files\Java\jdk-9.0.4

install.packages('rJava')    #rJava KoNLP를 사용하기 위해서 설치
install.packages('memoise')
install.packages('KoNLP')
install.packages('stringr') #특수문자를 제거할 때 사용하는 패키지 
install.packages('wordcloud')

library(KoNLP) #NIA사전은 
library(dplyr)
library(stringr) 
library(wordcloud)
library(RColorBrewer)
useNIADic()  #약 98만 단어를 메모리로 올리는 것
txt <- readLines('hiphop.txt')
txt <- str_replace(txt,'\\w', ' '); #특수문자를 공백으로 바꾸시오

txt <- gsub('\\W',' ',txt)
txt <- gsub('[0-9]',' ',txt)
#txt <- gsub('[a-z]',' ',txt)
#txt <- gsub('[A-Z]',' ',txt)

#txt <- str_replace(txt,'[0-9]', ' '); #숫자를 공백으로 바꾸시오
#txt <- str_replace(txt,'[a-z]', ' '); #숫자를 공백으로 바꾸시오
#txt <- str_replace(txt,'[A-Z]', ' '); #숫자를 공백으로 바꾸시오

noun <- extractNoun(txt); #명사만 추출하시오
vc <- unlist(noun)  #unlist : 벡터형식으로 바꿔줌, 
wc <- table(vc) #벡터형으로 만들어줘야 테이블형에서 데이터 자료의 갯수를 셀 수 있다. 
wf <- as.data.frame(wc,stringsAsFactors = F)  #stringsAsFactors 스트링형으로 넣을건지에 대한 속성
                                      #데이터프레임으로 만들어야 여러가지 핸들링하기가 편하다. 
wf <- filter(wf,nchar(vc)>=2)  #글자의 길이가 2 이상인 것들만 뽑아 냄
wf <- head(wf[order(wf$Freq,decreasing = T),],100)
wf2 <- wf[order(wf$Freq,decreasing = T),]
pal <- brewer.pal(8,'Dark2')
set.seed(1234)


wordcloud(words= wf$vc,
          freq = wf$Freq,
          min.freq = 2,  #최소 단어 빈도 수 2이상
          max.words = 200, #화면에 표현되는 단어의 갯수200개로 제한
          random.order = F,
          colors = pal,
          rot.per = 0.5,#화면 안의 글자의 로테이션
          scale = c(4,0.3)
          )

wordcloud(words= wf2$vc,
          freq = wf2$Freq,
          min.freq = 2,  #최소 단어 빈도 수 2이상
          max.words = 200, #화면에 표현되는 단어의 갯수200개로 제한
          random.order = F,
          colors = pal,
          rot.per = .1,#화면 안의 글자의 로테이션
          scale = c(4,0.3)
)
"C:\\TIL\\R\\day07\\mychart5.jpg"

g1 <- function(){
  library(ggplot2)
  jpeg(filename = "C:\\TIL\\R\\day07\\mychart5.jpg", width = 680, height = 680, quality = 100)
  
  p = wordcloud(words= wf$vc,
              freq = wf$Freq,
              min.freq = 2,  #최소 단어 빈도 수 2이상
              max.words = 200, #화면에 표현되는 단어의 갯수200개로 제한
              random.order = F,
              colors = pal,
              rot.per = 0.5,#화면 안의 글자의 로테이션
              scale = c(4,0.3)
    )
  print(p)
  dev.off()
}

#----------------------------------------------
