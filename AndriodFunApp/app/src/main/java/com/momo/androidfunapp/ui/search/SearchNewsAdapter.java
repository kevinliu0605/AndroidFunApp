package com.momo.androidfunapp.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.momo.androidfunapp.R;
import com.momo.androidfunapp.databinding.SearchNewsItemBinding;
import com.momo.androidfunapp.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchNewsAdapter extends RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder> {
    // 1. Supporting data:
    private List<Article> articles = new ArrayList<>();

    public void setArticles(List<Article> newsList) {
        articles.clear();
        articles.addAll(newsList);
        notifyDataSetChanged();
    }


    // 2. SearchNewsViewHolder:
    public static class SearchNewsViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImageView;
        TextView itemTitleTextView;

        public SearchNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            SearchNewsItemBinding binding = SearchNewsItemBinding.bind(itemView);
            itemImageView = binding.searchItemImage;
            itemTitleTextView = binding.searchItemTitle;
        }
    }

    // 3. Adapter overrides:
    @NonNull
    @Override
    public SearchNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 把XML file 转换成java class，把parent给你 但是需不需要把当前的root给parent --> false, 不需要自动attack
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_news_item, parent, false);
//        SearchNewsViewHolder searchNewsViewHolder = new SearchNewsViewHolder(view);
//        Log.d("test", "onCreate" + searchNewsViewHolder.toString());
        return new SearchNewsViewHolder(view);
    }

    @Override
    // 复用 每次get新的position
    public void onBindViewHolder(@NonNull SearchNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.itemTitleTextView.setText(article.title);
        Picasso.get().load(article.urlToImage).resize(200, 200).into(holder.itemImageView);
    }

    // 多少个article 代表能滑到多少个
    @Override
    public int getItemCount() {
        return articles.size();
    }
}
