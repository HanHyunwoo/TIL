library(dplyr)

mpg
View(mpg)

mpg2 <- mpg[,c('drv','hwy')]

result <- aggregate(hwy~drv,mpg,mean)


# reorder : 막대를 크기 순으로 정렬하기  , -붙이면 내림차순 
ggplot(data=result,aes(x=reorder(drv,-hwy),y=hwy))  + geom_col()

#geom_bar() 빈도 막대그래프 
ggplot(data=mpg,aes(x=drv)) + geom_bar()
ggplot(data=mpg,aes(x=hwy)) + geom_bar()



#193p 혼자해보기
#q1
#데이터를 꺼내서 그래프로 그리기 전에 데이터 프레임을 끄집어 내는게 중요하다. 
result2 <- aggregate(cty~manufacturer+class,mpg,mean)
result3 <- result2[result2$class=='suv',] 
result4 <- result3[order(result3$cty,decreasing = T),] 
result4 <- head(result4,5)


#q2
#aggregate(model~class, mpg,NULL) ??




