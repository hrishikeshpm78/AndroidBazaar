package com.example.bazaar.mainactivities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazaar.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView pName;
    ImageView image;
    TextView pPrice;
    TextView quantity;
    View itemView2;
    Button cartDelete;
    RecyclerViewHolder(View itemView)
    {

        super(itemView);
        itemView2=itemView;
        pName = (TextView)itemView.findViewById(R.id.product_text);
        image = (ImageView)itemView.findViewById(R.id.imagerec);
        pPrice=(TextView) itemView.findViewById(R.id.prod_price);
        quantity=(TextView) itemView.findViewById(R.id.cart_quantity);
        cartDelete=(Button) itemView.findViewById(R.id.cart_delete);

    }

}
