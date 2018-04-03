#install.packages('RgoogleMaps')

library(RgoogleMaps)
mycenter = c(37.500418, 127.037221)

#지도 그리기
mymap <- GetMap(
  center=mycenter,
  zoom=11,
  maptype='load',  # or imgmap
  #format='roadmap',
  destfile = 'mymap.jpg' #destfile 나중에 만들어질 파일이름
  
)



jpeg(filename = "C:\\TIL\\R\\day07\\mymap.jpg",width=680,height=680,quality = 100);
mydata <- data.frame(
  a=c(1:5),
  lat=c(37.500418,37.510518,37.520618,37.530918,37.541418),
  lon=c(127.037221,127.047221,127.057221,127.067221,127.077221)
  
);


#win.graph()

#PlotOnStaticMap : 지도위에 표시하는 것 
p <- PlotOnStaticMap(mymap,
                lat=mydata$lat,    #벡터가 들어가면 다 뿌려줌
                lon=mydata$lon,
                destfile = 'mymap.jpg',
                cex=1,pch=10,col='red'
                )

print(p);
dev.off();

























