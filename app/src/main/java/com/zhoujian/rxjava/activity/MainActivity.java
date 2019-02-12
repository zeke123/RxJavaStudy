package com.zhoujian.rxjava.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.zhoujian.rxjava.R;
import com.zhoujian.rxjava.bean.Actor;
import com.zhoujian.rxjava.bean.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RxJava 其实就是提供一套异步编程的 API，这套 API 是基于观察者模式的，而且是链式调用的，所以使用 RxJava 编写的代码的逻辑会非常简洁

        //RxJava 有以下三个基本的元素：
        //被观察者（Observable）
        //观察者（Observer）
        //订阅（subscribe）

        //首先在 gradle 文件中添加依赖：
        //implementation 'io.reactivex.rxjava2:rxjava:2.1.4'
        //implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'


        //1.创建操作符

        //methodOne();

        //methodTwo();

        //createMethod();

        //justMethod();

        //fromArrayMethod();

        //fromCallableMethod();

        //fromFutureMethod();

        //fromIterableMethod();

        //deferMethod();

        //timerMethod();

        //intevalMethod();

        //intervalRangeMethod();

        //rangerMethod();

        //emptyMethod();

        //neverMethod();

        //errorMethod();







        //2.转换操作符

        //mapMethod();

        //initDatas();
        //flatMapMethod();

        //bufferMethod();

        //groupByMethod();

        //scanMethod();

        //windowMethod();


        //3.组合操作符

        //concatMethod();

        //concatArrayMethod();

        //mergeMethod();

        //zipMethod();

        //reduceMethod();

        //collectMethod();

        //startWithMethod();

        //countMethod();


        //4.功能操作符

        //delayMethod();

        //doOnEachMethod();

        //doOnNextMethod();

        //doAfterNextMethod();

        //doOnCompleteMethod();

        //doOnErrorMethod();

        //doOnSubscribeMethod();

        //doOnDisposeMethod();

        //doOnLifecycleMethod();

        //doOnTerminateMethod();

        //doAfterTerminateMethod();

        //doFinallyMethod();

        //onErrorReturnMethod();

        //onErrorResumeNextMethod();

        //onExceptionResumeNextMethod();

        //retryMethod();

        //retryUntilMethod();

        //retryWhenMethod();

        //repeatMethod();

        //repeatWhenMethod();

        //subscribeOnMethod();

        //observeOnMethod();


        //5.过滤操作符

        //filterMethod();

        //ofTypeMethod();

        //skipMethod();

        //distinctMethod();

        //distinctUntilChangedMethod();

        //takeMethod();

        //debounceMethod();

        //firstElementMethod();

        //lastElementMethod();

        //elementAtMethod();


        //6. 条件操作符

        //allMethod();

        //takeWhileMethod();

        //skipWhileMethod();

        //takeUntilMethod();

        //skipUntilMethod();

        //sequenceEqualMethod();

        //containsMethod();

        //isEmptyMethod();

        //ambMethod();

        defaultIfEmptyMethod();


    }


    private void methodOne() {
        //创建被观察者：
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        });

        //创建观察者：
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        };
        //订阅
        observable.subscribe(observer);
    }


    private void methodTwo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void createMethod() {

        //create()
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello Observable");
                emitter.onComplete();

            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "======================onNext= " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        };
        observable.subscribe(observer);

    }


    private void justMethod() {
        //just() 创建一个被观察者，并发送事件，发送的事件不可以超过10个以上

        Observable.just(1, 2, 3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void fromArrayMethod() {

        //fromArray()   这个方法和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组

        Integer array[] = {1, 2, 3, 4};
        Observable.fromArray(array).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });

    }


    private void fromCallableMethod() {

        //fromCallable()
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "======================accept:" + integer);
            }
        });
    }


    private void fromFutureMethod() {
        //fromFuture()
        //参数中的 Future 是 java.util.concurrent 中的 Future，Future 的作用是增加了 cancel() 等方法操作 Callable，它可以通过 get() 方法来获取 Callable 返回的值。

        final FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.i(TAG, "======================call()方法执行了");

                return "1";
            }
        });

        Observable.fromFuture(futureTask).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                futureTask.run();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "======================accept:" + s);
            }
        });
    }


    private void fromIterableMethod() {
        // fromIterable():直接发送一个 List 集合数据给观察者

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Observable.fromIterable(list).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    Integer i = 100;

    private void deferMethod() {

        //defer():这个方法的作用就是直到被观察者被订阅后才会创建被观察者
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });
        i = 200;
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        };
        observable.subscribe(observer);
        i = 300;
        observable.subscribe(observer);

    }

    private void timerMethod() {

        //timer():当到指定时间后就会发送一个 0L 的值给观察者

        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.i(TAG, "======================onNext=" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void intevalMethod() {
        // interval():每隔一段时间就会发送一个事件，这个事件是从0开始，不断增1的数字

        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.i(TAG, "======================onNext=" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void intervalRangeMethod() {

        Observable.intervalRange(2, 5, 1, 1, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.i(TAG, "======================onNext=" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void rangerMethod() {

        //range():时发送一定范围的事件序列。
        //angeLong():作用与 range() 一样，只是数据类型为 Long

        Observable.range(2, 5).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "======================onNext=" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void emptyMethod() {
        //empty() ： 直接发送 onComplete() 事件

        Observable.empty().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, "==================onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError " + e);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete");
            }
        });
    }



    private void neverMethod() {

        //never()：不发送任何事件

        Observable.never().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, "==================onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError " + e);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete");
            }
        });
    }

    private void errorMethod() {
        //error()：发送 onError() 事件

        Observable.error(new Throwable()).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, "==================onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError " + e);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete");
            }
        });
    }


    private void mapMethod() {

        //map():可以将被观察者发送的数据类型转变成其他的类型

        Observable.just(1, 2, 3).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return String.valueOf(integer);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "==================onNext=" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError " + e);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete");
            }
        });
    }

    ArrayList<Movie> moveList = new ArrayList<Movie>();

    private void initDatas() {

        Actor actor1 = new Actor("周星驰", "男");
        Actor actor2 = new Actor("张柏芝", "女");
        ArrayList<Actor> movie1List = new ArrayList<Actor>();
        movie1List.add(actor1);
        movie1List.add(actor2);
        Movie movie1 = new Movie("1998-10-14", 1, movie1List, "喜剧之王");
        moveList.add(movie1);

        Actor actor3 = new Actor("罗志祥", "男");
        Actor actor4 = new Actor("张雨绮", "女");
        ArrayList<Actor> movie2List = new ArrayList<Actor>();
        movie2List.add(actor3);
        movie2List.add(actor4);
        Movie movie2 = new Movie("2016-05-01", 2, movie2List, "美人鱼");
        moveList.add(movie2);

    }

    private void flatMapMethod() {
        //flatMap() :这个方法可以将事件序列中的元素进行整合加工，返回一个新的被观察者。
        //将多个电影转换成多个演员输出

        //将多个电影转换成多个演员输出
        Observable.fromIterable(moveList).flatMap(new Function<Movie, ObservableSource<Actor>>() {
            @Override
            public ObservableSource<Actor> apply(Movie movie) throws Exception {
                return Observable.fromIterable(movie.getMactorList());
            }
        }).subscribe(new Observer<Actor>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe");
            }

            @Override
            public void onNext(Actor actor) {
                Log.i(TAG, "onNext=" + actor.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete");
            }
        });

    }


    private void bufferMethod() {
        //buffer():从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出

        Observable.just(1, 2, 3, 4, 5).buffer(2, 1).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Integer> integers) {
                Log.i(TAG, "================缓冲区大小： " + integers.size());
                for (Integer i : integers) {
                    Log.i(TAG, "================元素： " + i);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void groupByMethod() {

        //groupBy():将发送的数据进行分组，每个分组都会返回一个被观察者

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).groupBy(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer % 3;
            }
        }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe");
            }

            @Override
            public void onNext(GroupedObservable<Integer, Integer> objectIntegerGroupedObservable) {
                objectIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "GroupedObservable---onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {

                        Log.i(TAG, "GroupedObservable---onNext=" + integer);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void scanMethod() {
        //scan():将数据以一定的逻辑聚合起来。

        Observable.just(1, 2, 3, 4).scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "GroupedObservable---accept=" + integer);
            }
        });
    }


    private void windowMethod() {

        //window():发送指定数量的事件时，就将这些事件分为一组。window 中的 count 的参数就是代表指定的数量，例如将 count 指定为2，那么每发2个数据就会将这2个数据分成一组

        Observable.just(1, 2, 3, 4, 5).window(2).subscribe(new Observer<Observable<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe");
            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                integerObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext=" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void concatMethod() {
        //concat():可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。需要注意的是，concat() 最多只可以发送4个事件

        Observable.concat(Observable.just(1, 2), Observable.just(3, 4), Observable.just(5, 6), Observable.just(7, 8)).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void concatArrayMethod() {
        //concatArray():与 concat() 作用一样，不过 concatArray() 可以发送多于 4 个被观察者

        Observable.concatArray(Observable.just(1, 2), Observable.just(3, 4), Observable.just(5, 6), Observable.just(7, 8), Observable.just(9, 10)).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void mergeMethod() {
        //merge():这个方法月 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行发送事件

        Observable.merge(Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "A" + aLong;
            }
        }), Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "B" + aLong;
            }
        })).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void zipMethod() {

        // zip():会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合起来，最终发送的事件数量会与源 Observable 中最少事件的数量一样

        Observable.zip(Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {

                String s1 = "A" + aLong;
                Log.i(TAG, "===================A 发送的事件 " + s1);

                return s1;
            }
        }), Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String s2 = "B" + aLong;
                Log.i(TAG, "===================B 发送的事件 " + s2);

                return s2;
            }
        }), new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) throws Exception {
                String res = s + s2;
                return res;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "===================onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "===================onNext" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "===================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "===================onComplete");
            }
        });
    }


    private void reduceMethod() {

        //reduce():与 scan() 操作符的作用也是将发送数据以一定逻辑聚合起来，这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，而 reduce() 会将所有数据聚合在一起才会发送事件给观察者

        Observable.just(0, 1, 2, 3).reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {

                int res = integer + integer2;
                Log.i(TAG, "====================integer " + integer);
                Log.i(TAG, "====================integer2 " + integer2);
                Log.i(TAG, "====================res " + res);

                return res;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "==================accept " + integer);
            }
        });
    }


    private void collectMethod() {
        //collect():将数据收集到数据结构当中。

        Observable.just(1, 2, 3, 4).collect(new Callable<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> call() throws Exception {
                return new ArrayList<>();
            }
        }, new BiConsumer<ArrayList<Integer>, Integer>() {
            @Override
            public void accept(ArrayList<Integer> integers, Integer integer) throws Exception {
                integers.add(integer);
            }
        }).subscribe(new Consumer<ArrayList<Integer>>() {
            @Override
            public void accept(ArrayList<Integer> integers) throws Exception {
                Log.i(TAG, "===============accept " + integers);
            }
        });
    }


    private void startWithMethod() {

        //startWith():追加一个事件，startWithArray() 可以追加多个事件。追加的事件会先发出。

        Observable.just(1, 2, 3, 4).startWithArray(5, 6, 7).startWith(8).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "================accept " + integer);
            }
        });

    }


    private void countMethod() {
        //count():返回被观察者发送事件的数量
        Observable.just(1, 2, 3).count().subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.i(TAG, "=======================aLong " + aLong);
            }
        });

    }


    private void delayMethod() {
        //delay():延迟一段时间发送事件
        Observable.just(1, 2, 3).delay(2, TimeUnit.SECONDS).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "=======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "=======================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "=======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "=======================onComplete");
            }
        });
    }


    private void doOnEachMethod() {
        //doOnEach():Observable 每发送一件事件之前都会先回调这个方法

        Observable.just(1, 2, 3).doOnEach(new Consumer<Notification<Integer>>() {
            @Override
            public void accept(Notification<Integer> integerNotification) throws Exception {
                Log.i(TAG, "==================doOnEach " + integerNotification.getValue());

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete");
            }
        });
    }

    private void doOnNextMethod() {
        // doOnNext() :Observable 每发送 onNext() 之前都会先回调这个方法

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "==================doOnNext " + integer);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete");
            }
        });
    }


    private void doAfterNextMethod() {
        //doAfterNext():Observable 每发送 onNext() 之后都会回调这个方法

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).doAfterNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "==================doAfterNext " + integer);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void doOnCompleteMethod() {
        // doOnComplete():Observable 每发送 onComplete() 之前都会回调这个方法
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnComplete ");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void doOnErrorMethod() {

        //doOnError():Observable 每发送 onError() 之前都会回调这个方法。
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new NullPointerException());
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "==================doOnError " + throwable);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void doOnSubscribeMethod() {
        //doOnSubscribe():Observable 每发送 onSubscribe() 之前都会回调这个方法。

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.i(TAG, "==================doOnSubscribe ");

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void doOnDisposeMethod() {

        //doOnDispose():当调用 Disposable 的 dispose() 之后回调该方法。

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnDispose ");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
                this.d = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
                d.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }

    private void doOnLifecycleMethod() {
        //doOnLifecycle():在回调 onSubscribe 之前回调该方法的第一个参数的回调方法，可以使用该回调方法决定是否取消订阅。

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.i(TAG, "==================doOnLifecycle accept");

            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnLifecycle Action");
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnDispose Action");
            }
        }).subscribe(new Observer<Integer>() {

            private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
                this.d = d;
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "==================onNext " + s);
                d.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });

    }

    private void doOnTerminateMethod() {
        //doOnTerminate() & doAfterTerminate():doOnTerminate 是在 onError 或者 onComplete 发送之前回调，
        //doAfterTerminate 则是 onError 或者 onComplete 发送之后回调。

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).doOnTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnTerminate ");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }

    private void doAfterTerminateMethod() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new NullPointerException());
                e.onComplete();
            }
        }).doOnTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnTerminate ");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void doFinallyMethod() {
        //doFinally():在所有事件发送完毕之后回调该方法。

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doFinally ");
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doOnDispose ");
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "==================doAfterTerminate ");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
                this.d = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
                d.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void onErrorReturnMethod() {
        // onErrorReturn():当接受到一个 onError() 事件之后回调，返回的值会回调 onNext() 方法，并正常结束该事件序列

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new NullPointerException());
            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) throws Exception {
                Log.i(TAG, "==================onErrorReturn " + throwable);
                return 404;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void onErrorResumeNextMethod() {
        //onErrorResumeNext():当接收到 onError() 事件时，返回一个新的 Observable，并正常结束事件序列

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new NullPointerException());

            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                Log.i(TAG, "==================onErrorResumeNext " + throwable);
                return Observable.just(1, 2, 3);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");

            }
        });
    }


    private void onExceptionResumeNextMethod() {
        //onExceptionResumeNext():与 onErrorResumeNext() 作用基本一致，但是这个方法只能捕捉 Exception
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Exception("404"));

            }
        }).onExceptionResumeNext(new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {
                observer.onNext(4);
                observer.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext " + integer);

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");

            }
        });
    }


    private void retryMethod() {

        // retry():如果出现错误事件，则会重新发送所有事件序列。times 是代表重新发的次数
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Exception("404"));
            }
        }).retry(2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "==================onNext= "+integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    Integer a = 6;
    private void retryUntilMethod() {

        //retryUntil():出现错误事件之后，可以通过此方法判断是否继续发送事件

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Exception("404"));
            }
        }).retryUntil(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Exception {
                if (a == 6) {
                    return true;
                }
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                a += integer;
                Log.i(TAG, "==================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }


    private void retryWhenMethod() {
        //retryWhen():当被观察者接收到异常或者错误事件时会回调该方法，这个方法会返回一个新的被观察者。
        // 如果返回的被观察者发送 Error 事件则之前的被观察者不会继续发送事件，如果发送正常事件则之前的被观察者会继续不断重试发送事件

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onNext("2");
                e.onNext("3");
                e.onError(new Exception("404"));
                e.onNext("5");
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        if (!throwable.toString().equals("java.lang.Exception: 404")) {
                            return Observable.just("可以忽略的异常");
                        } else {
                            return Observable.error(new Throwable("终止啦"));
                        }
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "==================onSubscribe ");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "==================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "==================onError " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "==================onComplete ");
            }
        });
    }

    private void repeatMethod() {

        //repeat():重复发送被观察者的事件，times 为发送次数

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).repeat(2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "===================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "===================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "===================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "===================onComplete ");
            }
        });
    }


    private void repeatWhenMethod() {

        //repeatWhen():这个方法可以会返回一个新的被观察者设定一定逻辑来决定是否重复发送事件

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                //return Observable.empty();
                return Observable.error(new Exception("404"));
                //return Observable.just(4);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "===================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "===================onNext " + integer);

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "===================onError ");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "===================onComplete ");

            }
        });
    }


    private void subscribeOnMethod() {

        //subscribeOn():指定被观察者的线程，要注意的时，如果多次调用此方法，只有第一次有效

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.i(TAG, "===================currentThread name:" + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        }).subscribeOn(Schedulers.newThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "===================onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "===================onNext " + integer);

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "===================onError ");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "===================onComplete ");

            }
        });
    }

    private void observeOnMethod() {

        //observeOn():指定观察者的线程，每指定一次就会生效一次。
        Observable.just(1, 2, 3).observeOn(Schedulers.newThread()).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                Log.i(TAG, "===================currentThread name:" + Thread.currentThread().getName());
                return Observable.just("zhou" + integer);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "======================onNext Thread name " + Thread.currentThread().getName());
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void filterMethod() {
        // filter():通过一定逻辑来过滤被观察者发送的事件，如果返回 true 则会发送事件，否则不会发送

        Observable.just(1, 2, 3).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 2;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void ofTypeMethod() {
        //ofType():可以过滤不符合该类型事件

        Observable.just(1, 2, 3, "zhou", "jian").ofType(Integer.class).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void skipMethod() {
        //skip():跳过正序某些事件，count 代表跳过事件的数量

        Observable.just(1, 2, 3, 4).skip(2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void distinctMethod() {

        // distinct():过滤事件序列中的重复事件

        Observable.just(1, 2, 2, 2, 1, 1).distinct().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }

    private void distinctUntilChangedMethod() {
        //distinctUntilChanged():过滤掉连续重复的事件

        Observable.just(1, 2, 2, 3, 3, 4).distinctUntilChanged().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void takeMethod() {
        //take():控制观察者接收的事件的数量

        Observable.just(1, 2, 3, 4, 5).take(3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }

    private void debounceMethod() {
        //debounce():如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                Thread.sleep(900);
                e.onNext(2);
            }
        }).debounce(1, TimeUnit.SECONDS).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, "======================onNext " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "======================onComplete");
            }
        });
    }


    private void firstElementMethod() {
        //firstElement() 取事件序列的第一个元素，

        Observable.just(1, 2, 3, 4).firstElement().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "====================firstElement " + integer);
            }
        });
    }

    private void lastElementMethod() {
        //lastElement() 取事件序列的最后一个元素
        Observable.just(1, 2, 3, 4).lastElement().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "====================lastElement " + integer);
            }
        });
    }


    private void elementAtMethod() {
        //elementAt() :可以指定取出事件序列中事件，但是输入的 index 超出事件序列的总数的话就不会出现任何结果
        //这种情况下，你想发出异常信息的话就用 elementAtOrError()

        Observable.just(1, 2, 3, 4).elementAt(0).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "====================accept " + integer);
            }
        });

        Observable.just(1, 2, 3, 4).elementAtOrError(5).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "====================accept " + integer);
            }
        });
    }

    private void allMethod() {
        //all():判断事件序列是否全部满足某个事件，如果都满足则返回 true，反之则返回 false

        Observable.just(1, 2, 3, 4).all(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 5;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.i(TAG, "==================aBoolean " + aBoolean);
            }
        });
    }

    private void takeWhileMethod() {
        //takeWhile():可以设置条件，当某个数据满足条件时就会发送该数据，反之则不发送

        Observable.just(1, 2, 3, 4, 5).takeWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 4;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "========================integer " + integer);
            }
        });
    }


    private void skipWhileMethod() {
        //skipWhile():可以设置条件，当某个数据满足条件时不发送该数据，反之则发送

        Observable.just(1, 2, 3, 4).skipWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 3;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "========================integer " + integer);
            }
        });
    }


    private void takeUntilMethod() {
        //takeUntil():可以设置条件，当事件满足此条件时，下一次的事件就不会被发送了

        Observable.just(1, 2, 3, 4, 5, 6).takeUntil(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer > 3;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "========================integer " + integer);
            }
        });
    }

    private void skipUntilMethod() {

        //skipUntil():当 skipUntil() 中的 Observable 发送事件了，原来的 Observable 才会发送事件给观察者

        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS).skipUntil(Observable.intervalRange(6, 5, 3, 1, TimeUnit.SECONDS)).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "========================onSubscribe ");
            }

            @Override
            public void onNext(Long along) {
                Log.i(TAG, "========================onNext " + along);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "========================onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "========================onComplete ");
            }
        });
    }

    private void sequenceEqualMethod() {
        // sequenceEqual():判断两个 Observable 发送的事件是否相同。

        Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2, 3)).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.i(TAG, "========================onNext " + aBoolean);
            }
        });
    }

    private void containsMethod() {
        // contains():判断事件序列中是否含有某个元素，如果有则返回 true，如果没有则返回 false
        Observable.just(1, 2, 3).contains(3).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.i(TAG, "========================onNext " + aBoolean);
            }
        });
    }

    private void isEmptyMethod() {
        // isEmpty():判断事件序列是否为空
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();
            }
        }).isEmpty().subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.i(TAG, "========================onNext " + aBoolean);
            }
        });
    }

    private void ambMethod() {
        //amb():amb() 要传入一个 Observable 集合，但是只会发送最先发送事件的 Observable 中的事件，其余 Observable 将会被丢弃
        ArrayList<Observable<Long>> list = new ArrayList<>();
        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));
        Observable.amb(list).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.i(TAG, "========================aLong " + aLong);
            }
        });

    }


    private void defaultIfEmptyMethod() {
        //defaultIfEmpty():如果观察者只发送一个 onComplete() 事件，则可以利用这个方法发送一个值

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();
            }
        }).defaultIfEmpty(666).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i(TAG, "========================onNext " + integer);
            }
        });
    }
}
