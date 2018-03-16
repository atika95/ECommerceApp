package com.oum.e_commerceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oum.e_commerceapp.adapter.CategoryAdapter;
import com.oum.e_commerceapp.adapter.ProductAdapter;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductActivity extends Activity {
    GridView gridView;
    TextView  txtItemCount;
    int itemCount;

    ArrayList<ProductDomain> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productList = new ArrayList<>();

        gridView = findViewById(R.id.grid_product);

        int position = getIntent().getIntExtra("position",0);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.description_layout,null));
        builder.create();

        Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();


        ProductDomain productDomain;
        switch(position){
            case 0:

                String [] clothList = {"JEANS","SHIRT","PANTS","T-SHIRT","SWEATER","PALAZO"};
                int [] clothImageList = {R.drawable.jeans,R.drawable.shirt,R.drawable.pants,R.drawable.t_shirt,R.drawable.sweater,R.drawable.palazo};
                String [] clothpriceList = {"70 MYR","45 MYR","100 MYR","30 MYR","55 MYR","30 MYR"};

                for (int i=0;i<clothList.length;i++){
                    productDomain = new ProductDomain(clothList[i],clothImageList[i],clothpriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList,getApplicationContext()));


                break;

            case 1:
                String [] electronicsList = {"COMPUTERS","TABLETS","CPU","KEYBOARD","TV"};
                int [] electronicsImageList = {R.drawable.computer,R.drawable.tablets,R.drawable.cpu,R.drawable.keyboard,R.drawable.tv};
                String [] electronicspriceList = {"2000 MYR","500 MYR","100 MYR","30 MYR","3500 MYR"};

                for (int i=0;i<electronicsList.length;i++){
                    productDomain = new ProductDomain(electronicsList[i],electronicsImageList[i],electronicspriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList,getApplicationContext()));

                break;

            case 2:
                String [] softwareList = {"GOOGLE CHROME","MICROSOFT","ANDROID","JAVA"};
                int [] softwareImageList = {R.drawable.chrome,R.drawable.microsoft,R.drawable.android,R.drawable.java};
                String [] softwarepriceList = {"200 MYR","250 MYR","100 MYR","300 MYR"};

                for (int i=0;i<softwareList.length;i++){
                    productDomain = new ProductDomain(softwareList[i],softwareImageList[i],softwarepriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList,getApplicationContext()));

                break;

            case 3:
                String [] phoneList = {"SAMSUNG","LG","PIXEL","SAMSUNG","LG","PIXEL","SAMSUNG"};
                int [] phoneImageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};
                String [] phonepriceList = {"2000 MYR","2500 MYR","1000 MYR","3000 MYR","2500 MYR","2000 MYR","3000 MYR"};

                for (int i=0;i<phoneList.length;i++){
                    productDomain = new ProductDomain(phoneList[i],phoneImageList[i],phonepriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList,getApplicationContext()));

                break;

            case 4:
                String [] automobilesList = {"SUZUKI","HONDA","MERCEDES","PROTON","PERDOUA","AUDI"};
                int [] automobilesImageList = {R.drawable.suzuki,R.drawable.honda,R.drawable.mercedes,R.drawable.proton,R.drawable.perodua,R.drawable.audi};
                String [] automobilespriceList = {"200000 MYR","250000 MYR","100000 MYR","30000 MYR","25000 MYR","20000 MYR","300000 MYR"};

                for (int i=0;i<automobilesList.length;i++){
                    productDomain = new ProductDomain(automobilesList[i],automobilesImageList[i],automobilespriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList,getApplicationContext()));

                break;


        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
                productDetails(productList.get(i).getProductName(),productList.get(i).getProductPrice(),productList.get(i).getImageId(),i);
            }
        });

    }
    public void productDetails(String productName,String productPrice,int productImageId,final int position) {
        final AlertDialog alert;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Get the layout inflater
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //Inflate and set the layout for the dialog
        //pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.description_layout, null);

        builder.setView(view);
        alert = builder.create();
        alert.show();

        //this for each product click to add to cart
        TextView txtProduct = view.findViewById(R.id.txt_product_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ImageView imageView = view.findViewById(R.id.img_product);
        Button btnCart = view.findViewById(R.id.button);

        txtProduct.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(productImageId);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cartArray.add(productDomainArrayList.get(position));
                itemCount++;
                updateHotCount(itemCount);
                alert.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.cart_menu,menu);

            final View notifications = menu.findItem(R.id.cart_item).getActionView();

         txtItemCount = (TextView) notifications.findViewById(R.id.cart_badge);
         updateHotCount(itemCount++);
         txtItemCount.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     updateHotCount(itemCount++);
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle item selection
        switch (item.getItemId()) {
            case R.id.cart_item:
                //newGame();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    public void updateHotCount(final int new_number){
        itemCount = new_number;
        if (itemCount <0 ) return;
        runOnUiThread(new Runnable() {

        @Override
        public void run() {
            if (itemCount ==0)
                txtItemCount.setVisibility(View.GONE);
            else {
                txtItemCount.setVisibility(View.VISIBLE);
                txtItemCount.setText(Integer.toString(itemCount));
                // supportInvalidateOptionsMenu();
            }
        }
    });


}
}
