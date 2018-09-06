package hoanglong.framgia.com.android_tablayoutviewpager.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import hoanglong.framgia.com.android_tablayoutviewpager.R;
import hoanglong.framgia.com.android_tablayoutviewpager.adapter.SongAdapter;
import hoanglong.framgia.com.android_tablayoutviewpager.model.Song;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerViewHome;
    private ArrayList<Song> mSongs;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView(view);
        setData();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        SongAdapter mSongAdapter = new SongAdapter(mSongs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewHome.setLayoutManager(linearLayoutManager);
        mRecyclerViewHome.setHasFixedSize(true);
        mRecyclerViewHome.setAdapter(mSongAdapter);
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
        mRecyclerViewHome = view.findViewById(R.id.rv_home);
    }

}
