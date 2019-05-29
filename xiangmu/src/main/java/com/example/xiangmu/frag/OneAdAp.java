package com.example.xiangmu.frag;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.Bean.OneBean;
import com.example.xiangmu.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class OneAdAp extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<OneBean.TopStoriesBean> top_stories =new ArrayList<>();
    List<OneBean.StoriesBean> stories =new ArrayList<>();
    String date ="";
    Context context;
    private int a;

    public OneAdAp(List<OneBean.TopStoriesBean> top_stories, List<OneBean.StoriesBean> stories, String date, Context context) {
        this.top_stories = top_stories;
        this.stories = stories;
        this.date = date;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            android.view.View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recribaobanner, null);
            ViewHone viewHone = new ViewHone(inflate);
            return viewHone;
        } else if (viewType == 2) {
            android.view.View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recribaotext, null);
            ViewHtwo viewHtwo = new ViewHtwo(inflate);
            return viewHtwo;
        }else {
            android.view.View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recribaoliebiao, null);
            ViewHthree viewHthree = new ViewHthree(inflate);
            return viewHthree;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            final ViewHone viewHone = (ViewHone) holder;
            viewHone.ribaobannertitle.setText(top_stories.get(position).getTitle());
            Banner banner = viewHone.banner.setImages(top_stories);
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    OneBean.TopStoriesBean bean= (OneBean.TopStoriesBean) path;
                    Glide.with(context).load(bean.getImage()).into(imageView);
                }
            }).start();
            banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }
                @Override
                public void onPageSelected(int position) {
                    if (top_stories.size() == 0) {
                    } else {
                        viewHone.ribaobannertitle.setText(top_stories.get(position).getTitle());
                    }
                }
                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        } else if (itemViewType == 2) {
            ViewHtwo viewHtwo = (ViewHtwo) holder;
            viewHtwo.ribaotv.setText(date);

        } else {
            a = position-1;
            if (top_stories.size() > 0) {
                a -= 1;
            }
            ViewHthree viewHthree= (ViewHthree) holder;
            viewHthree.ribaotv.setText(stories.get(a).getTitle());
            Glide.with(context).load(stories.get(a).getImages().get(0)).into(viewHthree.ribaoiv);
            /*viewHthree.itemView.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Intent intent = new Intent(context, ZhuHuActivity.class);
                    if (top_stories.size() > 0) {
                        intent.putExtra("2", stories.get(position - 2));
                    } else {
                        intent.putExtra("2", stories.get(position - 1));
                    }

                    context.startActivity(intent);
                }
            });*/
        }
    }

    @Override
    public int getItemCount() {
        if (top_stories.size() > 0) {
            return 1 + stories.size() + 1;
        } else {
            return 1+stories.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (top_stories.size() > 0) {
            if (position == 0) {
                return 1;
            } else if (position == 1) {
                return 2;
            } else {
                return 3;
            }

        } else {
            if (position == 0) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public class ViewHone extends RecyclerView.ViewHolder{
        Banner banner;
        TextView ribaobannertitle;
        public ViewHone(android.view.View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.ribaobanner);
            ribaobannertitle=itemView.findViewById(R.id.ribaobannertitle);
        }
    }
    public class ViewHtwo extends RecyclerView.ViewHolder{
        TextView ribaotv;
        public ViewHtwo(android.view.View itemView) {
            super(itemView);
            ribaotv=itemView.findViewById(R.id.ribaotv);
        }
    }
    public class ViewHthree extends RecyclerView.ViewHolder{
        ImageView ribaoiv;
        TextView ribaotv;
        public ViewHthree(View itemView) {
            super(itemView);
            ribaoiv=itemView.findViewById(R.id.ribaoiv);
            ribaotv=itemView.findViewById(R.id.ribaotv);

        }
    }
}
