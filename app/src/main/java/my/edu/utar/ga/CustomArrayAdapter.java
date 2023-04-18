package my.edu.utar.ga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<DataModel> {
    // Constructor
    public CustomArrayAdapter(Context context, ArrayList<DataModel> data) {
        super(context, R.layout.favourite_item, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.favourite_item, parent, false);
        }

        // Retrieve data from the database
        DataModel dataModel = getItem(position); // or retrieve from Cursor if using Cursor

        // Bind data to UI elements in list item layout
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView categoryTextView = convertView.findViewById(R.id.categoryTextView);

        nameTextView.setText(dataModel.getName());
        categoryTextView.setText(dataModel.getCategory());

        return convertView;
    }
}
