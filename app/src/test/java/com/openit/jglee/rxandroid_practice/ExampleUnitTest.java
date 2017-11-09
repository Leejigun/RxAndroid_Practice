package com.openit.jglee.rxandroid_practice;

import android.util.Log;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        final String filename;
       /* Observable.just(filename)
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                });*/
        assertTrue(true);
    }
}