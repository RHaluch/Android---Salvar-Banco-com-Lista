package com.example.opet.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by opet on 02/10/2019.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    int rId;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mView = convertView;

        if(mView==null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            mView = inflater.inflate(rId,null);
        }

        Item item = getItem(position);

        TextView textNome = mView.findViewById(R.id.textNome);
        TextView textQtde = mView.findViewById(R.id.textQtde);
        TextView textCategoria = mView.findViewById(R.id.textCategoria);

        textNome.setText(item.getNome());
        textQtde.setText(String.valueOf(item.getQtde()));
        textCategoria.setText(item.getCategoria());

        return mView;
    }
}
