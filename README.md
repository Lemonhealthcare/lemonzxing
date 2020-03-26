[![](https://jitpack.io/v/Lemonhealthcare/lemonzxing.svg)](https://jitpack.io/#Lemonhealthcare/lemonzxing)
[![](https://jitci.com/gh/Lemonhealthcare/lemonzxing/svg)](https://jitci.com/gh/Lemonhealthcare/lemonzxing)


# lemonzxing

기존의 zxing android embeded를 fork해서 만들었습니다.
오리지널 프로젝트는 싱글뷰인데, 무조건 activity를 생성해서 activityForResult를 호출하여 intent로 스캔결과를 주고 받고 있습니다.
이게 무슨 문제냐면... 뷰를 커스텀해서 처리해서 얻은 결과를 전달하고 싶어도 바코드를 찍고나면 전달할 수가 없다는 점입니다.
그래서 커스텀을 하였고 시험삼아 배포도 해봤는데, 힘듭니다.

오픈소스에 기여하는 전세계 개발자님들에게 경의를 표합니다.

```gradle
implementation 'com.github.Lemonhealthcare:lemonzxing:1.0.9'
```
