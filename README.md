## 헥사고날 아키텍처에 기반한 각종 기술 테스트 공간

### Feign Client 연결
- BoardService에 InternalApi 작성, CommentService에 Feign Client 구현
- CommentService에 게시글 갯수 API를 요청하면, CommentService는 BoardService에게 boardCount를 요청하여 응답포맷으로 변환 후 클라이언트에게 응답

### STOMP 활용 웹소켓 구현
- BoardService에 json타입 메시지 송수신 구현, 단일 채팅방 시스템
- CommentService에 여러개의 채팅방 시스템 구현
