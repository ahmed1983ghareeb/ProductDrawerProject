package com.ghareeb.productdrawerproject;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import model.FileManager;
import model.Product;
import model.ProductFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ArrayList<Product> products = new ArrayList<>();
    ArrayAdapter<Product> productArrayAdapter;
    ListView productsListView;
    ImageButton menuBtn;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }

    private void initialize() {
        productsListView = findViewById(R.id.productsListView);
        productsListView.setOnItemClickListener(this);

        menuBtn = findViewById(R.id.imageButton);
        menuBtn.setOnClickListener(this);

        products = FileManager.readFile(this, "products.txt");
        productArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,products);
        productsListView.setAdapter(productArrayAdapter);

        drawerLayout = findViewById(R.id.productDrawer);
    }


    @Override
    public void onClick(View v) {

        drawerLayout.openDrawer(productsListView);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        drawerLayout.closeDrawer(productsListView);

        // replace the linearLayout with the fragement
        ProductFragment productFragment =  new ProductFragment();
        //reference the fragment container
        android.app.FragmentManager fragmentManager = getFragmentManager();
        //begin the transaction
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replace linearLayout
        fragmentTransaction.replace(R.id.productLinearLayout,productFragment);
        //commit the transaction
        fragmentTransaction.commit();
        //set title  for the main activity
        setTitle(products.get(position).getProductName());
        //send data to fragement
        Bundle bundle = new Bundle();
        bundle.putSerializable("product",products.get(position));
        productFragment.setArguments(bundle);
        //rescive the data in the fragment
        //go to CountryFragement class

    }
}
