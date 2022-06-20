package com.example.simplechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.Date;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUsername;
        private TextView tvDescription;
        private ImageView ivImage;
        private TextView imageTime;
        private ImageView profilePicture;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.postName);
            ivImage = itemView.findViewById(R.id.postImage);
            tvDescription = itemView.findViewById(R.id.postDescription);
            imageTime = itemView.findViewById(R.id.imageTime);
            profilePicture = itemView.findViewById(R.id.profilePicture);
        }

        public void bind(Post post)
        {
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            imageTime.setText(post.getKeyCreatedKey().toString());
            if(post.getImage() != null)
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);

            ParseUser current = ParseUser.getCurrentUser();

            if(current.get("profilePic") != null) {
                Glide.with(context).load(post.getProfileImage().getUrl()).into(profilePicture);
                System.out.println("we are doing it");
            }
            //System.out.println("we are NOT doing it");
        }
    }
}
