package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rojinonlineclothingshoppingapp.ItemsDetailActivity;
import com.rojinonlineclothingshoppingapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.ItemProperties;

public class AdapterItems extends RecyclerView.Adapter<AdapterItems.ItemViewHolder> {
    Context mContext;
    List<ItemProperties> itemList;

    public AdapterItems(Context mContext, List<ItemProperties> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgview;
        TextView itemname, itemprice, itemdescription, itemimagename;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imgview = itemView.findViewById(R.id.imgview);
            itemname = itemView.findViewById(R.id.tvName);
            itemprice = itemView.findViewById(R.id.tvPrice);
            itemdescription = itemView.findViewById(R.id.tvDescription);
            itemimagename = itemView.findViewById(R.id.tvImagename);
        }


    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_properties,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        final ItemProperties itemProperties = itemList.get(i);

        itemViewHolder.imgview.setImageResource(itemProperties.getImgId());
        itemViewHolder.itemname.setText(itemProperties.getItemName());
        itemViewHolder.itemprice.setText(itemProperties.getItemPrice());
        itemViewHolder.itemdescription.setText(itemProperties.getItemDescription());
        itemViewHolder.itemimagename.setText(itemProperties.getImageName());

        itemViewHolder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ItemsDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("image",itemProperties.getImgId());
                intent.putExtra("name",itemProperties.getItemName());
                intent.putExtra("description",itemProperties.getItemDescription());
                intent.putExtra("price",itemProperties.getItemPrice());
                intent.putExtra("imagename",itemProperties.getImageName());




                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return  itemList.size();
    }





}

