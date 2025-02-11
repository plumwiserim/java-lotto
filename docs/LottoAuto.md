# 로또 자동

## 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 실행 결과
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 프로그래밍 요구 사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) 을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
  - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.

### 추가된 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.

## 기능 구현 목록
**Cashier**
- [x] `Cashier#Cashier` : 생성자
- [x] `Cashier#calculateAutoLottoQuantity` : 자동 로또 갯수 계산
- [x] `Cashier#getPrice` : getter
- [x] `Cashier#getLottoQuantity` : getter
- [x] `Cashier#getAutoQuantity` : getter
- [x] `Cashier#getManualQuantity` : getter

**LottoNumber**
- [x] `static` : 1부터 45까지 로또 숫자 생성
- [x] `LottoNumber#LottoNumber` : 생성자
- [x] `LottoNumber#of` : static factory method
- [x] `LottoNumber#checkNumber` : 1부터 45까지의 수인지 확인
- [x] `LottoNumber#isSame` : 다른 LottoNumber 와 일치 여부
- [x] `LottoNumber#toString` : 로또 번호 숫자값 반환

**LottoFactory**
- [x] `static` : 1부터 45까지 로또 번호 생성
- [x] `LottoFactory#createAutoLottos` : 자동 로또 갯수만큼 생성
- [x] `LottoFactory#createManualLottos` : 수동 로또 갯수만큼 생성
- [x] `LottoFactory#createAutoLotto` : 자동 로또 생성
- [x] `LottoFactory#createManualLotto` : 수동 로또 생성

**Lotto**
- [x] `Lotto#Lotto` : 생성자
- [x] `Lotto#checkLottoSize` : 로또 번호 갯수 확인
- [x] `Lotto#checkLottoNumbers` : 로또 번호들이 서로 겹치는지 확인
- [x] `Lotto#sort` : 로또 번호 오름차순 정렬
- [x] `Lotto#countWinningNumbers` : 당첨번호 포함 갯수
- [x] `Lotto#contains` : LottoNumber 포함 여부
- [x] `Lotto#getNumbers` : getter

**Lottos**
- [x] `Lottos#Lottos` : 생성자
- [x] `Lottos#countWinningResults` : 당첨 결과 집계
- [x] `Lottos#getLottos` : getter

**WinningLotto**
- [x] `WinningLotto#WinningLotto` : 생성자
- [x] `WinningLotto#checkBonusNumber` : 당첨번호 중 보너스번호와 동일한 번호가 있는지 확인
- [x] `WinningLotto#countWinningNumbers` : 입력받은 lotto 의 당첨번호 갯수 세기
- [x] `WinningLotto#containsBonusNumber` : 입력받은 lotto 의 보너스번호 존재여부 확인

**WinningResult(enum)**
- [x] `WinningResult#WinningResult` : 생성자
- [x] `WinningResult#addNumberOfWinning` : 당첨 횟수 저장
- [x] `WinningResult#calculateEarningPrice` : 총 수익 계산
- [x] `WinningResult#getWinningAmount` : getter
- [x] `WinningResult#getNumberOfWins` : getter

**WinningResults**
- [x] `WinningResults#WinningResults` : 생성자
- [x] `WinningResults#calculateEarningRate` : 당첨결과 총 수익률 계산
- [x] `WinningResults#getWinningResults` : getter

**LottoAutoInputView**
- [x] `LottoAutoInputView#inputPrice` : 로또구매금액 입력
- [x] `LottoAutoInputView#inputWinningNumbers` : 당첨번호 입력
- [x] `LottoAutoInputView#inputBonusNumber` : 보너스번호 입력

**LottoAutoOutputView**
- [x] `LottoAutoOutputView#printLotto` : 로또 자동 구매갯수 출력. 로또별 6개의 번호 출력
- [x] `LottoAutoOutputView#printWinningResults` : 로또 당첨 결과 출력
- [x] `LottoAutoOutputView#printEarningRate` : 로또 총 수익률 출력

**LottoAutoController**
- [x] `LottoAutoController#start` : 시작. 흐름 제어
- [x] `LottoAutoController#convertWinningNumbers` : 문자열로 입력받은 당첨번호를 로또로 변환
