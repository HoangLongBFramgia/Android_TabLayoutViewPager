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

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private ArrayList<Song> songs;

    public SongAdapter(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_song, viewGroup, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder songViewHolder, int i) {
        Song song = songs.get(i);
        songViewHolder.mTextTitleSong.setText(song.getName());
        songViewHolder.mTextAuthor.setText(song.getAuthor());
        new MyUtils.DownloadImageTask(songViewHolder.mImageSong)
                .execute(song.getImageSong());
    }

    @Override
    public int getItemCount() {
        return songs.size();
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
