package es.upsa.mimo.espressoexamples.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.upsa.mimo.espressoexamples.DatabaseF1;
import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.model.Team;

/**
 * Created by sergiogarcia on 26/6/16.
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ItemsViewHolder> implements View.OnClickListener {

    private Context context;
    private View.OnClickListener listener;

    public TeamAdapter(Context context) {
        context = context;
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
    public TeamAdapter.ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        viewItem.setOnClickListener(this);

        ItemsViewHolder viewHolder = new ItemsViewHolder(context, viewItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeamAdapter.ItemsViewHolder holder, int position) {
        holder.bindItem(DatabaseF1.DATABASE_F1.get(position));
    }

    @Override
    public int getItemCount() {
        return DatabaseF1.DATABASE_F1.size();
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
}