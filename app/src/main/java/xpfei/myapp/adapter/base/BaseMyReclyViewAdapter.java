package xpfei.myapp.adapter.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import xpfei.mylibrary.view.reclyview.recyclerview.BaseRecyclerAdapter;

/**
 * Description: Recyclerview adapter的基类
 * Author: xpfei
 * Date:   2017/08/25
 */
public abstract class BaseMyReclyViewAdapter<T, V extends RecyclerView.ViewHolder> extends BaseRecyclerAdapter<V> {
    protected Context context;
    protected List<T> data;
    protected int layoutId;
    protected LayoutInflater inflater;
    private onMyItemClickListener listener;

    public abstract void onBindData(V holder, int position, boolean isItem);

    public BaseMyReclyViewAdapter(Context context, List<T> data, @LayoutRes int layoutId) {
        this.context = context;
        this.data = data;
        this.layoutId = layoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getAdapterItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onBindViewHolder(final V holder, int position, boolean isItem) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMyItemClick(holder.getAdapterPosition());
                }
            }
        });
        onBindData(holder, position, isItem);
    }

    public interface onMyItemClickListener {
        void onMyItemClick(int position);
    }

    public void setOnMyItemClickListener(onMyItemClickListener listener) {
        this.listener = listener;
    }

    public void setData(T t) {
        if (t != null) {
            if (data == null) {
                data = new ArrayList<>();
            }
            data.add(t);
            notifyDataSetChanged();
        }
    }

    public void setData(List<T> list) {
        if (list != null) {
            this.data = list;
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (data != null) {
            data.clear();
            notifyDataSetChanged();
        }
    }
}
