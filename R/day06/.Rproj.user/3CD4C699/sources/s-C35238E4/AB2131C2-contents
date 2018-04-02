#직업별 월급 차이 - "어떤 직업이 우러급을 가장 많이 받을까? "
class(welfare$code_job)   #code_job : 직업코드 
table(welfare$code_job)

library(readxl)
list_job <- read_excel("Koweps_Codebook.xlsx", col_names = T, sheet = 2)
head(list_job)


#코드와 직업명 두 변수로 구성되고, 직업이 149개로 분류된다는 것을 알 수 있음 
dim(list_job) 


#welfare에 welfare와 list_job의 code_job을 기준으로 결합한다. 
welfare <- left_join(welfare, list_job, id="code_job")
head(welfare)

##Joining, by = "code_job"

welfare %>%
  filter(!is.na(code_job)) %>%
  select(code_job, job) %>%
  head()

#---------------------------------------------------------------------

#직업별 월급 차이 분석하기
#직업별 월급 평균표 만들기
job_income <- welfare %>%
  filter(!is.na(job) & !is.na(income)) %>%
  group_by(job) %>%
  summarise(mean_income = mean(income))

head(job_income)

#직업 월급 상위10개 추출
top10 <- job_income %>%
  arrange(desc(mean_income)) %>%
  head(10)

top10

#coord_flip 막대를 오른쪽으로 회전
ggplot(data = top10, aes(x=reorder(job,mean_income), y=mean_income)) + geom_col() + coord_flip()


#직업 월급 하위10개 추출
bottom10 <- job_income %>%
  arrange(mean_income) %>%
  head(10)

bottom10

ggplot(data = bottom10, aes(x=reorder(job,-mean_income), y=mean_income)) + geom_col() + coord_flip() + ylim(0,850)


