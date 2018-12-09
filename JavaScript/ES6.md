## ES6(=ES2015)



# 목차

1. [const, let](#1-const-let)
1. [템플릿 문자열 (백틱: ` )](#2-템플릿-문자열-백틱--)
1. [향상된 객체 리터럴 (Enhanced Object Literal)](#3-향상된-객체-리터럴-enhanced-object-literal)
1. [화살표 함수](#4-화살표-함수)
1. [비구조화 할당](#5-비구조화-할당destructuring)
1. [Rest](#6-rest)
1. [Promise](#7-promise)
1. [async/await](#8-asyncawait)
---

&nbsp;
## 1. const, let

- var대신에 conset , let 을 사용 (기존의 var도 사용 가능)
- 기존의 var는 블럭( {} ) 밖에서도 접근이 가능한 반면에, const와 let은 블럭( {} ) 바깥에서 접근이 불가!

	- var는 함수 스코프(유효 범위)를 가지나, const와 let은 블록 스코프(유효 범위)를 가진다.

    ```javascript
    if (true){
        var x = 3;
    }
    console.log(x); //x값 3 출력됨

    if (true){
        const y = 3;
    }
    console.log(y); // y값 출력 안됨, y is not defined 에러 발생
    ```

- const :  한번 값을 선언하면 변경 불가 ,  하지만, 객체(배열)가 할당된 경우 객체 내부 속성은 변경 가능

  - 상수긴 한데 메모리 주소(참조)에 대한 상수이다.

  - 선언과 동시에 초기와 값을 입력하지 않으면 에러가 발생한다.

  - let : 값 변경 가능

##### => 자바스크립트를 사용할 때 한 번 초기화했던 변수에 다른 값을 대입하는 경우는 의외로 적다.  따라서 기본적으로 변수 선언 시에는 const를 사용하고, 다른 값을 대입해야 하는 상황이 생겼을 때 let을 사용하면 된다.

**[⬆ back to top](#목차)**
&nbsp;

&nbsp;
## 2. 템플릿 문자열 (백틱: ` )

- 백틱(`)을 쓰는 문자열을 템플릿 문자열이라고 한다.
- 큰따옴표나 작은따옴표로 감싸는 기존 문자열과는 다르게 백틱(`)으로 감싼다.
- 하나의 문자열로 인식한다. (문자열 안에 변수를 넣을 수 있다.)

```java
const a = 'hello'
const b = true
const c = 3;
const d = `${a} ${b} ${c}`;   // 변수는 ${변수명}으로 표시, 
▶ hello true 3

const f = `안녕하세요. 백틱 \`입니다.`;    // 백틱(`)을 표현할 때 \로 이스케이핑 한다.
▶ 안녕하세요. 백틱 `입니다.
const g = `안녕하세요. 큰따옴표 ", 작은따음표 ' 입니다.`;
▶ 안녕하세요. 큰따옴표 ", 작은따음표 ' 입니다.
```

**[⬆ back to top](#목차)**
&nbsp;

&nbsp;
## 3. 향상된 객체 리터럴 (Enhanced Object Literal)

```javascript
// 중괄호로 객체를 표현한다. 이렇게 {...} 중괄호로 표현하는 것을 객체 리터럴이라고 한다.
const obj = {
    a: 1,  // a = 1 객체의 속성
    b: 2,  // b = 2 객체의 속성, 
};
// ▶ { a: 1, b: 2 }
```
```javascript
var sayNode = function () {
    console.log('Node');
};
var es = 'ES';
```


- 이전 문법과 ES6문법의 비교

```javascript
// 기존의 JavaScript 문법(ES5)
var oldObject = {
    sayJS: function () {
        console.log('JS');
    },
    sayNode: sayNode,
};
oldObject[es + 6] = 'Fanstastic';  //oldObject의 속성으로 es+6의 값으로 Fanstastic 추가
// 출력
oldObject.sayNode();  // ▶ Node
oldObject.sayJS();    // ▶ JS
console.log(oldObject.ES6); // ▶ Fanstastic , 변수 es의 값이 ES이므로 ES6, es6 아님,
```

```javascript
// 위의 코드를 ES6문법으로 변경
const newObject = {
    sayJS(){   // 이전에는 sayJS가 key이고,펑션이 값인데 값에서 더이상 function을 쓰지 않아도 됨
        console.log('JS');
    },
    sayNode,   // {data: data, value: value} 이렇게 key와 값이 같은 경우 간단하게 표시 가능
    [es + 6]: 'Fanstastic', // 동적으로 객체를 변경할 때 객체 안에서 한번에 쓸수 있게 변경됨 
};
// 출력
newObject.sayNode();  // ▶ Node
newObject.sayJS();    // ▶ JS
console.log(newObject.ES6); // ▶ Fanstastic
```

※ 객체의 key에 변수가 들어가는 경우 동적으로 객체를 변경한다고 표현한다. 

​     이전에는 동적으로 객체를 변경할 때, 객체선언 밖에 별도로 선언해야만 했음, 

​     ES6은 객체 안에서 쓸 수 있게 변경 되었음, 즉, 좀 더 그룹화가 되었음

##### => 훨씬 코드가 간결해졌다. ES6을 사용하면 가독성이 좀 더 좋아지고, 타이핑을 좀 더 적게 한다.

**[⬆ back to top](#목차)**
&nbsp;

&nbsp;
## 4. 화살표 함수
-  화살표함수 하기 이전에 함수 정의..
```javascript
[ 함수 정의 ]
- 함수 선언문, 함수 표현식, Function()생성자함수 이렇게 3가지 방법으로 함수를 생성할 수 있다.
- JavaScript에서 함수는 조건에 의해 정의될 수 있다. (ex,if문 안에서 함수 정의)
- 자바스크립트 Guru로 알려진 더클러스 크락포드는 함수 생성에 있어서 함수 표현식만을 사용할 것을 권하고 있다. 그 이유는 함수 hoisting 때문이다.

[ 함수 선언문 ]
- 반드시 함수명이 정의되어 있어야 한다.
- 함수 선언 끌어올림(hoisting) 발생. 함수 실행코드가 선언보다 먼저 있어도 동작한다.

[ 함수 표현식 ]
- 생성된 함수를 변수에 할당하여 함수를 생성하는 것이 함수 표현식이라고 한다.
  ㅁ 함수가 할당된 변수를 함수 변수라고 한다.
- 함수 선언 끌어 올림이 없기 때문에, 반드시 실행보다 선언이 먼저 되어야 한다.
- 익명 함수를 만들 경우 이 이름을 생략할 수 있습니다.
  (함수의 이름이 생략되었다면, name속성의 값은 그 변수의 이름)
- 함수 표현식은 함수를 다른 함수의 매개변수로 전달할 때 편리하다.

// 함수 선언문
function add1(x, y){
  return x + y;
}

// add2() 함수 표현식,  함수 리터럴(자신이 데이터인 것을 말함) 방식, function(){}부분이 리터럴
var add2  = function(x, y) {
    return x + y;
}

// Function() 생성자 함수를 통한 함수 생성하기, 일반적으로 잘 쓰이지 않는다. 
new Function (arg1, arg2,...argN, functionBody)
var add = new Function('x','y','return x + y');
```

- 화살표 함수 

  - 화살표 함수는 함수 내부의 this를 외부의 this와 같게 만들어 준다. 

  - 원래 화살표함수 쓰기전에는 this는 window를 가져왔는데,

    화살표 함수를 씀으로써 외부의 this를 바로 가져온다.  즉, this의 동작을 조절할 수 있다.
```javascript
// 아래와 같은 방식으로 화살표함수로 변경한다. 
function(매개변수){			       (매개변수) =>{
    return 리턴값;          ==>       return 리턴값;
}   					      	  }

// ex, 기존 함수표현식을 화살표함수를 이용하여 변경
const add2  = function(x,y) {		const add2 = (x, y) => {
    return x + y;		   ==>	 		return x + y;
}									}

// 함수의 내용이 return밖에 없는 경우에 return글자와 {}를 생략할 수 있다. 
const add3 = (x,y) => {	   ==>   const add3 = (x,y) => x + y;
	return x + y;	       ==>   const add3 = (x,y) => (x + y); // 위랑 똑같은 거임
}						   ==>   const add3 = (x,y) => {x + y}; // 이건 안됨,   
```




- 기존 함수선언문 function은 ES6에서 사라지지 않고 살아남음.
  - function함수와 화살표함수는 내부 this가 동작하는 방식이 다르다.


```javaScript
// 메서드에서 this는,객체 리터럴에서 디스는 릴레이션1을 가리킴
var relationship1 = {	// relationship1이라는 객체 리터럴 생성, 
    name: 'zero',							//name 속성
    friends: ['nero', 'hero', 'xero'],		//friends 속성
    logFriends: function(){					//logFriends는 메서드 
        var that = this; // relationship1을 가리키는 this를 that에 저장
        this.friends.forEach(function(friend){
            console.log(that.name, friend);
        });
    },
};
relationship1.logFriends();
▶ zero nero
   zero hero
   zero xero

const relationship2 = {
    name: 'zero',
    friends: ['nero', 'hero', 'xero'],
    logFriends(){
        this.friends.forEach(friend => {
            console.log(this.name, friend);
        });
    },
};
relationship2.logFriends();
               
=> 예전에는 logFriends의 this를 가져오기 위해서 새로운 변수(that)에다가 대입한 후에 
다시 그것을 that.name으로 가져왔는데, 화살표함수를 사용함으로써 logFriends의 this를 바로 가져올 수 있다. 
```

**[⬆ back to top](#목차)**
&nbsp;
&nbsp;

## 5. 비구조화 할당(Destructuring)

- 객체 리터럴은 { } (객체리터럴) 로 감싼다.
  - const { status, getCandy } = candyMachine;
- 배열은 [ ] (배열) 로 감싼다. 
  - const [ node, obj, ,bool ] = array;

```javascript
var candyMachine = {					// candyMachine 객체 리터럴
    status: {							// status 객체가 또다른 속성
        name: 'node',
        count: 5,
    },
    getCandy: function(){				// getCandy 메서드
        this.status.count--;
        return this.status.count;
    }
};

// status 가져올려면 아래와 같이 가져옴
var status = candyMachine.status;		// 변수명과 속성명이 같음
var getCandy = candyMachine.getCandy;	// 변수명과 메서드명이 같음


// 위에 candyMachine을 es6으로 바꿔서 다시 보자 
const candyMachine = {
    status: {
        name: 'node',
        count: 5,
    },
    getCandy(){
        this.status.count--;
        return this.status.count;
    }
};
const status = candyMachine.status;		// 변수명과 속성명이 같음
const getCandy = candyMachine.getCandy;	// 변수명과 메서드명이 같음

// 만약 위에처럼 변수명이 속성명 또는 메서드명과 같을 경우, es6는 아래와 같이 사용 가능
const { status, getCandy } = candyMachine;	// 이것이 비구조화 할당
// candyMachine객체에서 status랑 getCandy를 변수로 꺼내오는 거다.

// 값 제대로 꺼내오는지 확인하기
status			=> {name: "node", count: 5}
getCandy()		=> undefined
candyMachine.getCandy(); => 4
//getCandy()앞에 getCandy를 갖고 있는 객체(candyMachine)가 붙어 있는 경우에 getCandy가 
//호출이 될 때 this를 candyMachine으로 만든다.  
//즉, this가 candyMachine을 파악할 수가 있어서 값이 제대로 나온다. 객체까지 제대로 붙어 있어야 제대로 동작한다.


[ getCandy()는 값이 제대로 나오지 않는 이유 ]
//getCandy()는 앞에 candyMachine. 이 없어서 getCandy가 this를(candyMachine) 못찾는다
//그래서 getCandy와 candyMachine이 분리가 되어 버리면, getCandy()는 제대로 동작하지 않는다.
//즉, 비구조화 할당 시 this가 의도와 다르게 동작하는 현상이 있기 때문이다.

// 화살표 함수로 해도 효과가 없고, candyMachine을 붙여줘야 한다.
candyMachine.getCandy(); 
getCandy.call(candyMachine); // 이렇게 하면 가능, this를 candyMachine로 바꿔주겠다. 

 
 앞에 객체까지 붙어 있어야 this가 제대로 동작한다. 
```
```javaScript
[ 비구조화 문법 ]
- 속성들을 변수로 꺼내올 때 효율성이 좋다
const a = 객체.a;
const b = 객체.b;
=> const { a, b } = 객체; //이렇게 변경 가능

// 노드에서 다음과 같은 코드가 많이 나온다. 
const { Router } = require('express'); 
// require express라는 객체에서 Router속성을 변수로 꺼내오겠다.
```

```javascript
[ 배열에서도 비구조화 할당 가능]
var array = ['nodejs', {}, 10, true];
// 배열에서 요소를 꺼내올 때 아래와 같이 가져왔었음
var node = array[0];
var obj = array[1];
var bool = array[array.length - 1];

// 위의 코드를 e6문법으로 아래와 같이 변경, wow ~ 
const array = ['nodejs', {}, 10, true];
const [node, obj, ,bool] = array;

const a = array[0];
const b = array[1];
=> const [a, b] = array; //이렇게 변경 가능
```

**[⬆ back to top](#목차)**
&nbsp;

&nbsp;
## 6. Rest
- (...변수)는 rest로 여러 개의 변수를 모아서 배열로 만든다.

```javascript
const array = ['nodejs', {}, 10, true];
const [node, obj, ...bool] = array;

const n = (x, ...y) => console.log(x, y) //첫번째 값은 x에 들어가고, 나머지는 y에 넣어라
n(5,6,7,8,9) ▶ 5 (4) [6, 7, 8, 9] 

// es5에는 아래와 같이 많이 사용했음,  
function o() {
    console.log(arguments)
}
o(1,2,3,4,5) ▶ Arguments(5) [1, 2, 3, 4, 5, callee: ƒ, Symbol(Symbol.iterator): ƒ]

// es6에서 arguments 찍는 방법, 
// 이게 좋은 이유는 rest는 배열이다. 배열의 메서드를 쓸 수 있다. 그래서 이 방식을 선호함
// arguments는 배열처럼 보이더라도 배열이 아니다.(유사배열이라고도 함)
const p = (...rest) => console.log(rest)
p(5,6,7,8,9) ▶ (5) [5, 6, 7, 8, 9]
```

**[⬆ back to top](#목차)**
&nbsp;

&nbsp;
## 7. Promise
~
**[⬆ back to top](#목차)**
&nbsp;

&nbsp;
## 8. async/await
~
**[⬆ back to top](#목차)**





