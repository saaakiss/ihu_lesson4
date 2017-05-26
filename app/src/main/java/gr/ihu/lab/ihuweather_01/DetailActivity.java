package gr.ihu.lab.ihuweather_01;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_detail, new PlaceHolderFragment())
                    .commit();
        }


    }


    public static class PlaceHolderFragment extends Fragment{

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            Intent baklavaPackage = getActivity().getIntent();
            View rootView =  inflater.inflate(R.layout.activity_detail, container, false);

            if (baklavaPackage != null && baklavaPackage.hasExtra(Intent.EXTRA_TEXT)){
                String baklava = baklavaPackage.getStringExtra(Intent.EXTRA_TEXT);
                TextView textView = (TextView) rootView.findViewById(R.id.detail_text);
                textView.setText(baklava);
            }

            return rootView;


        }
    }




}
