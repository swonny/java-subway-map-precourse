### 게임 설명
지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

### 게임 진행 순서
1. 메인 메뉴 선택
2. 선택한 메뉴에 대한 메뉴 출력
3. 선택한 메뉴 중 기능 선택
4. 기능 실행
5. 1번으로 회귀

### 초기 설정
프로그램 시작 시 역, 노선 등 필요한 정보를 미리 셋팅할 수 있다.
> 아래의 사전 등록 정보로 반드시 초기 설정을 하기
```
 1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
 2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
 3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
   - 2호선: 교대역 - 강남역 - 역삼역
   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
```

### 지하철 역 관련 기능
- [ ] 지하철 역을 등록하고 삭제할 수 있다. (단, 노선에 등록된 역은 삭제할 수 없다)
- [ ] 중복된 지하철 역 이름이 등록될 수 없다.
- [ ] 지하철 역 이름은 2글자 이상이어야 한다.
- [ ] 지하철 역의 목록을 조회할 수 있다.

### 지하철 노선 관련 기능
- [ ] 지하철 노선을 등록하고 삭제할 수 있다.
- [ ] 중복된 지하철 노선 이름이 등록될 수 없다.
- [ ] 지하철 노선 이름은 2글자 이상이어야 한다.
- [ ] 노선 등록 시 상행 종점역과 하행 종점역을 입력받는다.
- [ ] 지하철 노선의 목록을 조회할 수 있다.

### 지하철 구간 추가 기능
등록된 노선에 지하철 역을 추가하는 기능이다.
- [ ] 지하철 노선에 구간을 추가하는 기능은 노선에 역을 추가하는 기능이라고도 할 수 있다.
- [ ] 역과 역사이를 구간이라 하고 이 구간들의 모음이 노선이다.
- [ ] 하나의 역은 여러개의 노선에 추가될 수 있다.
- [ ] 역과 역 사이에 새로운 역이 추가 될 수 있다.
- [ ] 🔴 노선에서 갈래길은 생길 수 없다. 🔴

### 지하철 구간 삭제 기능
등록된 노선에 지하철 역을 삭제하는 기능이다.
- [ ] 노선에 등록된 역을 제거할 수 있다.
- [ ] 종점을 제거할 경우 다음 역이 종점이 된다.
- [ ] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.

### 지하철 노선에 등록된 역 조회 기능
- [ ] 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회할 수 있다.

---
### 입력

### 출력
- [ ] 기대하는 출력 결과는 [INFO]를 붙여서 출력한다. 출력값의 형식은 예시와 동일하게 한다.
- [ ] 메인 메뉴
  - [ ] 역 관리 메뉴
  - [ ] 노선 관리
  - [ ] 구간 관리
  - [ ] 지하철 노선도 출력
  - [ ] 종료
- [ ] 역 관리 메뉴
  - [ ] 역 등록
  - [ ] 역 등록
  - [ ] 역 삭제
  - [ ] 역 조회
  - [ ] 돌아가기
- [ ] 노선 관리
  - [ ] 노선 등록
    - [ ] `## 등록할 노선 이름을 입력하세요.`
    - [ ] `## 등록할 노선의 상행 종점역 이름을 입력하세요.`
    - [ ] `## 등록할 노선의 하행 종점역 이름을 입력하세요.`
    - [ ] `[INFO] 지하철 노선이 등록되었습니다.`
  - [ ] 노선 삭제
    - `[INFO] 지하철 노선이 삭제되었습니다.`
  - [ ] 노선 조회
    - ```
      [INFO] 2호선
      [INFO] 3호선
      [INFO] 신분당선
      [INFO] 1호선
      ```
  - [ ] 돌아가기
- [ ] 구간 관리
- [ ] 지하철 노선도 출력
```
## 지하철 노선도
[INFO] 2호선
[INFO] ---
[INFO] 교대역
[INFO] 강남역
[INFO] 역삼역

[INFO] 3호선
[INFO] ---
[INFO] 교대역
[INFO] 남부터미널역
[INFO] 양재역
[INFO] 매봉역

[INFO] 신분당선
[INFO] ---
[INFO] 강남역
[INFO] 양재역
[INFO] 양재시민의숲역
```

### 예외
- [ ] 에러 발생 시 [ERROR]를 붙여서 출력한다. (에러의 문구는 자유롭게 작성한다.)

---
# 설계
### 노선

[상태]

- [x] 노선 이름을 갖는다.

[행동]

- [x] 노선 이름 반환한다.

### 노선 컨트롤러 (지하철 구간 추가 기능)

- 지하철 노선을 등록하고 삭제할 수 있다.

[구간 추가]

- 하나의 역은 여러개의 노선에 추가될 수 있다.
- 역과 역 사이에 새로운 역이 추가 될 수 있다.
- 노선에서 갈래길은 생길 수 없다.

[구간 삭제]

- 노선에 등록된 역을 제거할 수 있다.
- 종점을 제거할 경우 다음 역이 종점이 된다.
- 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.

[노선 조회]

- 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회할 수 있다.

### 노선 메이커

[노선 이름 검증]

- 중복된 지하철 노선 이름이 등록될 수 없다.
- 지하철 노선 이름은 2글자 이상이어야 한다.
- 상행에 해당하는 정보 (ex: index 0)
- 하행에 해당하는 역을 갖는다. (ex: lastIndex)

- 노선 등록 시 상행 종점역과 하행 종점역을 입력받는다.

### 노선 레포지토리

[상태]

- 생성한 노선들을 가지고 있다.
  - 노선에 해당하는 지하철 정보를 가지고 있다.
- 상행에 해당하는 정보 (ex: index 0)
- 하행에 해당하는 역을 갖는다. (ex: lastIndex)

[행동]

### 지하철 역

[상태]

- 지하철 역의 이름을 갖는다.
  - 지하철 역 이름은 2글자 이상이어야 한다. `(메이커와 역할 고민해보기)`
- 지하철 역을 등록하고 삭제할 수 있다. (단, 노선에 등록된 역은 삭제할 수 없다)

### 지하철 역 메이커

[지하철 역 이름 검사]

- 지하철 역 이름은 2글자 이상이어야 한다.
- 중복된 지하철 역 이름이 등록될 수 없다.

### 지하철 레포지토리

[상태]

- 생성한 지하철 정보를 모두 저장한다.

[행동]

- 지하철 역의 목록을 조회할 수 있다.