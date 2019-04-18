package model;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ghareeb.productdrawerproject.R;

public class ProductFragment extends android.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.product_fragment,container,false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Product product = (Product) getArguments().getSerializable("product");

        TextView textViewName = getActivity().findViewById(R.id.textViewName2);
        TextView textVieweCost = getActivity().findViewById(R.id.textViewCost2);
        TextView textViewFees = getActivity().findViewById(R.id.textViewFees2);
        TextView textViewTotal = getActivity().findViewById(R.id.textViewTotal2);

        textViewName.setText(product.getProductName());
        textVieweCost.setText(String.valueOf(product.getCost()));
        textViewFees.setText(String.valueOf(product.getFees()));
        textViewTotal.setText(String.valueOf(product.getCost()+product.getFees()));

        ImageView productImage = getActivity().findViewById(R.id.imageView);
        int imgId = getResources().getIdentifier("drawable/"+product.getProductimage(),null,getActivity().getPackageName());
        productImage.setImageResource(imgId);
    }
}
