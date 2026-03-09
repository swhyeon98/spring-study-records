# Overview

[book] 이동욱님의 [스프링 부트와 AWS로 혼자 구현하는 웹 서비스](https://www.yes24.com/Product/Goods/83849117)의 구현 코드입니다.

## 사용 기술 및 버전

- **Java**: [11]
- **Spring Boot**: [2.7.11]
- **Gradle**: [7.6.1]

## 주의 사항

JUnit 버전: 책에서는 JUnit4를 테스트 코드 작성에 사용하였으나, 본 구현에서는 JUnit5로 업데이트 하였습니다.

템플릿 엔진 변경: 원래 책에서는 Mustache를 사용하지만 SpringBoot 2.7.x와 함께 Mustache를 사용할 때 한글 인코딩 문제가 있습니다. Mustache의 업데이트 중단 등의 여러 이유로, 템플릿 엔진을 Thymeleaf로 변경하였습니다.

> 책과 관련하여 이 코드를 참조하시는 경우, 이러한 변경사항을 주의하시기 바랍니다.
