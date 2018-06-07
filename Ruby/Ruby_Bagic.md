# Ruby

### 0. 개요

1. 루비는 순수 객체 지향 언어이다.
2. 컴파일러가 필요 없다.
3. 객체지향적이다. 거의 모든 것이 '객체'
4. Ruby on Rails 프레임 워크 등장으로 유명



### 1. puts vs print

```ruby
3.times { print "hellow"}  # =>hellowhellowhellow
3.times { puts "hellow"}   # => hellow
						 # => hellow
						 # => hellow
```

> puts는 개행문자 포함



### 2. p vs puts

```ruby
string = "hello"
puts string 			# hello => nil 
p string 				# "hello" => "hello"
```



### 3. Naming Conventions

> 거의 자바랑 같지만 변수를 선언할 때 단어사이에  _ 로 구분한다.

- 변수
  - snake_case
- 상수
  - CONSTANT
- 클래스
  - CamelCase



### 4. pry

- 설치
  - `gem install pry`
- 실행
  - pry



### 5. Inline statement

```ruby
# if 문
puts "a=0" if == 0		 # a=0
puts "a=0" if == 1		 # 출력 안됨

# while 문
c = 0
result = c += 2 while c < 50
puts result				# 50
    

puts "hi" if 0
# 0은 true!!!!! 그래서 hi가 출력이 된다.
```



### 6. CASE

```ruby
pry(main)> case name
pry(main)* when "chang2" then puts "hi chang2"  
pry(main)* when "tak" then puts "hi tak"  
pry(main)* else puts "hi"  
pry(main)* end  
 								  => hi chang2
```





### 7. Method

- 대부분의 언어

  - 클래스 밖  :  function
  - 클래스 안  : method

- 루비에서는 모든 function은 method

- ```ruby
  #루비에서의 method 선언
  def simple
      puts "simple!!"
  end
  
  #루비에서의 method는 괄호를 명시적으로 하여 줄수도 있습니다.
  def asdf()
      puts "asdf"
  end
  
  # 루비에서는 return이 없을때 마지막 연산 값을 return 합니다. 
  def add(a,b)
  	a + b
  end  
  
  # return을 선택적을 사용할 수 있습니다. 
  def divide(a,b)
  	return "I don't think so" if b == 0
  	a / b
  end  
  ```

- 기본 매개변수

  ```ruby
  def factorial(n)
      n == 0 ? 1 : n * factorial(n-1)
  end
  
  factorial # ArgumentError: wrong number of arguments (given 0, expected 1)
  def factorial_d(n=5)
      n == 0 ? 1 : n * factorial(n-1)
  end
  
  factorial_d # 120
  
  ```

  

  ### 8. Block

  ```ruby
  3.times {puts "hello"}
  
  3.times do |asdf|   # | | 안에 값이 매개변수이다. 
      puts asdf  #요부분이 block입니다.
  end
  
  # 0 1 2
  
  
  def hihi
      return "No block" unless block_given?  # unless는 false면 실행이 된다. 
      yield  #블럭을 받았을 ㄸㅐ 그 블럭을 가리키게 된다. 
  end
  
  hihi # => "No block"
  hihi {puts "hihi"} # hihi
  
  
  ```

  ### 9. String

  ```ruby
  a = "안녕하세요 \n 멋사입니다."
  	=> "안녕하세요 \n 멋사입니다."
  b = '안녕하세요. \n 멋사입니다.'
  	=> "안녕하세요. \\n 멋사입니다."
  
  puts a
  안녕하세요 
   멋사입니다.
  
  puts b
  안녕하세요. \n 멋사입니다.
  
  name = "HanHyunwoo"
  	=> "HanHyunwoo"
  a = "#{name} 님 안녕하세요."                                   
  	=> "HanHyunwoo 님 안녕하세요."
  
  %Q(hihi)  => "hihi"
  
  my_name = "Han Hyun Woo"
  	=> "Han Hyun Woo"
  my_name.upcase!   # => "HAN HYUN WOO" ,!는 안에 있는 값을 변경
  my_name	          # => "HAN HYUN WOO"
  
  
  
  ```

  

### 10. Hash

- key, value로 이루어져 있다.

  ````ruby
  hash1 = { "key" => value}
  hash2 = {:key => value, key: value}
  hash3 = {key: value}
  hash4 = {name: "Hyunwoo",:age => 27, "hometown" => "G2"}  
  hash4["hometown"] => "G2"
  hash4[:name]      => "Hyunwoo"
  ````

  

  

- each 반복하기

  ```ruby
  hash4 => {:name=>"Hyunwoo", :age=>27, "hometown"=>"G2"}
  
  hash4.each do |k,v|
      
     puts "#{k} : #{v}"
  end  
  name : Hyunwoo
  age : 27
  hometown : G2 => {:name=>"Hyunwoo", :age=>27, "hometown"=>"G2"}
  ```



https://gist.github.com/nacyot/7624036





