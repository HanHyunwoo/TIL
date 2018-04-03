class(welfare$birth)

#코드북에 보면 태어난 연도는 1900~2014사의 값을 지니고, 
# 모른/무응답은 9999로 코딩되어있다
summary(welfare$birth)

#결측치 확인
table(is.na(welfare$birth))#false :정상, true 결측치가 있다는 것인데 true는 없다.

#만약 이상치가 발견된다면, 아래와 같이 전처리한 후 다음 작업을 진행해야 합니다. 
welfare$birth <- ifelse(welfare$birth==9999,NA,welfare$birth)
table(is.na(welfare$birth))


#파생변수 만들기, 태어난해와 2015년을 기준으로 나이 변수를 만들겠다.
welfare$age <- 2015 - welfare$birth +1
summary(welfare$age)

qplot(welfare$age)
library(dplyr)
ggplot(data=welfare,aes(x=age)) + geom_bar()

#---------------------------------------------------------------------
#나이와 월급의 관계 분석하기
age_income <- welfare %>%
  filter(!is.na(income)) %>%
  group_by(age) %>%
  summarise(mean_income = mean(income))

head(age_income)

ggplot(data = age_income, aes(x=age, y=mean_income)) + geom_line()
#---------------------------------------------------------------------

#연령대에 따른 월 차이 - "어떤 연령대의 월급이 가장 많을까?"
welfare <- welfare %>%
  mutate(ageg = ifelse(age<30,"young",
                       ifelse(age <60, "middle","old")))

table(welfare$ageg)
qplot(welfare$ageg)

#---------------------------------------------------------------------
#연령대에 따른 월급 차이 분석하기 
ageg_income <- welfare %>%
  filter(!is.na(income)) %>%
  group_by(ageg) %>% #연령대로 그룹
  summarise(mean_income = mean(income))

ageg_income

#막대 그래프
ggplot(data = ageg_income, aes(x=ageg,y=mean_income)) + geom_col()

#막대를 변수의 알파벳 순으로 정렬하도록 기본값이 설정되어 있는데, 
#초년,중년,노년의 나이 순으로 정렬되도록 변경하겠다. 
ggplot(data = ageg_income, aes(x=ageg,y=mean_income)) + geom_col()+scale_x_discrete(limits=c('young','middle','old'))

#---------------------------------------------------------------------
# 연령대 및 성별 월급 차이, 성별 우러급 차이는 연령대별로 다를까? 

#연령대 및 성별 월급 평균표 만들기 
sex_income <- welfare %>%
  filter(!is.na(income)) %>%
  group_by(ageg, sex) %>%
  summarise(mean_income = mean(income))

sex_income 

ggplot(data= sex_income, aes(x=ageg, y=mean_income,fill=sex)) + geom_col() + scale_x_discrete(limits = c('young','middle','old'))

ggplot(data= sex_income, aes(x=ageg, y=mean_income,fill=sex)) + geom_col(position = "dodge") + scale_x_discrete(limits = c('young','middle','old'))

#---------------------------------------------------------------------
#231p 나이 및 성별 우러급 차이 분석하기
#성별 연령별 월급 평균표 만들기

sex_age <- welfare %>%
  filter(!is.na(income)) %>%
  group_by(age,sex) %>%
  summarise(mean_income = mean(income))

head(sex_age)

ggplot(data = sex_age,aes(x=age,y=mean_income, col=sex)) + geom_line()









