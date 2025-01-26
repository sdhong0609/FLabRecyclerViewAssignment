### F-Lab 멘토링 과정 중에 수행한 간단한 과제입니다.

1. 하나의 Activity에 두 개의 RecyclerView를 수평으로 배치
    1. 좌측 RecyclerView에는 10개의 아이템 목록
    2. 우측 RecyclerView에는 휴지통 목록
2. 좌측 아이템 목록에서 휴지통 아이콘을 누르면 우측 휴지통 목록으로 이동
3. 우측 휴지통 목록에서 아이템을 누르면 좌측 아이템 목록으로 이동시켜서 복구
4. n초 카운트 (숫자 n은 자율)
    1. 휴지통 목록에 아이템이 추가되면 n초 카운트
    2. n초 카운트될 동안 다른 아이템이 추가되면 새로 n초 카운트
    3. 휴지통 목록에서 아이템을 눌러서 복구했을 때, 휴지통 목록에 아직 아이템이 남아있으면 새로 n초 카운트
    4. 만약 휴지통 목록에 아무것도 없는 상태가 되면 카운트 중지
5. 자동 삭제
    1. 휴지통 목록의 아이템은 n초 카운트 후 해당 아이템 자동 삭제
    2. 자동 삭제하지 말고 복구시키고 싶다면 n초 안에 휴지통 목록의 아이템을 눌러서 복구시켜야 한다.