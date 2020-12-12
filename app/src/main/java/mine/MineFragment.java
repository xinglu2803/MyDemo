package mine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MineFragment extends Fragment {

    private View rootView;
    private Unbinder unBinder;
    public MineFragment() {
        // Required empty public constructor
    }


    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        unBinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}