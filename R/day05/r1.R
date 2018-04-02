library(ggplot2)

#aes로 x,y축을 설정해준다. 
ggplot(data=mpg, aes(x=mpg$displ,y=mpg$hwy))

#+geom_point() 해주기 대신 같은 줄에 있어야함 
ggplot(data=mpg, aes(x=mpg$displ,y=mpg$hwy)) + geom_point()


# x,y 범주 설정 , x축 범위 2~8 : xlim(2,8) , y축 범위 10~50 : ylim(10,50)
ggplot(data=mpg, aes(x=mpg$displ,y=mpg$hwy)) + geom_point() + geom_line() + ylim(10,50) + xlim(2,8)


#----------------------------------------------------------------------------------------------------
#188p 혼자 해보기
#q1
ggplot(data=mpg,aes(x=cty,y=hwy)) + geom_point()

#q2
ggplot(data=midwest,aes(x=poptotal,y=popasian)) + geom_point() + ylim(0,10000) + xlim(0,500000)
