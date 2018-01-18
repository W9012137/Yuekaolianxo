package chencheng.bwie.com.yuekaolianxo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Bean.ProductsBean;
import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.view.DetailActivity;

/**
 * Created by dell on 2018/1/17.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private List<ProductsBean.DataBean> list;
   private Context context;
    OnClickfl onClickfl;
    public interface OnClickfl{
        void onClickxq(int position);
    }
    public void setOnclickSpflAdpter(OnClickfl onClickfl) {
        this.onClickfl = onClickfl;
    }
    public ListAdapter(List<ProductsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false);
        return new MyViewHaoder(view) ;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
          MyViewHaoder myViewHaoder= (MyViewHaoder) holder;
        final ProductsBean.DataBean dataBean = list.get(position);
        myViewHaoder.title.setText(dataBean.getTitle());
        myViewHaoder.name.setText(dataBean.getSubhead());
        String images = dataBean.getImages();
        String[] split = images.split("\\|");
        myViewHaoder.iv.setImageURI(Uri.parse(split[1]));
        myViewHaoder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(context, DetailActivity.class);
                it.putExtra("pid", dataBean.getPid() + "");
                context.startActivity(it);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHaoder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView  iv;
        private TextView title,name;
        LinearLayout ll;
        public MyViewHaoder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            title=itemView.findViewById(R.id.title);
            name=itemView.findViewById(R.id.name);
            ll=itemView.findViewById(R.id.all);
        }
    }
}
