library('googleVis')
head(Fruits)
class(Fruits)
is.data.frame(Fruits)


banana <- Fruits[Fruits$Fruit=='Bananas',]
result <- sum(banana$Sales)

# group by 와 같은 역할
# 첫번째: 그룹을 지을 내용(Sales: 함수를 적용할 대상,Fruit : 기준),  두번째 : 데이터, 세번째: 함수
aggregate(Sales~Fruit,Fruits,sum) 

df1 <- aggregate(Profit~Year,Fruits,sum)  #년도별 수익합계
df1 <- aggregate(Profit~Year+Fruit,Fruits,sum)  # 년도별, 과일별 수익합계

df2 <- Fruits[,c(4:6)]
colSums(df2)


#apply: 숫자만 들어간 형태(매트릭스)형태로 처리해야만 사용할 수 있다. 
#첫번째 함수를 적용하고 싶은 대상, 두번째 자리: 함수가 적용되는 방향, 마지막 자리:함수
apply(df2, 2, sum)  
#-----------------------------------------------------------------------------------------

#1.Fruits 데이터를 기반으로 년도별 월별 Sales 합을 구하시오
kk <- aggregate(Sales~Year+substr(Date,6,7),Fruits,sum)
colnames(kk) = c("년도", "월","Sales 합계")
kk
df1 <- aggregate(Sales~substr(Date,1,4)+ substr(Date,6,7),Fruits,sum)  #강사님이한 거

#2. 1번의 결과를 기반으로 순이익(Psales)컬럼을 추가한다. 
#공식 (Sales - Profit) * 1.83
df2 <- aggregate(Profit~substr(Date,1,4)+ substr(Date,6,7),Fruits,sum)
df1$Psales <- (df1$Sales - df2$Profit)*1.83
df1

#3. 년별 월 별 세금을 계산한다. 
#세금은   (총 판매액(Sales)-총 수익(Profit)) *0.1 
#년, 월, 세금(Fee)

df3 <- aggregate((Sales-Profit)*0.1~Year+substr(Date,6,7),Fruits,sum)
colnames(df3) <- c('Year','Month','Fee')
#----------------------------------------------------------------------------------------
#란영이가 한거 
df3 <- Fruits[, c(2,4,6,7)];
df3$Date <- substr(df3$Date,6,7)
dfFee <- aggregate((Sales-Profit)*0.1~Year+Date,df3,sum)
names(dfFee) <- c('Year','Date','Fee')

#-----------------------------------------------------------------------------------------


