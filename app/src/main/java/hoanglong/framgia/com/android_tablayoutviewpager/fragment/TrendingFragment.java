package hoanglong.framgia.com.android_tablayoutviewpager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import hoanglong.framgia.com.android_tablayoutviewpager.R;
import hoanglong.framgia.com.android_tablayoutviewpager.adapter.SongAdapter;
import hoanglong.framgia.com.android_tablayoutviewpager.adapter.TrendingAdapterHorizontal;
import hoanglong.framgia.com.android_tablayoutviewpager.model.Song;

public class TrendingFragment extends Fragment {

    private RecyclerView mRecyclerViewTrendingHorizontal;
    private RecyclerView mRecyclerViewTrendingVertical;
    private TrendingAdapterHorizontal mTrendingAdapterHorizontal;
    private ArrayList<Song> mSongs;

    public TrendingFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView(view);
        setData();
        setAdapter(mRecyclerViewTrendingVertical, LinearLayoutManager.VERTICAL);
        setAdapterAutoScroll();
    }

    private void setAdapterAutoScroll() {
        mTrendingAdapterHorizontal = new TrendingAdapterHorizontal(mSongs);
        mRecyclerViewTrendingHorizontal.setAdapter(mTrendingAdapterHorizontal);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(getContext()) {
                    private static final float SPEED = 3000f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        autoScrollAnother();
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewTrendingHorizontal.setLayoutManager(layoutManager);
        mRecyclerViewTrendingHorizontal.setHasFixedSize(true);
        mRecyclerViewTrendingHorizontal.setItemViewCacheSize(10);
        mRecyclerViewTrendingHorizontal.setDrawingCacheEnabled(true);
        mRecyclerViewTrendingHorizontal.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        mRecyclerViewTrendingHorizontal.setAdapter(mTrendingAdapterHorizontal);

        SongAdapter trendingAdapter = new SongAdapter(mSongs);
        mRecyclerViewTrendingVertical.setAdapter(trendingAdapter);

    }

    private void autoScrollAnother() {
        final int[] scrollCount = {0};
        final int speedScroll = 2400;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (scrollCount[0] == mTrendingAdapterHorizontal.getItemCount()) {
                    mTrendingAdapterHorizontal.notifyDataSetChanged();
                    scrollCount[0] = 0;
                } else {
                    mRecyclerViewTrendingHorizontal.smoothScrollToPosition((scrollCount[0]++));
                    handler.postDelayed(this, speedScroll);
                }
            }
        };
        handler.postDelayed(runnable, speedScroll);

    }

    private void setAdapter(RecyclerView recyclerView, int linearLayoutManager) {
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), linearLayoutManager, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(10);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
    }

    private void setData() {
        mSongs = new ArrayList<>();
        Song song1 = new Song("https://109cdf7de.vws.vegacdn.vn/kv0puCNE4oNNfn7YhOpK/1/v1/artists/s2/0/0/2/2117.jpg", "Người lạ ơi", "karik");
        Song song2 = new Song("https://109cdf7de.vws.vegacdn.vn/kv0puCNE4oNNfn7YhOpK/1/v1/artists/s2/0/0/36/37204.jpg", "Chạm đáy nỗi đau", "Erik");
        Song song3 = new Song("https://109cdf7de.vws.vegacdn.vn/kv0puCNE4oNNfn7YhOpK/1/v1/artists/s2/0/0/26/27592.jpg", "Tìm lại bầu trời", "Tuấn Hưng");
        Song song4 = new Song("https://109cdf7de.vws.vegacdn.vn/kv0puCNE4oNNfn7YhOpK/1/v1/artists/s2/0/0/3/3349.jpg", "Nơi tình yêu bắt đầu", "Bùi Anh Tuấn");
        Song song5 = new Song("https://109cdf7de.vws.vegacdn.vn/jXitUPK9cvjCkkVYrFPL/200x200x1525690529/v1/album/s0/0/21/889/22930433.jpg", "Đừng như thói quen", "Jayki");
        Song song6 = new Song("https://109cdf7de.vws.vegacdn.vn/kv0puCNE4oNNfn7YhOpK/1529037018/v1/videos/img/s2/0/0/53/54380.jpg", "Đừng quên tên anh", "Hoa Vinh");

        mSongs.add(song1);
        mSongs.add(song2);
        mSongs.add(song3);
        mSongs.add(song4);
        mSongs.add(song5);
        mSongs.add(song6);
    }

    private void setView(View view) {
        mRecyclerViewTrendingHorizontal = view.findViewById(R.id.rv_trending_horizontal);
        mRecyclerViewTrendingVertical = view.findViewById(R.id.rv_trending_vertical);
    }
}
