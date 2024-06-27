'인가' 설정

-   유저정보(id,암호화된 pw, role)를 UserDetails에 저장하고,
    SecurityFilterChain 에서 유저 정보별 접근가능한 페이지 (인가 설정) 테스트해보기.

-   컨트롤러,서비스 (HomeController) 에서, 저장된 유저정보 꺼내기 !
     -> 스프링 시큐리티에서 인증이 성공하면 Authentication 객체가 생성되고, 이 객체는 사용자 인증정보를 담았다고 함!!
        해당 객체는 ThreadLocal인 SecurityContext 에 저장되어 있음!
     -> SecurityContextHolder -> SecurityContext -> Authentication
     -> ThreadLocal이기에, 같은 클라이언트 요청 안이라면, 어디서든지 꺼내쓸 수 있음 !!

     -> 코드 : HomeController, UserController의 어노테이션

- build.gradle에 thymeleaf에서도 스프링시큐리티를 사용할 수 있도록, 의존성 추가
    + mypage.html 코드