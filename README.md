# JSINC
project clone 후
src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
<!-- 업로드 패스 설정 -->
제일 아래에
beans:constructor-arg value=".metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSINC\resources"    // 여기부분 수정
.metadata 앞에 workspace 경로까지 추가
Ex)
beans:constructor-arg value="(((((C:\workspace\))))))).metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSINC\resources"
(((()))) 괄호 안 추가
