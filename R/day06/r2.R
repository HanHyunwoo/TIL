#213p 성별에 따른 월급 차이 - "성별에 따라 월급이 다를까?"

welfare
class(welfare$sex)
table(welfare$sex)


# 이상치 결측 처리 
welfare$sex <- ifelse(welfare$sex == 9, NA, welfare$sex)

#결측치 확인
table(is.na(welfare$sex)) #is.na : NA면 TRUE, 아니면 FALSE 해서 개수 보여줌

welfare$sex <- ifelse(welfare$sex ==1, "male", "female")

#welfare$sex 각각 개수 세어줘
table(welfare$sex)

#표보여줘
qplot(welfare$sex)

#--------------------------------------------
#월급변수 컴토하기 216p
class(welfare$income)

#요약하여 통계량을 확인하기 (너무 많은 항목이 있어서 table은 부적합)
#최소값 0, 최대값 2400, 결측치 12030개, 최소값0이 있다는것은 
#이상치가 존재한다는 것을 의미하므로, 값이 0이면 결측 처리해야 한다. 
#값이 0이거나 9999일 경우 결측처리 하겠다. 
summary(welfare$income)

#그래프 x값 범위를 0~1000 으로 변경
qplot(welfare$income) + xlim(0,1000)

#income 값이 0 or 9999를 NA(결측) 처리하겠다.  NA: 제외한다. 
welfare$income <- ifelse(welfare$income %in% c(0,9999), NA, welfare$income)

#is.na : NA면 TRUE, 아니면 FALSE 해서 개수 보여줌
table(is.na(welfare$income))  #FALSE:4620, TRUE :12044, 결측치가 12044개


#성별에 따른 월급 차이 분석하기
sex_income <- welfare %>%
  filter(!is.na(income)) %>%
  group_by(sex) %>%
  summarise (mean_income = mean(income))

sex_income

ggplot(data = sex_income, aes(x=sex, y=mean_income)) + geom_col()









