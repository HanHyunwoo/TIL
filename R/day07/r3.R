library(KoNLP)
library(dplyr)
library(stringr)
library(wordcloud)
library(RColorBrewer)
useNIADic() 

txt <- readLines('Kakao.txt')
txt <- gsub('[0-9]', '', txt)
txt <- gsub('[오전]', '', txt)
txt <- gsub('[오후]', '', txt)
txt <- gsub('_', '', txt)
txt <- gsub('^', '', txt)
txt <- gsub('ㅋ', '', txt)
txt <- gsub('ㅇ', '', txt)
txt <- gsub('ㄱ', '', txt)
txt <- gsub('ㅎ', '', txt)
txt <- gsub('ㄴ', '', txt)
txt <- gsub('ㅅ', '', txt)
txt <- gsub('ㅂ', '', txt)
txt <- gsub('ㅁ', '', txt)
txt <- gsub('ㅊ', '', txt)
txt <- gsub('ㄹ', '', txt)

txt <- gsub('character', '', txt)
txt <- extractNoun(txt)


vc <- unlist(txt)
wc <- table(vc)
wf <- as.data.frame(wc, stringsAsFactors = F)
str(wf)
wf <- filter(wf,nchar(vc)>=2)
str(wf)

wf<-(wf[order(wf$Freq, decreasing = T),]) 

#install.packages("wordcloud")
library(wordcloud)
library(RColorBrewer)

pal <- brewer.pal(6, "Dark2")
set.seed(134)

wordcloud(words = wf$vc,
          freq = wf$Freq,
          min.freq = 5,
          max.words =100,
          random.order =  F,
          rot.per = .1,
          scale = c(4, 0.3),
          colors = pal)


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
          min.freq = 30,  #최소 단어 빈도 수 2이상
          max.words = 200, #화면에 표현되는 단어의 갯수200개로 제한
          random.order = F,
          colors = pal,
          rot.per = .1,#화면 안의 글자의 로테이션
          scale = c(4,0.3)
)

