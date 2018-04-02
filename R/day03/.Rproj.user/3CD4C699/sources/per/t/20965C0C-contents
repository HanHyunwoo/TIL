#123p 
#문제1. ggplot2의 midwest 데이터를 데이터 프레임 형태로 불러온 다음 데이터의 특징을 파악하세요. 

midwest
class(midwest)
mw <- as.data.frame(midwest)
View(mw)

mw <- rename(mw,total=poptotal,asian=popasian)


mw$All_of_asian <- (mw$asian/mw$total)*100
qplot(mw$All_of_asian)


meanasian <- mean(mw$asian)

mw <-
#--------------------------------------------------------------------

library(ggplot2)
library(sqldf)
mympg <- sqldf('SELECT *, (cty+hwy)/2 AS total FROM mpg')
sqldf('select case when total > 20 then "pass" else "fail" end as test from mympg')

mympg2 <- sqldf('SELECT *,
                CASE
                WHEN total >=  20 THEN "PASS"
                ELSE "FAIL"
                END AS test
                FROM mympg')


mympg3 <- sqldf('SELECT *,
                CASE
                WHEN total >=  30 THEN "A"
                WHEN total <=  29 AND total >= 25 THEN "B"
                WHEN total >=  20 THEN "C"
                ELSE "D"
                END AS grade
                FROM mympg2')






