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