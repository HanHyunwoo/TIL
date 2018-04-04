#install.packages('plotly')
#install.packages('htmlwidgets')
library(plotly)
library(ggplot2)
library('htmlwidgets')
p <- ggplot(data=mpg,aes(x=displ,y=hwy,col=drv))+geom_point() #col은 분류로 색을 입힌다

tmp <- ggplotly(p)

saveWidget(widget=tmp,file='mpg2.html')
