package com.lmlunadev.gymapp.utils;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.constants.ListenerConstants;
import com.lmlunadev.gymapp.listeners.ListItemEditOnClickListener;
import com.lmlunadev.gymapp.model.TitleDescriptionItem;

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    private final ListenerConstants.ContentType contentType;
    private FragmentActivity contextActivity;
    private TextView titleField;
    private TextView descriptionField;
    private TitleDescriptionItem item;

    public ListItemViewHolder(View itemView, FragmentActivity contextActivity, ListenerConstants.ContentType contentType) {
        super(itemView);
        this.contextActivity = contextActivity;
        this.contentType = contentType;

        itemView.setClickable(true);
        ListItemEditOnClickListener itemEditListener = new ListItemEditOnClickListener(this.contextActivity, this.contentType);
        itemView.setOnClickListener(itemEditListener);
        this.titleField = (TextView) itemView.findViewById(R.id.recycler_item_title);
        this.descriptionField = (TextView) itemView.findViewById(R.id.recycler_item_description);
    }

    public TextView getTitleField() { return this.titleField; }

    public void setTitleField(TextView textView) { this.titleField = textView; }

    public TextView getDescriptionField() { return descriptionField; }

    public void setDescriptionField(TextView descriptionField) { this.descriptionField = descriptionField; }

    public void setItem(TitleDescriptionItem item) { this.item = item; }
}