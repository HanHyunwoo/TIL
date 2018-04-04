#
#1.data load : data frame

#2. wifi 
#  1. KT 지도
#  2. LG 지도
#  3. SKT 지도

#.이미지가 각각 저장 된다. 
#-------------------------------------------------------

library('readxl')
library(dplyr)
library(RgoogleMaps)

data <- read.csv(file="seoul.csv",header = F)


data <- rename(data,
               gu=V1,
               dep=V2,
               addr=V3,
               lon=V4,
               lat=V5,
               comp=V6
               )

mycenter = c(37.500418, 127.037221)

#---------------------------------------------------------------------------------------
#1개만 뿌려본거
mymap <- GetMap(
  center=mycenter,
  zoom=11,
  maptype='load'  # or imgmap
  #format='roadmap',
  #destfile = 'mymap.jpg' #destfile 나중에 만들어질 파일이름
)


p=PlotOnStaticMap(mymap,
                lat=data[data$comp=="SKT",c('lat')],    #벡터가 들어가면 다 뿌려줌
                lon=data[data$comp=="SKT",c('lon')],
                cex=1,pch=10,col='red')

print(p)

#---------------------------------------------------------------------------------------

write_map <- function(a){
  
  #지도 그리기
  mycenter = c(37.500418, 127.037221)
  mymap <- GetMap(
    center=mycenter,
    zoom=11,
    maptype='load'  # or imgmap
    #format='roadmap',
    #destfile = 'mymap.jpg' #destfile 나중에 만들어질 파일이름
  )
  
  
  jpeg(filename = "C:\\TIL\\R\\day07\\mymap.jpg",width=680,height=680,quality = 100);
  
  
  if (a==2){
    p <- PlotOnStaticMap(mymap,
                         lat=data[data$comp=="LGU+",c('lat')],    #벡터가 들어가면 다 뿌려줌
                         lon=data[data$comp=="LGU+",c('lon')],
                         cex=1,pch=10,col='red'
    )
  }
  
  if (a==1){
    p <- PlotOnStaticMap(mymap,
                         lat=data[data$comp=="KT",c('lat')],    #벡터가 들어가면 다 뿌려줌
                         lon=data[data$comp=="KT",c('lon')],
                         cex=1,pch=10,col='red'
    )
  }
  
  if (a==3){
    p <- PlotOnStaticMap(mymap,
                         lat=data[data$comp=="SKT",c('lat')],    #벡터가 들어가면 다 뿌려줌
                         lon=data[data$comp=="SKT",c('lon')],
                         cex=1,pch=10,col='red'
    )
  }
  
  print(p);
 dev.off()
}