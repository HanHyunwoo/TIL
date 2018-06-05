# 멋사 day_01



## - Ruby 

##### 

#### ㅁ 점심메뉴

```ruby
menu = ["20층", "순남시래기", "양자강", "한우"]
lunch = menu.sample
puts lunch
```

#### ㅁ 타임

```ruby
5.times do
  puts "안녕하세요"
end

for i in [1,2,3]
  puts i
end

array = ["20층", "양자강","김밥까페"]
for i in array
  puts i
end

array.each do  |fdsa|
   puts fdsa
end
```



#### ㅁ 미세먼지

```ruby
require 'httparty'
url = URI.encode("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=강남구&dataTerm=MONTH&numOfRows=100&ServiceKey=")+key
response = HTTParty.get(url)
dust = response['response']['body']['items']['item'][0]['pm10Value']
#puts dust.methods
puts dust.class 

if ( dust.to_i > 150)
  puts "매우나쁨"
elsif (dust.to_i > 80 && dust.to_i <= 150)
  puts "나쁨"
elsif (dust.to_i > 30 && dust.to_i <= 80)
  puts "보통"
else
  puts "좋음"
end
```



#### ㅁ 로또

```ruby
puts Random.new.rand(1..45)


lotto = [1..45].to_a.sample[5].sort.to_a.
lotto2 = puts (1..45).to_a.sample(6).sort.join(',')
puts lotto
```



#### ㅁ 코스피

```ruby
require 'httparty'
require 'nokogiri'

# 원하는 정보가 있는 주소로 접근
url  = 'http://finance.naver.com/sise/'
# 요청을 보내고 응답을 저장
res = HTTParty.get(url)  #대소문자 구분 잘해야 함,  HTTParty.get(url)  = 요청을 보내고,  /// 응답을 저장함

# 조작하기 편하게 바꾸기
data = Nokogiri::HTML(res.body)

# 바꾼 정보중에서 원하는 정보만 뽑아서
customData = data.css("#KOSPI_now").text  #selector 정보가 들어가야함
# 출력
puts customData
```






