package hoanglong.framgia.com.android_tablayoutviewpager.model;

public class Song {
    private String mName;
    private String mAuthor;
    private String mImageSong;

    public Song(String mName, String mAuthor, String mImageSong) {
        this.mName = mName;
        this.mAuthor = mAuthor;
        this.mImageSong = mImageSong;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getImageSong() {
        return mImageSong;
    }

}
