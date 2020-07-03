package com.study.fcsbadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // JPA에 대해서 감시를 활성화 시키겠다.
public class JpaConfig {
}
