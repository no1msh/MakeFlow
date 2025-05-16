# Kotlin Flow 만들면서 이해하기

![main_image](/images/main_image.jpeg)

## 소개

해당
레포지토리는 [Kotlin Flow 만들면서 이해하기](https://velog.io/@no1msh1217/series/Kotlin-Flow-%EB%A7%8C%EB%93%A4%EB%A9%B4%EC%84%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)
포스팅 시리즈를 진행하면서 사용된 코드들을 저장한 곳입니다.

이 포스팅 시리즈를 따라가면서 [바퀴를 재발명](https://en.wikipedia.org/wiki/Reinventing_the_wheel)하며 `Flow`에 익숙하지 않은 분들이 직접 만들어 보며 이해하는 경험을
할 수 있습니다.

> **완전히 실제 코드와 똑같이 구현하는 것이 아닌 주 기능을 간략화** 해서 구현합니다.
> 따라서 실제 코드가 궁금하신 분들은 [Kotlin Coroutine 레포지토리](https://github.com/Kotlin/kotlinx.coroutines)를 참고하시기 바랍니다.

## 목차 (진행중)

#### [Part 1. Flow 빌더](https://velog.io/@no1msh1217/Kotlin-Flow-%EB%A7%8C%EB%93%A4%EB%A9%B4%EC%84%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-Part-1.-Flow-%EB%B9%8C%EB%8D%94)

- `Flow`의 근간이 되는 빌더를 처음부터 이해하기 쉽게 만듭니다.
- 제네릭 타입이 이해에 어려움을 준다면 [Int 타입만을 다룬 브랜치](https://github.com/no1msh/MakeFlow/tree/main) 참고하시기 바랍니다.

#### [Part 2. Flow 생명주기 함수](https://velog.io/@no1msh1217/Kotlin-Flow-%EB%A7%8C%EB%93%A4%EB%A9%B4%EC%84%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-Part-2.-Flow-%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0-%ED%95%A8%EC%88%98)

- `Flow`의 중간 연산중 생명주기 함수가 왜 필요한지 가볍게 알아보고 만들어봅니다.

#### [Part 3. Flow 처리 함수(중간 연산)](https://velog.io/@no1msh1217/Kotlin-Flow-%EB%A7%8C%EB%93%A4%EB%A9%B4%EC%84%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-Part-3.-Flow-%EC%B2%98%EB%A6%AC-%ED%95%A8%EC%88%98%EC%A4%91%EA%B0%84-%EC%97%B0%EC%82%B0)

- `Flow`의 생명 주기함수를 제외한 중간연산 함수를 만들어봅니다.
- `Flow`에 집중하기 위해 내부적으로 `channelFlow`를 사용한 함수는 제외하였습니다.
