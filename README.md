### Feign Client 연결
- BoardService에 InternalApi 작성, CommentService에 Feign Client 구현
- CommentService에 게시글 갯수 API를 요청하면, CommentService는 BoardService에게 boardCount를 요청하여 응답포맷으로 변환 후 클라이언트에게 응답
