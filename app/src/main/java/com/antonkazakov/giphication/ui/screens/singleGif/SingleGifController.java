package com.antonkazakov.giphication.ui.screens.singleGif;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antonkazakov.giphication.R;
import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.bluelinelabs.conductor.Controller;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class SingleGifController extends Controller {

    private GifEntity gifEntity;

    @BindView(R.id.player_view)
    SimpleExoPlayerView playerView;

    private SimpleExoPlayer player;

    public SingleGifController(@Nullable Bundle args) {
        super(args);
        if (args != null) {
            gifEntity = args.getParcelable("entity");
        }
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_gif, container, false);
        ButterKnife.bind(this, view);
        init(gifEntity.getUrl());
        initializePlayer();
        return view;
    }

    private void init(@NonNull String url) {
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        DataSource.Factory mediaDataSourceFactory = new DefaultDataSourceFactory(getActivity(), Util.getUserAgent(getActivity(), "mediaPlayerSample"),
                (TransferListener<? super DataSource>) bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector();
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector);
        }
        DefaultExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource = new ExtractorMediaSource(Uri.parse(url),
                mediaDataSourceFactory, extractorsFactory, null, null);
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onSaveViewState(@NonNull View view, @NonNull Bundle outState) {
        super.onSaveViewState(view, outState);
        player.stop();
        outState.putLong("pos", player.getCurrentPosition());
    }

    @Override
    protected void onRestoreViewState(@NonNull View view, @NonNull Bundle savedViewState) {
        super.onRestoreViewState(view, savedViewState);
        player.seekTo(savedViewState.getLong("pos"));
        player.setPlayWhenReady(true);
    }

    private void initializePlayer() {
        playerView.requestFocus();
        playerView.setPlayer(player);
    }

    @Override
    protected void onDestroy() {
        player.release();
    }
}
