package com.antonkazakov.giphication.data.mapper;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public interface IMapper<In, Out> {

    @NonNull
    Out transform(In in);

    @NonNull
    List<Out> transform(List<In> inList);

}
