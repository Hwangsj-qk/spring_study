# Spring REST API

## Spring Framework 이해

### 레퍼런스
- Spring 공식 문서: [Spring Documentation](https://spring.io/projects/spring-framework)
- Spring Boot 가이드: [Spring Boot Guide](https://spring.io/guides/gs/spring-boot/)
- RESTful API 설계: [RESTful API Design](https://restfulapi.net/)

### Spring Framework 소개

- Spring Framework : 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크

#### 주요 특징
- IoC (Inversion of Control): 객체 생성 및 의존성 관리를 프레임워크가 담당.
- DI (Dependency Injection): 필요한 객체를 외부에서 주입받아 유연성과 테스트 용이성 증가.
- 모듈화: 독립적으로 사용 가능한 다양한 모듈로 구성.
- AOP (Aspect-Oriented Programming): 횡단 관심사를 모듈화하여 코드 중복 감소.
- 통합성: JPA, JMS, RabbitMQ 등 다양한 기술과의 통합 지원.
- 커뮤니티: 활발한 커뮤니티와 풍부한 생태계.

#### 주요 구성 요소
- Spring Core: IoC 컨테이너와 DI 제공 (BeanFactory, ApplicationContext).
- Spring Boot: 빠르고 쉽게 Spring 애플리케이션 개발 지원, 기본 설정 제공, 설정 작업 최소화.
- Spring Data: 데이터 접근 통합 (JPA, JDBC 등).
- Spring MVC: 웹 애플리케이션용 MVC 프레임워크.
- Spring Security: 인증 및 권한 부여 관리.
- Spring AOP: AOP 기능 제공.

### Spring 프로젝트 구조

- Spring 프로젝트는 다양한 계층과 구성 요소로 이루어져 있으며, 각 계층은 특정한 역할을 담당
- 이 구조는 코드의 유지보수성을 높이고, 각 계층의 책임을 명확히 하여 개발을 용이하게 함

#### 1. 프로젝트 기본 구조
- src/main/java: 애플리케이션의 주요 자바 소스 코드가 위치하는 디렉토리.
- src/main/resources: 설정 파일, 정적 리소스, 템플릿 등이 위치하는 디렉토리.
- src/test/java: 테스트 코드가 위치하는 디렉토리.
- src/test/resources: 테스트 설정 파일 등이 위치하는 디렉토리.

#### 2. 주요 패키지 구조
- com.example.project: 기본 패키지, 하위 패키지로 세분화.
   - controller: 웹 요청을 처리하는 컨트롤러 클래스.
   - service: 비즈니스 로직을 처리하는 서비스 클래스.
   - repository: 데이터베이스와의 상호작용을 담당하는 리포지토리 인터페이스.
   - model: 데이터베이스 테이블과 매핑되는 엔티티 클래스.
   - dto: 데이터 전송 객체 (Data Transfer Object) 클래스.
   - config: 설정 파일을 관리하는 클래스.

#### 3. 각 계층의 역할
- Controller (컨트롤러):
   - 클라이언트의 요청을 처리하고 응답을 반환.
   - @Controller 또는 @RestController 어노테이션 사용.
   - URL 매핑: @RequestMapping, @GetMapping, @PostMapping 등 사용.

- Service (서비스):
   - 비즈니스 로직을 처리.
   - @Service 어노테이션 사용.
   - 트랜잭션 관리: @Transactional 어노테이션 사용 가능.

- Repository (리포지토리):
   - 데이터베이스와의 상호작용 담당.
   - Spring Data JPA 사용 시, JpaRepository 인터페이스 상속.
   - CRUD 메서드 제공: save, findById, findAll, delete 등.

- Model (모델):
   - 데이터베이스 테이블과 매핑되는 엔티티 클래스.
   - @Entity 어노테이션 사용.
   - 필드에 @Id, @Column 등 어노테이션 사용.

- DTO (데이터 전송 객체):
   - 클라이언트와의 데이터 전송을 위한 객체.
   - 주로 서비스 계층과 컨트롤러 계층 간의 데이터 전달에 사용.

- Config (설정):
   - 애플리케이션 설정 클래스.
   - @Configuration 어노테이션 사용.
   - Bean 정의, 보안 설정 등.

#### 4. 프로젝트 설정 파일
- application.properties 또는 application.yml:
   - 애플리케이션 설정을 정의하는 파일.
   - 데이터베이스 연결 정보, 서버 포트, 로깅 설정 등 포함.

- pom.xml (Maven) 또는 build.gradle (Gradle):
   - 프로젝트의 의존성을 관리하는 파일.
   - Spring Boot, JPA, Web, Security 등 필요한 라이브러리 선언.

#### 5. 예제 프로젝트 구조
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── project
│   │               ├── controller
│   │               ├── service
│   │               ├── repository
│   │               ├── model
│   │               ├── dto
│   │               └── config
│   └── resources
│       ├── static
│       ├── templates
│       └── application.properties
└── test
    ├── java
    │   └── com
    │       └── example
    │           └── project
    └── resources
```

### Spring Boot 소개

#### Spring Boot의 개요
- 목적: Spring Framework를 쉽게 사용하고, 설정을 최소화하여 신속하게 애플리케이션을 개발하도록 돕는 도구입니다.
- 특징: 미리 정의된 설정, 자동 구성, 독립 실행 가능한 애플리케이션을 생성할 수 있습니다.
- 장점
   - 복잡한 설정 없이 빠르게 애플리케이션을 시작할 수 있음.
   - 기본 설정과 자동 구성을 통해 초기 설정 시간 절약
   - 설정 파일을 통해 외부 구성 관리 (application.properties 또는 application.yml) 등


#### 주요 특징
- 자동 구성 (Auto-Configuration):
   - 애플리케이션의 설정을 자동으로 구성.
   - 필요한 설정을 자동으로 찾아 적용하여 개발자의 설정 부담을 줄임.

- 스타터 의존성 (Starter Dependencies):
   - 특정 기능을 쉽게 추가할 수 있도록 도와주는 의존성 모음.
   - 예: `spring-boot-starter-web`는 웹 애플리케이션 개발을 위한 모든 필요한 의존성을 포함.

- 독립 실행 가능한 JAR 생성:
   - 내장 웹 서버(Tomcat, Jetty, Undertow)를 포함한 독립 실행 가능한 JAR 파일 생성.
   - 별도의 WAS(Web Application Server) 없이 실행 가능.

- 프로덕션 준비 기능:
   - 모니터링, 로깅, 외부 구성 등을 위한 다양한 기능 제공.
   - Spring Boot Actuator를 통해 애플리케이션 상태 모니터링 및 관리 가능.

- Spring Initializr:
   - 웹 인터페이스를 통해 Spring Boot 프로젝트를 손쉽게 생성.
   - 필요한 의존성을 선택하고, 프로젝트 구조를 자동으로 생성.


#### 주요 구성 요소
- Spring Boot Starter:
   - 필요한 기능을 쉽게 추가할 수 있도록 도와주는 의존성 모음.
   - 예: `spring-boot-starter-data-jpa`, `spring-boot-starter-security`.

- Spring Boot DevTools:
   - 개발 시 편리함을 제공하는 도구 모음.
   - 자동 재시작, 라이브 릴로드, 구성 파일 변경 시 즉시 반영 등.

- 프로젝트 생성: Spring Initializr 사용
   - URL: [start.spring.io](https://start.spring.io)
   - 필요한 의존성 선택 (예: Web, JPA, H2 등.)


### Spring Boot 환경 설정 및 프로젝트 생성

#### 1. Spring Boot 환경 설정

##### 기본 도구 설치
- Java Development Kit (JDK):
   - JDK 17 이상 버전을 설치.
- IDE (통합 개발 환경):
   - IntelliJ IDEA, Eclipse, VS Code 등.
- 빌드 도구:
   - Maven 또는 Gradl

#### 2. Spring Boot 프로젝트 생성

##### Spring Initializr 사용
- 웹 인터페이스: [start.spring.io](https://start.spring.io)
- 설정 선택:
   - Project: Gradle - Groovy (빌드 도구)
   - Language: Java           (언어 선택)
   - Spring Boot Version: 최신 안정화 버전 선택
   - Project Metadata:
      - Group: com.busanit   (프로젝트 그룹 이름)
      - Artifact: spring-study       (프로젝트의 아이디)
      - Name: spring-study           (프로젝트 이름 - 일반적으로 아티팩트 이름)
      - Package Name: com.example.spring_study   (프로젝트 패키지 명: 그룹 + 아티팩트 )
      - Packaging: Jar       (패키징 방법)
      - Java Version: 17 이상
   - Dependencies: 필요한 의존성 추가 (예: Spring Web, Spring Data JPA, H2 Database )

##### 프로젝트 다운로드 및 실행
1. 프로젝트 생성:
   - 필요한 설정을 선택하고 "Generate" 버튼 클릭.
   - ZIP 파일 다운로드 후, 원하는 위치에 압축 해제.

2. IDE에서 프로젝트 열기:
   - IntelliJ IDEA, Eclipse, 또는 VS Code에서 프로젝트를 열기.
   - 프로젝트의 루트 디렉토리에 있는 `pom.xml` (Maven) 또는 `build.gradle` (Gradle) 파일을 통해 프로젝트를 불러옴.

3. 의존성 다운로드:
   - IDE가 자동으로 의존성을 다운로드하고 프로젝트를 빌드.

#### 3. 기본 애플리케이션 설정 및 실행

##### Main 클래스 생성
- Spring Boot 애플리케이션의 진입점:
  ```java
	package com.example.spring_study;

	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	@SpringBootApplication
	public class SpringStudyApplication {
	    public static void main(String[] args) {
	        SpringApplication.run(SpringStudyApplication.class, args);
	    }
	}
  ```
##### 브라우저에서 확인
- 웹 브라우저: `http://localhost:8080/

##### application.properties 설정
- src/main/resources/application.properties 파일 생성.
  ```properties
  server.port=8080
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=password
  spring.h2.console.enabled=true
  ```

##### 간단한 REST 컨트롤러 생성
- Hello World REST API:
  ```java
	package com.example.spring_study.controller;

	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class HelloWorldController {
	    @GetMapping("/hello")
	    public String hello() {
	        return "Hello, World!";
	    }
	}
  ```

##### 애플리케이션 실행
- IDE에서 실행:
   - Main 클래스 (`DemoApplication`)의 main 메서드를 실행.
- 터미널에서 실행:
   - Maven: `mvn spring-boot:run`
   - Gradle: `./gradlew bootRun`

##### 브라우저에서 확인
- 웹 브라우저: `http://localhost:8080/hello`로 접속하여 "Hello, World!" 메시지를 확인.

---


### IoC (제어의 역전) 개념

#### 정의
- Inversion of Control (IoC): 객체의 생성 및 제어 권한을 개발자가 아닌 프레임워크나 컨테이너에 위임하는 디자인 원칙.

#### 주요 특징
- 객체의 생성 및 관리: 프레임워크가 객체를 생성하고, 의존성을 주입하며, 생명주기를 관리.
- 유연성 증가: 애플리케이션 코드의 결합도 감소, 유연성 및 재사용성 증가.
- 테스트 용이성: 객체 간의 의존성을 명확히 하여 유닛 테스트와 모킹이 쉬워짐.

#### IoC 구현 방식
- Dependency Injection (DI): 객체가 필요한 의존성을 외부에서 주입받는 방식.
   - Constructor Injection: 생성자를 통해 의존성 주입.
   - Setter Injection: Setter 메서드를 통해 의존성 주입.
   - Field Injection: 필드에 직접 의존성 주입 (@Autowired 사용).

- Service Locator: 객체가 자신이 필요한 의존성을 런타임에 검색하여 사용하는 방식.

#### Spring Framework에서의 IoC
- IoC 컨테이너: Spring의 핵심 부분으로, BeanFactory와 ApplicationContext가 대표적.
   - BeanFactory: IoC 컨테이너의 기본 구현체.
   - ApplicationContext: BeanFactory를 확장한 컨테이너로, 추가적인 기능 (예: 이벤트 처리, 메시지 소스 처리) 제공.

#### IoC의 장단점
- 장점
   - 모듈성 향상: 컴포넌트 간의 결합도를 낮추어 모듈화가 쉬워짐.
   - 유연성 증가: 객체 간의 의존성을 쉽게 교체 가능.
   - 테스트 용이성: 의존성을 주입받기 때문에 단위 테스트 시 Mock 객체 사용이 쉬움.

- 단점
   - 복잡성 증가: IoC 컨테이너 사용으로 인해 초기 설정이 복잡해질 수 있음.
   - 추적 어려움: 의존성 주입이 자동으로 이루어지기 때문에 코드에서 객체 생성과 의존성 주입의 흐름을 추적하기 어려울 수 있음.

### Annotation 기반의 스프링 Bean 관리

- Spring Framework는 어노테이션을 사용하여 간편하고 명확하게 Bean을 정의하고 관리
   - 이전에 사용하던 XML 설정보다 직관적이며, 코드와 설정을 통합. 유지보수가 용이.
   - 컴포넌트 스캔을 통해 자동으로 Bean을 등록하여 자동 구성

- Spring Bean:
   - Spring 컨테이너에 의해 관리되는 객체.
   - 애플리케이션의 구성 요소로, 의존성 주입을 통해 관리됨.
   - Bean은 Spring IoC (Inversion of Control) 컨테이너에 의해 생성, 구성, 관리 및 제거됨.

#### 주요 어노테이션

1. @Component
   - 역할: 일반적인 Spring Bean으로 등록.
   - 사용 위치: 클래스.
   - 설명: Spring 컨테이너에서 자동으로 인식하고 관리하는 Bean으로 등록. 모든 구성 요소에 사용할 수 있는 범용 어노테이션.

2. @Service
   - 역할: 비즈니스 로직을 수행하는 서비스 클래스.
   - 사용 위치: 클래스.
   - 설명: @Component의 특수화. 비즈니스 로직을 처리하는 클래스에 사용하여, 명시적으로 서비스 계층임을 나타냄.

3. @Repository
   - 역할: 데이터 접근 계층 (DAO) 클래스.
   - 사용 위치: 클래스.
   - 설명: @Component의 특수화. 데이터베이스 접근 로직을 처리하는 클래스에 사용. 데이터 접근 관련 예외를 Spring의 DataAccessException으로 변환하는 기능 포함.

4. @Controller
   - 역할: 웹 요청을 처리하는 컨트롤러 클래스.
   - 사용 위치: 클래스.
   - 설명: @Component의 특수화. MVC 패턴의 프레젠테이션 계층을 담당. 웹 요청을 처리하고 적절한 뷰를 반환하는 클래스에 사용.

5. @RestController
   - 역할: RESTful 웹 서비스를 위한 컨트롤러 클래스.
   - 사용 위치: 클래스.
   - 설명: @Controller와 @ResponseBody의 조합. JSON/XML 형식의 응답을 반환하는 RESTful 웹 서비스 엔드포인트를 처리하는 클래스에 사용.

6. @Autowired
   - 역할: 의존성 주입.
   - 사용 위치: 생성자, 세터, 필드.
   - 설명: Spring이 자동으로 Bean을 주입하여 의존성을 해결. 생성자, 세터 메서드 또는 필드에 적용 가능.

7. @Configuration
   - 역할: 스프링 설정 클래스.
   - 사용 위치: 클래스.
   - 설명: 설정을 자바 코드로 정의하는 클래스에 사용. @Bean 어노테이션을 사용하여 Bean을 정의하는 메서드를 포함.

8. @Bean
   - 역할: @Configuration 클래스 내에서 Bean 정의.
   - 사용 위치: 메서드.
   - 설명: 해당 메서드의 리턴 객체를 Spring Bean으로 등록. @Configuration 클래스 내에서 사용하여 Bean 설정을 정의.

9. @ComponentScan
   - 역할: 특정 패키지를 스캔하여 @Component, @Service, @Repository, @Controller 등을 자동으로 Bean으로 등록.
   - 사용 위치: @Configuration 클래스.
   - 설명: basePackages 속성을 사용하여 스캔할 패키지를 지정. 지정된 패키지 내의 클래스를 자동으로 검색하여 Bean으로 등록.


---

## REST API

### 레퍼런스

1. [MDN Web Docs - HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP)
2. [웹의 리소스 식별하기](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/Identifying_resources_on_the_Web)
2. [REST API Tutorial](https://restfulapi.net/)
5. [HTTP Status Codes](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)

### 네트워킹 기본 개념

1. 네트워크(Network)
   - 정의: 두 대 이상의 컴퓨터가 데이터를 교환할 수 있는 시스템.
   - 종류:
      - LAN (Local Area Network): 가까운 거리의 네트워크, 예를 들어 한 건물 내에서.
      - WAN (Wide Area Network): 넓은 지역을 커버하는 네트워크, 예를 들어 인터넷.

2. 클라이언트-서버 모델(Client-Server Model)
   - 클라이언트(Client): 서비스를 요청하는 컴퓨터 또는 프로그램.
   - 서버(Server): 클라이언트의 요청을 처리하고 응답하는 컴퓨터 또는 프로그램.

#### HTTP 프로토콜

1. HTTP (HyperText Transfer Protocol)
   - 정의: 웹 상에서 데이터를 주고받기 위한 프로토콜.
   - 특징:
      - 무상태성(Statelessness): 각 요청은 독립적이며, 서버는 요청 간의 상태를 저장하지 않음.
      - HTTP 메소드:
         - GET: 리소스를 조회.
         - POST: 새로운 리소스를 생성.
         - PUT: 기존 리소스를 업데이트.
         - DELETE: 리소스를 삭제.
      - HTTP 상태 코드:
         - 200 OK: 요청 성공.
         - 404 Not Found: 요청한 리소스를 찾을 수 없음.
         - 500 Internal Server Error: 서버 내부 오류.

2. HTTP 요청과 응답 구조
   - HTTP 요청: 클라이언트가 서버에 데이터를 요청할 때 사용.
      - 요청 라인: 메소드, URL, HTTP 버전.
      - 헤더(Header): 요청의 메타데이터.
      - 본문(Body): 요청 데이터(옵션).
   - HTTP 응답: 서버가 클라이언트에 데이터를 응답할 때 사용.
      - 응답 라인: HTTP 버전, 상태 코드, 상태 메시지.
      - 헤더(Header): 응답의 메타데이터.
      - 본문(Body): 응답 데이터(옵션).

#### REST API

1. REST (Representational State Transfer)
   - 정의: 자원을 이름(URI)으로 구분하고, 해당 자원의 상태를 주고받는 웹 아키텍처 스타일.
   - 특징:
      - 무상태성(Statelessness): 서버는 클라이언트 상태를 저장하지 않음.
      - 캐시 가능(Cacheable): 응답은 캐시될 수 있음.
      - 일관된 인터페이스(Uniform Interface): 자원 접근을 위한 일관된 방법 제공.
      - 계층형 시스템(Layered System): 여러 계층으로 구성된 시스템.
   - 구성 요소:
      - 자원(Resource): URI로 식별되는 모든 데이터.
      - 표현(Representation): 자원의 상태를 나타내는 데이터(JSON, XML 등).
      - 메소드(Method): 자원에 대해 수행할 작업(GET, POST, PUT, DELETE).

2. RESTful API
   - 정의: REST 원칙을 따르는 API.
   - 사용 사례:
      - 웹 애플리케이션: 프론트엔드와 백엔드 간의 데이터 통신.
      - 모바일 애플리케이션: 서버와 데이터 통신.
      - 사물 인터넷(IoT): 디바이스 간의 데이터 통신.

### REST (Representational State Transfer)의 개요
- REST: 네트워크 아키텍처 스타일의 하나로, 웹 서비스 개발에 주로 사용됨.
- 창시자: Roy Fielding, 그의 박사 논문에서 소개.

#### REST의 주요 원칙
- 정의: 자원을 이름(URI)으로 구분하고, 해당 자원의 상태를 주고받는 웹 아키텍처 스타일.
- 특징:
   - 무상태성(Statelessness): 서버는 클라이언트 상태를 저장하지 않음.
   - 캐시 가능(Cacheable): 응답은 캐시될 수 있음.
   - 계층형 시스템(Layered System): 여러 계층으로 구성된 시스템.
   - 일관된 인터페이스(Uniform Interface): 자원 접근을 위한 일관된 방법 제공.
   -   자원 식별 (Identification of Resources): URI를 통해 자원을 식별.
   - 자원 조작 (Manipulation of Resources through Representations): 자원의 표현을 통해 자원 조작.
- 구성 요소:
   - 자원(Resource): URI로 식별되는 모든 데이터.
   - 표현(Representation): 자원의 상태를 나타내는 데이터(JSON, XML 등).
   - 메소드(Method): 자원에 대해 수행할 작업(GET, POST, PUT, DELETE).

#### REST 아키텍처 스타일

- 자원 중심 (Resource-Oriented)
   - 자원 (Resource): URI를 통해 고유하게 식별되는 개체.
   - HTTP 메서드 사용: GET, POST, PUT, DELETE 등 표준 HTTP 메서드 사용.
   - 표현 (Representation): JSON, XML 등을 사용하여 자원의 상태를 표현.

- 표준화된 통신 방식
   - HTTP 프로토콜 사용: REST는 HTTP 프로토콜을 기반으로 통신.
   - 상태 코드 사용: HTTP 상태 코드를 통해 응답의 상태를 전달 (예: 200 OK, 404 Not Found, 500 Internal Server Error).

- 하이퍼미디어 (Hypermedia)
   - HATEOAS: 클라이언트가 서버 응답 내의 하이퍼링크를 통해 애플리케이션의 상태를 탐색할 수 있음.
   - 유연한 확장: 클라이언트와 서버 간의 계약이 변경되더라도 하이퍼링크를 통해 쉽게 탐색 가능.

#### REST의 장점
- 단순성: 표준 HTTP 메서드와 상태 코드 사용으로 직관적이고 간단.
- 유연성: 클라이언트와 서버의 독립적 발전 가능.
- 확장성: Stateless 원칙으로 인해 서버 확장 용이.
- 성능: 캐싱을 통한 성능 최적화 가능.

#### REST의 단점
- 복잡성 증가: 매우 복잡한 트랜잭션의 경우 상태 유지를 위해 추가 작업 필요.
- 표준의 부족: 일부 경우, 완전한 표준화 부족으로 인해 구현 상의 차이가 발생할 수 있음.

---

### RESTful 서비스의 특징

#### 1. 자원 기반 설계
- 자원 (Resource):
   - 모든 자원은 고유한 URI로 식별.
   - 예: `/users`, `/products/123`
- 표현 (Representation):
   - 자원의 상태는 JSON, XML 등의 형식으로 전달.

#### 2. 표준 HTTP 메서드 사용
- GET:
   - 자원의 조회.
   - 예: `GET /users`
- POST:
   - 자원의 생성.
   - 예: `POST /users`
- PUT:
   - 자원의 전체 업데이트.
   - 예: `PUT /users/123`
- PATCH:
   - 자원의 부분 업데이트.
   - 예: `PATCH /users/123`
- DELETE:
   - 자원의 삭제.
   - 예: `DELETE /users/123`

#### 3. 표준 HTTP 상태 코드 사용
- 2xx (성공):
   - 예: 200 OK, 201 Created
- 4xx (클라이언트 오류):
   - 예: 400 Bad Request, 404 Not Found
- 5xx (서버 오류):
   - 예: 500 Internal Server Error

--- 

### API 설계 원칙

#### 1. 자원 중심 설계 (Resource-Oriented Design)
- 자원 (Resource):
   - 모든 엔드포인트는 자원을 나타내야 함.
   - 자원은 명사로 표현 (예: `/users`, `/orders/123`).
   - 자원은 고유한 URI로 식별.
- URI 구조:
   - 간결하고 직관적인 URI 사용.
   - 중첩된 자원 표현 (예: `/users/{userId}/orders`).

#### 2. HTTP 메서드의 의미에 맞는 사용
- GET:
   - 자원의 조회.
   - 안전하며, 서버의 상태를 변경하지 않음.
- POST:
   - 자원의 생성.
   - 요청 본문에 새로운 자원의 세부 정보 포함.
- PUT:
   - 자원의 전체 업데이트.
   - 요청 본문에 자원의 전체 세부 정보 포함.
- PATCH:
   - 자원의 부분 업데이트.
   - 요청 본문에 변경할 부분의 세부 정보 포함.
- DELETE:
   - 자원의 삭제.

#### 3. HTTP 상태 코드의 적절한 사용
- 2xx (성공):
   - `200 OK`: 요청이 성공적으로 처리됨.
   - `201 Created`: 새로운 자원이 생성됨.
   - `204 No Content`: 요청이 성공적으로 처리되었으나, 응답 본문이 없음.
- 4xx (클라이언트 오류):
   - `400 Bad Request`: 잘못된 요청.
   - `401 Unauthorized`: 인증 필요.
   - `403 Forbidden`: 권한 부족.
   - `404 Not Found`: 자원을 찾을 수 없음.
- 5xx (서버 오류):
   - `500 Internal Server Error`: 서버 오류.
   - `503 Service Unavailable`: 서비스 이용 불가.

#### 4. 일관된 API 디자인
- 일관성:
   - URI, HTTP 메서드, 상태 코드의 일관된 사용.
- 표준화된 응답 형식:
   - JSON 또는 XML 등 일관된 형식 사용.
   - 에러 메시지 형식도 표준화 (예: `{ "error": "Resource not found" }`).

#### 5. 페이징, 필터링, 정렬 지원
- 페이징:
   - 큰 데이터셋을 작은 부분으로 나누어 제공.
   - 예: `GET /users?page=2&size=50`.
- 필터링:
   - 특정 조건에 따라 자원을 필터링.
   - 예: `GET /users?status=active`.
- 정렬:
   - 특정 기준에 따라 자원 정렬.
   - 예: `GET /users?sort=name,asc`.

#### 6. 보안 고려
- 인증:
   - API 접근에 대한 인증 요구.
   - 토큰 기반 인증 (예: JWT) 사용.
- 권한 부여:
   - 사용자 권한에 따라 접근 제어.
- 데이터 보호:
   - HTTPS를 통해 데이터 암호화.

---

### REST API 확인 관련 도구

### 1. 웹 브라우저 개발자 도구의 Network 탭

#### 주요 기능
- HTTP 요청 및 응답 모니터링
- 요청 상세 정보 확인: 요청 헤더, 응답 헤더, 페이로드, 응답 데이터 등
- 성능 분석: 로드 시간, 대기 시간 등
- Chrome, Edge, FireFox 등에 내장

#### 사용법
1. 개발자 도구 열기: 단축키 `F12` 또는 `Ctrl+Shift+I` (우클릭 후 검사, 개발자도구)
2. Network 탭 선택
3. 웹 페이지 새로고침 (`F5`): 모든 네트워크 요청 캡처
4. 요청 분석: 웹 페이지에서 특정 작업 수행 후 Network 탭 확인:
   - 요청 목록에서 요청 항목 클릭
   - Headers 탭: 요청 URL, 메서드, 상태 코드, 요청 및 응답 헤더 확인
   - Response 탭: 서버로부터 받은 응답 데이터 확인

### 2. Postman API (포스트맨)

#### 주요 기능
- HTTP 요청 작성: GET, POST, PUT, DELETE 등
- 요청 헤더 및 바디 설정
- 응답 검토: JSON, XML, HTML 형식 지원
- 컬렉션 및 환경 설정: 요청 그룹 관리, 환경 변수 설정

#### 사용법
1. POSTMAN 설치 및 실행: [POSTMAN 공식 사이트](https://www.postman.com/downloads/)

2. 새 요청 작성:
   - `New` 버튼 클릭, `Request` 선택
   - 요청 이름 입력, 컬렉션 선택

3. HTTP 메서드 및 URL 설정:
   - 메서드 선택: GET, POST, PUT, DELETE 등
   - URL 입력: 예) `GET http://localhost:8080/hello`

4. 요청 헤더 및 바디 설정:
   - Headers 탭: 필요한 요청 헤더 추가
   - Body 탭: 요청 바디 설정 (예: JSON 데이터)

5. 요청 전송 및 응답 검토:
   - `Send` 버튼 클릭: 요청 전송
   - 응답 패널 확인: 상태 코드, 응답 시간, 응답 바디 등


---

### Spring을 이용한 RESTful API: Spring MVC 기초

#### 1. Spring MVC 개요
- Spring MVC (Model-View-Controller): Spring Framework의 웹 애플리케이션 개발을 위한 모듈.
- MVC 패턴: 웹 애플리케이션의 구조를 Model, View, Controller 세 부분으로 나누어 역할을 분리.

#### @Controller와 @RestController의 차이

- @Controller
   - 역할: 요청을 처리하고 적절한 뷰를 반환하는 컨트롤러 클래스에 사용.
   - 설명: MVC 패턴에서 프레젠테이션 계층을 담당.

- @RestController
   - 역할: RESTful 웹 서비스의 컨트롤러 클래스에 사용.
   - 설명: @Controller와 @ResponseBody의 조합으로 자바 객체를 JSON 형식으로 변환하여 HTTP 응답 본문에 반환.

#### 요청 매핑

1. @RequestMapping
   - 역할: 요청 URL을 메서드와 매핑.
   - 설명: 클래스 또는 메서드 레벨에서 사용 가능.
   - 예제: `@RequestMapping("/users")`는 "/users" 경로와 매핑.

2. @GetMapping
   - 역할: GET 요청을 처리.
   - 설명: `@RequestMapping(method = RequestMethod.GET)`의 축약형.
   - 예제: `@GetMapping("/users")`

3. @PostMapping
   - 역할: POST 요청을 처리.
   - 설명: `@RequestMapping(method = RequestMethod.POST)`의 축약형.
   - 예제: `@PostMapping("/users")`

4. @PutMapping
   - 역할: PUT 요청을 처리.
   - 설명: `@RequestMapping(method = RequestMethod.PUT)`의 축약형.
   - 예제: `@PutMapping("/users/{id}")`

5. @DeleteMapping
   - 역할: DELETE 요청을 처리.
   - 설명: `@RequestMapping(method = RequestMethod.DELETE)`의 축약형.
   - 예제: `@DeleteMapping("/users/{id}")`

#### 데이티 전송 및 데이터 바인딩
- 클라이언트와 서버 간의 데이터 전송 및 바인딩을 효율적으로 처리할 수 있는 다양한 어노테이션

1. @RequestParam
- 역할: 요청의 쿼리 파라미터, 폼 데이터 등을 메서드 매개변수에 바인딩.
- 예시:
  ```java
  @GetMapping("/users")
  public List<User> getUsersByStatus(@RequestParam("status") String status) {
      // status 파라미터로 필터링된 사용자 목록 반환
  }
  ```

2. @PathVariable
- 역할: URI 경로 변수 값을 메서드 매개변수에 바인딩.
- 예시:
  ```java
  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable("id") Long id) {
      // id에 해당하는 사용자 반환
  }
  ```

3. @RequestBody
- 역할: HTTP 요청 본문을 객체로 바인딩.
- 설명: 주로 POST, PUT 요청에서 사용되며, JSON/XML 형식의 요청 본문을 자바 객체로 변환.
- 예시:
  ```java
  @PostMapping("/users")
  public User createUser(@RequestBody User user) {
      // 요청 본문을 User 객체로 변환하여 사용자 생성
  }
  ```

4. @RequestHeader
- 역할: 요청 헤더 값을 메서드 매개변수에 바인딩.
- 예시:
  ```java
  @GetMapping("/users")
  public List<User> getUsers(@RequestHeader("Authorization") String token) {
      // Authorization 헤더 값을 사용
  }
  ```

---

## 데이터베이스 연동

### Spring Data JPA

### 데이터베이스 연동: Spring Data JPA 소개

#### Spring Data JPA 개요
- Spring Data JPA: Spring Framework의 하위 프로젝트로, JPA(Java Persistence API) 기반의 데이터 접근을 단순화하는 라이브러리.
- 목적: 복잡한 데이터 접근 코드를 최소화하고, 데이터베이스와의 상호작용을 간편하게 처리.
- Repository 인터페이스: 기본 CRUD 및 커스텀 메서드 지원.

#### 엔티티 (Entity)

- 엔티티(Entity)는 데이터베이스 테이블과 매핑되는 객체입니다. 애플리케이션 내에서 데이터를 구조화하고, 데이터베이스와의 상호작용을 위한 객체-관계 매핑(ORM)을 제공합니다.

##### 주요 특징
- 데이터베이스 테이블과 매핑: 엔티티 클래스는 데이터베이스의 테이블과 매핑.
- 상태 저장: 엔티티는 애플리케이션에서 데이터의 상태를 저장하고 전송하는 데 사용됨.
- 영속성 컨텍스트: 엔티티는 영속성 컨텍스트(persistence context)에 의해 관리됨.

##### 주요 어노테이션
- @Entity: 클래스가 엔티티임을 지정하고 데이터베이스 테이블과 매핑됨을 명시.
- @Table: 엔티티와 매핑되는 테이블의 세부 정보를 설정 (생략 시 클래스 이름이 테이블 이름으로 사용됨).
- @Id: 기본 키(primary key) 필드를 지정.
- @GeneratedValue: 기본 키의 생성 전략을 지정.
- @Column: 테이블의 컬럼과 매핑되는 필드를 지정.

#### 리포지토리 (Repository)

- 리포지토리(Repository)는 데이터베이스에 접근하고, 엔티티 객체를 영속성(persistence) 계층에서 관리하는 인터페이스입니다. Spring Data JPA에서 제공하는 리포지토리 인터페이스를 통해 기본적인 CRUD 작업을 쉽게 구현할 수 있습니다.

##### 주요 특징
- 데이터 접근 추상화: 리포지토리는 데이터베이스와의 상호작용을 추상화하여, 데이터 접근 로직을 분리합니다.
- 자동 구현: Spring Data JPA는 리포지토리 인터페이스를 자동으로 구현하여 런타임에 인스턴스를 생성합니다.
- 확장성: 기본 CRUD 메서드 외에도 커스텀 쿼리 메서드를 정의할 수 있습니다.

##### 주요 어노테이션

1. @Repository
   - 역할: 데이터 접근 계층을 나타내는 어노테이션.
   - 설명: Spring Data JPA 리포지토리 인터페이스에 사용.

2. @Query
   - 역할: 커스텀 쿼리를 정의.
   - 설명: 메서드에 직접 쿼리를 작성하여 실행.

#### Spring Data JPA 설정 및 사용

##### 1. 프로젝트 설정

###### build.gradle 의존성 추가
```groovy

dependencies {
	...
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    ...
}
```

###### application.properties 설정 추가
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

##### 2. 엔티티 클래스 정의

```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
```

##### 3. 리포지토리 인터페이스 정의

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD 메서드를 자동으로 제공
    // 커스텀 쿼리 메서드 정의 가능
}
```

#### 주요 CRUD 메서드

1. Create (생성)

   - save(S entity):
      - 설명: 새로운 엔티티를 데이터베이스에 저장하거나 기존 엔티티를 업데이트.
      - 예제:
        ```java
        User newUser = new User();
        newUser.setName("John Doe");
        newUser.setEmail("john.doe@example.com");
        userRepository.save(newUser);
        ```

2. Read (조회)

   - findById(ID id):
      - 설명: 기본 키를 사용하여 엔티티를 조회.
      - 반환 타입: Optional<T>
      - 예제:
        ```java
        Optional<User> user = userRepository.findById(1L);
        ```

   - findAll():
      - 설명: 모든 엔티티를 조회.
      - 반환 타입: List<T>
      - 예제:
        ```java
        List<User> users = userRepository.findAll();
        ```

   - findAllById(Iterable<ID> ids):
      - 설명: 주어진 ID 리스트에 해당하는 모든 엔티티를 조회.
      - 반환 타입: List<T>
      - 예제:
        ```java
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<User> users = userRepository.findAllById(ids);
        ```

3. Update (갱신)
   - 설명: JpaRepository에서는 save 메서드를 사용하여 기존 엔티티를 갱신할 수 있음. 엔티티의 ID가 존재하면 업데이트, 존재하지 않으면 생성.
   - 예제:
     ```java
     User existingUser = userRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
     existingUser.setEmail("new.email@example.com");
     userRepository.save(existingUser);
     ```

4. Delete (삭제)

   - deleteById(ID id):
      - 설명: 기본 키를 사용하여 엔티티를 삭제.
      - 예제:
        ```java
        userRepository.deleteById(1L);
        ```

   - delete(T entity):
      - 설명: 주어진 엔티티를 삭제.
      - 예제:
        ```java
        User user = userRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
        userRepository.delete(user);
        ```

   - deleteAll():
      - 설명: 모든 엔티티를 삭제.
      - 예제:
        ```java
        userRepository.deleteAll();
        ```

   - deleteAll(Iterable<? extends T> entities):
      - 설명: 주어진 엔티티 목록을 삭제.
      - 예제:
        ```java
        List<User> users = userRepository.findAll();
        userRepository.deleteAll(users);
        ```

#### 기타 유용한 메서드

- count():
   - 설명: 엔티티의 총 개수를 반환.
   - 예제:
     ```java
     long userCount = userRepository.count();
     ```

- existsById(ID id):
   - 설명: 주어진 ID의 엔티티가 존재하는지 여부를 반환.
   - 예제:
     ```java
     boolean exists = userRepository.existsById(1L);
     ```

### 요약
- save: 새로운 엔티티 생성 및 기존 엔티티 업데이트.
- findById: ID를 사용하여 엔티티 조회.
- findAll: 모든 엔티티 조회.
- deleteById: ID를 사용하여 엔티티 삭제.
- delete: 주어진 엔티티 삭제.
- deleteAll: 모든 엔티티 삭제.
- count: 총 엔티티 개수 반환.
- existsById: 주어진 ID의 엔티티 존재 여부 확인.

---
### H2 데이터베이스와 스프링 연동 및 설정

H2 데이터베이스는 자바로 작성된 경량의 임베디드 관계형 데이터베이스입니다. Spring Boot와 함께 사용하면 개발 및 테스트 환경에서 매우 유용합니다.

#### 1. H2 데이터베이스와 스프링 연동 설정

##### 1.1. 프로젝트 의존성 추가
`build.gradle` 파일에 H2 데이터베이스와 Spring Data JPA 의존성을 추가합니다.

```groovy
dependencies {
    ...
    implementation 'com.h2database:h2'
}
```

##### 1.2. 데이터베이스 설정
`src/main/resources/application.properties` 파일에 H2 데이터베이스 설정을 추가합니다.

```properties
# H2 Database configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# Enable H2 console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

- spring.datasource.url: H2 데이터베이스의 URL. `jdbc:h2:mem:testdb`는 메모리 모드의 H2 데이터베이스를 의미.
- spring.datasource.driverClassName: H2 드라이버 클래스 이름.
- spring.datasource.username: 데이터베이스 사용자 이름 (`sa`는 기본값).
- spring.datasource.password: 데이터베이스 비밀번호 (기본값은 빈 문자열).
- spring.jpa.database-platform: Hibernate가 사용할 방언(Dialect) 설정.
- spring.jpa.hibernate.ddl-auto: Hibernate가 데이터베이스 스키마를 생성 및 업데이트하는 방식 설정.
- spring.h2.console.enabled: H2 콘솔 활성화 여부.
- spring.h2.console.path: H2 콘솔의 접속 경로 설정.

#### 2. H2 데이터베이스 콘솔 사용

##### 2.1. H2 콘솔 접속
Spring Boot 애플리케이션을 실행한 후 웹 브라우저에서 H2 콘솔에 접속합니다. 기본 경로는 `http://localhost:8080/h2-console`입니다.

##### 2.2. H2 콘솔 설정
H2 콘솔 페이지에서 다음과 같이 설정합니다:

- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: (빈 문자열)

이후 "Connect" 버튼을 클릭하여 데이터베이스에 접속합니다.

##### 2.3. H2 콘솔에서 SQL 쿼리 실행
H2 콘솔을 통해 데이터베이스 테이블을 조회하거나 SQL 쿼리를 실행할 수 있습니다. 예를 들어, `User` 테이블의 데이터를 조회하는 쿼리는 다음과 같습니다:

```sql
SELECT * FROM <테이블명>;
```
---

### MySQL 데이터베이스 연동

MySQL 데이터베이스를 Spring Boot 애플리케이션과 연동하려면 MySQL JDBC 드라이버를 추가하고, 데이터베이스 연결 설정을 구성해야 합니다.

#### 1. 프로젝트 설정

##### 1.1. 프로젝트 의존성 추가
`build.gradle` 파일에 MySQL JDBC 드라이버와 Spring Data JPA 의존성을 추가합니다.

```groovy

dependencies {
    ...
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    runtimeOnly 'mysql:mysql-connector-java'
    ...
}

```

##### 1.2. 데이터베이스 설정
`src/main/resources/application.properties` 파일에 MySQL 데이터베이스 설정을 추가합니다.

```properties
# MySQL Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/springdb
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

- spring.datasource.url: MySQL 데이터베이스의 URL입니다. `localhost:3306`은 MySQL 서버가 로컬에서 실행 중이고, 포트는 3306임을 의미합니다. `springdb`는 사용할 데이터베이스 이름입니다.
- spring.datasource.username: 데이터베이스 사용자 이름.
- spring.datasource.password: 데이터베이스 비밀번호.
- spring.datasource.driver-class-name: MySQL JDBC 드라이버 클래스 이름.
- spring.jpa.hibernate.ddl-auto: Hibernate가 데이터베이스 스키마를 생성 및 업데이트하는 방식 설정.
   - none: 스키마 변경 불가
   - create: 기존 스키마 삭제 후 새 스키마 생성 (주의: 데이터 손실 가능성 있음)
   - create-drop: 애플리케이션 종료 후 스키마 삭제 (테스트 환경에 유용)
   - update: 엔티티 클래스에 맞춰 스키마 자동 업데이트 (새로운 요소만 추가, 기존 제거 불가)
   - validate: 엔티티와 테이블 매핑 확인 (스키마 변경 불가)
- spring.jpa.show-sql: 쿼리 로깅을 활성화하여 SQL 쿼리를 콘솔에 출력.
- spring.jpa.properties.hibernate.dialect: MySQL에 맞는 Hibernate 방언 설정.

#### 2. MySQL 데이터베이스 설정

1. MySQL 서버 설치 및 실행: MySQL 서버가 설치되어 있고 실행 중이어야 합니다. MySQL 서버를 설치하는 방법은 운영 체제에 따라 다릅니다.
2. 데이터베이스 생성:
   ```sql
   CREATE DATABASE springdb;
   ```

---

## 애플리케이션 계층 구조

애플리케이션을 계층 구조로 설계하면 모듈화가 쉬워지고 유지보수성이 향상됩니다. 각 계층은 특정 역할을 수행하며, 계층 간의 명확한 분리를 통해 애플리케이션의 복잡성을 줄일 수 있습니다. Spring Framework를 이용한 전형적인 애플리케이션 계층 구조는 다음과 같습니다:

### 계층 구조(Layered Architecture Pattern)

#### 1. 프레젠테이션 계층 (Presentation Layer)

- 역할: 사용자 인터페이스를 처리하고 클라이언트의 요청을 수신하여 비즈니스 로직을 호출한 후, 응답을 생성.
- 구성 요소: 컨트롤러 (Controller).
- 주요 어노테이션: `@Controller`, `@RestController`.

#### 2. 비즈니스 계층 (Business Layer)

- 역할: 비즈니스 로직을 처리하고, 데이터 접근 계층과 프레젠테이션 계층 간의 중개 역할을 수행.
- 구성 요소: 서비스 (Service).
- 주요 어노테이션: `@Service`.

#### 3. 데이터 접근 계층 (Data Access Layer)

- 역할: 데이터베이스와의 상호작용을 처리하고, 비즈니스 계층에 데이터 접근 기능을 제공.
- 구성 요소: 리포지토리 (Repository).
- 주요 어노테이션: `@Repository`.

#### 4. 도메인 계층 (Domain Layer)

- 역할: 애플리케이션의 핵심 비즈니스 객체 및 로직을 정의.
- 구성 요소: 엔티티 (Entity), 도메인 모델.
- 주요 어노테이션: `@Entity`.


- 프레젠테이션 계층은 비즈니스 계층에 요청을 전달하고 응답을 받아 사용자에게 반환합니다.
- 비즈니스 계층은 데이터 접근 계층을 호출하여 데이터를 가져오거나 저장하고, 필요한 비즈니스 로직을 처리합니다.
- 데이터 접근 계층은 도메인 계층의 엔티티를 사용하여 데이터베이스와 상호작용합니다.


---

### 서비스 계층 및 비즈니스 로직

서비스 계층은 애플리케이션의 비즈니스 로직을 담당하는 계층으로, 프레젠테이션 계층과 데이터 접근 계층 사이에서 중간 역할을 합니다. 이 계층은 데이터 처리, 비즈니스 규칙 구현, 데이터 접근 계층과의 상호작용을 수행합니다.

#### 서비스 계층의 주요 역할
1. 비즈니스 로직 구현: 애플리케이션의 핵심 비즈니스 규칙을 구현.
2. 데이터 접근 계층 호출: 데이터베이스와 상호작용하기 위해 리포지토리 계층을 호출.
3. 트랜잭션 관리: 데이터 일관성을 유지하기 위해 트랜잭션을 관리.
4. 데이터 변환: 프레젠테이션 계층에서 사용할 데이터 형식으로 변환.
5. 에러 처리: 비즈니스 로직 수행 중 발생하는 에러를 처리.

#### Spring에서 서비스 계층 구성

##### 1. 서비스 클래스 정의
- 서비스 클래스는 `@Service` 어노테이션을 사용하여 정의합니다. 이 클래스는 리포지토리 인터페이스를 주입받아 데이터베이스와 상호작용.

##### 2. 트랜잭션 관리
- Spring에서는 `@Transactional` 어노테이션을 사용하여 트랜잭션을 관리할 수 있습니다. 이 어노테이션은 클래스나 메서드 레벨에서 사용하여 데이터베이스 작업이 원자적으로 수행되도록 보장.
- 트랜잭션 내에서 데이터베이스 작업이 원자적으로 수행되고, 에러 발생 시 롤백.
- insert, update, delete 작업에는 기본적으로 @Transactional을 사용하는 것이 일반적임.
- select 작업에는 필요에 따라 @Transactional(readOnly = true)를 사용할 수 있음.

#### 예제

##### 1. 엔티티 클래스
```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
```

##### 2. 리포지토리 인터페이스
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

##### 3. 서비스 클래스
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Repository 주입

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
```

##### 4. 컨트롤러 클래스
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; // Service 주입

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}
```

#### 주요 구성 요소 설명 및 정리

-  서비스 클래스 (`UserService`):
   - `@Service` 어노테이션을 사용하여 서비스 클래스로 지정.
   - `UserRepository`를 주입받아 데이터베이스 작업을 수행.
   - `@Transactional` 어노테이션을 사용하여 트랜잭션 관리.

- 컨트롤러 클래스 (`UserController`):
   - 서비스 계층을 호출하여 비즈니스 로직을 수행.

- 서비스 계층은 애플리케이션의 비즈니스 로직을 구현하고 데이터 접근 계층과 프레젠테이션 계층 간의 중개 역할을 함.
- 트랜잭션 관리는 `@Transactional` 어노테이션을 통해 수행됨.
- 컨트롤러 계층은 클라이언트 요청을 처리하고 서비스 계층을 호출하여 비즈니스 로직을 수행함.

---

### ResponseEntity

`ResponseEntity`는 Spring Framework에서 제공하는 HTTP 응답을 나타내는 클래스로, 응답의 상태 코드, 헤더, 바디 등을 포함할 수 있습니다. `ResponseEntity`를 사용하면 더욱 유연하고 세밀하게 HTTP 응답을 제어할 수 있습니다.

#### 주요 기능 및 장점

1. 상태 코드 설정: HTTP 응답 상태 코드를 설정할 수 있습니다.
2. 헤더 설정: 응답 헤더를 설정할 수 있습니다.
3. 바디 설정: 응답 본문을 설정할 수 있습니다.
4. 유연성: 다양한 HTTP 응답을 손쉽게 구성할 수 있습니다.

#### 생성 방법

`ResponseEntity`는 여러 가지 방법으로 생성할 수 있습니다. `ResponseEntity` 빌더를 사용하면 더욱 직관적이고 유연하게 응답을 생성할 수 있습니다.

#### 주요 생성 방법

1. 빌더 사용
   - `ResponseEntity.ok()`: 200 OK 상태 코드와 함께 응답을 생성합니다.
   - `ResponseEntity.status(HttpStatus)`: 특정 상태 코드와 함께 응답을 생성합니다.
   - `ResponseEntity.noContent()`: 204 No Content 상태 코드와 함께 응답을 생성합니다.
   - `ResponseEntity.created(URI)`: 201 Created 상태 코드와 함께 응답을 생성합니다.

2. 생성자 사용
   - `new ResponseEntity<>(body, status)`: 응답 본문과 상태 코드를 직접 지정하여 응답을 생성합니다.
   - `new ResponseEntity<>(body, headers, status)`: 응답 본문, 헤더, 상태 코드를 지정하여 응답을 생성합니다.

##### UserController
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }
}
```

### 상세 설명

1. `@GetMapping` 메서드:
   - getAllUsers: 모든 사용자를 조회하고 200 OK 상태 코드와 함께 응답을 반환.
   - getUserById: 특정 사용자를 조회. 존재하지 않는 경우 404 Not Found 상태 코드를 반환.

2. `@PostMapping` 메서드:
   - createUser: 새로운 사용자를 생성하고 201 Created 상태 코드와 함께 응답을 반환.

3. `@DeleteMapping` 메서드:
   - deleteUser: 특정 사용자를 삭제하고 204 No Content 상태 코드와 함께 응답을 반환.

4. `@PutMapping` 메서드:
   - updateUser: 특정 사용자를 업데이트하고 200 OK 상태 코드와 함께 응답을 반환.

### 네트워킹의 기본 개념과 REST API, HTTP 프로토콜 이해

#### 네트워킹 기본 개념

1. 네트워크(Network)
    - 정의: 두 대 이상의 컴퓨터가 데이터를 교환할 수 있는 시스템.
    - 종류:
        - LAN (Local Area Network): 가까운 거리의 네트워크, 예를 들어 한 건물 내에서.
        - WAN (Wide Area Network): 넓은 지역을 커버하는 네트워크, 예를 들어 인터넷.

2. 클라이언트-서버 모델(Client-Server Model)
    - 클라이언트(Client): 서비스를 요청하는 컴퓨터 또는 프로그램.
    - 서버(Server): 클라이언트의 요청을 처리하고 응답하는 컴퓨터 또는 프로그램.

#### HTTP 프로토콜

1. HTTP (HyperText Transfer Protocol)
    - 정의: 웹 상에서 데이터를 주고받기 위한 프로토콜.
    - 특징:
        - 무상태성(Statelessness): 각 요청은 독립적이며, 서버는 요청 간의 상태를 저장하지 않음.
        - HTTP 메소드:
            - GET: 리소스를 조회.
            - POST: 새로운 리소스를 생성.
            - PUT: 기존 리소스를 업데이트.
            - DELETE: 리소스를 삭제.
        - HTTP 상태 코드:
            - 200 OK: 요청 성공.
            - 404 Not Found: 요청한 리소스를 찾을 수 없음.
            - 500 Internal Server Error: 서버 내부 오류.

2. HTTP 요청과 응답 구조
    - HTTP 요청: 클라이언트가 서버에 데이터를 요청할 때 사용.
        - 요청 라인: 메소드, URL, HTTP 버전.
        - 헤더(Header): 요청의 메타데이터.
        - 본문(Body): 요청 데이터(옵션).
    - HTTP 응답: 서버가 클라이언트에 데이터를 응답할 때 사용.
        - 응답 라인: HTTP 버전, 상태 코드, 상태 메시지.
        - 헤더(Header): 응답의 메타데이터.
        - 본문(Body): 응답 데이터(옵션).

#### REST API

1. REST (Representational State Transfer)
    - 정의: 자원을 이름(URI)으로 구분하고, 해당 자원의 상태를 주고받는 웹 아키텍처 스타일.
    - 특징:
        - 무상태성(Statelessness): 서버는 클라이언트 상태를 저장하지 않음.
        - 캐시 가능(Cacheable): 응답은 캐시될 수 있음.
        - 일관된 인터페이스(Uniform Interface): 자원 접근을 위한 일관된 방법 제공.
        - 계층형 시스템(Layered System): 여러 계층으로 구성된 시스템.
    - 구성 요소:
        - 자원(Resource): URI로 식별되는 모든 데이터.
        - 표현(Representation): 자원의 상태를 나타내는 데이터(JSON, XML 등).
        - 메소드(Method): 자원에 대해 수행할 작업(GET, POST, PUT, DELETE).

2. RESTful API
    - 정의: REST 원칙을 따르는 API.
    - 사용 사례:
        - 웹 애플리케이션: 프론트엔드와 백엔드 간의 데이터 통신.
        - 모바일 애플리케이션: 서버와 데이터 통신.
        - 사물 인터넷(IoT): 디바이스 간의 데이터 통신.

#### 참고할 사이트

1. [MDN Web Docs - HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP)
2. [REST API Tutorial](https://restfulapi.net/)
3. [w3schools - HTTP](https://www.w3schools.com/tags/ref_httpmethods.asp)
4. [REST API Design](https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api)
5. [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)