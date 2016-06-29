package es.upsa.mimo.espressoexamples.fragments;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.upsa.mimo.espressoexamples.DatabaseF1;
import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.adapter.TeamRecyclerAdapter;

public class TeamFragment extends Fragment implements View.OnClickListener  {

    private Parcelable scrollState;
    private ViewGroup containerView;
    private TeamRecyclerAdapter listAdapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        containerView = container;
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_fragment);

        listAdapter = new TeamRecyclerAdapter(getContext(), DatabaseF1.DATABASE_F1);
        listAdapter.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setOnClickListener(this);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        int positionClicked = recyclerView.getChildAdapterPosition(v);
        TeamDetailFragment teamDetailFragment = TeamDetailFragment.newInstance(DatabaseF1.DATABASE_F1.get(positionClicked).name);
        scrollState = recyclerView.getLayoutManager().onSaveInstanceState();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(containerView.getId(), teamDetailFragment).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.getLayoutManager().onRestoreInstanceState(scrollState);
    }
}
