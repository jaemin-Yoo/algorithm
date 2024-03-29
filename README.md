# 백준 문제 풀기

> 백준 문제 풀 때 어떤 알고리즘을 사용해야하는지 모르고 풀기 위해서 랜덤으로 페이지 여는 코드 작성 + 문제 다 푼 다음 Git에 저장하기 위해 파일 자동 생성

`Start.kt`: 랜덤으로 알고리즘 문제 페이지 열기  
`Note.kt`: 문제 해답 코드 작성  
`Complete.kt`: 정답 시 특정 알고리즘 폴더에 `문제번호_문제이름` 파일 생성

### 사용 방법
1. `Start.kt` 파일 실행
2. 열린 페이지에서 문제 찾기
3. `Note.kt`에서 코드 작성 (문제 번호, 이름 입력)
4. 코드 제출 후 문제 풀이가 끝났으면 `Complete.kt` 파일 실행
5. Git에 올리기

### 알고리즘 목록

- 브루트포스
- DFS
- BFS
- 해시테이블
- 문자열
- DP
- 다익스트라
- 구현
- 자료구조
- 투포인터
- 그리디
- 이분탐색
- 위상정렬
- 유니온 파인드 (분리 집합)
- 우선순위 큐

## 개발 환경 셋팅

### 1. SDK 설정
`File -> Project Structure -> Project Settings -> Project`

적절한 SDK 버전을 설정한다.

![image](docs/img/project.png)

### 2. Kotlin Sources 마킹

`Project Settings -> Modules`

`kotlin` 폴더를 `Sources`로 마킹하여 해당 폴더가 코틀린 폴더임을 나타낸다.

![image](docs/img/modules.png)

### 3. 코틀린 표준 라이브러리 추가

`Project Settings -> Libraries`

코틀린 표준 라이브러리를 추가한다.  
`org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0`

![image](docs/img/libraries.png)