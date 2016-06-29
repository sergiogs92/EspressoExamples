package es.upsa.mimo.espressoexamples.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import es.upsa.mimo.espressoexamples.DatabaseF1;
import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.adapter.TeamListAdapter;
import es.upsa.mimo.espressoexamples.model.Team;

public class AdapterViewFragment extends Fragment {

    private ViewGroup containerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        containerView = container;
        return inflater.inflate(R.layout.fragment_adapter_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ;
        ListView list = (ListView) view.findViewById(R.id.adapter_view_list);
        list.setAdapter(new TeamListAdapter(getContext(), DatabaseF1.DATABASE_F1));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team team = (Team) parent.getItemAtPosition(position);
                TeamDetailFragment teamDetailFragment = TeamDetailFragment.newInstance(team.name);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(containerView.getId(), teamDetailFragment).commit();
            }
        });
    }
}
