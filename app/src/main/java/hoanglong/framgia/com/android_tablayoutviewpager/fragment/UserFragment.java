package hoanglong.framgia.com.android_tablayoutviewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hoanglong.framgia.com.android_tablayoutviewpager.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    public UserFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
}
