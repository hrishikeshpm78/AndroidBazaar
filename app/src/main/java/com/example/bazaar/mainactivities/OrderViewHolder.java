package com.example.bazaar.mainactivities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bazaar.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    ImageView imageOrder;
    TextView productOrdername;
    TextView orderPrice;
    TextView orderDate;
    TextView payment;


    OrderViewHolder(View itemView)
    {
        super(itemView);
        imageOrder = (ImageView)itemView.findViewById(R.id.imageorder);
        productOrdername=(TextView) itemView.findViewById(R.id.product_order_name);
        orderPrice=(TextView) itemView.findViewById(R.id.order_price);
        orderDate=(TextView) itemView.findViewById(R.id.order_date);
        payment=(TextView) itemView.findViewById(R.id.payment);

    }
}
