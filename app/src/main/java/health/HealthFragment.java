package health;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HealthFragment extends Fragment {


    private Bundle arguments;
    private View rootView;
    private Unbinder unBinder;

    public HealthFragment() {

    }

    public static HealthFragment newInstance() {
        HealthFragment fragment = new HealthFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arguments = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_health, container, false);
        unBinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}