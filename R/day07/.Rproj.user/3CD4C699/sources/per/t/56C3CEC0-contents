library(KoNLP)
library(dplyr)
library(stringr)
library(wordcloud)
library(RColorBrewer)
library(ggplot2)
useNIADic() 

txt <- readLines('friend.txt')
txt <- gsub('[0-9]', '', txt)
txt <- gsub('[오전]', '', txt)
txt <- gsub('[오후]', '', txt)
txt <- gsub('[이창훈]', '', txt)
txt <- gsub('[김지명]', '', txt)
txt <- gsub('[ㅋ]', '', txt)
txt <- gsub('[신창훈]', '', txt)
txt <- gsub('[한현우]', '', txt)
txt <- gsub('[김요셉]', '', txt)
txt <- gsub('[승용]', '', txt)
txt <- gsub('[사진]', '', txt)
txt <- gsub('[Mr]', '', txt)
txt <- gsub('[회원]', '', txt)
txt <- gsub('[ㅇ]', '', txt)
txt <- gsub('[ㅎ]', '', txt)
txt <- gsub('[ㄱ]', '', txt)
txt <- gsub('[ㅂ]', '', txt)
txt <- gsub('[ㅅ]', '', txt)
txt <- gsub('[ㄴ]', '', txt)
txt <- gsub('[ㅁ]', '', txt)
txt <- gsub('[ㅊ]', '', txt)
txt <- gsub('[ㄲ]', '', txt)
txt <- gsub('[ㄷ]', '', txt)
txt <- gsub('[ㄹ]', '', txt)
txt <- gsub('[이모]', '', txt)
txt <- gsub('[티콘]', '', txt)
txt <- gsub('[모티]', '', txt)
txt <- gsub('["ㅠ"]', '', txt)
txt <- gsub('[https]', '', txt)

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


order<-arrange(wf,Freq)$vc
p= ggplot(data=wf, aes(x=vc ,y=Freq))+ xlim(0,100) +ylim(0,250)+geom_col()+coord_flip()+scale_x_discrete(limit=order)+geom_text(aes(label=Freq),hjust=-0.3)
print(p); 
dev.off();


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
          min.freq = 3,  #최소 단어 빈도 수 2이상
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

