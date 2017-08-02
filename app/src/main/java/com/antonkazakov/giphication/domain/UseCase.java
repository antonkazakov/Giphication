package com.antonkazakov.giphication.domain;

import android.support.annotation.NonNull;

import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 2.08.2017
 */

public abstract class UseCase<ResultType, ParameterType> {

    @NonNull
    protected abstract Observable<ResultType> buildObservable(ParameterType parameter);

    @NonNull
    public Observable<ResultType> buildAndNoExecute(ParameterType parameter) {
        return buildObservable(parameter);
    }

}
