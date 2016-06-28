package es.upsa.mimo.espressoexamples.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.upsa.mimo.espressoexamples.R;

public class TeamDetailFragment extends Fragment {

    private static final String ARGS_KEY = "title";
    private TextView textView;
    private String title;

    public static TeamDetailFragment newInstance(String title) {
        TeamDetailFragment booksDetailFragment = new TeamDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_KEY, title);
        booksDetailFragment.setArguments(args);
        return booksDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.text);
        if (getArguments() != null) {
            title = (String) getArguments().get(getString(R.string.extraTitle));
            textView.setText(title);
        }
    }
}
