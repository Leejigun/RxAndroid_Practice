# RxAndroid_Practice

본 페이지는 RxAndroid 개인 학습 페이지 입니다. 아래와 같은 페이지를 참고하였습니다.

* Android developer 88{

​	[RxAndroid part1](http://developer88.tistory.com/1)

​	[Retrofit + RxAndroid를 이용한 Json 파싱](http://developer88.tistory.com/2)

​	}

* [RxAndroid](https://github.com/ReactiveX/RxAndroid)



1. RxAndroid- RxJava를 안드로이드에 맞게 적용한 라이브러리로 RxJava에  대해서는 다음 페이지에 정리 해 놓았습니다. [(RxJava git page)](https://github.com/Leejigun/RxJavaTesting)
2. [RxAndroid git page](https://github.com/ReactiveX/RxAndroid)에서 항상 최신 버전을 확인하고 Dependency를 추가 하도록 합시다.



## 1. RxAndoid의 구성요소

RxAndroid는 4가지의 구성 요소를 가지고 반응형 프로그래밍을 구현합니다.

 * Observable
 * Observer
 * Scheduler
 * Subscription

1. Observable

끊임 없이 흘러나오는 데이터 스트림을 가르킵니다. 아이템이나 배열을 방출하는데, onNext, onComplete, onError를 통해서 데이터를 전달하는 것 뿐만 아니라 에러 신호도 전달하는 역할을 합니다.

2. Observer

Observable에서 흘러 노오는 데이터를 구독해서 반응합니다. 단순히 데이터를 받는 간단한 역할을 한다고 합니다. 앞서 배운 RxJava에서의 Subscriber의 역할을 하는 것 같습니다.

3. Subscription

Observable이 방출한 데이터를 Observar가 구독해서 반응하는데, 이 때 그 트랜젝션을 Subscription이라고 합니다. 안드로이드 생명 주기 안에서 언제든지 가져와 unregister할 수 있기 때문에 중요합니다.

4. Scheduler

멀티 쓰레드 환경에서 적용하고자 할 때 사용합니다.

<pre><code>

```
Observable.just(filename)
        .map(new Func1<String,String>(){
        @Override
            public String call(String s){
            File file;
            try {
                file=File.createTempFile(filename,null,getCacheDir());
                storedCacheName=file.getName();
            }catch (IOException e){
                e.printStackTrace();
            }
            return storedCacheName;
        }
        })
        .subscribeOn(Schedulers.io()) //동작을 워커 쓰레드로 지정
        .observeOn(AndroidSchedulers.mainThread()) //데이터를 사용할 때 어디에 결과를 보낼 지 지정
        .subscribe(new Observer<String>() {
            @Override
            public void onNext(String s) {
            }
            @Override
            public void onError(Throwable e) {
                Log.d(TAG,e.getMessage());
            }
            @Override
            public void onComplete() {
                mResultText.setText(s);
            }
        });
```

</code></pre>

* 위 코드를 정리하면 Observable에서 filename을 받아와서, map을 이용해 캐쉬파일을 생성하는 연산을 진행하는데, 이 때 작업은 워커 쓰레드를 이용하도록 지정합니다.
* 그 후 데이터를 받아와서 메인 쓰레드에서 표현을 할 것입니다. 에러가 난다면 로그를 찍고 완료되면 mResultText에 텍스트를 보여주도록 한 코드입니다.