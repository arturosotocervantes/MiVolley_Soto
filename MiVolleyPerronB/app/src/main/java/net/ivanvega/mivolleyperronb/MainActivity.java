package net.ivanvega.mivolleyperronb;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;
    RequestQueue queue;
    //String url = "http://lorempixel.com/";
    String url = "https://placeimg.com/";
    Button btn;
    String tip;

    boolean banderaGrey=false, nSelected=false;

    TextView txtX,txtY;
    //http://lorempixel.com/g/400/200/sports/


    // Request a string response from the provided URL.

// Add the request to the RequestQueue.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        mImageView = (ImageView) findViewById(R.id.imaVie);





        txtX= (TextView) findViewById(R.id.txtX);
        txtY= (TextView) findViewById(R.id.txtY);









    }

    public void btnGenerar_click(View view) {

        try {

            int x=Integer.parseInt(txtX.getText().toString());
            int y=Integer.parseInt(txtY.getText().toString());


            if(banderaGrey==true){
                url = url+x+"/"+y+"/"+tip+"/grayscale";
                //Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
            }else{
                url = url+x+"/"+y+"/"+tip;
                // Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
            }
            ImageRequest request = new ImageRequest(url,
                    new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap bitmap) {
                            mImageView.setImageBitmap(bitmap);
                        }
                    }, 0, 0, null,
                    new Response.ErrorListener() {
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });


            queue.add(request);
            url = "https://placeimg.com/";



        }catch (Exception e){
            Toast.makeText(this, "Asegurate de Seleccionar Todos Los Campos", Toast.LENGTH_SHORT).show();

        }



    }

    public void btnAnimals_click(View view) {
        tip="animals";
        Toast.makeText(this, "Categories: Animals", Toast.LENGTH_SHORT).show();
    }

    public void btnArchitecture_click(View view) {
        tip="architecture";
        Toast.makeText(this, "Categories: Architecture", Toast.LENGTH_SHORT).show();
    }

    public void btnNature_click(View view) {
        tip="nature";
        Toast.makeText(this, "Categories: Nature", Toast.LENGTH_SHORT).show();
    }

    public void btnPeople_click(View view) {
        tip="people";
        Toast.makeText(this, "Categories: People", Toast.LENGTH_SHORT).show();
    }

    public void btnTech_click(View view) {
        tip="tech";
        Toast.makeText(this, "Categories: Tech", Toast.LENGTH_SHORT).show();
    }

    public void btnGrayScale_click(View view) {
        banderaGrey=true;
        Toast.makeText(this, "Filters: Grayscale", Toast.LENGTH_SHORT).show();
    }

    public void btnSepia_click(View view) {
        banderaGrey=false;
        Toast.makeText(this, "Filters: Sepia", Toast.LENGTH_SHORT).show();
    }
}
