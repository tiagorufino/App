package ie.rufino.system.course;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class PrimeiraTelaMainActivity extends Activity {

    private EditText myEditText1, myEditText2;
    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_tela_main);

        //get reference to the EditText
        myEditText1 = (EditText) findViewById(R.id.editText1);
        //set the onFocusChange listener
        myEditText1.setOnFocusChangeListener(myEditTextFocus);

        //get reference to the EditText
        myEditText2 = (EditText) findViewById(R.id.editText2);
        //set the onFocusChange listener
        myEditText2.setOnFocusChangeListener(myEditTextFocus);

        myEditText1.setText("Digite your name");
        myEditText2.setText("Digite your name");
        //Generate list View from ArrayList
        displayListView();

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<String> countryList = new ArrayList<String>();
        countryList.add("Can");
        countryList.add("Have");
        countryList.add("Do");
        countryList.add("Let");
        countryList.add("Work");
        countryList.add("Try");
        countryList.add("move");;

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this, R.layout.my_row, countryList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

    }

    private class MyCustomAdapter extends ArrayAdapter<String> {

        private ArrayList<String> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<String> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<String>();
            this.countryList.addAll(countryList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {

                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.my_row, null);

            }

            /*//get reference to the Editext inside the view that was inflated to create the row
            EditText myInputText = (EditText) convertView.findViewById(R.id.myInputText);
            //attach the onFocusChange listener to the EditText
            myInputText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View v, boolean gainFocus) {
                    //onFocus
                    if (gainFocus) {
                        //set the row background to a different color
                        ((View) v.getParent()).setBackgroundColor(Color.rgb(255, 248, 220));
                    }
                    //onBlur
                    else {
                        //set the row background white
                        ((View) v.getParent()).setBackgroundColor(Color.rgb(255, 255, 255));
                    }
                }
            });*/

            TextView country = (TextView) convertView.findViewById(R.id.country);
            country.setText(countryList.get(position));
            return convertView;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    private OnFocusChangeListener myEditTextFocus =  new OnFocusChangeListener() {
        public void onFocusChange(View view, boolean gainFocus) {
            //onFocus
            if (gainFocus) {
                //set the text
                ((EditText) view).setText("");
            }
            //onBlur
            else {
                //clear the text
                ((EditText) view).setText("Digite your name");
            }
        };
    };

}