package org.jwtExam.jwt.exception;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

/*
    스프링 시큐리티에서 지원해주는 인터페이스
    주로, 사용자가 인증되지 않은 상태에서, 보호된 리소스에 접근하려고 할 때 처리해주는 역할

    commence 메서드에서는 주로,
        - 리다이렉션 : 인증되지 않은 사용자를, 로그인페이지로 리다이렉트
        - 에러 응답 : 401 Unauthorized 상태코드를 반환하고, 응답 본문에 에러메세지 포함 가능

    이 커스텀 인터페이스를 정의하고 나면, SpringSecurity Config 설정클래스에, 해당 보안설정클래스를 등록해줘야 함 !!
        (http.exceptionHandling()으로 !!)
 */
@Slf4j
@Component
public class CustomAuthenticationiEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        String exception = (String) request.getAttribute("exception"); // 에러메시지 반환

        // 어떤 요청인지를 구분..
        // RestController로 요청한건지.. Controller로 요청한건지 구분.. (두 요청은 각각 응답방식이 다르므로!)

        if (isRestRequest(request)){
            // RestController
            handleRestResponse(request, response, exception);

        } else {
            // Controller
            handlePageResponse(request, response, exception);
        }

    }

    // RestController 약속 - 헤더에 'XMLHttpRequest'이거나 URL이 /api/ 로 호출된다면..
    private boolean isRestRequest(HttpServletRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader) || request.getRequestURI().startsWith("/api/");
    }

    // RestController 요청을 처리할 핸들러 함수 정의
    private void handleRestResponse(HttpServletRequest request, HttpServletResponse response, String exception)
            throws IOException {
        log.error("Rest Request - Commence Get Exception : {}", exception);

        if (exception != null) { // exception이 발생됨 !!
            if (exception.equals(JwtExceptionCode.INVALID_TOKEN.getCode())) {
                log.error("entry point >> invalid token");
                setResponse(response, JwtExceptionCode.INVALID_TOKEN);

            } else if (exception.equals(JwtExceptionCode.EXPIRED_TOKEN.getCode())) {
                log.error("entry point >> expired token");
                setResponse(response, JwtExceptionCode.EXPIRED_TOKEN);

            } else if (exception.equals(JwtExceptionCode.UNSUPPORTED_TOKEN.getCode())) {
                log.error("entry point >> unsupported token");
                setResponse(response, JwtExceptionCode.UNSUPPORTED_TOKEN);

            } else if (exception.equals(JwtExceptionCode.NOT_FOUND_TOKEN.getCode())) {
                log.error("entry point >> not found token");
                setResponse(response, JwtExceptionCode.NOT_FOUND_TOKEN);

            } else {
                setResponse(response, JwtExceptionCode.UNKNOWN_ERROR);
            }

        } else {
            setResponse(response, JwtExceptionCode.UNKNOWN_ERROR);
        }
    }

    private void setResponse(HttpServletResponse response, JwtExceptionCode exceptionCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        HashMap<String, Object> errorInfo = new HashMap<>();
        errorInfo.put("message", exceptionCode.getMessage());
        errorInfo.put("code", exceptionCode.getCode());
        Gson gson = new Gson();
        String responseJson = gson.toJson(errorInfo);
        response.getWriter().print(responseJson);
    }

    // Controller 요청에서 예외발생시 핸들러 정의
    // -- 페이지로 요청이 들어왔을 때, 인증되지 않은 사용자라면, 무조건 /loginform으로 redirect시키겠다 !!
    private void handlePageResponse(HttpServletRequest request, HttpServletResponse response, String exception) throws IOException {
        log.error("Page Request - Commence Get Exception : {}", exception);

        if (exception != null) {
            // 추가적인 페이지 요청에 대한 예외 처리 로직을 여기에 추가할 수 있습니다.
        }

        response.sendRedirect("/loginform");
    }
}

