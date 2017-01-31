package id.sch.smktelkom_mlg.learn.recyclerview2;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.recyclerview2.adapter.HotelAdapter;
import id.sch.smktelkom_mlg.learn.recyclerview2.model.Hotel;

public class MainActivity extends AppCompatActivity {


    ArrayList<Hotel> mlist = new ArrayList<>();
    HotelAdapter madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        madapter = new HotelAdapter(mlist);
        recyclerView.setAdapter(madapter);

        filldata();

    }

    private void filldata() {

        Resources resources = getResources();
        String[] arjudul = resources.getStringArray(R.array.places);
        String[] ardeskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        Drawable[] arfoto = new Drawable[a.length()];


        for (int i = 0; i < arfoto.length; i++) {

            arfoto[i] = a.getDrawable(i);

        }


        a.recycle();


        for (int i = 0; i < arjudul.length; i++) {
            mlist.add(new Hotel(arjudul[i], ardeskripsi[i], arfoto[i]));

        }
        madapter.notifyDataSetChanged();


    }
}