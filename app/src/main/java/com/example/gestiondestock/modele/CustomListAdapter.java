package com.example.gestiondestock.modele;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gestiondestock.R;

import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private List<Article> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Article> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.imgProduit = (ImageView) convertView.findViewById(R.id.imageView_flag);
            holder.libView = (TextView) convertView.findViewById(R.id.textView_lib);
            holder.qteView = (TextView) convertView.findViewById(R.id.textView_qte);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Article article = this.listData.get(position);

        holder.libView.setText(article.getLib_article());
        holder.qteView.setText("qte: " + article.getQteArticle());

        //int imageId = this.getMipmapResIdByName(article.getImage());

        //holder.imgProduit.setImageBitmap(article.getImage());

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    /*public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }*/

    static class ViewHolder {
        ImageView imgProduit;
        TextView qteView;
        TextView libView;
    }

}