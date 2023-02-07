# JS.Inc Office
> '자바 기반 웹 개발자 양성과정'의 국비지원 교육과정에서 수행한 최종 프로젝트.


Spring MVC_사내 인트라넷 서비스


## 🖥 프로젝트 소개
회사 전체 업무 서비스와 개인 스케줄 관리, 사원들의 커뮤니티 환경 등을 제공하여 기업 내에 업무 효율성을 높여주는 사내 인트라넷 웹 페이지


## 🕐 개발 기간
- 2020.05.13 ~ 2020.06.19 (38일)


### 👥 팀 구성 (3명)
- **허성택** (팀장) - 프로젝트 제안, 기획, 웹 페이지 디자인, 기능 구현, 테스트, 발표
- 서ㅇㅇ (팀원) - 프로젝트 제안, 기획, 기능 구현, 테스트
- 임ㅇㅇ (팀원) - 웹 페이지 디자인, 기능 구현, 테스트


### ⚙️ 개발 환경
- `java 8`
- `jdk 1.8`
- **IDE** : EclipseIDE
- **Framework** : springMVC
- **Database** : Oracle DB
- **사용도구** : Apache Tomcat, Spring Tool Suite, BootStrap 등
- **기술** : Mybatis, ajax, Apache Commons API, JavaMail API, Thumbnailator API, openweathermap API 등

---

## 📌 설명

### ✏️ 기능도
<img src="https://user-images.githubusercontent.com/121115266/209166857-b30976b4-3fb9-4950-88b5-00fcd832c605.png" width="480" height="270">


#### 🖱 담당 기능
> 구현기능 상세설명 부록 참조
  - **허성택** : 메인 화면 / Lock Screen / 로그인 / 프로필 / 출근&퇴근 / 주소록 / 스케줄 / 설문 / 관리자 서비스
  - 서ㅇㅇ : 메인 화면 / 회원가입 / 비밀번호 찾기
  - 임ㅇㅇ : 메인 화면 / 보고 / 커뮤니티 / 게시판


### ✏️ 메인 화면
<img src="https://user-images.githubusercontent.com/121115266/209167555-fe222af1-35ca-4b58-bb1a-6e0be2ea3926.png" width="480" height="270">


### ✏️ 실행 방법
1. Code clone
2. JSINC>src>main>webapp>WEB-INF>spring>appServlet>servlet-context.xml 파일 열기
3. 41번 째 줄 소스코드에 workspace 경로 추가 : <beans:constructor-arg value = "(workspace path)\.metadata\.plugins\ ...">
4. Run on Server (Apache Tomcat 9.0)


### ✏ Login
- User (2233 / 111)
- Manager (1 / master)

---

### 부록
- [구현 기능 상세 설명 pdf 다운로드](https://github.com/taek-project/JSINC/files/10288608/JSInc_report.pdf)
