package es.upsa.mimo.espressoexamples.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.model.Team;

/**
 * Created by sergiogarcia on 26/6/16.
 */
public class TeamRecyclerAdapter extends RecyclerView.Adapter<TeamRecyclerAdapter.ItemsViewHolder> implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;
    private ArrayList<Team> databaseF1;

    public TeamRecyclerAdapter(Context context, ArrayList<Team> databaseF1) {
        this.context = context;
        this.databaseF1 = databaseF1;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    @Override
    public TeamRecyclerAdapter.ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        viewItem.setOnClickListener(this);

        ItemsViewHolder viewHolder = new ItemsViewHolder(context, viewItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeamRecyclerAdapter.ItemsViewHolder holder, int position) {
        holder.bindItem(databaseF1.get(position));
    }

    public static class ItemsViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView driverTextView;

        public ItemsViewHolder(Context context, View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.team_title);
            driverTextView = (TextView) itemView.findViewById(R.id.driver_title);
        }

        public void bindItem(Team team) {
            titleTextView.setText(team.name);
            driverTextView.setText(team.driver);
        }
    }

    @Override
    public int getItemCount() {
        return databaseF1.size();
    }

}