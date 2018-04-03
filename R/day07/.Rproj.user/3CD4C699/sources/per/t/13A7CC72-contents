library(KoNLP)
library(dplyr)
library(stringr)
library(wordcloud)
library(RColorBrewer)
useNIADic() 

txt1 <- readLines('txt1.txt')
txt2 <- readLines('txt2.txt')
txt3 <- readLines('txt3.txt')
txt <- c(txt1, txt2, txt3)
txt <- gsub('\\W', ' ', txt)#stringr에 속한 함수로  str_replace_all이 너무 안좋아서 이걸 사용함
txt <- gsub('[0-9]', '', txt)
txt <- gsub('[a-z]', '', txt)
txt <- gsub('[A-Z]', '', txt)
txt <- gsub('_', '', txt)
txt <- gsub('__', '', txt)
txt <- gsub('  ', '', txt)


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
          min.freq = 2,
          max.words =100,
          random.order =  F,
          rot.per = .1,
          scale = c(4, 0.3),
          colors = pal)

