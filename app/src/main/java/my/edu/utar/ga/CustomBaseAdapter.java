package my.edu.utar.ga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listRestaurant[];
    int listImages[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx,String [] RestaurantList,int [] images){
        this.context=ctx;
        this.listRestaurant=RestaurantList;
        this.listImages=images;
        inflater =LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return listRestaurant.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView =(TextView)convertView.findViewById(R.id.textView);
        ImageView RestaurantImg=(ImageView)convertView.findViewById(R.id.imageIcon);
        txtView.setText(listRestaurant[position]);
        RestaurantImg.setImageResource(listImages[position]);
        return convertView;
    }
}
