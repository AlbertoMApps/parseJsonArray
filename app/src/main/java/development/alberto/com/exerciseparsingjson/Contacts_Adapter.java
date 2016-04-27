package development.alberto.com.exerciseparsingjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by alber on 27/04/2016.
 */
public class Contacts_Adapter extends ArrayAdapter{
    List list = new ArrayList<>();
    public Contacts_Adapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContactHolder contactHolder = new ContactHolder();
        int pos = position;
        if(convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_layout, parent, false);
            contactHolder.name = (TextView) convertView.findViewById(R.id.txt_name);
            contactHolder.email = (TextView) convertView.findViewById(R.id.txt_email);
            contactHolder.mobile = (TextView) convertView.findViewById(R.id.txt_mobile);
            convertView.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) convertView.getTag();
        }
        Contacts contacts = (Contacts) getItem(position);
        contactHolder.name.setText(contacts.getName());
        contactHolder.email.setText(contacts.getEmail());
        contactHolder.mobile.setText(contacts.getNumber());

        return convertView;
    }

    public class ContactHolder {
        TextView name, email, mobile;
    }
}
