package admin.example.aaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adapter extends BaseAdapter {
private Context context;
private int[] hinh;

    public Adapter(Context context, int[] hinh) {
        this.context = context;
        this.hinh = hinh;
    }

    @Override
    public int getCount() {
        return hinh.length;
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
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.gridview,null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.hinh);
        imageView.setImageResource(hinh[position]);
        return convertView;


    }
}
