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

txt3 <- readLines('Kakao.txt')
txt2 <- readLines('Kakao.txt')
txt2 <- gsub('\\W',' ',txt2)
txt2<- gsub('[0-9]',' ',txt2)
txt2<- gsub('[0-9][0-9][0-9][0-9]년 [0-9][0-9]월 [0-9][0-9]일',' ',txt2)

jpeg(filename = "c:\\rproject\\wc.jpg", width = 740, height=740, quality = 200);
wc <- wordcloud(words = df_word$word,  # 표현할 단어 
                freq = df_word$freq,   # 단어의 빈도
                min.freq = 2,          # 최소 단어 빈도
                max.words = 200,       # 최대 표현 단어 수
                random.order = TRUE,  # 고빈도 단어 중앙 배치
                rot.per = .1,          # 회전 단어 비율
                scale = c(4, 0.6),     # 단어 크기 범위
                colors = pal)          # 색상 목록

print(wc)
dev.off()

