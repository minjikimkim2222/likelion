package org.example.spring_mvc.config;

import org.example.spring_mvc.View.MyCustomView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyCustomViewResolver implements ViewResolver, Ordered  {

    private int order;
    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("my-prefix")){
            return new MyCustomView(); // 커스텀 뷰 로직 호출!
        }
        return null; // null 반환 시, 그다음 우선순위의 뷰 리졸버가 처리해줄 것..
    }
}
