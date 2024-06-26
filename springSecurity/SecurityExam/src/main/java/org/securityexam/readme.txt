1. spring security 의존성을 초기화전에 컨트롤러를 만들고, http://localhost:8080 이렇게 표현한다.
    - 누구든지 접속가능한 페이지
    - 보안에 취약할 수 있겠죠?

2. spring security 의존성을, build.gradle 에 추가해봅시다.
    - 의존성, 딱하나만 추가했는데 .. !!
    - 아까 접속가능했던 GET / url에 접근했더니, 로그인하라구 함.

    -> 의존성이 추가되면, 기본적으로는 인증을 해야만 모든 페이지를 요청할 수 있게 된다 !!

    (스프링 시큐리티 기본제공로그인페이지 인증)
    -> 콘솔에, "Using generated security password"가 뜸. 이게 매번 랜덤값이고,
        id는 디폴트로 user 제공함.

3. 스프링 시큐리티, 디폴트 설정
    - 계정에 user 하나만 존재 --> 계정추가할 필요가 있다.
    - 인증만 되면, 어떤 페이지든 갈 수 있다 --> 인가 권한을 추가할 필요가 있다.

4. 스프링 시큐리티, 추가설정 커스터마이징 (SecurityConfig)
    - formLogin 시큐리티디폴트제공 / 사용자 커스터마이징
    - 스프링시큐리티에서 인증에 성공하면 Authentication 객체가 생성되는데, 이 객체는 현재 사용자에 대한 인증정보를 가짐.
        이 Authentication 객체는 Thread-Local 저장소인 SecurityContext에 저장되어, 요처암다 다르게 관리됨 !!