library(ggplot2)

#160p 
midwest  #ggplot2에서 기본 제공하는 데이터

tmp <- midwest
tmp <- midwest[,c('popadults')]
tmp2 <- midwest[,c('poptotal')]

tmp$child <- (tmp2$poptotal-tmp$popadults)/tmp2$poptotal*100

imsi <- tmp[,c('county','child','popadults','poptotal')]

imsi %>%
  arrange(child) %>%
  arrange(desc(child)) %>%
  head(5)

midwest$popjuni <- 100-(midwest$popadults/midwest$poptotal*100)  
head(midwest$popjuni)

midwest$grade <- ifelse(midwest$popjuni>=40, 'large', 
                        ifelse(midwest$popjuni<30,'small','middle'))


midwest$popasianrate <- (midwest$popasian/midwest$poptotal*100) 

head(midwest[order(midwest$popasianrate),c('state','county','popasianrate')],10)






