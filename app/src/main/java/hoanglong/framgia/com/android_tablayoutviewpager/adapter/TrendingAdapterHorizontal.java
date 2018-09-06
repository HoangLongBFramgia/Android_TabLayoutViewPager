package hoanglong.framgia.com.android_tablayoutviewpager.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoanglong.framgia.com.android_tablayoutviewpager.R;
import hoanglong.framgia.com.android_tablayoutviewpager.model.Song;
import hoanglong.framgia.com.android_tablayoutviewpager.utils.MyUtils;

public class TrendingAdapterHorizontal extends RecyclerView.Adapter<TrendingAdapterHorizontal.SongViewHolder> {

    private ArrayList<Song> mSongs;

    public TrendingAdapterHorizontal(ArrayList<Song> mSongs) {
        this.mSongs = mSongs;
    }

    @NonNull
    @Override
    public TrendingAdapterHorizontal.SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_trending_horizontal, viewGroup, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapterHorizontal.SongViewHolder songViewHolder, int i) {
        Song mSong = mSongs.get(i);
        songViewHolder.mTextTitleSong.setText(mSong.getName());
        songViewHolder.mTextAuthor.setText(mSong.getAuthor());
        new MyUtils.DownloadImageTask(songViewHolder.mImageSong)
                .execute(mSong.getImageSong());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextTitleSong;
        private TextView mTextAuthor;
        private ImageView mImageSong;

        SongViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextTitleSong = itemView.findViewById(R.id.tv_song);
            mTextAuthor = itemView.findViewById(R.id.tv_author);
            mImageSong = itemView.findViewById(R.id.iv_song);
        }
    }
}
