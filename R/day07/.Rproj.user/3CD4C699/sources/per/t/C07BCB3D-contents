#왜 안되냥

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

txt1 <- readLines('http://www.ytn.co.kr/_ln/0103_201804030932232840',encoding = 'UTF-8')
txt2 <- readLines('http://www.ytn.co.kr/_sn/0117_201804031018542626',encoding = 'UTF-8')
txt3 <- readLines('http://www.ytn.co.kr/_sn/0117_201804021650063420',encoding = 'UTF-8')

txt1 <- readLines('txt1.txt')
txt2 <- readLines('txt2.txt')
txt3 <- readLines('txt3.txt')


txt <- c(txt1,txt2,txt3)
txt <- gsub('\\W', ' ', txt)#stringr에 속한 함수로  str_replace_all이 너무 안좋아서 이걸 사용함
txt <- gsub('[0-9]', '', txt)
txt <- gsub('[a-z]', '', txt)
txt <- gsub('[A-Z]', '', txt)
txt <- gsub('_', '', txt)
txt <- gsub('__', '', txt)
txt <- gsub('  ', '', txt)
txt <- extractNoun(txt); 

vc <- unlist(txt)
wc <- table(vc)

vc <- unlist(noun)  
wc <- table(vc) 
wf <- as.data.frame(wc, stringsAsFactors = F)  
str(wf)
wf <- filter(wf,length(vc)>=2)

wf

txt <- gsub('\\W',' ',txt)
txt<- gsub('[0-9]',' ',txt)
txt<- gsub('[a-z]',' ',txt)
txt<- gsub('[A-z]',' ',txt)
txt<- gsub('_',' ',txt)
txt<- gsub('__',' ',txt)
txt<- gsub('  ',' ',txt)

View(txt1)