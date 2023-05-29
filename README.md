# 날씨 일기 프로젝트

## ⚒️ 적용 기술
Java, Mysql, JPA, logback, Swagger

## 📝 기능 구현
✅ POST / create / diary
- date parameter (date 형식 : yyyy-MM-dd)
- text parameter
- 외부 API 에서 받아온 날씨 데이터와 함께 DB에 저장

✅ GET / read / diary
- date parameter
- 해당 날짜의 일기를 List 형태로 반환

✅ GET / read / diaries
- startDate, ednDate parameter
- 해당 기간의 일기를 List 형태로 반환

✅ PUT / update / diary
- date parameter
- text parameter
- 해당 날짜의 첫번째 일기 글을 새로 받아온 일기글로 수정

✅ DELETE / delete / diary
- date parameter
- 해당 날짜의 모든 일기 삭제

✅ DB와 관련된 함수들을 트랜잭션 처리<br/>
✅ 매일 새벽 1시에 날씨 데이터를 외부 API 에서 받아다 DB에 저장하는 로직 구현<br/>
✅ logback 을 이용하여 프로젝트에 로그 남기기<br/>
✅ ExceptionHandler 을 이용한 예외처리<br/>
✅ swagger 이용하여 API documentation<br/>

