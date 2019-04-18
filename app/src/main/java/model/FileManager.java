package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManager {

    public static ArrayList<Product> readFile(Context context, String fileName){
        ArrayList<Product> products = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();

        try{
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br = new BufferedReader(isr);

            String oneLine = br.readLine();

            while(oneLine != null){
                StringTokenizer tokenizer = new StringTokenizer(oneLine, ",");
                String productImage = tokenizer.nextToken();
                String productName = tokenizer.nextToken();
                float cost = Float.valueOf(tokenizer.nextToken());
                int fee = Integer.valueOf(tokenizer.nextToken());

                products.add(new Product(productImage,productName,cost,fee));
                oneLine = br.readLine();
            }
            br.close();
            isr.close();
        }catch(Exception e){
            Toast.makeText(context,"can not open file!",Toast.LENGTH_SHORT).show();
        }

        return products;
    }
}
