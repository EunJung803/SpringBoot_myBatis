package com.ll.exam.mybatis_exam.app.base;

import com.ll.exam.mybatis_exam.interceptor.BeforeActionInterceptor;
import com.ll.exam.mybatis_exam.interceptor.NeedToLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final BeforeActionInterceptor beforeActionInterceptor;
    private final NeedToLoginInterceptor needToLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir;

        ir = registry.addInterceptor(beforeActionInterceptor);
        ir.addPathPatterns("/**");              // 들어오는 모든 요청에 대해서는 다 인터셉터 적용
        ir.excludePathPatterns("/favicon.ico"); // 그러나 그 중에서 파비콘을 가져오는 요청 제외,
        ir.excludePathPatterns("/resource/**"); // 이미지 css 가져오는 요청 제외,
        ir.excludePathPatterns("/gen/**");      // 고객이 업로드한 파일 요청 제외,
        ir.excludePathPatterns("/error");       // 에러 관련 요청 제외

        ir = registry.addInterceptor(needToLoginInterceptor);
        ir.addPathPatterns("/article/write");
    }
}