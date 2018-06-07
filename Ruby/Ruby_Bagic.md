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

- 

- 











