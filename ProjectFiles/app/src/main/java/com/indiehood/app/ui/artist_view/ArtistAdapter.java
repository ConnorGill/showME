package com.indiehood.app.ui.artist_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.indiehood.app.R;
import com.indiehood.app.ui.listings.ShowListing;

// implements a recycler view using data pulled directly from firestore
public class ArtistAdapter extends FirestoreRecyclerAdapter<ShowListing, ArtistAdapter.ShowHolder> {
    ArtistAdapter(@NonNull FirestoreRecyclerOptions<ShowListing> options) {
        super(options);
    }

    class ShowHolder extends RecyclerView.ViewHolder {
        TextView mTextBandName;
        TextView mTextVenue;
        TextView mTextDay;
        TextView mTextMonth;
        TextView mTimeStart;
        TextView mInterestedText;
        ImageView mBandFavorited;
        CheckBox mUserInterested;

        ShowHolder(View itemView) {
            super(itemView);
            mTextBandName = itemView.findViewById(R.id.bandName);
            mTextVenue = itemView.findViewById(R.id.venue);
            mTextDay = itemView.findViewById(R.id.day);
            mTextMonth = itemView.findViewById(R.id.month);
            mBandFavorited = itemView.findViewById(R.id.bandFavorited);
            mUserInterested = itemView.findViewById(R.id.interested);
            mInterestedText = itemView.findViewById(R.id.interested_text);
            mTimeStart = itemView.findViewById(R.id.time);
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull final ShowHolder viewHolder, int position,
                                    @NonNull final ShowListing model) {
        model.formatValues();
        viewHolder.mTextBandName.setText(model.getBandName());
        viewHolder.mTextVenue.setText(model.getVenueName());
        viewHolder.mTextMonth.setText(model.dateMonth);
        viewHolder.mTextDay.setText(model.dateDay);
        viewHolder.mTimeStart.setText(model.startTimeFormatted);
        viewHolder.mInterestedText.setText(model.getInterestedText());
       /* if (model.getBandFavorite()) {            update this with currentUser stuff
            viewHolder.mBandFavorited.setImageResource(R.drawable.favorites_icon);
        } */

        if (model.getUserInterested()) {
            viewHolder.mUserInterested.setChecked(true);
        }
        else {
            viewHolder.mUserInterested.setChecked(false);
        }
    }

    @NonNull
    @Override
    public ShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // TODO i'd prefer to use a slimmer show listing, like artist_show_listing.xml
        // but android studio doesn't recognize R.layout.artist_show_listing even though it
        // is contained in layout and contains no syntax errors
        View artistView = inflater.inflate(R.layout.show_listing, parent, false);

        return new ShowHolder(artistView);
    }

    /*@Override
    public void onDataChanged() {
        emptyList.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }*/
}
