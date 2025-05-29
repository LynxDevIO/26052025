package puc.mobile.a26052025;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> lista;

    public UserAdapter(Context context, ArrayList<User> lista) {
        this.context = context;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        TextView t1 = v.findViewById(R.id.user_name);
        TextView t2 = v.findViewById(R.id.user_email);
        TextView t3 = v.findViewById(R.id.user_phone);

        User u = lista.get(position);
        t1.setText(u.getName());
        t2.setText(u.getEmail());
        t3.setText(u.getPhone());
        return v;
    }
}
