1. 프로젝트 준비
    - build.gradle에 jpa, sql 추가

2. 코드 작성
    - 기본 작성 코드 : domain, repository
    - 스프링 시큐리티 관련 (코드 설명 주석에 다 써져있다 !)
        -> CustomUserDetailsService
        -> SecurityConfig

3. 서비스 로직할 일
    - 회원가입
        -> DB   repository.. (이미 구현함)
        -> service
            컨트롤러가 보내준 정보를 받아와서, RoleRepository로부터 권한에 알맞는 Role객체를 얻어오고,
            User객체에 포함하고,
            UserRepository에 save해준다.
        -> controller
            회원가입폼, 회원가입 기능 .. 2개 메서드 만들기
        -> view
            회원정보를 얻어올 폼 만들기
