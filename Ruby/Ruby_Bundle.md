### bundler를 통한 gem 관리

어플리케이션의 의존성(dependency)를 관리해주는 bundler



### 1.bundler 설치

`gem install bundler`



2. Gemfile 작성 : 루트 디렉터리에 만들기

   ```ruby
   source 'https://rubygems.org'
   
   gem 'sinatra'
   gem 'sinatra-reloader'
   gem 'datamapper'
   gem 'dm-sqlite-adapter'
   gem 'json',  '~> 1.6'
   
   ```

3. `gem` 설치

4. `bundle` install





User CRUD

필수 : EMAIL, PASSWORD

회원가입(C)

회원정보보기(R)



Heroku 배포

1. Heroku에서 addon 추가

   `heroku postgre` 

2. `Gemfile` 수정

   ```ruby
   source 'https://rubygems.org'
   
   gem 'sinatra'
   gem 'sinatra-reloader'
   gem 'datamapper'
   gem 'json',  '~> 1.6'
   gem 'bcrypt'
   gem 'rack'
   
   
   group :production do
       gem 'pg'
       gem 'dm-postgres-adapter'
   end
   
   group :development, :test do
       gem 'dm-sqlite-adapter'
   end
   ```

   - pg를 쓰는 이유는 헤로쿠에서 지원하는 DB이기 때문.
   - `bundle install --without production`

   

   3. `Model.rb` 파일에서 db경로 수정

   ```ruby
   configure :development do
     DataMapper::setup(:default, "sqlite3://#{Dir.pwd}/blog.db")
   end 
   
   configure :production do
     DataMapper::setup(:default, ENV["DATABASE_URL"])
   end
   ```

   - ENV["DATABASE_URL"] 은 Heroku 서버에서 설정되어 있는 환경 변수



4. `CONFIG.RU`  추가-> 루트 디렉터리에

5. ```RUBY
   require './app'
   run Sinatra::Application
   ```

   * 헤로쿠에서 서버를 실행하는 방법이 rake이기 때문

   console에서 헤로쿠로 push

   `$heroku login`

   `git add .`

   `git commit -m "msg"`

`git push heroku master`

