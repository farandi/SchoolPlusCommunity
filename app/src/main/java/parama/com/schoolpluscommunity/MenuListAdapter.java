package parama.com.schoolpluscommunity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Farandi Kusumo on 09-Aug-17.
 */

public class MenuListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Notification> mDataSource;

    public MenuListAdapter(Context context, ArrayList<Notification> items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public int getCount() {return mDataSource.size();}

    @Override
    public Object getItem(int position) { return mDataSource.get(position);}

    @Override
    public long getItemId(int position) { return position;}

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = mInflater.inflate(R.layout.list_notification, parent, false);

            holder = new ViewHolder();
            holder.thumbnailImageView = (ImageView)convertView.findViewById(R.id.list_thumbnail);
            holder.titleTextView = (TextView)convertView.findViewById(R.id.list_title_text);
            holder.subtitleTextView = (TextView)convertView.findViewById(R.id.list_subtitle_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        TextView titleTextView = holder.titleTextView;
        TextView subtitleTextView = holder.subtitleTextView;
        ImageView thumbnailImageView = holder.thumbnailImageView;

        Notification notification = (Notification)getItem(position);

        titleTextView.setText(notification.title);
        subtitleTextView.setText(notification.subtitle);


        return convertView;
    }

    private static class ViewHolder {
        public TextView titleTextView;
        public TextView subtitleTextView;
        public ImageView thumbnailImageView;

    }
}
