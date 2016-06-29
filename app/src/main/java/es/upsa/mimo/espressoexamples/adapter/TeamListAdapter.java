package es.upsa.mimo.espressoexamples.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.model.Team;

/**
 * Created by sergiogarcia on 29/06/16.
 */
public class TeamListAdapter extends BaseAdapter {

    private final ArrayList<Team> teams;
    private LayoutInflater inflater;

    public TeamListAdapter(Context context, ArrayList<Team> teams) {
        this.teams = teams;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int i) {
        return teams.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_team, viewGroup, false);
        }

        TextView teamName = (TextView) view.findViewById(R.id.team_title);
        teamName.setText(teams.get(i).name);

        TextView teamDriver = (TextView) view.findViewById(R.id.driver_title);
        teamDriver.setText(teams.get(i).driver);

        return view;
    }
}
